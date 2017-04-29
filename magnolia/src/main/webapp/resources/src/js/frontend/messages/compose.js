$(document).ready(function() {
	composeCtrl.init();
});

var composeCtrl = {
			init: function(){
			this.validateCompose();
		},
		validateCompose: function() {
			$('button[id=sendMsg]').on('click', function() {
				var subject = $('input[name="subject"]');
				var sender = $('input[name="sender"]');
				var receiver = $('input[name="receiver"]');
				var message = $('textarea[name="message"]');
				
				$('form[name=compose] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($.trim($(receiver).val()) == '' && $.trim($(message).val()) == '' && $.trim($(subject).val()) == '') {
					$('form[name=compose] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'Please fill in empty field(s)';
					$('.alert-error').show();
					$('.composeErrorMsg').text(errorMsg);
				} else {
					if($.trim($(subject).val()) == '') {
						$(subject).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(receiver).val()) == '') {
						$(receiver).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(message).val()) == '') {
						$(message).css({'background-color' : '#FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
				
					if(isError) {
						$('.alert-error').show();
						$('.composeErrorMsg').text(errorMsg);
					}
					
					if(!isError) {
						$('.alert-error').hide();
						composeCtrl.send($(subject).val(), $(receiver).val(), $(sender).val(), $(message).val());
					}
				}
			});
		},
		send: function(subject, receiver, sender, message) {
			var composeRes = {};
			composeRes.subject = subject;
			composeRes.receiver = receiver;
			composeRes.sender = sender;
			composeRes.message = message;
			
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			var successMsg = "Your message has been sent successfully";
			var serverErrorMsg = "Your messaage has already been sent";
			
			$.ajax({
				url: 'http://localhost:8080/magnolia/api/v1/mg/restful/messages/send',
				type: 'post',
				dataType: 'json',
				contentType: 'application/json',
				headers: { "Accept": "application/json; odata=verbose" }, 
				data: JSON.stringify(composeRes),
				beforeSend: function() {
					$('#sendMsg').text('Sending...');
				},
				}).done(function(data) {
					$('.alert-success').show();
					$('.composeSuccessMsg').text(successMsg);
					$('input[name="receiver"]').val('');
					$('input[name="subject"]').val('');
					$('textarea[name="message"]').val('');
				}).fail(function(data) {
					$('#sendMsg').text('Send');
					$('.alert-info').show();
					$('.serverErrorMsg').text(serverErrorMsg);
				}).always(function() {
					$('#sendMsg').text('Send');
				});
		}
};