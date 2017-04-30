<%-- 
    Document   : edit admin staff
    Created on : Apr 30, 2017
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
		<form:form class="animated fadeIn validate" method="PUT" id="staff" modelAttribute="staff">
			<input type="hidden" name="_method" value="PUT" />
        	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">	
              	<div class="col-md-2 col-sm-2">
              		<div class="col-md-12">
	           			<a href="#loc_photo" ></a><div id="preview_photo" class="centered" ><img src="<c:url value="/resources/assets/img/mg/${pageContext.request.userPrincipal.name}.png" /> " class="img-circle" width="80"></div>
	           		</div>
           		</div>
           		
           		<div class="col-md-10 col-sm-10">
	                
           			<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="username" class="control-label">User ID:</label>
	                    <label for="username" class="form-control">${staff.user.id}</label>
	                    <form:input class="form-control" id="username" name="username" placeholder="Username" path="user.id" type="hidden" />
	                  </div>
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="staffId" class="control-label">Staff ID:</label>
	                    <form:input class="form-control" id="staffId" name="staffId" placeholder="Staff ID" path="staffId" />
	                    <form:errors class="error" path="staffId" />
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
		                  	<label for="dept" class="control-label">Staff Department Code:</label>
	                  		<form:select id="dept" path="staffDepartment.departmentId" style="width:100%; font-weight: 0; font-size: 12px;">
			                		<c:if test="${not empty depts}">
				                      	<c:forEach items="${depts}" var="dept">
				                      	 	<form:option value="${dept.departmentId}">${dept.code}</form:option>
				                      	</c:forEach>
			                      </c:if>
							</form:select>
							<form:errors class="error" path="staffDepartment.departmentId" />
	                    </div>
	                	<div class="col-md-6 col-sm-6">
		                  	<label for="dept" class="control-label">Staff Department:</label>
	                  		<form:select id="dept" path="staffDepartment.departmentId" style="width:100%; font-weight: 0; font-size: 12px;">
			                		<c:if test="${not empty depts}">
				                      	<c:forEach items="${depts}" var="dept">
				                      	 	<form:option value="${dept.departmentId}">${dept.name}</form:option>
				                      	</c:forEach>
			                      </c:if>
							</form:select>
							<form:errors class="error" path="staffDepartment.departmentId" />
	                    </div>
	               	</div>
	               	
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	               		<div class="col-md-6 col-sm-6">
	               			<label for="isAcademic" class="control-label">Academic?:</label>
	               			<form:checkbox path="isAcademic" />
	               		</div>
	               		<div class="col-md-6 col-sm-6">
	               			<label for="isTemporary" class="control-label">Temporary?:</label>
	               			<form:checkbox path="isTemporary" />
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
	                  	<div class="col-md-1 col-sm-1">
	                  		<button class="btn btn-success btn-cons">
	                  			<div class="lsf-icon" title="edit">Edit</div>
	               			</button>
	                  	</div>
	                </div>
              	</div>
             </div>
             <form:hidden id="apiKey" name="apiKey" path="apiKey" />
             <form:hidden id="title" name="title" path="title" />
        </form:form>
	</div>
</div>

