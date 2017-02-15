$(document).ready(function(){
	stdRegisterCtrl.init();
});

var stdRegisterCtrl = {
		base64_photo: '',
		init: function(){
			this.validateStudent();
			this.onFacultySelect();
		},
		onFacultySelect: function(){
			$('#stdFaculty').change(function(event){
				let facultyId = $('#stdFaculty option:selected').val();
				
				$.ajax({
					url: 'api/v1/' + Utils.SCHOOL_ALIAS + '/studentRegistration/getDepartmentByFaculty',
					type: 'get',
					dataType: 'json',
					contentType: 'application/json',
					data: {'apiKey' : Utils.API_KEY, 'facultyId' : facultyId},
					beforeSend: function(){
						$('#stdDepartment').empty();
						$('#stdDepartment').append('<option value="0">loading...</option>');
					},
					success: function(response){
						$('#stdDepartment').empty();
						if(response.success){
							var object = response.object;
							$('#stdDepartment').append('<option value="0">Select Department</option>')
							for(var i = 0; i < object.length; i++){
								$('#stdDepartment').append('<option value="' + object[i].departmentId + '">' + object[i].name + '</option>')
							}
						}
						else{
							$('#stdDepartment').append('<option value="0">' + response.error + '</option>');
						}
					},
					complete: function(){
						
					}
				});
			});
		},
		validateStudent: function(){
			this.validate_file();
			$('button[id=stdRegister]').on('click', function(){
				var isFileValid = stdRegisterCtrl.validate_file();
				//alert(isFileValid + ' ' + stdRegisterCtrl.base64_photo);
				var firstName = $('input[name="stdFirstName"]');
				var otherNames = $('input[name="stdOtherNames"]');
				var email = $('input[name="stdEmail"]');
				var dob = $('input[name="stdDob"]');
				var state = $('#stdState option:selected');
				var lga = $('#stdLga option:selected');
				var faculty = $('#stdFaculty option:selected');
				var department = $('#stdDepartment option:selected');
				var  teleNo = $('input[name=stdTeleNo');
				var teleCode = $('input[name=stdTeleCode');
				var address = $('#stdAddress');
				var photo = $('input[name=std_upload_photo]');
				var gender = $('input[name="stdGender"]:checked');
				
				$('form[name=student] input, form[name=student] textarea').css({'background-color' : '#FFF'});
				$('form[name=student] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($.trim($(firstName).val()) == '' && $.trim($(otherNames).val()) == '' && $.trim($(email).val()) == '' && $(dob).val() == '' && 
						$(state).val() === '0' && $(lga).val() === '0' && $.trim($(teleNo).val()) == '' && $.trim($(teleCode).val()) == '' && 
						$.trim($(address).val()) == '' && $(photo).val() == '' && $(gender).val() === undefined && 
						$(faculty).val() == '0' && $(department).val() == '0'){
					$('form[name=student] input, form[name=student] textarea').css({'background-color' : '#FF6666'});
					$('form[name=student] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'All fields are required';
					$('.alert').show();
					$('.stdErrorMsg').text(errorMsg);
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
						$('#stdState').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'All fields are required';
					}
					
					if($.trim($(lga).val()) == '0'){
						$('#stdLga').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'All fields are required';
					}
					
					if($.trim($(faculty).val()) == '0'){
						$('#stdFaculty').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'All fields are required';
					}
					
					if($.trim($(department).val()) == '0'){
						$('#stdDepartment').css({'border' : '1px solid #FF6666'});
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
						$('.stdErrorMsg').text(errorMsg);
					}
					
					if(!isError){
						if("" + $(teleCode).val() + $(teleNo).val() != ''){
							if(!/^[+]*[(]{0,1}[0-9]{1,3}[)]{0,1}[-\s\./0-9]*$/g.test("" + $(teleCode).val() + $(teleNo).val())){
								$(teleCode).css({'background-color' : '#FF6666'});
								$(teleNo).css({'background-color' : '#FF6666'});
							    isError = true;
							    $('.alert').show();
								$('.stdErrorMsg').text('Invalid Telephone');
							}
						}
						if(!stdRegisterCtrl.validateEmail($(email).val())){
							$(email).css({'background-color' : '#FF6666'});
							$('.alert').show();
							$('.stdErrorMsg').append(' / ' + 'Invalid email address');
							isError = true;
						}
						
						if(!isError){
							$('.alert').hide();
							stdRegisterCtrl.register($(firstName).val(), $(otherNames).val(), $(email).val(), $(dob).val(), $(lga).val(),
									$(department).val(), $(teleCode).val() + '' + $(teleNo).val(), $(address).val(), $(gender).val());
						}
					}
				}
			});
		},
		register: function(firstName, otherNames, email, dob, lga, department, telephone, address, gender){
			var studentVo = {};
			studentVo.firstName = firstName;
			studentVo.otherNames = otherNames;
			studentVo.email = email;
			studentVo.dob = dob;
			//studentVo.lga = lga;
			studentVo.departmentName = department;
			studentVo.telephone = telephone;
			studentVo.address = address;
			studentVo.gender = gender;
			studentVo.photoBase64 = stdRegisterCtrl.base64_photo;
			studentVo.apiKey = Utils.API_KEY;
			
			$.ajax({
				url: 'api/v1/' + Utils.SCHOOL_ALIAS + '/studentRegistration/registerStudent',
				type: 'post',
				dataType: 'json',
				contentType: 'application/json',
				data: JSON.stringify(studentVo),
				beforeSend: function(){
					$('#stdRegister').text('Registering...');
				},
				success: function(response){
					if(response.success){
						$('form[name=student] input[name="status"]').attr('checked', false);
						$('form[name=student] input, form[name=success] textarea').val('');
						$('#stdFaculty option:selected').val(0);
						$('#stdDepartment option:selected').val(0);
						//$('#stdLga option')
						
					}
					else{
						$('#stdRegister').text('Register');
						$('.alert').show();
						$('.stdErrorMsg').append(response.message);
					}
				},
				complete: function(){
					$('#createBtn').text('Create');
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
			$('input[name=std_upload_photo]').change(function () {
				error = false;
				var val = $(this).val().toLowerCase();
				var regex = new RegExp("(.*?)\.(jpg|jpeg|png|bmp)$");
				$('#upload_photo_error').text('');
				if(!(regex.test(val))) {
					$('.alert').show();
					$('.stdErrorMsg').text('File must be an image');
					error = true;
					return true;
				}
				else{
					var fileSize = $(this)[0].files[0].size;
					if(fileSize > 202144){
						$('.alert').show();
						$('.stdErrorMsg').text('File size exceeds 200KB');
						error = true;
					}
					else{
						$("body, html").animate({ 
					        scrollTop: $('#preview_photo').offset().top 
					    }, 600);
						$('.alert').hide();
						error = false;
					}
				}
				var FR= new FileReader();
			    FR.onload = function(e) {
			      stdRegisterCtrl.base64_photo = e.target.result;
			    };       
			    FR.readAsDataURL( this.files[0] );
			});
			$('#preview_photo').imagepreview({
		        input: '[name="std_upload_photo"]',
		        reset: '#reset1',
		        preview: '#preview_photo'
		    });
			return error;
		}
};