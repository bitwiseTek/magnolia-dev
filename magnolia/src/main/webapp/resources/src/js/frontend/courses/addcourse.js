$(document).ready(function() {
	courseAddCtrl.init();
});

var courseAddCtrl = {
		init: function(){
			this.validateCourse();
		},
		validateCourse: function() {
			$('button[id=courseAdd]').on('click', function() {
				var name = $('input[name="name"]');
				var code = $('input[name="code"]');
				var descr = $('textarea[name="descr"]');
				var semester = $('#semester option:selected');
				var level = $('#level option:selected');
				var option = $('#option option:selected');
				var programme = $('#programme option:selected');
				var unit = $('#unit option:selected');
				var lecturer = $('#lecturer option:selected');
				var createdBy = $('#createdBy option:selected');
				var updatedBy = $('#updatedBy option:selected');
				
				$('form[name=course] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($.trim($(name).val()) == '' && $.trim($(code).val()) == '' && $.trim($(semester).val()) === '0' && $.trim($(programme).val()) === '0'
					&& $.trim($(descr).val()) == '' && $.trim($(lecturer).val()) === '0' && $.trim($(level).val()) === 'SA' && $.trim($(option).val()) === 'ST' 
					&& $.trim($(unit).val()) === 'SU') {
					$('form[name=course] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'Please fill in highlighted field(s)';
					$('.alert-error').show();
					$('.courseErrorMsg').text(errorMsg);
				} else {
					if($.trim($(name).val()) == '') {
						$(name).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(semester).val()) === '0') {
						$(category).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(programme).val()) === '0') {
						$(length).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(lecturer).val()) === '0') {
						$(lecturer).css({'background-color' : '#FF6666'});
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
					
					if($.trim($(level).val()) === 'SA') {
						$(level).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(option).val()) === 'ST') {
						$(option).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(unit).val()) === 'SU') {
						$(unit).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
				
					if(isError) {
						$('.alert-error').show();
						$('.courseErrorMsg').text(errorMsg);
					}
					
					if(!isError) {
						$('.alert-error').hide();
						courseAddCtrl.add($(name).val(), $(code).val(), $(descr).val(), $(level).val(), $(unit).val(), $(option).val(), $(createdBy).val(), 
								$(updatedBy).val(), $(lecturer).val(), $(semester).val(), $(programme).val());
					}
				}
			});
		},
		add: function(name, code, description, academicLevel, creditUnit, optionality, createdBy, updatedBy, courseLecturer, semester, studyProgramme) {
			var cosRes = {};
			cosRes.name = name;
			cosRes.code = code;
			cosRes.description = description;
			cosRes.academicLevel = academicLevel;
			cosRes.creditUnit = creditUnit;
			cosRes.optionality = optionality;
			cosRes.createdBy = createdBy;
			cosRes.updatedBy = updatedBy;
			cosRes.courseLecturer = courseLecturer;
			cosRes.semester = semester;
			cosRes.studyProgramme = studyProgramme;
			
			var successMsg = "Course Added Successfully";
			var serverErrorMsg = "Course already exists; please check database";
			
			$.ajax({
				url: 'http://localhost:8080/magnolia/api/v1/mg/restful/courses/add',
				type: 'post',
				dataType: 'json',
				contentType: 'application/json',
				headers: { "Accept": "application/json; odata=verbose" }, 
				data: JSON.stringify(cosRes),
				beforeSend: function() {
					$('#courseAdd').text('Adding...');
				},
				}).done(function(data) {
					if (data != null) {
						$('.alert-success').show();
						$('.courseSuccessMsg').text(successMsg);
						window.location.href = "/magnolia/courses/list";
					}
				}).fail(function(data) {
					$('#courseAdd').text('Add');
					$('.alert-info').show();
					$('.serverErrorMsg').text(serverErrorMsg);
				}).always(function() {
					$('#courseAdd').text('Add');
				});
		}
};