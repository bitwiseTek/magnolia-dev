<%-- 
    Document   : register course
    Created on : May 13, 2017
    Author     : Sika Kay
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ page isELIgnored="false" %>

<spring:message code="created.date.pattern" var="createdDatePattern" />

<div align="left" class="container">
	<div align="left" class="login-container animated fadeInUp">
		<div style="margin-top: -80px;" align="left">
	 		<a href="<c:url value="/" /> "><img src="<c:url value="/resources/assets/img/school_logo.png" /> " class="logo" width="40" height="40" /></a>
		</div>
		<form:form class="animated fadeIn validate" method="PUT" modelAttribute="scourse">
			<input type="hidden" name="_method" value="PUT" />
        	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
           		<div class="col-md-10 col-sm-10">
           			<div class="row">
           				<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="courses.register.course.new" arguments="${scourse.course.name}" /></span></h3>
        				<div>&nbsp;</div>
           			</div>
              		<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-error" style="display: none;">                   
		                      <span class="courseErrorMsg"></span>
		                    </div>
		                 </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-success" style="display: none;">                   
		                      <span class="courseSuccessMsg"></span>
		                    </div>
		                 </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-info" style="display: none;">                   
		                      <span class="serverErrorMsg"></span>
		                    </div>
		                 </div>
	                </div>
	                
           			<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-12">
	                  	<label for="name" class="control-label"><spring:message code="courses.show.course.name" /></label>
			 			<label for="name" class="form-control">${scourse.course.name}</label>
			 			<form:input path="course.id" class="form-control input-lg" placeholder="Course Name" type="hidden" />
						<form:errors class="error" path="course.id" />
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-12">
	                  	<label for="register" class="control-label"><spring:message code="courses.register.course.register"></spring:message></label>
		               	<form:checkbox path="toggleOnOff" data-toggle="toggle" data-on="Registered" data-off="Unregistered" data-onstyle="warning"/>
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-12">
	                  	<form:label path="students"><spring:message code="courses.register.course.select"></spring:message></form:label>
			 			<form:select path="students" items="${students}" multiple="true" itemValue="id" itemLabel="studentId" class="form-control input-lg" placeholder="Student Id" />
			 			<div class="help-block with-errors">
							<form:errors class="error" path="students" />
						</div>
	                  </div>
	                </div>
	               	
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  	<div>&nbsp;</div>
	                  	<div class="col-md-1 col-sm-1">
	                  		<button class="btn btn-success btn-cons">
		                  		<div class="lsf-icon" title="plus"><spring:message code="courses.register.course.button" /></div>
		               		</button>
	                  	</div>
	                </div>
              	</div>
             </div>
             <form:hidden id="courseStatus" name="courseStatus" path="courseStatus" />
             <form:hidden id="startDate" name="startDate" path="startDate" />
             <form:hidden id="endDate" name="endDate" path="endDate" />
             <form:hidden id="billing" name="biiling" path="billing.id" />
        </form:form>
	</div>
</div>