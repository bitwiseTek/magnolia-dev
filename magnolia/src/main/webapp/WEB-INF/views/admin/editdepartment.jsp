<%-- 
    Document   : edit department
    Created on : May 04, 2017
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
		<form:form class="animated fadeIn validate" method="PUT" id="dept" modelAttribute="dept">
			<input type="hidden" name="_method" value="PUT" />
        	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
           		<div class="col-md-10 col-sm-10">
           			<div class="row">
           				<h3 align="left" class="appTitle"><span class="lsf-icon" title="tabs"><spring:message code="depts.edit.dept.new" arguments="${dept.name}" /></span></h3>
        				<div>&nbsp;</div>
           			</div>
              		<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-error" style="display: none;">                   
		                      <span class="deptErrorMsg"></span>
		                    </div>
		                 </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-success" style="display: none;">                   
		                      <span class="deptSuccessMsg"></span>
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
        				<label for="name" class="control-label"><spring:message code="depts.edit.dept.name" /></label>
		                <form:input class="form-control" id="name" path="name" placeholder="Enter Department Name" />
        			</div>
	                  
	                  <div class="col-md-6 col-sm-6">
	                  		<label for="code" class="control-label"><spring:message code="depts.edit.dept.code" /></label>
		                   	<form:input class="form-control" id="code" path="code" placeholder="Enter Department Code" />
	                  </div>
	                </div>
	                
	               <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
        					<div class="col-md-12">
        						<label for="faculty" class="control-label"><spring:message code="depts.edit.dept.fac" /></label>
			                  	<form:select id="faculty" path="faculty.facultyId" style="width:100%; font-weight: 0; font-size: 12px;">
			                		<c:if test="${not empty faculties}">
				                      	<c:forEach items="${faculties}" var="faculty">
				                      	 	<form:option value="${faculty.facultyId}">${faculty.name}</form:option>
				                      	</c:forEach>
			                      </c:if>
								</form:select>
								<form:errors class="error" path="faculty.facultyId" />
		                    </div>
	               	</div>
	               	
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-12">
	                  		<label for="status" class="control-label">Status:</label>
		                	<form:select id="status" path="status" style="width:100%">
								<form:option value="${currentStatus}">${currentStatus}</form:option>
								<form:options items="${statuses}"></form:options>
							</form:select>
							<form:errors class="error" path="status" />
	                  	</div>
	               	</div>
	               	
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
	                  		<label for="createdAt" class="control-label">Created At:</label>
	                  		<label for="createdAt" class="form-control">${dept.createdAt}</label>
	                  		<form:hidden class="form-control" id="createdAt" name="createdAt" placeholder="Created At" path="createdAt" />
	                    </div>
	                  	
	                  	<div class="col-md-6 col-sm-6">
	                  		<label for="createdAt" class="control-label">Updated At:</label>
	                  		<label for="createdAt" class="form-control">${dept.updatedAt}</label>
	                  		<form:hidden class="form-control" id="createdAt" name="createdAt" placeholder="Updated At" path="updatedAt" />
	                    </div>
	               	</div>
	               	
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  	<div>&nbsp;</div>
	                  	<div class="col-md-1 col-sm-1">
	                  		<button class="btn btn-danger btn-cons">
		                  		<div class="lsf-icon" title="edit"><spring:message code="depts.edit.dept.button" /></div>
		               		</button>
	                  	</div>
	                </div>
              	</div>
             </div>
        </form:form>
	</div>
</div>