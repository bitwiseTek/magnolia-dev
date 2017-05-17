$(document).ready(function() {
	campAddCtrl.init();
});

var campAddCtrl = {
		init: function(){
			this.validateCamp();
		},
		validateCamp: function() {
			$('button[id=campAdd]').on('click', function() {
				var campName = $('input[name="campName"]');
				var subId = $('#sub option:selected');
				
				$('form[name=camp] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($.trim($(campName).val()) == '' && $.trim($(subId).val()) === '0') {
					$('form[name=camp] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'Please fill in highlighted field(s)';
					$('.alert-error').show();
					$('.campErrorMsg').text(errorMsg);
				} else {
					if($.trim($(campName).val()) == '') {
						$(campName).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(subId).val()) === '0') {
						$(subId).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
				
					if(isError) {
						$('.alert-error').show();
						$('.campErrorMsg').text(errorMsg);
					}
					
					if(!isError) {
						$('.alert-error').hide();
						campAddCtrl.add($(campName).val(), $(subId).val());
					}
				}
			});
		},
		add: function(name, subSchool) {
			var campRes = {};
			campRes.name = name;
			campRes.subSchool = subSchool;
			
			var successMsg = "Campus Added Successfully";
			var serverErrorMsg = "Campus already exists; please check database";
			
			$.ajax({
				url: 'http://localhost:8080/magnolia/api/v1/mg/restful/campuses/add',
				type: 'post',
				dataType: 'json',
				contentType: 'application/json',
				headers: { "Accept": "application/json; odata=verbose" }, 
				data: JSON.stringify(campRes),
				beforeSend: function() {
					$('#campAdd').text('Adding...');
				},
				}).done(function(data) {
					if (data != null) {
						$('.alert-success').show();
						$('.campSuccessMsg').text(successMsg);
						window.location.href = "/magnolia/admin/campuses/list";
					}
				}).fail(function(data) {
					$('#campAdd').text('Add');
					$('.alert-info').show();
					$('.serverErrorMsg').text(serverErrorMsg);
				}).always(function() {
					$('#campAdd').text('Add');
				});
		}
};