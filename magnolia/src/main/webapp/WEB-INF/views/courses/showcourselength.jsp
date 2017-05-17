<%-- 
    Document   : show courselength
    Created on : May 03, 2017
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
		<form:form class="animated fadeIn validate" id="length" modelAttribute="length">
        	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
           		<div class="col-md-10 col-sm-10">
           			<div class="row">
           				<h3 align="left" class="appTitle"><span class="lsf-icon" title="time"><spring:message code="lengths.show.length.new" arguments="${length.name}" /></span></h3>
        				<div>&nbsp;</div>
           			</div>
              		<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-error" style="display: none;">                   
		                      <span class="lengthErrorMsg"></span>
		                    </div>
		                 </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-success" style="display: none;">                   
		                      <span class="lengthSuccessMsg"></span>
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
	                  	<label for="name" class="control-label"><spring:message code="lengths.show.length.name" /></label>
		                <form:input class="form-control" id="name" path="name" placeholder="Enter Course Length Name" disabled="true"/>
	                  </div>
	                </div>
	                
	               <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
        						<label for="hours" class="control-label"><spring:message code="lengths.show.length.hours" /></label>
		                    	<form:input class="form-control" id="hours" path="tCH" placeholder="Enter Credit Hours" disabled="true"/>
        					</div>
        					
        					<div class="col-md-6 col-sm-6">
        						<label for="unit" class="control-label"><spring:message code="lengths.show.length.units" /></label>
		                    	<form:input class="form-control" id="unit" path="tCU" placeholder="Enter Credit Unit" disabled="true"/>
        					</div>
	               	</div>
	               	
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<spring:url value="/course/lengths/list" var="back"></spring:url>
	                  	<div>&nbsp;</div>
	                  	<div class="col-md-1 col-sm-1">
	                  		<a href="${back}"><button class="btn btn-info btn-cons" type="submit" formmethod="get" formaction="${back}">
		                  		<div class="lsf-icon" title="left"><spring:message code="lengths.show.length.button" /></div>
		               		</button></a>
	                  	</div>
	                </div>
              	</div>
             </div>
        </form:form>
	</div>
</div>