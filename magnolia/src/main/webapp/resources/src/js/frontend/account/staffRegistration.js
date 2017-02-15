$(document).ready(function(){
	staffRegisterCtrl.init();
});

var staffRegisterCtrl = {
		base64_photo: '',
		init: function(){
			this.validateStudent();
		},
		validateStudent: function(){
			this.validate_file();
			$('button[id=staffRegister]').on('click', function(){
				var isFileValid = staffRegisterCtrl.validate_file();
				//alert(isFileValid + ' ' + stdRegisterCtrl.base64_photo);
				var firstName = $('input[name="staffFirstName"]');
				var otherNames = $('input[name="staffOtherNames"]');
				var email = $('input[name="staffEmail"]');
				var dob = $('input[name="staffDob"]');
				var state = $('#staffState option:selected');
				var lga = $('#staffLga option:selected');
				var role = $('#staffRole option:selected');
				var faculty = $('#staffFaculty option:selected');
				var department = $('#staffDepartment option:selected');
				var  teleNo = $('input[name=staffTeleNo');
				var teleCode = $('input[name=staffTeleCode');
				var address = $('#staffAddress');
				var photo = $('input[name=staff_upload_photo]');
				var gender = $('input[name="staffGender"]:checked');
				
				$('form[name=staff] input, form[name=staff] textarea').css({'background-color' : '#FFF'});
				$('form[name=staff] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($.trim($(firstName).val()) == '' && $.trim($(otherNames).val()) == '' && $.trim($(email).val()) == '' && $(dob).val() == '' && 
						$(state).val() === '0' && $(lga).val() === '0' && $.trim($(teleNo).val()) == '' && $.trim($(teleCode).val()) == '' && 
						$.trim($(address).val()) == '' && $(photo).val() == '' && $(gender).val() === undefined && $(role).val() == '0' && 
						$(faculty).val() == '0' && $(department).val() == '0'){
					$('form[name=staff] input, form[name=staff] textarea').css({'background-color' : '#FF6666'});
					$('form[name=staff] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'All fields are required';
					$('.alert').show();
					$('.staffErrorMsg').text(errorMsg);
				}
				else{
					if($.trim($(firstName).val()) == ''){
						$(firstName).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'All fields are required';
					}
					
					if($.trim($(otherNames).val()) == ''){
						$(otherNames).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'All fields are required';
					}
					
					if($.trim($(email).val()) == ''){
						$(email).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'All fields are required';
					}
					
					if($.trim($(dob).val()) == ''){
						$(dob).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'All fields are required';
					}
					
					if($.trim($(state).val()) == '0'){
						$('#staffState').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'All fields are required';
					}
					
					if($.trim($(lga).val()) == '0'){
						$('#staffLga').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'All fields are required';
					}
					
					if($.trim($(role).val()) == '0'){
						$('#staffRole').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'All fields are required';
					}
					
					if($.trim($(faculty).val()) == '0'){
						$('#staffFaculty').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'All fields are required';
					}
					
					if($.trim($(department).val()) == '0'){
						$('#staffDepartment').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'All fields are required';
					}
					
					if($.trim($(teleNo).val()) == ''){
						$(teleNo).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'All fields are required';
					}
					
					if($.trim($(teleCode).val()) == ''){
						$(teleCode).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'All fields are required';
					}
					
					if($.trim($(address).val()) == ''){
						$(address).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'All fields are required';
					}
					
					if($.trim($(photo).val()) == ''){
						$(photo).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'All fields are required';
					}
					if($(gender).val() === undefined){
						$(gender).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'All fields are required';
					}
					
					if(isError){
						$('.alert').show();
						$('.staffErrorMsg').text(errorMsg);
					}
					
					if(!isError){
						if("" + $(teleCode).val() + $(teleNo).val() != ''){
							if(!/^[+]*[(]{0,1}[0-9]{1,3}[)]{0,1}[-\s\./0-9]*$/g.test("" + $(teleCode).val() + $(teleNo).val())){
								$(teleCode).css({'background-color' : '#FF6666'});
								$(teleNo).css({'background-color' : '#FF6666'});
							    isError = true;
							    $('.alert').show();
								$('.staffErrorMsg').text('Invalid Telephone');
							}
						}
						if(!staffRegisterCtrl.validateEmail($(email).val())){
							$(email).css({'background-color' : '#FF6666'});
							$('.alert').show();
							$('.staffErrorMsg').append(' / ' + 'Invalid email address');
							isError = true;
						}
						
						if(!isError){
							$('.alert').hide();
							alert('Successful...');
						}
					}
				}
			});
		},
		validateEmail: function(email){
			var emailReg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
			var valid = emailReg.test(email);

			if(!valid) {
		        return false;
		    } else {
		    	return true;
		    }
		},
		validate_file: function(){
			var error = false;
			var output;
			$('input[name=staff_upload_photo]').change(function () {
				error = false;
				var val = $(this).val().toLowerCase();
				var regex = new RegExp("(.*?)\.(jpg|jpeg|png|bmp)$");
				$('#upload_photo_error').text('');
				if(!(regex.test(val))) {
					$('#upload_photo_error').val('');
					$('#upload_photo_error').text('File must be an image').css({color: 'red'});
					error = true;
					return true;
				}
				else{
					var fileSize = $(this)[0].files[0].size;
					if(fileSize > 202144){
						$('#upload_photo_error').val('');
						$('#upload_photo_error').text('File size exceeds 200KB').css({color: 'red'});
						error = true;
					}
					else{
						$("body, html").animate({ 
					        scrollTop: $('#preview_photo').offset().top 
					    }, 600);
						$('#upload_photo_error').text('');
						error = false;
					}
				}
				var FR= new FileReader();
			    FR.onload = function(e) {
			      staffRegisterCtrl.base64_photo = e.target.result;
			    };       
			    FR.readAsDataURL( this.files[0] );
			});
			$('#staff_preview_photo').imagepreview({
		        input: '[name="staff_upload_photo"]',
		        reset: '#reset1',
		        preview: '#staff_preview_photo'
		    });
			return error;
		}
};