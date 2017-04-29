<%-- 
    Document   : admin bill view
    Created on : Apr 27, 2017
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
		<form:form class="animated fadeIn validate" method="PUT" id="bill" modelAttribute="bill">
			<input type="hidden" name="_method" value="PUT" />
        	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">	
              	<div class="col-md-2 col-sm-2">
              		<div class="col-md-12">
	           			<a href="#loc_photo" ></a><div id="preview_photo" class="centered" ><img src="<c:url value="/resources/assets/img/mg/${username}.png" /> " class="img-circle" width="80"></div>
	           		</div>
           		</div>
           		
           		<div class="col-md-10 col-sm-10">
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="refCode" class="control-label">Reference Code:</label>
	                    <label for="refCode" class="form-control">${bill.referenceNumber}</label>
	                    <form:input class="form-control" id="refCode" name="refCode" placeholder="Ref Code" path="referenceNumber" type="hidden" />
	                  </div>
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="studentId" class="control-label">Student ID:</label>
	                    <label for="studentId" class="form-control">${bill.studentId.studentId}</label>
	                    <form:input class="form-control" id="studentId" name="studentId" placeholder="studentId" path="studentId.id" type="hidden" />
	                  </div>
	                </div>
	                
           			<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="username" class="control-label">Username:</label>
	                    <label for="username" class="form-control">${bill.userId.user.username}</label>
	                    <form:input class="form-control" id="username" name="username" placeholder="Username" path="userId.id" type="hidden" />
	                  </div>
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="fullName" class="control-label">Full Name:</label>
	                  	<label for="fullName" class="form-control">${bill.personName.user.fullName}</label>
	                    <form:input class="form-control" id="fullName" name="fullName" placeholder="Full Name" path="personName.id" type="hidden" />
	                    <form:errors class="error" path="personName" />
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-12">
	                  	<label for="email" class="control-label">Email:</label>
	                  	<label for="email" class="form-control">${bill.emailAddress.user.primaryEmail}</label>
		              	<form:input class="form-control" id="priEmail" name="priEmail" placeholder="Primary Email" path="emailAddress.id" type="hidden" />
		              	<form:errors class="error" path="emailAddress" />
		              </div>
	                </div>
                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="session" class="control-label">Academic Session:</label>
	                  	<label for="session" class="form-control">${bill.semester.session}</label>
		              	<form:input class="form-control" id="session" name="session" placeholder="Session" path="semester.id" type="hidden"/>
		              	<form:errors class="error" path="semester" />
		              </div>
		              
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="programme" class="control-label">Study Programme:</label>
	                  	<label for="programme" class="form-control">${bill.studyProgramme.name}</label>
	                  	<form:input class="form-control" id="programme" name="programme" placeholder="Programme" path="studyProgramme.id" type="hidden" />
	                  	<form:errors class="error" path="studyProgramme" />
	                  </div>
	                </div>
              
                 	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-12">
	                  	<label for="address" class="control-label">Street Address:</label>
	                  	<label for="address" class="form-control">${bill.streetAddress.user.streetAddress}</label>
	                  	<form:input id="address" name="address" placeholder="Enter Street Address ..." class="form-control" path="streetAddress.id" type="hidden"/>
	                  	<form:errors class="error" path="streetAddress" />
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                 <div class="col-md-6 col-sm-6">
		                 	<label for="paymentMethod" class="control-label">Payment Method:</label>
		                 	<label for="paymentMethod" class="form-control">${bill.paymentMethod}</label>
		                    <form:input class="form-control" id="paymentMethod" name="paymentMethod" placeholder="Method" path="paymentMethod" type="hidden"/>
		                    <form:errors class="error" path="paymentMethod" />
		                 </div>
		                 
		                 <div class="col-md-6 col-sm-6">
		                 	<label for="amount" class="control-label">Fees Amount:</label>
		                 	<label for="amount" class="form-control">${bill.feesAmount}</label>
		                   <form:input class="form-control" id="amount" name="amount" placeholder="Amount" path="feesAmount" type="hidden"/>
		                   <form:errors class="error" path="feesAmount" />
		                 </div>
                 	</div>
	               	
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	               		<div class="col-md-6 col-sm-6">
	               			<label for="statement" class="control-label">Payment Statement:</label>
		                	<form:select id="statement" path="statement" style="width:100%">
								<form:option value="${currentStatement}">${currentStatement}</form:option>
								<form:options items="${statements}"></form:options>
							</form:select>
							<form:errors class="error" path="statement" />
						</div>
	                    
	                  	<div class="col-md-6 col-sm-6">
	                  		<label for="payRef" class="control-label">Payment Reference:</label>
	                  		<label for="payRef" class="form-control">${bill.paymentReference}</label>
	                  		<form:hidden class="form-control" id="payRef" name="payRef" placeholder="Pay Ref" path="paymentReference" />
	                    </div>
	               	</div>
	               	
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	               		<div class="col-md-6 col-sm-6">
	               			<label for="responseCode" class="control-label">Response Code:</label>
	                  		<label for="responseCode" class="form-control">${bill.responseCode}</label>
	                  		<form:hidden class="form-control" id="responseCode" name="responseCode" placeholder="Response Code" path="responseCode" />
	                    </div>
	                    
	                  	<div class="col-md-6 col-sm-6">
	                  		<label for="paidAt" class="control-label">Paid At:</label>
	                  		<label for="paidAt" class="form-control"><joda:format value="${bill.paidAt}" pattern="${createdDatePattern}"/></label>
	                  		<form:hidden class="form-control" id="paidAt" name="paidAt" placeholder="Paid At" path="paidAt" />
	                    </div>
	               	</div>
	               	
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	               		<div class="col-md-6 col-sm-6">
	               			<label for="status" class="control-label">Status:</label>
		                	<form:select id="status" path="status" style="width:100%">
								<form:option value="${currentStatus}">${currentStatus}</form:option>
								<form:options items="${statuses}"></form:options>
							</form:select>
							<form:errors class="error" path="status" />
						</div>
						
	               		<div class="col-md-6 col-sm-6">
	               			<label for="notes" class="control-label">Notes:</label>
		                    <form:textarea class="form-control" id="endText" name="notes" placeholder="Notes" rows="7" path="notes" />
		                    <form:errors class="error" path="notes" />
	                  	</div>
	               	</div>
                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-1 col-sm-1">
	                  	<a href="/finance/billing/status"><button class="btn btn-success btn-cons" type="submit" formmethod="get" formaction="/finance/billing/status">
	                  		<div class="lsf-icon" title="left">Back</div>
	               		</button></a>
	                  </div>
	                </div>
              	</div>
             </div>
        </form:form>
	</div>
</div>