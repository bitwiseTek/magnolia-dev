$(document).ready(function(){
	loginCtrl.init();
});

var loginCtrl = {
		base64_photo: '',
		init: function(){
			this.validateLogin();
		},
		validateLogin: function(){
			$('button[id=loginBtn]').on('click', function(){
				var email = $('input[name="email"]');
				var password = $('input[name="password"]');
				
				$('form[name=login] input').css({'border' : '1px solid #FFF'});
				
				var isError = false;
				var errorMsg;
				
				if($.trim($(email).val()) == '' && $.trim($(password).val()) == ''){
					$('form[name=login] input').css({'border' : '1px solid #FF6666'});
					isError = true;
					errorMsg = 'All fields are required';
					$('.alert').show();
					$('.loginErrorMsg').text(errorMsg);
				}
				else{
					if($.trim($(email).val()) == '' || !loginCtrl.validateEmail($.trim($(email).val()))){
						$('form[name=login] input').css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'Warning. Incorrect login details! Pls try again';
					}
					
					if($.trim($(password).val()) == ''){
						$(password).css({'border' : '1px solid #FF6666'});
						isError = true;
						errorMsg = 'All fields are required';
					}
					
					
					if(isError){
						$('.alert').show();
						$('.loginErrorMsg').text(errorMsg);
					}
					
					if(!isError){
						$('.alert').hide();
						$('.loginErrorMsg').text('');
					}
				}
			});
		},
		validateEmail: function(email){
			var emailReg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
			var valid = emailReg.test(email);

			if(!valid) {
		        return false;
		    } else {
		    	return true;
		    }
		}
};