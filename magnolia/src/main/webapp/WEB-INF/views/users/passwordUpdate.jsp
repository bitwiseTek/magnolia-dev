<%-- 
    Document   : password update
    Created on : 28 Mar, 2017
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

<div align="left" class="container">
	<div align="left" class="login-container animated fadeInUp">
		<div style="margin-top: -80px;" align="left">
	 		<a href="<c:url value="/" /> "><img src="<c:url value="/resources/assets/img/school_logo.png" /> " class="logo" width="40" height="40" /></a>
		</div>
		<form:form class="animated fadeIn validate" method="PUT" modelAttribute="user">
			<input type="hidden" name="_method" value="PUT" />
        		<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
        			<h3 align="left" class="appTitle"><span class="lsf-icon" title="lock"><spring:message code="users.editSystemUser.password.update" arguments="${user.username}" /></span></h3>
        			<div>&nbsp;</div>
        			<div class="col-md-10 col-sm-10">
        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
        					<div class="col-md-7 col-sm-7">
        						<label for="newPassword" class="control-label"><spring:message code="users.editSystemUser.new.password" /></label>
		                    	<form:password class="form-control" id="newPassword" name="newPassword" placeholder="New Password" path="tempPassword" />
        					</div>
        				</div>
        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
        					<div class="col-md-7 col-sm-7">
        						<label for="confirmPassword" class="control-label"><spring:message code="users.editSystemUser.password" /></label>
		                    	<form:password class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" path="password" />
        					</div>
        				</div>
        				
        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                  <div class="col-md-1 col-sm-1">
		                  	<button class="btn btn-success btn-cons">
		                  		<div class="lsf-icon" title="edit">Edit</div>
		               		</button>
		                  </div>
		                </div>
        			</div>
        		</div>
        	<form:hidden id="username" name="username" path="username" />
        	<form:hidden id="primaryEmail" name="primaryEmail" path="primaryEmail" />
        	<form:hidden id="secretAnswer" name="secretAnswer" path="secretAnswer" />
        	<form:hidden id="createdAt" name="createdAt" path="createdAt" />
        	<form:hidden id="lastLogin" name="lastLogin" path="lastLogin" />
        	<form:hidden id="lastLogout" name="lastLogout" path="lastLogout" />
        	<form:hidden id="photoBase64" name="photoBase64" path="photoBase64" />
        	<form:hidden id="lga.id" name="lga.id" path="lga.id" />
        	<form:hidden id="state.id" name="state.id" path="state.id" />
        	<form:hidden id="lastName" name="lastName" path="lastName" />
        	<form:hidden id="firstName" name="firstName" path="firstName" />
        	<form:hidden id="status" name="status" path="status" />
        	<form:hidden id="secretQuestion" name="secretQuestion" path="secretQuestion" />
        	<form:hidden id="sex" name="sex" path="sex" />
        	<form:hidden id="streetAddress" name="streetAddress" path="streetAddress" />
        	<form:hidden id="primaryNumber" name="primaryNumber" path="primaryNumber" />
        	<form:hidden id="birthday" name="birthday" path="birthday" />
        </form:form>
	</div>
</div>