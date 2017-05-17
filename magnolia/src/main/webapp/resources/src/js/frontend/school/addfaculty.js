$(document).ready(function() {
	facAddCtrl.init();
});

var facAddCtrl = {
		init: function(){
			this.validateFac();
		},
		validateFac: function() {
			$('button[id=facAdd]').on('click', function() {
				var facName = $('input[name="facName"]');
				var campId = $('#camp option:selected');
				
				$('form[name=fac] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($.trim($(facName).val()) == '' && $.trim($(campId).val()) === '0') {
					$('form[name=fac] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'Please fill in highlighted field(s)';
					$('.alert-error').show();
					$('.facErrorMsg').text(errorMsg);
				} else {
					if($.trim($(facName).val()) == '') {
						$(facName).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(campId).val()) === '0') {
						$(campId).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
				
					if(isError) {
						$('.alert-error').show();
						$('.facErrorMsg').text(errorMsg);
					}
					
					if(!isError) {
						$('.alert-error').hide();
						facAddCtrl.add($(facName).val(), $(campId).val());
					}
				}
			});
		},
		add: function(name, campus) {
			var facRes = {};
			facRes.name = name;
			facRes.campus = campus;
			
			var successMsg = "Faculty Added Successfully";
			var serverErrorMsg = "Faculty already exists; please check database";
			
			$.ajax({
				url: 'http://localhost:8080/magnolia/api/v1/mg/restful/faculties/add',
				type: 'post',
				dataType: 'json',
				contentType: 'application/json',
				headers: { "Accept": "application/json; odata=verbose" }, 
				data: JSON.stringify(facRes),
				beforeSend: function() {
					$('#facAdd').text('Adding...');
				},
				}).done(function(data) {
					if (data != null) {
						$('.alert-success').show();
						$('.facSuccessMsg').text(successMsg);
						window.location.href = "/magnolia/admin/faculties/list";
					}
				}).fail(function(data) {
					$('#facAdd').text('Add');
					$('.alert-info').show();
					$('.serverErrorMsg').text(serverErrorMsg);
				}).always(function() {
					$('#facAdd').text('Add');
				});
		}
};