$(document).ready(function() {
	editUserCtrl.init();
});

var editUserCtrl = {
		base64_photo: '',
		init: function(){
			this.validateUser();
			this.onStateSelect();
		},
		onStateSelect: function() {
			$('#state').change(function(event) {
				let stateId = $('#state option:selected').val();
				
				$.ajax({
					url: 'http://localhost:8080/magnolia/api/v1/mg/restful/lgas/states/' + stateId,
					type: 'get', 
					dataType: 'json',
					contentType: 'application/json',
					beforeSend: function(xhr) {
						xhr.setRequestHeader("Accept", "application/json");
						$('#lga').empty();
						$('#lga').append('<option value="0">loading...</option>');
					},
					success: function(data) {
						$('#lga').empty();
						if(data !== '') {
							var object = data.lgas;
							$('#lga').append('<option value="0">Select LGA</option>');
							for(var i = 0; i < object.length; i++) {
								$('#lga').append('<option value="' + object[i].rid + '">' + object[i].name + '</option>');
							}
						} else {
							$('#lga').append('<option value="0">' + data.error + '</option>');
						}
					},
					complete: function() {
						
					}
				});
			});
		},	
		validateUser: function() {
			this.validate_file();
			$('button[id=userEdit]').on('click', function() {
				var id = $('input[name="userId"]');
				var firstName = $('input[name="firstName"]');
				var lastName = $('input[name="lastName"]');
				var middleName = $('input[name="middleName"]');
				var priEmail = $('input[name="priEmail"]');
				var secEmail = $('input[name="secEmail"]');
				var dob = $('input[name="dob"]');/*
				var state = $('#state option:selected');
				var lga = $('#lga option:selected');*/
				var priPhone = $('input[name="priPhone"]');
				var secPhone = $('input[name="secPhone"]');
				var address = $('input[name="address"]');
				var photo = $('input[name=user_upload_photo]');
				var sex = $('#sex option:selected');
				var secretQ = $('#secretQ option:selected');
				var status = $('#status option:selected');
				var secAnswer = $('input[name="secAnswer"]');
				
				$('form[name=user] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($.trim($(firstName).val()) == '' && $.trim($(lastName).val()) == '' && $.trim($(priEmail).val()) == '' && $(dob).val() == '' && 
						$(state).val() === '0' && $(lga).val() === '0' && $.trim($(priPhone).val()) == '' && $.trim($(address).val()) == '' 
						&& $(photo).val() == '' && $(sex).val() === '0' && $(secretQ).val() === '0' && $(secAnswer).val() == '' && $(status).val() == '0') {
					$('form[name=user] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'Please fill in highlighted field(s)';
					$('.alert-error').show();
					$('.userErrorMsg').text(errorMsg);
				} else {
					if($.trim($(firstName).val()) == '') {
						$(firstName).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(lastName).val()) == '') {
						$(lastName).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(priEmail).val()) == '') {
						$(priEmail).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(dob).val()) == '') {
						$(dob).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					/*if($.trim($(state).val()) == '0') {
						$('#state').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(lga).val()) == '0') {
						$('#lga').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}*/
					
					if($.trim($(sex).val()) == '0') {
						$('#sex').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(secretQ).val()) == '0') {
						$('#secretQ').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(priPhone).val()) == '') {
						$(priPhone).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(secAnswer).val()) == '') {
						$(secAnswer).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(address).val()) == '') {
						$(address).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(photo).val()) == '') {
						$(photo).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(status).val()) == '') {
						$(status).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
				
					if(isError) {
						$('.alert-error').show();
						$('.userErrorMsg').text(errorMsg);
					}
					
					if(!isError) {
						$('.alert-error').hide();
						editUserCtrl.edit($(id).val(), $(firstName).val(), $(lastName).val(), $(middleName).val(), $(priEmail).val(), $(secEmail).val(), $(dob).val(), 
								$(secretQ).val(), $(priPhone).val(), $(secPhone).val(), $(secAnswer).val(), $(address).val(), $(sex).val(), $(photo).val(), 
								$(status).val());
					}
				}
			});
		},
		edit: function(id, firstName, lastName, middleName, primaryEmail, secondaryEmail, birthday, secretQuestion, primaryNumber, secondaryNumber, secretAnswer, streetAddress, sex, status) {
			var userRes = {};
			userRes.id = id;
			userRes.firstName = firstName;
			userRes.lastName = lastName;
			userRes.middleName = middleName;
			userRes.primaryEmail = primaryEmail;
			userRes.secondaryEmail = secondaryEmail;
			userRes.birthday = birthday;
			userRes.secretQuestion = secretQuestion;
			userRes.primaryNumber = primaryNumber;
			userRes.secondaryNumber = secondaryNumber;
			userRes.secretAnswer = secretAnswer
			userRes.streetAddress = streetAddress;
			userRes.sex = sex;
			userRes.photoBase64 = userRegisterCtrl.base64_photo;
			userRes.status = status;
			
			var userId = $('input[name="userId"]').val();
			var successMsg = "Update Successful: Your password has been updated; observe and login to proceed";
			var serverErrorMsg = "Updated Error";
			
			$.ajax({
				url: 'http://localhost:8080/magnolia/api/v1/mg/restful/users/' + userId,
				type: 'put',
				dataType: 'json',
				contentType: 'application/json',
				headers: { "Accept": "application/json; odata=verbose" }, 
				data: JSON.stringify(userRes),
				beforeSend: function() {
					$('#userEdit').text('Editing...');
				},
				}).done(function(data) {
					$('.alert-success').show();
					$('.userSuccessMsg').text(successMsg);
					$('#state option:selected').val(0);
					$('#lga option:selected').val(0);
					$('#sex option:selected').val(0);
					$('#secretQ option:selected').val(0);
					$('#status option:selected').val(0);
				}).fail(function(data) {
					$('#userEdit').text('Edit');
					$('.alert-info').show();
					$('.serverErrorMsg').text(serverErrorMsg);
				}).always(function() {
					$('#userEdit').text('Edit');
				});
		}, 
		validate_file: function() {
			var error = false;
			var output;
			$('input[name=user_upload_photo]').change(function () {
				error = false;
				var val = $(this).val().toLowerCase();
				var regex = new RegExp("(.*?)\.(jpg|jpeg|png|bmp)$");
				$('#upload_photo_error').text('');
				if(!(regex.test(val))) {
					$('.alert-error').show();
					$('.userErrorMsg').text('File must be an image');
					error = true;
					return true;
				} else {
					var fileSize = $(this)[0].files[0].size;
					if(fileSize > 202144){
						$('.alert-error').show();
						$('.userErrorMsg').text('File size exceeds 200KB');
						error = true;
					} else {
						$("body, html").animate({ 
					        scrollTop: $('#preview_photo').offset().top 
					    }, 600);
						$('.alert').hide();
						error = false;
					}
				}
				var FR= new FileReader();
			    FR.onload = function(e) {
			      userRegisterCtrl.base64_photo = e.target.result;
			    };       
			    FR.readAsDataURL( this.files[0] );
			});
			$('#preview_photo').imagepreview({
		        input: '[name="user_upload_photo"]',
		        reset: '#reset1',
		        preview: '#preview_photo'
		    });
			return error;
		}
};