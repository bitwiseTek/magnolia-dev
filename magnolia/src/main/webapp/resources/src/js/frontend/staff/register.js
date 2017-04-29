$(document).ready(function() {
	stfRegisterCtrl.init();
});

var stfRegisterCtrl = {
		init: function(){
			this.validateStf();
		},
		validateStf: function() {
			$('button[id=stfRegister]').on('click', function() {
				var userId = $('#userId option:selected');
				var title = $('#title option:selected');
				var dept = $('#dept option:selected');
				
				$('form[name=stf] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($(userId).val() === '0' && $(title).val() === 'TT' && $(dept).val() === '0') {
					$('form[name=stf] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'Please fill in highlighted field(s)';
					$('.alert-error').show();
					$('.stfErrorMsg').text(errorMsg);
				} else {
					if($.trim($(userId).val()) == '0') {
						$('#userId').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(title).val()) == 'TT') {
						$('#title').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(dept).val()) == '0') {
						$('#dept').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
				
					if(isError) {
						$('.alert-error').show();
						$('.stfErrorMsg').text(errorMsg);
					}
					
					if(!isError) {
						$('.alert-error').hide();
						stfRegisterCtrl.register($(userId).val(), $(title).val(), $(dept).val());
					}
				}
			});
		},
		register: function(user, title, staffDepartment) {
			var stfRes = {};
			stfRes.user = user;
			stfRes.title = title;
			stfRes.staffDepartment = staffDepartment;
			
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			var successMsg = "Registration Successful: An email will be sent to you within 48 hours, if you don't get email contact support";
			var serverErrorMsg = "You are already registered; please check your mailbox or contact support";
			
			$.ajax({
				url: 'http://localhost:8080/magnolia/api/v1/mg/restful/staff/add',
				type: 'post',
				dataType: 'json',
				contentType: 'application/json',
				headers: { "Accept": "application/json; odata=verbose" }, 
				data: JSON.stringify(stfRes),
				beforeSend: function() {
					$('#stfRegister').text('Registering...');
					
				},
				}).done(function(data) {
					$('.alert-success').show();
					$('.stfSuccessMsg').text(successMsg);
				}).fail(function(data) {
					$('#stfRegister').text('Register');
					$('.alert-info').show();
					$('.serverErrorMsg').text(serverErrorMsg);
				}).always(function() {
					$('#stfRegister').text('Register');
				});
		}
};