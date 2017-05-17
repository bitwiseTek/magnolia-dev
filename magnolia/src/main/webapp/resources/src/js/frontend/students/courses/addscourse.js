$(document).ready(function() {
	scourseAddCtrl.init();
});

var scourseAddCtrl = {
		init: function(){
			this.validateSCourse();
		},
		validateSCourse: function() {
			$('button[id=courseAdd]').on('click', function() {
				var billId = $('#billId option:selected');
				var courseId = $('#courseId option:selected');
				
				$('form[name=course] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($.trim($(billId).val()) === '0' && $.trim($(courseId).val()) === '0') {
					$('form[name=course] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'Please fill in highlighted field(s)';
					$('.alert-error').show();
					$('.courseErrorMsg').text(errorMsg);
				} else {
					if($.trim($(billId).val()) === '0') {
						$(category).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(courseId).val()) === '0') {
						$(length).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
				
					if(isError) {
						$('.alert-error').show();
						$('.courseErrorMsg').text(errorMsg);
					}
					
					if(!isError) {
						$('.alert-error').hide();
						scourseAddCtrl.add($(courseId).val(), $(billId).val());
					}
				}
			});
		},
		add: function(course, billing) {
			var cosRes = {};
			cosRes.course = course;
			cosRes.billing = billing;
			
			var successMsg = "Course Added Successfully";
			var serverErrorMsg = "Course has already been added by you; Check Course List";
			
			$.ajax({
				url: 'http://localhost:8080/magnolia/api/v1/mg/restful/students/courses/add',
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
						window.location.href = "/magnolia/students/courses/list";
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