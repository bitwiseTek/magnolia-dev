<%-- 
    Document   : show subschool
    Created on : May 05, 2017
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
		<form:form class="animated fadeIn validate" id="subSchool" modelAttribute="subSchool">
        	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
           		<div class="col-md-10 col-sm-10">
           			<div class="row">
           				<h3 align="left" class="appTitle"><span class="lsf-icon" title="building"><spring:message code="subschools.show.subschool.new" arguments="${subSchool.name}" /></span></h3>
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
	                  	<label for="subName" class="control-label"><spring:message code="subschools.show.subschool.name" /></label>
		                <form:input class="form-control" path="name" placeholder="Enter Sub-School Name" disabled="true" />
	                  </div>
	                  
	                  <div class="col-md-6 col-sm-6">
	                  		<label for="type" class="control-label"><spring:message code="subschools.show.subschool.type" /></label>
	                  		<form:select id="type" path="type" style="width:100%" disabled="true">
								<form:option value="${currentType}">${currentType}</form:option>
							</form:select>
							<form:errors class="error" path="type" />
	                  </div>
	                </div>
	                
	               <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
        						<label for="address" class="control-label"><spring:message code="subschools.show.subschool.addr" /></label>
		                    	<form:input class="form-control" path="address" placeholder="Enter Address" disabled="true" />
        					</div>
        					
        					<div class="col-md-6 col-sm-6">
        						<label for="school" class="control-label"><spring:message code="subschools.show.subschool.school" /></label>
			                  	<form:select id="school" path="school.schoolId" style="width:100%; font-weight: 0; font-size: 12px;" disabled="true">
			                		<c:if test="${not empty schools}">
				                      	<c:forEach items="${schools}" var="school">
				                      	 	<form:option value="${school.schoolId}">${school.schoolName}</form:option>
				                      	</c:forEach>
			                      </c:if>
								</form:select>
								<form:errors class="error" path="school.schoolId" />
		                    </div>
	               	</div>
	               	
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
	                  		<label for="status" class="control-label">Status:</label>
		                	<form:select id="status" path="status" style="width:100%" disabled="true">
								<form:option value="${currentStatus}">${currentStatus}</form:option>
							</form:select>
							<form:errors class="error" path="status" />
	                  	</div>
	                  	
	                  	<div class="col-md-6 col-sm-6">
	                  		<label for="createdAt" class="control-label">Created At:</label>
	                  		<label for="createdAt" class="form-control">${subSchool.createdAt}</label>
	                  		<form:hidden class="form-control" id="createdAt" name="createdAt" placeholder="Created At" path="createdAt" />
	                    </div>
	               	</div>
	               	
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<spring:url value="/admin/subschools/list" var="back"></spring:url>
	                  	<div>&nbsp;</div>
	                  	<div class="col-md-1 col-sm-1">
	                  		<a href="${back}"><button class="btn btn-info btn-cons" type="submit" formmethod="get" formaction="${back}">
		                  		<div class="lsf-icon" title="left"><spring:message code="subschools.show.subschool.button" /></div>
		               		</button></a>
	                  	</div>
	                </div>
              	</div>
             </div>
        </form:form>
	</div>
</div>