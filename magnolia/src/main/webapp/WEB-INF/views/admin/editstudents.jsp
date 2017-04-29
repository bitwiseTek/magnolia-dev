<%-- 
    Document   : edit admin student
    Created on : Apr 18, 2017
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
		<form:form class="animated fadeIn validate" method="PUT" id="student" modelAttribute="student">
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
	                    <label for="username" class="form-control">${student.user.id}</label>
	                    <form:input class="form-control" id="username" name="username" placeholder="Username" path="user.id" type="hidden" />
	                  </div>
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="studentId" class="control-label">Student ID:</label>
	                    <form:input class="form-control" id="studentId" name="studentId" placeholder="Student ID" path="studentId" />
	                    <form:errors class="error" path="studentId" />
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-6 col-sm-6">
	                  		<label for="partType" class="control-label">Participation Type:</label>
	                  		<form:select id="partType" path="participationType" style="width:100%">
								<<form:option value="${currentPartType}">${currentPartType}</form:option>
								<form:options items="${partTypes}"></form:options>
							</form:select>
							<form:errors class="error" path="participationType" />
	                  </div>
	                  <div class="col-md-6 col-sm-6">
	                  		<label for="enrolType" class="control-label">Course Enrollment Type:</label>
	                  		<form:select id="enrolType" path="courseEnrolmentType" style="width:100%">
								<<form:option value="${currentEnrolType}">${currentEnrolType}</form:option>
								<form:options items="${enrolTypes}"></form:options>
							</form:select>
							<form:errors class="error" path="courseEnrolmentType" />
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-6 col-sm-6">
	                  		<label for="lodging" class="control-label">Accommodation Preference:</label>
	                  		<form:select id="lodging" path="lodging" style="width:100%">
								<<form:option value="${currentLodging}">${currentLodging}</form:option>
								<form:options items="${lodgings}"></form:options>
							</form:select>
							<form:errors class="error" path="lodging" />
	                  </div>
	                  <div class="col-md-6 col-sm-6">
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
		                  	<label for="dept" class="control-label">Student Department Code:</label>
	                  		<form:select id="dept" path="studentDepartment.departmentId" style="width:100%; font-weight: 0; font-size: 12px;">
			                		<c:if test="${not empty depts}">
				                      	<c:forEach items="${depts}" var="dept">
				                      	 	<form:option value="${dept.departmentId}">${dept.code}</form:option>
				                      	</c:forEach>
			                      </c:if>
							</form:select>
							<form:errors class="error" path="studentDepartment.departmentId" />
	                    </div>
	                    
	                  	<div class="col-md-6 col-sm-6">
	                  		<label for="endReason" class="control-label">Student End Reason:</label>
							<form:select id="endReason" path="studyEndReason" style="width:100% font-weight: 0; font-size: 12px;">
								<form:option value="${currentEndReason}">${currentEndReason}</form:option>
								<form:options items="${endReasons}"></form:options>
							</form:select>
							<form:errors class="error" path="studyEndReason" />
	                    </div>
	               	</div>
                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
		                  	<label for="dept" class="control-label">Student Department:</label>
	                  		<form:select id="dept" path="studentDepartment.departmentId" style="width:100%; font-weight: 0; font-size: 12px;">
			                		<c:if test="${not empty depts}">
				                      	<c:forEach items="${depts}" var="dept">
				                      	 	<form:option value="${dept.departmentId}">${dept.name}</form:option>
				                      	</c:forEach>
			                      </c:if>
							</form:select>
							<form:errors class="error" path="studentDepartment.departmentId" />
	                    </div>
	                    
	                  	<div class="col-md-6 col-sm-6">
	                  		<label for="programme" class="control-label">Student Programme:</label>
	                  		<form:select id="programme" path="studyProgramme.id" style="width:100%; font-weight: 0; font-size: 12px;">
			                		<c:if test="${not empty programmes}">
				                      	<c:forEach items="${programmes}" var="programme">
				                      	 	<form:option value="${programme.id}">${programme.name}</form:option>
				                      	</c:forEach>
			                      </c:if>
							</form:select><form:errors class="error" path="studyProgramme.id" />
							
	                    </div>
	               	</div>
	               	
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
	               			<label for="startDate" class="control-label">Student Start Date:</label>
	                  		<label for="startDate" class="form-control"><joda:format value="${student.startDate}" pattern="${createdDatePattern}"/></label>
	                  		<form:hidden class="form-control" id="startDate" name="startDate" placeholder="Start Date" path="startDate" />
	                    </div>
	                    
	                  	<div class="col-md-6 col-sm-6">
	                  		<label for="programmeEnd" class="control-label">Student End Date:</label>
	                  		<label for="programmeEnd" class="form-control"><joda:format value="${student.programmeEndDate}" pattern="${createdDatePattern}"/></label>
	                  		<form:hidden class="form-control" id="startDate" name="programmeEnd" placeholder="Programme End Date" path="programmeEndDate" />
	                    </div>
	               	</div>
	               	
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	               		<div class="col-md-6 col-sm-6">
	                  		<label for="studyStatus" class="control-label">Student Study Status:</label>
	                  		<label for="studyStatus" class="form-control">${student.studyStatus}</label>
	                    	<form:hidden class="form-control" id="studyStatus" name="studyStatus" placeholder="Study Status" path="studyStatus" />
	                    	<form:errors class="error" path="studyStatus" />
	                  	</div>
	                	<div class="col-md-6 col-sm-6">
	               			<label for="endDate" class="control-label">Student Actual End Date:</label>
	                  		<label for="endDate" class="form-control"><joda:format value="${student.actualEndDate}" pattern="${createdDatePattern}"/></label>
	                  		<form:hidden class="form-control" id="actualEndDate" name="actualEndDate" placeholder="End Date" path="actualEndDate" />
	                    </div>
	               	</div>
	               	
                 	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                 <div class="col-md-12">
                         	<label for="endText" class="control-label">End Text:</label>
		                    <form:textarea class="form-control" id="endText" name="endText" placeholder="Study End Text" rows="15" path="studyEndText" />
		                    <form:errors class="error" path="studyEndText" />
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
        </form:form>
	</div>
</div>

