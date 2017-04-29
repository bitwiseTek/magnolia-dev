$(document).ready(function() {
	stdRegisterCtrl.init();
});

var stdRegisterCtrl = {
		base64_photo: '',
		init: function(){
			this.validateStd();
			this.onDeptSelect();
		},
		onDeptSelect: function() {
			$('#dept').change(function(event) {
				let deptId = $('#dept option:selected').val();
				
				$.ajax({
					url: 'http://localhost:8080/magnolia/api/v1/mg/restful/programmes/departments/' + deptId,
					type: 'get', 
					dataType: 'json',
					contentType: 'application/json',
					beforeSend: function(xhr) {
						xhr.setRequestHeader("Accept", "application/json");
						$('#programme').empty();
						$('#programme').append('<option value="0">loading...</option>');
					},
					success: function(data) {
						$('#programme').empty();
						if(data !== '') {
							var object = data.programmes;
							$('#programme').append('<option value="0">Select Study Programme</option>');
							for(var i = 0; i < object.length; i++) {
								$('#programme').append('<option value="' + object[i].rid + '">' + object[i].name + '</option>');
							}
						} else {
							$('#programme').append('<option value="0">' + data.error + '</option>');
						}
					},
					complete: function() {
						
					}
				});
			});
		},	
		validateStd: function() {
			$('button[id=stdRegister]').on('click', function() {
				var userId = $('#userId option:selected');
				var partType = $('#partType option:selected');
				var enrolType = $('#enrolType option:selected');
				var lodging = $('#lodging option:selected');
				var dept = $('#dept option:selected');
				var programme = $('#programme option:selected');
				var endReason = $('#endReason option:selected');
				var endText = $('input[name="endText"]');
				var status = $('input[name="status"]');
				
				$('form[name=std] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($(userId).val() === '0' && $(partType).val() === 'PT' && $.trim($(endText).val()) == '' && $.trim($(enrolType).val()) === 'ET' 
						&& $(lodging).val() === 'AC' && $(dept).val() === '0' && $(programme).val() === '0' && $(endReason).val() === 'SE') {
					$('form[name=std] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'Please fill in highlighted field(s)';
					$('.alert-error').show();
					$('.stdErrorMsg').text(errorMsg);
				} else {
					if($.trim($(userId).val()) == '0') {
						$('#userId').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(partType).val()) == 'PT') {
						$('#partType').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(enrolType).val()) == 'ET') {
						$('#enrolType').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(lodging).val()) == 'AC') {
						$('#lodging').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(dept).val()) == '0') {
						$('#dept').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(programme).val()) == '0') {
						$('#programme').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(endReason).val()) == 'SE') {
						$('#endReason').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
				
					if(isError) {
						$('.alert-error').show();
						$('.stdErrorMsg').text(errorMsg);
					}
					
					if(!isError) {
						$('.alert-error').hide();
						stdRegisterCtrl.register($(userId).val(), $(partType).val(), $(endText).val(), $(enrolType).val(), $(lodging).val(), $(dept).val(), $(programme).val(),
						$(endReason).val(), $(status).val());
					}
				}
			});
		},
		register: function(user, participationType, studyEndText, courseEnrolmentType, lodging, studentDepartment, studyProgramme, studyEndReason, status) {
			var stdRes = {};
			stdRes.user = user;
			stdRes.participationType = participationType;
			stdRes.studyEndText = studyEndText;
			stdRes.courseEnrolmentType = courseEnrolmentType
			stdRes.lodging = lodging;
			stdRes.studentDepartment = studentDepartment;
			stdRes.studyProgramme = studyProgramme;
			stdRes.studyEndReason = studyEndReason;
			stdRes.status = status;
			
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			var successMsg = "Registration Successful: An email will be sent to you within 48 hours, if you don't get email contact support";
			var serverErrorMsg = "You are already registered; please check your mailbox or contact support";
			
			$.ajax({
				url: 'http://localhost:8080/magnolia/api/v1/mg/restful/students/add',
				type: 'post',
				dataType: 'json',
				contentType: 'application/json',
				headers: { "Accept": "application/json; odata=verbose" }, 
				data: JSON.stringify(stdRes),
				beforeSend: function() {
					$('#stdRegister').text('Registering...');
					
				},
				}).done(function(data) {
					$('.alert-success').show();
					$('.stdSuccessMsg').text(successMsg);
					$('input[name="endText"]').val('');
					$('#partType option:selected').val(0);
					$('#enrolType option:selected').val(0);
					$('#lodging option:selected').val(0);
					$('#dept option:selected').val(0);
					$('#programme option:selected').val(0);
					$('#endReason option:selected').val(0);
				}).fail(function(data) {
					$('#stdRegister').text('Register');
					$('.alert-info').show();
					$('.serverErrorMsg').text(serverErrorMsg);
				}).always(function() {
					$('#stdRegister').text('Register');
				});
		}
};