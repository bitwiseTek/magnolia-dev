$(document).ready(function() {
	lengthAddCtrl.init();
});

var lengthAddCtrl = {
		init: function(){
			this.validateLength();
		},
		validateLength: function() {
			$('button[id=lengthAdd]').on('click', function() {
				var name = $('input[name="name"]');
				var hours = $('input[name="hours"]');
				var unit = $('input[name="unit"]');
				
				$('form[name=length] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($.trim($(name).val()) == '' && $.trim($(hours).val()) == '' && $.trim($(unit).val()) == '') {
					$('form[name=length] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'Please fill in highlighted field(s)';
					$('.alert-error').show();
					$('.lengthErrorMsg').text(errorMsg);
				} else {
					if($.trim($(name).val()) == '') {
						$(name).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(hours).val()) == '') {
						$(hours).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(unit).val()) == '') {
						$(unit).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
				
					if(isError) {
						$('.alert-error').show();
						$('.subErrorMsg').text(errorMsg);
					}
					
					if(!isError) {
						$('.alert-error').hide();
						lengthAddCtrl.add($(name).val(), $(hours).val(), $(unit).val());
					}
				}
			});
		},
		add: function(name, tCH, tCU) {
			var lenRes = {};
			lenRes.name = name;
			lenRes.tCH = tCH;
			lenRes.tCU = tCU;
			
			var successMsg = "Course Length Added Successfully";
			var serverErrorMsg = "Course Length already exists; please check database";
			
			$.ajax({
				url: 'http://localhost:8080/magnolia/api/v1/mg/restful/lengths/add',
				type: 'post',
				dataType: 'json',
				contentType: 'application/json',
				headers: { "Accept": "application/json; odata=verbose" }, 
				data: JSON.stringify(lenRes),
				beforeSend: function() {
					$('#lengthAdd').text('Adding...');
				},
				}).done(function(data) {
					if (data != null) {
						$('.alert-success').show();
						$('.lengthSuccessMsg').text(successMsg);
						window.location.href = "/magnolia/course/lengths/list";
					}
				}).fail(function(data) {
					$('#lengthAdd').text('Add');
					$('.alert-info').show();
					$('.serverErrorMsg').text(serverErrorMsg);
				}).always(function() {
					$('#lengthAdd').text('Add');
				});
		}
};