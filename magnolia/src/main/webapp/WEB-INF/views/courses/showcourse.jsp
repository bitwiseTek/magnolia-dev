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
		<form:form class="animated fadeIn validate" id="course" modelAttribute="course">
        	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
           		<div class="col-md-10 col-sm-10">
           			<div class="row">
           				<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="courses.show.course.new" arguments="${course.name}" /></span></h3>
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
		                <form:input class="form-control" id="name" path="name" placeholder="Enter Course Name" disabled="true"/>
	                  </div>
	                  
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="code" class="control-label"><spring:message code="courses.show.course.code" /></label>
		                <form:input class="form-control" id="code" path="code" placeholder="Enter Course Code" disabled="true"/>
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="descr" class="control-label"><spring:message code="courses.show.course.descr" /></label>
		                <form:textarea class="form-control" id="descr" path="description" placeholder="Enter Course Description" rows="5" disabled="true"></form:textarea>
	                  </div>
	                  
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="semester" class="control-label"><spring:message code="courses.show.course.semester" /></label>
	                  	<form:select id="semester" path="semester.id" style="width:100%; font-weight: 0; font-size: 12px;" disabled="true">
				                      <c:if test="${not empty semesters}">
				                      	<c:forEach items="${semesters}" var="semester">
				                      	 	<form:option value="${semester.id}">${semester.name}</form:option>
				                      	</c:forEach>
				                      </c:if>
		                 </form:select>
		                 <form:errors class="error" path="semester.id" />
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="level" class="control-label"><spring:message code="courses.show.course.level" /></label>
		                <form:select id="level" path="academicLevel" style="width:100%" disabled="true">
		                	<form:option value="${currentLevel}">${currentLevel}</form:option>
							<form:options items="${levels}"></form:options>
		                 </form:select>
		                 <form:errors class="error" path="academicLevel" />
	                  </div>
	                  
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="option" class="control-label"><spring:message code="courses.show.course.option" /></label>
	                  	<form:select id="option" path="optionality" style="width:100%" disabled="true">
		                	<form:option value="${currentOptionality}">${currentOptionality}</form:option>
							<form:options items="${optionalities}"></form:options>
		                </form:select>
		                <form:errors class="error" path="optionality" />
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
        					<label for="programme" class="control-label"><spring:message code="courses.show.course.programme" /></label>
		                    <form:select id="programme" path="studyProgramme.id" style="width:100%; font-weight: 0; font-size: 12px;" disabled="true">
				                      <c:if test="${not empty programmes}">
				                      	<c:forEach items="${programmes}" var="programme">
				                      	 	<form:option value="${programme.id}">${programme.name}</form:option>
				                      	</c:forEach>
				                      </c:if>
		                    </form:select>
							<form:errors class="error" path="studyProgramme.id" />
        				</div>
        				
        				<div class="col-md-6 col-sm-6">
		                  	<label for="unit" class="control-label"><spring:message code="courses.show.course.unit" /></label>
		                  	<form:select id="unit" path="creditUnit" style="width:100%" disabled="true">
		                  		<form:option value="${currentUnit}">${currentUnit}</form:option>
								<form:options items="${units}"></form:options>
			                </form:select>
			                <form:errors class="error" path="creditUnit" />
	                  </div>
        					
	               	</div>
	               	
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-12">
	                  		<label for="lecturer" class="control-label"><spring:message code="courses.show.course.lecturer" /></label>
		                    <form:select id="lecturer" path="courseLecturer.id" style="width:100%; font-weight: 0; font-size: 12px;" disabled="true">
				                      <c:if test="${not empty staff}">
				                      	<c:forEach items="${staff}" var="staffer">
				                      	 	<form:option value="${staffer.id}">${staffer.user.fullName}</form:option>
				                      	</c:forEach>
				                      </c:if>
		                    </form:select>
		                    <form:errors class="error" path="courseLecturer.id" />
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-12">
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
	                  		<label for="createdAt" class="form-control"><joda:format value="${course.createdAt}" pattern="${createdDatePattern}"/></label>
	                  		<form:hidden class="form-control" id="createdAt" name="createdAt" placeholder="Created At" path="createdAt" />
	                    </div>
	                  	
	                  	<div class="col-md-6 col-sm-6">
	                  		<label for="updatedAt" class="control-label">Updated At:</label>
	                  		<label for="updatedAt" class="form-control"><joda:format value="${course.updatedAt}" pattern="${createdDatePattern}"/></label>
	                  		<form:hidden class="form-control" id="updatedAt" name="updatedAt" placeholder="Updated At" path="updatedAt" />
	                    </div>
	               	</div>
	               	
	               <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
        						<label for="createdBy" class="control-label"><spring:message code="courses.show.course.createdby" /></label>
		                    	<c:if test="${not empty users}">
				                    <form:select id="createdBy" path="createdBy.id" style="width:100%; font-weight: 0; font-size: 12px;" disabled="disabled">
				                    	<c:forEach items="${users}" var="user">
				                    		<c:if test="${user.username == pageContext.request.userPrincipal.name}">
					                       		<form:option value="${user.id}">${user.username}</form:option>
						                     </c:if>
						                 </c:forEach>
				                    </form:select>
				                    <form:errors class="error" path="createdBy.id" />
			                    </c:if>
        					</div>
        					
        					<div class="col-md-6 col-sm-6">
        						<label for="updatedBy" class="control-label"><spring:message code="courses.show.course.updatedby" /></label>
		                    	<c:if test="${not empty users}">
				                    <form:select id="updatedBy" path="updatedBy.id" style="width:100%; font-weight: 0; font-size: 12px;" disabled="disabled">
				                    	<c:forEach items="${users}" var="user">
				                    		<c:if test="${user.username == pageContext.request.userPrincipal.name}">
					                       		<form:option value="${user.id}">${user.username}</form:option>
						                     </c:if>
						                 </c:forEach>
				                    </form:select>
				                    <form:errors class="error" path="updatedBy.id" />
			                    </c:if>
		                    </div>
	               	</div>
	               	
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<spring:url value="/courses/list" var="back"></spring:url>
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