<%-- 
    Document   : show category
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
		<form:form class="animated fadeIn validate" id="category" modelAttribute="category">
        	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
           		<div class="col-md-10 col-sm-10">
           			<div class="row">
           				<h3 align="left" class="appTitle"><span class="lsf-icon" title="category"><spring:message code="categories.show.category.new" arguments="${category.name}" /></span></h3>
        				<div>&nbsp;</div>
           			</div>
              		<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-error" style="display: none;">                   
		                      <span class="catErrorMsg"></span>
		                    </div>
		                 </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-success" style="display: none;">                   
		                      <span class="catSuccessMsg"></span>
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
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="name" class="control-label"><spring:message code="categories.show.category.name" /></label>
		                <form:input class="form-control" id="name" path="name" placeholder="Enter Category Name" disabled="true"/>
	                  </div>
	                  
	                  <div class="col-md-6 col-sm-6">
	                  		<label for="status" class="control-label">Status:</label>
		                	<form:select id="status" path="status" style="width:100%" disabled="true">
								<form:option value="${currentStatus}">${currentStatus}</form:option>
								<form:options items="${statuses}"></form:options>
							</form:select>
							<form:errors class="error" path="status" />
	                  	</div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
	                  		<label for="createdAt" class="control-label">Created At:</label>
	                  		<label for="createdAt" class="form-control">${category.createdAt}</label>
	                  		<form:hidden class="form-control" id="createdAt" name="createdAt" placeholder="Created At" path="createdAt" />
	                    </div>
	                  	
	                  	<div class="col-md-6 col-sm-6">
	                  		<label for="createdAt" class="control-label">Updated At:</label>
	                  		<label for="createdAt" class="form-control">${category.updatedAt}</label>
	                  		<form:hidden class="form-control" id="createdAt" name="createdAt" placeholder="Updated At" path="updatedAt" />
	                    </div>
	               	</div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<spring:url value="/programme/categories/list" var="back"></spring:url>
	                  	<div>&nbsp;</div>
	                  	<div class="col-md-1 col-sm-1">
	                  		<a href="${back}"><button class="btn btn-info btn-cons" type="submit" formmethod="get" formaction="${back}">
		                  		<div class="lsf-icon" title="left"><spring:message code="categories.show.category.button" /></div>
		               		</button></a>
	                  	</div>
	                </div>
              	</div>
             </div>
        </form:form>
	</div>
</div>