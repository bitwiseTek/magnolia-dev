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

<div class="container">
      <div class="row login-container column-seperation">
        <div align="center" class="col-md-5 col-md-offset-1">
          <a href="<c:url value="/" /> "><img src="<c:url value="/resources/assets/img/mid_logo.png" /> " class="img-responsive"></a>
        </div>
        <div class="col-md-5">
          <br>
          <spring:url value="/j_spring_security_check" var="logIn"></spring:url>
          <form class="login-form validate" id="login-form" name="login-form" method="POST" action="${logIn}">
            <div class="row">
              <div class="form-group col-md-10">
              	<h3 align="left"><span class="lsf-icon" title="user"><spring:message code="users.login.pageTitle" /></span></h3>
              	<div>&nbsp;</div>
                <label class="form-label"><spring:message code="users.login.usernameTitle" /></label>
                <input class="form-control" id="username" name="username" type="text" required>
              </div>
            </div>
            <div class="row">
              <div class="form-group col-md-10">
                <label class="form-label"><spring:message code="users.login.passwordTitle" /></label> <span class="help"></span>
                <input class="form-control" id="password" name="password" type="password" required>
              </div>
            </div>
            <div class="row">
              <div class="control-group col-md-10">
                <div class="checkbox checkbox check-success">
                  <a href="<c:url value="/auth/password/recover/token" /> ">Forgot Password?</a>&nbsp;&nbsp;
                  <input id="checkbox1" type="checkbox" value="1">
                  <label for="checkbox1">Remember Me</label>
                </div>
              </div>
            </div>
            <div class="row">
             	<div class="col-md-10">
                	<button class="btn btn-primary btn-cons pull-right" type="submit"><i class="fa fa-sign-in"></i>&nbsp;Login</button>
              	</div>
            </div>
            <div class="row">
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
      </div>
    </div>
    <!-- END CONTAINER -->