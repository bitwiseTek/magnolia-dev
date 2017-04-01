<%-- 
    Document   : edit role II
    Created on : Mar 31, 2017
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
		<form:form class="animated fadeIn validate" id="role" method="PUT" modelAttribute="role">
			<input type="hidden" name="_method" value="PUT" />
        		<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
        			<h3 align="left" class="appTitle"><span class="lsf-icon" title="delicious"><spring:message code="roles.edit.role.edit" arguments="${role.roles}"/></span></h3>
        			<div>&nbsp;</div>
        			<div class="col-md-10 col-sm-10">
        				 <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
        					<div class="col-md-7 col-sm-7">
        						<label for="roles" class="control-label"><spring:message code="roles.edit.role.name" /></label>
		                		<form:input path="roles" class="form-control" />
								<div class="has-error">
									<form:errors path="roles" class="help-inline"/>
								</div>
							</div>
        				</div>
        				
        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
        					<div class="col-md-7 col-sm-7">
	        					<label for="permissions" class="control-label"><spring:message code="roles.edit.role.permission" /></label>
		                		<form:select path="permissions" items="${permissions}" multiple="true" itemValue="id" itemLabel="permissions" class="form-control" />
								<div class="has-error">
									<form:errors path="permissions" class="help-inline"/>
								</div>
        					</div>
        				</div>
        				
        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                  <div class="col-md-1 col-sm-1">
		                  	<button class="btn btn-success btn-cons">
		                  		<div class="lsf-icon" title="edit"><spring:message code="roles.edit.role.button" /></div>
		               		</button>
		                  </div>
		                </div>
        			</div>
        		</div>
        </form:form>
	</div>
</div>