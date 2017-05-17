<%-- 
    Document   : add student course
    Created on : May 11, 2017
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

<script src="<c:url value="/resources/src/js/frontend/students/courses/addscourse.js" /> " type="text/javascript"></script>

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
	                  	<label for="courseId" class="control-label">Select Course:</label>
		                 <select id="courseId" style="width:100%; font-weight: 0; font-size: 12px;">
			             	<option value="0">Select Course</option>
				              <c:if test="${not empty courses}">
				              	<c:forEach items="${courses}" var="course">
				                	<option value="${course.id}">${course.name}</option>
				                </c:forEach>
				              </c:if>
		                 </select>
	                  </div>
	                  
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="billId" class="control-label">Select Billing Reference:</label>
		                <select id="billId" style="width:100%; font-weight: 0; font-size: 12px;">
			             	<option value="0">Select Billing Reference</option>
				              <c:if test="${not empty bills}">
				              	<c:forEach items="${bills}" var="bill">
				              		<c:if test="${bill.userId.username == pageContext.request.userPrincipal.name}">
				                		<option value="${bill.id}">${bill.referenceNumber}</option>
				                	</c:if>
				                </c:forEach>
				              </c:if>
		                 </select>
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
             <input type="hidden" id="status" name="status" value="pending" />
        </form>
	</div>
</div>