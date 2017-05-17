$(document).ready(function() {
	subAddCtrl.init();
});

var subAddCtrl = {
		init: function(){
			this.validateSub();
		},
		validateSub: function() {
			$('button[id=subAdd]').on('click', function() {
				var subName = $('input[name="subName"]');
				var address = $('input[name="address"]');
				var type = $('#type option:selected');
				var schoolId = $('#schoolId option:selected');
				
				$('form[name=sub] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($.trim($(subName).val()) == '' && $.trim($(address).val()) == '' && $.trim($(type).val()) === 'ST' && $.trim($(schoolId).val()) === '0') {
					$('form[name=sub] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'Please fill in highlighted field(s)';
					$('.alert-error').show();
					$('.subErrorMsg').text(errorMsg);
				} else {
					if($.trim($(subName).val()) == '') {
						$(subName).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(type).val()) === 'ST') {
						$(type).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(schoolId).val()) === '0') {
						$(schoolId).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(address).val()) == '') {
						$(address).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
				
					if(isError) {
						$('.alert-error').show();
						$('.subErrorMsg').text(errorMsg);
					}
					
					if(!isError) {
						$('.alert-error').hide();
						subAddCtrl.add($(subName).val(), $(type).val(), $(schoolId).val(), $(address).val());
					}
				}
			});
		},
		add: function(name, type, school, address) {
			var subRes = {};
			subRes.name = name;
			subRes.type = type;
			subRes.school = school;
			subRes.address = address;
			
			var successMsg = "SubSchool Added Successfully";
			var serverErrorMsg = "SubSchool already exists; please check database";
			
			$.ajax({
				url: 'http://localhost:8080/magnolia/api/v1/mg/restful/subschools/add',
				type: 'post',
				dataType: 'json',
				contentType: 'application/json',
				headers: { "Accept": "application/json; odata=verbose" }, 
				data: JSON.stringify(subRes),
				beforeSend: function() {
					$('#subAdd').text('Adding...');
				},
				}).done(function(data) {
					if (data != null) {
						$('.alert-success').show();
						$('.subSuccessMsg').text(successMsg);
						window.location.href = "/magnolia/admin/subschools/list";
					}
				}).fail(function(data) {
					$('#subAdd').text('Add');
					$('.alert-info').show();
					$('.serverErrorMsg').text(serverErrorMsg);
				}).always(function() {
					$('#subAdd').text('Add');
				});
		}
};