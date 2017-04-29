$(document).ready(function() {
	revBillCtrl.init();
});

var revBillCtrl = {
		init: function(){
			this.validateBill();
		},
		validateBill: function() {
			$('button[id=revBill]').on('click', function() {
				var custName = $('input[name="cust_name"]');
				var custNameDesc = $('input[name="cust_name_desc"]');
				var userId = $('input[name="user_id"]');
				var txnRef = $('input[name="txn_ref"]');
				var productId = $('input[name="product_id"]');
				var amount = $('input[name="amount"]');
				var currency = $('input[name="currency"]');
				var payItemId = $('input[name="pay_item_id"]');
				var payItemName = $('input[name="pay_item_name"]');
				var custId = $('input[name="cust_id"]');
				var custIdDesc = $('input[name="cust_id_desc"]');
				var siteName = $('input[name="site_name"]');
				var siteRedirectUrl = $('input[name="site_redirect_url"]');
				var macKey = $('input[name="mac_key"]');
				var hash = $('input[name="hash"]').val($('input[name="hash"]').val() + sha512($(txnRef).val() + $(productId).val() + $(payItemId).val() + $(amount).val()*100 + $(siteRedirectUrl).val() + $(macKey).val()));
				
				$('form[name=reviewBill] select').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($(custName).val() == '' && $(custNameDesc).val() == '' && $(userId).val() == '' && $(txnRef).val() == '' 
					&& $(productId).val() == '' && $(amount).val() == '' && $(currency).val() == '' && $(payItemId).val() == ''
					&& $(payItemName).val() == '' && $(custId).val() == '' && $(custIdDesc).val() == '' && $(siteName).val() == ''
					&& $(siteRedirectUrl).val() == '' && $(hash).val() == '') {
					$('form[name=reviewBill] select').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'Please fill in highlighted field(s)';
					$('.alert-error').show();
					$('.billRevErrorMsg').text(errorMsg);
				} else {
					if($.trim($(custName).val()) == '') {
						$('#cust_name').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(custNameDesc).val()) == '') {
						$('#cust_name_desc').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(userId).val()) == '') {
						$('#user_id').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(txnRef).val()) == '') {
						$('#txn_ref').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(productId).val()) == '') {
						$('#product_id').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(amount).val()) == '') {
						$('#amount').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(currency).val()) == '0') {
						$('#currency').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}

					if($.trim($(payItemId).val()) == '') {
						$('#pay_item_id').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}

					if($.trim($(payItemName).val()) == '') {
						$('#pay_item_name').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}

					if($.trim($(custId).val()) == '') {
						$('#cust_id').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}

					if($.trim($(custIdDesc).val()) == '') {
						$('#cust_id_desc').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}

					if($.trim($(siteName).val()) == '') {
						$('#site_name').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}

					if($.trim($(siteRedirectUrl).val()) == '') {
						$('#site_redirect_url').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if($.trim($(hash).val()) == '') {
						$('#hash').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Please fill in highlighted field(s)';
					}
					
					if(isError) {
						$('.alert-error').show();
						$('.billRevErrorMsg').text(errorMsg);
					}
					
					if(!isError) {
						$('.alert-error').hide();
						revBillCtrl.forward($(custName).val(), $(custNameDesc).val(), $(userId).val(), $(txnRef).val(), 
								$(productId).val(), $(amount).val(), $(currency).val(), $(payItemId).val(), $(payItemName).val(), 
								$(custId).val(), $(custIdDesc).val(), $(siteName).val(), $(siteRedirectUrl).val(), $(hash).val());
					}
				}
			});
		},
		forward: function(custName, custNameDesc, userId, txnRef, productId, amount, currency, payItemId, payItemName, custId, custIdDesc, siteName, siteRedirectUrl, hash) {
			var revBillRes = {};
			revBillRes.custName = custName;
			revBillRes.custNameDesc = custNameDesc;
			revBillRes.userId = userId;
			revBillRes.txnRef = txnRef;
			revBillRes.productId = productId;
			revBillRes.amount = amount;
			revBillRes.currency = currency;
			revBillRes.payItemId = payItemId;
			revBillRes.payItemName = payItemName;
			revBillRes.custId = custId;
			revBillRes.custIdDesc = custIdDesc;
			revBillRes.siteName = siteName;
			revBillRes.siteRedirectUrl = siteRedirectUrl;
			revBillRes.hash = hash;
			
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			var successMsg = "Forwarding...";
			var serverErrorMsg = "Internal Server Error";
			
			$.ajax({
				url: 'https://webpay.interswitchng.com/paydirect/pay',
				type: 'post',
				crossDomain: true,
			    dataType: 'json',
				contentType: 'application/json',
				headers: { "Accept": "application/json; odata=verbose" }, 
				data: JSON.stringify(revBillRes),
				beforeSend: function() {
					$('#revBill').text('Forwarding...');
					
				},
				}).done(function(data) {
					$('.alert-success').show();
					$('.billRevSuccessMsg').text(successMsg);
				}).fail(function(data) {
					$('#revBill').text('Continue');
					$('.alert-info').show();
					$('.serverErrorMsg').text(serverErrorMsg);
				}).always(function() {
					$('#revBill').text('Continue');
				});
		}
};