<%-- 
    Document   : show course
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
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ page isELIgnored="false" %>

<spring:message code="created.date.pattern" var="createdDatePattern" />

<div align="left" class="container">
	<div align="left" class="login-container animated fadeInUp">
		<div style="margin-top: -80px;" align="left">
	 		<a href="<c:url value="/" /> "><img src="<c:url value="/resources/assets/img/school_logo.png" /> " class="logo" width="40" height="40" /></a>
		</div>
		<form:form class="animated fadeIn validate" id="course" modelAttribute="scourse">
        	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
           		<div class="col-md-10 col-sm-10">
           			<div class="row">
           				<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="courses.show.course.new" arguments="${scourse.course.name}" /></span></h3>
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
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="name" class="control-label"><spring:message code="courses.show.course.name" /></label>
		                <form:input class="form-control" id="name" path="course.name" placeholder="Enter Course Name" disabled="true"/>
	                  </div>
	                  
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="code" class="control-label"><spring:message code="courses.show.course.code" /></label>
		                <form:input class="form-control" id="code" path="course.code" placeholder="Enter Course Code" disabled="true"/>
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="descr" class="control-label"><spring:message code="courses.show.course.descr" /></label>
		                <form:textarea class="form-control" id="descr" path="course.description" placeholder="Enter Course Description" rows="5" disabled="true"></form:textarea>
	                  </div>
	                  
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="semester" class="control-label"><spring:message code="courses.show.course.semester" /></label>
	                  	<form:select id="semester" path="course.semester.id" style="width:100%; font-weight: 0; font-size: 12px;" disabled="true">
				                      <c:if test="${not empty semesters}">
				                      	<c:forEach items="${semesters}" var="semester">
				                      	 	<form:option value="${semester.id}">${semester.name}</form:option>
				                      	</c:forEach>
				                      </c:if>
		                 </form:select>
		                 <form:errors class="error" path="course.semester.id" />
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="level" class="control-label"><spring:message code="courses.show.course.level" /></label>
		                <form:select id="level" path="course.academicLevel" style="width:100%" disabled="true">
		                	<form:option value="${currentLevel}">${currentLevel}</form:option>
							<form:options items="${levels}"></form:options>
		                 </form:select>
		                 <form:errors class="error" path="course.academicLevel" />
	                  </div>
	                  
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="option" class="control-label"><spring:message code="courses.show.course.option" /></label>
	                  	<form:select id="option" path="course.optionality" style="width:100%" disabled="true">
		                	<form:option value="${currentOptionality}">${currentOptionality}</form:option>
							<form:options items="${optionalities}"></form:options>
		                </form:select>
		                <form:errors class="error" path="course.optionality" />
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
        					<label for="programme" class="control-label"><spring:message code="courses.show.course.programme" /></label>
		                    <form:select id="programme" path="course.studyProgramme.id" style="width:100%; font-weight: 0; font-size: 12px;" disabled="true">
				                      <c:if test="${not empty programmes}">
				                      	<c:forEach items="${programmes}" var="programme">
				                      	 	<form:option value="${programme.id}">${programme.name}</form:option>
				                      	</c:forEach>
				                      </c:if>
		                    </form:select>
							<form:errors class="error" path="course.studyProgramme.id" />
        				</div>
        				
        				<div class="col-md-6 col-sm-6">
		                  	<label for="unit" class="control-label"><spring:message code="courses.show.course.unit" /></label>
		                  	<form:select id="unit" path="course.creditUnit" style="width:100%" disabled="true">
		                  		<form:option value="${currentUnit}">${currentUnit}</form:option>
								<form:options items="${units}"></form:options>
			                </form:select>
			                <form:errors class="error" path="course.creditUnit" />
	                  </div>
        					
	               	</div>
	               	
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-12">
	                  		<label for="lecturer" class="control-label"><spring:message code="courses.show.course.lecturer" /></label>
		                    <form:select id="lecturer" path="course.courseLecturer.id" style="width:100%; font-weight: 0; font-size: 12px;" disabled="true">
				                      <c:if test="${not empty staff}">
				                      	<c:forEach items="${staff}" var="staffer">
				                      	 	<form:option value="${staffer.id}">${staffer.user.username}</form:option>
				                      	</c:forEach>
				                      </c:if>
		                    </form:select>
		                    <form:errors class="error" path="course.courseLecturer.id" />
	                  </div>
	                </div>
	                
	                 <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                    <div class="col-md-6 col-sm-6">
	                  		<label for="status" class="control-label">Status:</label>
		                	<form:input class="form-control" id="courseStatus" path="courseStatus" placeholder="Enter Course Status" disabled="true"/>
	                  	</div>
	                  	
	                  	<div class="col-md-6 col-sm-6">
	                  		<label for="status" class="control-label">Billing Ref:</label>
		                	<form:input class="form-control" id="billing" path="billing.referenceNumber" placeholder="Enter Billing" disabled="true"/>
	                  	</div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
	                  		<label for="startDate" class="control-label">Start Date:</label>
	                  		<label for="startDate" class="form-control"><joda:format value="${scourse.startDate}" pattern="${createdDatePattern}"/></label>
	                  		<form:hidden class="form-control" id="startDate" name="startDate" placeholder="Start Date" path="startDate" />
	                    </div>
	                  	
	                  	<div class="col-md-6 col-sm-6">
	                  		<label for="endDate" class="control-label">End Date:</label>
	                  		<label for="endDate" class="form-control"><joda:format value="${scourse.endDate}" pattern="${createdDatePattern}"/></label>
	                  		<form:hidden class="form-control" id="endDate" name="endDate" placeholder="End Date" path="endDate" />
	                    </div>
	               	</div>
	               	
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<spring:url value="/students/courses/list" var="back"></spring:url>
	                  	<div>&nbsp;</div>
	                  	<div class="col-md-1 col-sm-1">
	                  		<a href="${back}"><button class="btn btn-info btn-cons" type="submit" formmethod="get" formaction="${back}">
		                  		<div class="lsf-icon" title="left"><spring:message code="courses.show.course.button" /></div>
		               		</button></a>
	                  	</div>
	                </div>
              	</div>
             </div>
        </form:form>
	</div>
</div>