$(document).ready(function() {
	roleAddCtrl.init();
});

var roleAddCtrl = {
		init: function(){
			this.validateRole();
		},
		validateRole: function() {
			$('button[id=roleAdd]').on('click', function() {
				var roleName = $('input[name="roleName"]');
				
				$('form[name=role] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($.trim($(roleName).val()) == '') {
					$('form[name=role] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'Please fill in highlighted field(s)';
					$('.alert-error').show();
					$('.roleErrorMsg').text(errorMsg);
				} else {
					if($.trim($(roleName).val()) == '') {
						$(roleName).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
				
					if(isError) {
						$('.alert-error').show();
						$('.roleErrorMsg').text(errorMsg);
					}
					
					if(!isError) {
						$('.alert-error').hide();
						roleAddCtrl.add($(roleName).val());
					}
				}
			});
		},
		add: function(roles) {
			var roleRes = {};
			roleRes.roles = roles;
			
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			var successMsg = "Role Added Successfully";
			var serverErrorMsg = "Role already exists; please check database";
			
			$.ajax({
				url: 'http://localhost:8080/magnolia/api/v1/mg/restful/roles/add',
				type: 'post',
				dataType: 'json',
				contentType: 'application/json',
				headers: { "Accept": "application/json; odata=verbose" }, 
				data: JSON.stringify(roleRes),
				beforeSend: function() {
					$('#roleAdd').text('Adding...');
				},
				}).done(function(data) {
					$('.alert-success').show();
					$('.roleSuccessMsg').text(successMsg);
				}).fail(function(data) {
					$('#roleAdd').text('Add');
					$('.alert-info').show();
					$('.serverErrorMsg').text(serverErrorMsg);
				}).always(function() {
					$('#roleAdd').text('Add');
				});
		}
};