$(document).ready(function() {
	prgAddCtrl.init();
});

var prgAddCtrl = {
		init: function(){
			this.validatePrg();
		},
		validatePrg: function() {
			$('button[id=prgAdd]').on('click', function() {
				var name = $('input[name="name"]');
				var code = $('input[name="code"]');
				var descr = $('textarea[name="descr"]');
				var parts = $('input[name="parts"]');
				var maxPart = $('input[name="maxPart"]');
				var days = $('input[name="days"]');
				var category = $('#category option:selected');
				var dept = $('#dept option:selected');
				var length = $('#length option:selected');
				var createdBy = $('#createdBy option:selected');
				var updatedBy = $('#updatedBy option:selected');
				
				$('form[name=prg] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($.trim($(name).val()) == '' && $.trim($(code).val()) == '' && $.trim($(category).val()) === '0' && $.trim($(dept).val()) === '0'
					&& $.trim($(descr).val()) == '' && $.trim($(parts).val()) == '' && $.trim($(maxPart).val()) == '' && $.trim($(length).val()) === '0'
					&& $.trim($(days).val()) == '') {
					$('form[name=prg] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'Please fill in highlighted field(s)';
					$('.alert-error').show();
					$('.prgErrorMsg').text(errorMsg);
				} else {
					if($.trim($(name).val()) == '') {
						$(name).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(category).val()) === '0') {
						$(category).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(length).val()) === '0') {
						$(length).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(dept).val()) === '0') {
						$(dept).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(code).val()) == '') {
						$(code).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(descr).val()) == '') {
						$(descr).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(parts).val()) == '') {
						$(parts).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(maxPart).val()) == '') {
						$(maxPart).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(days).val()) == '') {
						$(days).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
				
					if(isError) {
						$('.alert-error').show();
						$('.prgErrorMsg').text(errorMsg);
					}
					
					if(!isError) {
						$('.alert-error').hide();
						prgAddCtrl.add($(name).val(), $(code).val(), $(descr).val(), $(days).val(), $(parts).val(), $(maxPart).val(), $(createdBy).val(), 
								$(updatedBy).val(), $(category).val(), $(length).val(), $(dept).val());
					}
				}
			});
		},
		add: function(name, code, description, programDays, participants, maxParticipants, createdBy, updatedBy, category, courseLength, department) {
			var prgRes = {};
			prgRes.name = name;
			prgRes.code = code;
			prgRes.description = description;
			prgRes.programDays = programDays;
			prgRes.participants = participants;
			prgRes.maxParticipants = maxParticipants;
			prgRes.createdBy = createdBy;
			prgRes.updatedBy = updatedBy;
			prgRes.category = category;
			prgRes.courseLength = courseLength;
			prgRes.department = department;
			
			var successMsg = "Study Programme Added Successfully";
			var serverErrorMsg = "Study Programme already exists; please check database";
			
			$.ajax({
				url: 'http://localhost:8080/magnolia/api/v1/mg/restful/programmes/add',
				type: 'post',
				dataType: 'json',
				contentType: 'application/json',
				headers: { "Accept": "application/json; odata=verbose" }, 
				data: JSON.stringify(prgRes),
				beforeSend: function() {
					$('#prgAdd').text('Adding...');
				},
				}).done(function(data) {
					if (data != null) {
						$('.alert-success').show();
						$('.subSuccessMsg').text(successMsg);
						window.location.href = "/magnolia/programmes/list";
					}
				}).fail(function(data) {
					$('#prgAdd').text('Add');
					$('.alert-info').show();
					$('.serverErrorMsg').text(serverErrorMsg);
				}).always(function() {
					$('#prgAdd').text('Add');
				});
		}
};