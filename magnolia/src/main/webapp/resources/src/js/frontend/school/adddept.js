$(document).ready(function() {
	deptAddCtrl.init();
});

var deptAddCtrl = {
		init: function(){
			this.validateDept();
		},
		validateDept: function() {
			$('button[id=deptAdd]').on('click', function() {
				var deptName = $('input[name="deptName"]');
				var code = $('input[name="code"]');
				var facId = $('#fac option:selected');
				
				$('form[name=dept] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($.trim($(deptName).val()) == '' && $.trim($(code).val()) == '' && $.trim($(facId).val()) === '0') {
					$('form[name=dept] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'Please fill in highlighted field(s)';
					$('.alert-error').show();
					$('.deptErrorMsg').text(errorMsg);
				} else {
					if($.trim($(code).val()) == '') {
						$(code).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(deptName).val()) === 'ST') {
						$(deptName).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(facId).val()) === '0') {
						$(facId).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
				
					if(isError) {
						$('.alert-error').show();
						$('.subErrorMsg').text(errorMsg);
					}
					
					if(!isError) {
						$('.alert-error').hide();
						deptAddCtrl.add($(deptName).val(), $(code).val(), $(facId).val());
					}
				}
			});
		},
		add: function(name, code, faculty) {
			var deptRes = {};
			deptRes.name = name;
			deptRes.code = code;
			deptRes.faculty = faculty;
			
			var successMsg = "Department Added Successfully";
			var serverErrorMsg = "Department already exists; please check database";
			
			$.ajax({
				url: 'http://localhost:8080/magnolia/api/v1/mg/restful/departments/add',
				type: 'post',
				dataType: 'json',
				contentType: 'application/json',
				headers: { "Accept": "application/json; odata=verbose" }, 
				data: JSON.stringify(deptRes),
				beforeSend: function() {
					$('#deptAdd').text('Adding...');
				},
				}).done(function(data) {
					if (data != null) {
						$('.alert-success').show();
						$('.subSuccessMsg').text(successMsg);
						window.location.href = "/magnolia/admin/departments/list";
					}
				}).fail(function(data) {
					$('#deptAdd').text('Add');
					$('.alert-info').show();
					$('.serverErrorMsg').text(serverErrorMsg);
				}).always(function() {
					$('#deptAdd').text('Add');
				});
		}
};