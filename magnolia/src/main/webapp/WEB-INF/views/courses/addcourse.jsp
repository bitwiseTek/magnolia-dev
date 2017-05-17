<%-- 
    Document   : add course
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

<script src="<c:url value="/resources/src/js/frontend/courses/addcourse.js" /> " type="text/javascript"></script>

<div align="left" class="container">
	<div align="left" class="login-container animated fadeInUp">
		<div style="margin-top: -80px;" align="left">
	 		<a href="<c:url value="/" /> "><img src="<c:url value="/resources/assets/img/school_logo.png" /> " class="logo" width="40" height="40" /></a>
		</div>
		<form class="animated fadeIn validate" id="" name="course">
        	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
           		<div class="col-md-10 col-sm-10">
           			<div class="row">
           				<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="courses.add.course.new" /></span></h3>
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
	                  	<label for="name" class="control-label"><spring:message code="courses.add.course.name" /></label>
		                <input class="form-control" id="name" name="name" placeholder="Enter Course Name" type="text" required>
	                  </div>
	                  
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="code" class="control-label"><spring:message code="courses.add.course.code" /></label>
		                <input class="form-control" id="code" name="code" placeholder="Enter Course Code" type="text" required>
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="descr" class="control-label"><spring:message code="courses.add.course.descr" /></label>
		                <textarea class="form-control" id="descr" name="descr" placeholder="Enter Course Description" rows="5"></textarea>
	                  </div>
	                  
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="semester" class="control-label"><spring:message code="courses.add.course.semester" /></label>
	                  	<select id="semester" style="width:100%; font-weight: 0; font-size: 12px;">
			                       <option value="0">Select Academic Semester</option>
				                      <c:if test="${not empty semesters}">
				                      	<c:forEach items="${semesters}" var="semester">
				                      	 	<option value="${semester.id}">${semester.name}</option>
				                      	</c:forEach>
				                      </c:if>
		                 </select>
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="level" class="control-label"><spring:message code="courses.add.course.level" /></label>
		                <select id="level" style="width:100%">
		                	<option value="SA">Select Academic Level</option>
		                    <option value="100">100</option>
		                    <option value="200">200</option>
		                    <option value="300">300</option>
		                    <option value="400">400</option>
		                    <option value="500">500</option>
		                    <option value="600">600</option>
		                    <option value="700">700</option>
		                 </select>
	                  </div>
	                  
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="option" class="control-label"><spring:message code="courses.add.course.option" /></label>
	                  	<select id="option" style="width:100%">
		                	<option value="ST">Select Course Optionality</option>
		                    <option value="MANDATORY">Mandatory</option>
		                    <option value="OPTIONAL">Optional</option>
		                </select>
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
        					<label for="programme" class="control-label"><spring:message code="courses.add.course.programme" /></label>
		                    <select id="programme" style="width:100%; font-weight: 0; font-size: 12px;">
			                       <option value="0">Select Study Programme</option>
				                      <c:if test="${not empty programmes}">
				                      	<c:forEach items="${programmes}" var="programme">
				                      	 	<option value="${programme.id}">${programme.name}</option>
				                      	</c:forEach>
				                      </c:if>
		                    </select>
        				</div>
        				
        				<div class="col-md-6 col-sm-6">
		                  	<label for="unit" class="control-label"><spring:message code="courses.add.course.unit" /></label>
		                  	<select id="unit" style="width:100%">
		                  		<option value="SU">Select Course Unit</option>
			                    <option value="1.0">1.0</option>
			                    <option value="2.0">2.0</option>
			                    <option value="3.0">3.0</option>
			                    <option value="4.0">4.0</option>
			                    <option value="5.0">5.0</option>
			                    <option value="6.0">6.0</option>
			                    <option value="7.0">7.0</option>
			                    <option value="8.0">8.0</option>
			                    <option value="9.0">9.0</option>
			                </select>
	                  </div>
        					
	               	</div>
	               	
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-12">
	                  		<label for="lecturer" class="control-label"><spring:message code="courses.add.course.lecturer" /></label>
		                    <select id="lecturer" style="width:100%; font-weight: 0; font-size: 12px;">
			                       <option value="0">Select Course Lecturer</option>
				                      <c:if test="${not empty staff}">
				                      	<c:forEach items="${staff}" var="staffer">
				                      	 	<option value="${staffer.id}">${staffer.user.fullName}</option>
				                      	</c:forEach>
				                      </c:if>
		                    </select>
	                  </div>
	                </div>
	                
	               <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
        						<label for="createdBy" class="control-label"><spring:message code="courses.add.course.createdby" /></label>
		                    	<c:if test="${not empty users}">
				                    <select id="createdBy" style="width:100%; font-weight: 0; font-size: 12px;" disabled="disabled">
				                    	<c:forEach items="${users}" var="user">
				                    		<c:if test="${user.username == pageContext.request.userPrincipal.name}">
					                       		<option value="${user.id}">${user.username}</option>
						                     </c:if>
						                 </c:forEach>
				                    </select>
			                    </c:if>
        					</div>
        					
        					<div class="col-md-6 col-sm-6">
        						<label for="updatedBy" class="control-label"><spring:message code="courses.add.course.updatedby" /></label>
		                    	<c:if test="${not empty users}">
				                    <select id="updatedBy" style="width:100%; font-weight: 0; font-size: 12px;" disabled="disabled">
				                    	<c:forEach items="${users}" var="user">
				                    		<c:if test="${user.username == pageContext.request.userPrincipal.name}">
					                       		<option value="${user.id}">${user.username}</option>
						                     </c:if>
						                 </c:forEach>
				                    </select>
			                    </c:if>
		                    </div>
	               	</div>
	               	
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  	<div>&nbsp;</div>
	                  	<div class="col-md-1 col-sm-1">
	                  		<button type="button" class="btn btn-success btn-cons" name="courseAdd" id="courseAdd">
		                  		<div class="lsf-icon" title="plus"><spring:message code="courses.add.course.button" /></div>
		               		</button>
	                  	</div>
	                </div>
              	</div>
             </div>
             <input type="hidden" id="status" name="status" value="active" />
        </form>
	</div>
</div>