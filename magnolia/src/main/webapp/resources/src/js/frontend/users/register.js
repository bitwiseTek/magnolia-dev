$(document).ready(function() {
	userRegisterCtrl.init();
});

var userRegisterCtrl = {
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
			$('button[id=userRegister]').on('click', function() {
				var isFileValid = userRegisterCtrl.validate_file();
				var firstName = $('input[name="firstName"]');
				var lastName = $('input[name="lastName"]');
				var middleName = $('input[name="middleName"]');
				var priEmail = $('input[name="priEmail"]');
				var secEmail = $('input[name="secEmail"]');
				var dob = $('input[name="dob"]');
				var state = $('#state option:selected');
				var lga = $('#lga option:selected');
				var priPhone = $('input[name="priPhone"]');
				var secPhone = $('input[name="secPhone"]');
				var address = $('input[name="address"]');
				var photo = $('input[name=user_upload_photo]');
				var sex = $('#sex option:selected');
				var secretQ = $('#secretQ option:selected');
				var secAnswer = $('input[name="secAnswer"]');
				var status = $('input[name="status"]');
				
				$('form[name=user] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($.trim($(firstName).val()) == '' && $.trim($(lastName).val()) == '' && $.trim($(priEmail).val()) == '' && $(dob).val() == '' && 
						$(state).val() === '0' && $(lga).val() === '0' && $.trim($(priPhone).val()) == '' && $.trim($(address).val()) == '' 
						&& $(photo).val() == '' && $(sex).val() === '0' && $(secretQ).val() === '0' && $(secAnswer).val() == '') {
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
					
					if($.trim($(state).val()) == '0') {
						$('#state').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(lga).val()) == '0') {
						$('#lga').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
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
				
					if(isError) {
						$('.alert-error').show();
						$('.userErrorMsg').text(errorMsg);
					}
					
					if(!isError) {
						$('.alert-error').hide();
						userRegisterCtrl.register($(firstName).val(), $(lastName).val(), $(middleName).val(), $(priEmail).val(), $(secEmail).val(), $(dob).val(), $(lga).val(),
								$(secretQ).val(), $(priPhone).val(), $(secPhone).val(), $(secAnswer).val(), $(address).val(), $(sex).val(), $(state).val(), $(status).val(), $(photo).val());
					}
				}
			});
		},
		register: function(firstName, lastName, middleName, primaryEmail, secondaryEmail, birthday, lga, secretQuestion, primaryNumber, secondaryNumber, secretAnswer, streetAddress, sex, state, status) {
			var userRes = {};
			userRes.firstName = firstName;
			userRes.lastName = lastName;
			userRes.middleName = middleName;
			userRes.primaryEmail = primaryEmail;
			userRes.secondaryEmail = secondaryEmail;
			userRes.birthday = birthday;
			userRes.lga = lga;
			userRes.secretQuestion = secretQuestion;
			userRes.primaryNumber = primaryNumber;
			userRes.secondaryNumber = secondaryNumber;
			userRes.secretAnswer = secretAnswer
			userRes.streetAddress = streetAddress;
			userRes.sex = sex;
			userRes.state = state;
			userRes.status = status;
			userRes.photoBase64 = userRegisterCtrl.base64_photo;
			
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			var successMsg = "Registration Successful: An email has been sent to your primary mailbox containing your login details; observe and login to proceed";
			var serverErrorMsg = "User already exists; please check your mailbox or contact support";
			
			$.ajax({
				url: 'http://localhost:8080/magnolia/api/v1/mg/restful/users/register',
				type: 'post',
				dataType: 'json',
				contentType: 'application/json',
				headers: { "Accept": "application/json; odata=verbose" }, 
				data: JSON.stringify(userRes),
				beforeSend: function() {
					$('#userRegister').text('Registering...');
				},
				}).done(function(data) {
					$('.alert-success').show();
					$('.userSuccessMsg').text(successMsg);
					$('#state option:selected').val(0);
					$('#lga option:selected').val(0);
					$('#sex option:selected').val(0);
					$('#secretQ option:selected').val(0);
				}).fail(function(data) {
					$('#userRegister').text('Sign Up');
					$('.alert-info').show();
					$('.serverErrorMsg').text(serverErrorMsg);
				}).always(function() {
					$('#userRegister').text('Sign Up');
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