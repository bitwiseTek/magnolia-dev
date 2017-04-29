$(document).ready(function() {
	payBillCtrl.init();
});

var payBillCtrl = {
		init: function(){
			this.validateBill();
		},
		validateBill: function() {
			$('button[id=payBill]').on('click', function() {
				var userId = $('#userId option:selected');
				var studentId = $('#studentId option:selected');
				var fullName = $('#fullName option:selected');
				var email = $('#email option:selected');
				var state = $('#state option:selected');
				var lga = $('#lga option:selected');
				var address = $('#address option:selected');
				var session = $('#session option:selected');
				var programme = $('#programme option:selected');
				var paymentMethod = $('input[name="paymentMethod"]');
				var amount = $('input[name="amount"]');
				
				$('form[name=billPay] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($(userId).val() === '0' && $(studentId).val() === '0' && $(fullName).val() === '0' && $(email).val() === '0' && $(state).val() === '0' 
					&& $(lga).val() === '0' && $(address).val() === '0' && $(session).val() === '0' && $(programme).val() === '0' && $(paymentMethod).val() == ''
					&& $(amount).val() == '') {
					$('form[name=billPay] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'Please fill in highlighted field(s)';
					$('.alert-error').show();
					$('.billingErrorMsg').text(errorMsg);
				} else {
					if($.trim($(userId).val()) == '0') {
						$('#userId').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(studentId).val()) == '0') {
						$('#studentId').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(fullName).val()) == '0') {
						$('#fullName').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(email).val()) == '0') {
						$('#email').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(state).val()) == '0') {
						$('#state').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(lga).val()) == '0') {
						$('#lga').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(address).val()) == '0') {
						$('#address').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(programme).val()) == '0') {
						$('#programme').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(session).val()) == '0') {
						$('#session').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(paymentMethod).val()) == '') {
						$('#paymentMethod').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(amount).val()) == '') {
						$('#amount').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
				
					if(isError) {
						$('.alert-error').show();
						$('.billingErrorMsg').text(errorMsg);
					}
					
					if(!isError) {
						$('.alert-error').hide();
						payBillCtrl.pay($(userId).val(), $(studentId).val(), $(fullName).val(), $(email).val(), 
								$(state).val(), $(lga).val(), $(address).val(), $(programme).val(), $(session).val(), 
								$(paymentMethod).val(), $(amount).val());
					}
				}
			});
		},
		pay: function(userId, studentId, personName, emailAddress, state, lga, streetAddress, studyProgramme, semester, paymentMethod, feesAmount) {
			var billRes = {};
			billRes.userId = userId;
			billRes.studentId = studentId;
			billRes.personName = personName;
			billRes.emailAddress = emailAddress;
			billRes.state = state;
			billRes.lga = lga;
			billRes.streetAddress = streetAddress;
			billRes.studyProgramme = studyProgramme;
			billRes.semester = semester;
			billRes.paymentMethod = paymentMethod;
			billRes.feesAmount = feesAmount;
			
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			var successMsg = "Bill Payment has been initiated; proceed to complete payment";
			var serverErrorMsg = "Bill Payment has already been initiated";
			
			$.ajax({
				url: 'http://localhost:8080/magnolia/api/v1/mg/restful/billing/details/pay',
				type: 'post',
				dataType: 'json',
				contentType: 'application/json',
				headers: { "Accept": "application/json; odata=verbose" }, 
				data: JSON.stringify(billRes),
				beforeSend: function() {
					$('#payBill').text('Continuing...');
					
				},
				}).done(function(data) {
					if (data != null) {
						$('.alert-success').show();
						$('.billingSuccessMsg').text(successMsg);
						var id = data.rid;
						window.location.href = "/magnolia/students/billing/pay/review/" + id;
					}
				}).fail(function(data) {
					$('#payBill').text('Continue');
					$('.alert-info').show();
					$('.serverErrorMsg').text(serverErrorMsg);
				}).always(function() {
					$('#payBill').text('Continue');
				});
		}
};