$(document).ready(function() {
	permissionAddCtrl.init();
});

var permissionAddCtrl = {
			init: function(){
			this.validatePermission();
		},
		validatePermission: function() {
			$('button[id=permissionAdd]').on('click', function() {
				var permissionName = $('input[name="permissionName"]');
				
				$('form[name=permission] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($.trim($(permissionName).val()) == '') {
					$('form[name=permission] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'Please fill in highlighted field(s)';
					$('.alert-error').show();
					$('.permissionErrorMsg').text(errorMsg);
				} else {
					if($.trim($(permissionName).val()) == '') {
						$(permissionName).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
				
					if(isError) {
						$('.alert-error').show();
						$('.permissionErrorMsg').text(errorMsg);
					}
					
					if(!isError) {
						$('.alert-error').hide();
						permissionAddCtrl.add($(permissionName).val());
					}
				}
			});
		},
		add: function(permissions) {
			var permissionRes = {};
			permissionRes.permissions = permissions;
			
			var successMsg = "Permission Added Successfully";
			var serverErrorMsg = "Permission already exists; please check database";
			
			$.ajax({
				url: 'http://localhost:8080/magnolia/api/v1/mg/restful/permissions/add',
				type: 'post',
				dataType: 'json',
				contentType: 'application/json',
				headers: { "Accept": "application/json; odata=verbose" }, 
				data: JSON.stringify(permissionRes),
				beforeSend: function() {
					$('#permissionAdd').text('Adding...');
				},
				}).done(function(data) {
					$('.alert-success').show();
					$('.permissionSuccessMsg').text(successMsg);
				}).fail(function(data) {
					$('#permissionAdd').text('Add');
					$('.alert-info').show();
					$('.serverErrorMsg').text(serverErrorMsg);
				}).always(function() {
					$('#permissionAdd').text('Add');
				});
		}
};