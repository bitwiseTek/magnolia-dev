<%-- 
    Document   : add subschool
    Created on : Apr 02, 2017
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
		<form class="animated fadeIn validate" id="" name="sub">
        	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
           		<div class="col-md-10 col-sm-10">
           			<div class="row">
           				<h3 align="left" class="appTitle"><span class="lsf-icon" title="building"><spring:message code="subschools.add.subschool.new" /></span></h3>
        				<div>&nbsp;</div>
           			</div>
              		<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-error" style="display: none;">                   
		                      <span class="subErrorMsg"></span>
		                    </div>
		                 </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-success" style="display: none;">                   
		                      <span class="subSuccessMsg"></span>
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
	                  	<label for="subName" class="control-label"><spring:message code="subschools.add.subschool.name" /></label>
		                <input class="form-control" id="subName" name="subName" placeholder="Enter Sub-School Name" type="text" required>
	                  </div>
	                  
	                  <div class="col-md-6 col-sm-6">
	                  		<label for="type" class="control-label"><spring:message code="subschools.add.subschool.type" /></label>
	                  		<select id="type" style="width:100%">
		                       		<option value="ST">Select Type</option>
		                       		<option value="GRADUATE">Graduate</option>
		                       		<option value="UNDERGRADUATE">Undergraduate</option>
		                       		<option value="RESEARCH">Research</option>
		                       		<option value="SANDWICH">Sandwich</option>
		                    </select>
	                  </div>
	                </div>
	                
	               <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
        						<label for="address" class="control-label"><spring:message code="subschools.add.subschool.addr" /></label>
		                    	<input class="form-control" id="address" name="address" placeholder="Enter Address" type="text" required>
        					</div>
        					
        					<div class="col-md-6 col-sm-6">
        						<label for="school" class="control-label"><spring:message code="subschools.add.subschool.school" /></label>
			                  	<select id="schoolId" style="width:100%; font-weight: 0; font-size: 12px;">
			                       <option value="0">Select School</option>
				                      <c:if test="${not empty schools}">
				                      	<c:forEach items="${schools}" var="school">
				                      	 	<option value="${school.schoolId}">${school.schoolName}</option>
				                      	</c:forEach>
				                      </c:if>
		                        </select>
		                    </div>
	               	</div>
	               	
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  	<div>&nbsp;</div>
	                  	<div class="col-md-1 col-sm-1">
	                  		<button type="button" class="btn btn-success btn-cons" name="subAdd" id="subAdd">
		                  		<div class="lsf-icon" title="plus"><spring:message code="subschools.add.subschool.button" /></div>
		               		</button>
	                  	</div>
	                </div>
              	</div>
             </div>
             <input type="hidden" id="status" name="status" value="active" />
        </form>
	</div>
</div>