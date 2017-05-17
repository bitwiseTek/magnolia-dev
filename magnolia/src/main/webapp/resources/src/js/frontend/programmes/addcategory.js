$(document).ready(function() {
	catAddCtrl.init();
});

var catAddCtrl = {
		init: function(){
			this.validateCat();
		},
		validateCat: function() {
			$('button[id=catAdd]').on('click', function() {
				var catName = $('input[name="catName"]');
				
				$('form[name=cat] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($.trim($(catName).val()) == '' ) {
					$('form[name=cat] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'Please fill in highlighted field(s)';
					$('.alert-error').show();
					$('.catErrorMsg').text(errorMsg);
				} else {
					if($.trim($(catName).val()) == '') {
						$(catName).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if(isError) {
						$('.alert-error').show();
						$('.catErrorMsg').text(errorMsg);
					}
					
					if(!isError) {
						$('.alert-error').hide();
						catAddCtrl.add($(catName).val());
					}
				}
			});
		},
		add: function(name) {
			var catRes = {};
			catRes.name = name;
			
			var successMsg = "Category Added Successfully";
			var serverErrorMsg = "Category already exists; please check database";
			
			$.ajax({
				url: 'http://localhost:8080/magnolia/api/v1/mg/restful/categories/add',
				type: 'post',
				dataType: 'json',
				contentType: 'application/json',
				headers: { "Accept": "application/json; odata=verbose" }, 
				data: JSON.stringify(catRes),
				beforeSend: function() {
					$('#catAdd').text('Adding...');
				},
				}).done(function(data) {
					if (data != null) {
						$('.alert-success').show();
						$('.catSuccessMsg').text(successMsg);
						window.location.href = "/magnolia/programme/categories/list";
					}
				}).fail(function(data) {
					$('#catAdd').text('Add');
					$('.alert-info').show();
					$('.serverErrorMsg').text(serverErrorMsg);
				}).always(function() {
					$('#catAdd').text('Add');
				});
		}
};