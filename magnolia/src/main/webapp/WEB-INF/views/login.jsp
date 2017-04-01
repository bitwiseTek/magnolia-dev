<%-- 
    Document   : login
    Created on : Feb 02, 2017
    Author     : Sika Kay
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false" %>

<script type="text/javascript">
	function validateRegEx(regex, input, helpText, helpMessage) {
		if (!regex.test(input)) {
			if (helpText != null) {
				helpText.innerHTML = helpMessage;
				return false;
			}
		} else {
			if (helpText != null) {
				helpText.innerHTML = "";
				return true;
			}
		}
	}
	
	function validateNonEmptyUsername(inputField, helpText) {
		return validateRegEx(/.+/, inputField.value, helpText, "Please enter a username");
	}
	
	function validateNonEmptyPassword(inputField, helpText) {
		return validateRegEx(/.+/, inputField.value, helpText, "Please enter a password");
	}
	
	function submitPage(form) {
		if (validateNonEmptyUsername(form['username'], form['username_help']) &&
		validateNonEmptyPassword(form['password'], form['password_help'])) {
			form.submit();
		} else {
			alert("Sorry but the information provided in your form is insufficient");
		}
	}
</script>
<div align="center" class="container">
	<div align="center" class="row">
			<div align="center" class="login-container animated fadeInUp">
			<div style="margin-top: -45px;" align="center">
		  	    <a href="<c:url value="/" /> "><img src="<c:url value="/resources/assets/img/mid_logo.png" /> " class="img-responsive"></a>
		   	</div>
		   	<div class="col-md-5 hidden-sm hidden-xs"></div>
		   	<div align="center" class="col-md-5" style="margin-top: 10px;">
				<h3 align="left"><span class="lsf-icon" title="user"><spring:message code="users.login.pageTitle" /></span></h3>
		 			<br />
		 			<spring:url value="/j_spring_security_check" var="logIn"></spring:url>
		 			<form class="animated fadeIn validate" name="logInForm" method="POST" action="${logIn}">
		 				<div align="left" class="form-group">
		 					<label for="username" class="control-label"><spring:message code="users.login.usernameTitle" /></label>
							<input type="text" id="username" name="username" class="form-control input-lg" placeholder="Username" 
							onblur="validateNonEmptyUsername(this, document.getElementById('username_help'))" />
							<div class="help-block with-errors">
								<span id="username_help" class="error"></span>
							</div>
		 				</div>
		 				
		 				<div align="left" class="form-group">
		 					<label for="password" class="control-label"><spring:message code="users.login.passwordTitle" /></label>
							<input type="password" id="password" name="password" class="form-control input-lg" placeholder="Password"
							onblur="validateNonEmptyPassword(this, document.getElementById('password_help'))" />
							<div class="help-block with-errors">
								<span id="password_help" class="error"></span>
							</div>
		 				</div>
						
						<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-success" id="loginBtn">
								    <div class="lsf-icon" title="key"><spring:message code="users.login.loginButton" /></div>
								</button>
							</div>
							
							<div class="col-md-4">
			                    <div style="margin-top: 7px;" class="checkbox check-success">
			                      <input id="checkbox1" type="checkbox" value="1">
			                      <label for="checkbox1">Remember Me</label>
			                    </div>
			                </div>
			                
							<div class="col-md-9">
								<c:if test="${param.error != null}">
									<div class="alert alert-danger">
										<spring:message code="users.login.loginFailed" />
									</div>
								</c:if>
								<c:if test="${param.locked != null}">
									<div class="alert alert-info">
										<spring:message code="users.login.locked" />
									</div>
								</c:if>
								<c:if test="${param.deactivated != null}">
									<div class="alert alert-info">
										<spring:message code="users.login.deactivated" />
									</div>
								</c:if>
								<c:if test="${param.logout != null}">
									<div class="alert alert-success">
										<spring:message code="users.login.loggedOut" />
									</div>
								</c:if>
							</div>
						</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		 			</form>
	 			</div>
	 		<div class="col-md-5 hidden-sm hidden-xs"></div>
		</div>
	</div>      
</div>