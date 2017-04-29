<%-- 
    Document   : pay bill
    Created on : Apr 26, 2017
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
		
		<form class="animated fadeIn validate" id="" name="billPay">
        		<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
        			<h3 align="left" class="appTitle"><span class="lsf-icon" title="memo"><spring:message code="students.billing.pay" /></span></h3>
        			<div>&nbsp;</div>
        			<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-error" style="display: none;">                   
		                      <span class="billingErrorMsg"></span>
		                    </div>
		                 </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-success" style="display: none;">                   
		                      <span class="billingSuccessMsg"></span>
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
	                
        			<div class="col-md-10 col-sm-10">
        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
        					<div class="col-md-6 col-sm-6">
        						<c:if test="${not empty users}">
        							<label for="userId" class="control-label"><spring:message code="students.billing.label.username" /></label>
				                    <select id="userId" style="width:100%; font-weight: 0; font-size: 12px;" disabled="disabled">
				                    	<c:forEach items="${users}" var="user">
				                    		<c:if test="${user.username == pageContext.request.userPrincipal.name}">
					                       		<option value="${user.id}">${user.username}</option>
						                     </c:if>
						                 </c:forEach>
				                    </select>
	                    		</c:if>
        					</div>
        					
        					<div class="col-md-6 col-sm-6">
        						<c:if test="${not empty students}">
        							<label for="studentId" class="control-label"><spring:message code="students.billing.label.studentId" /></label>
				                    <select id="studentId" style="width:100%; font-weight: 0; font-size: 12px;" disabled="disabled">
				                    	<c:forEach items="${students}" var="student">
				                    		<c:if test="${student.user.username == pageContext.request.userPrincipal.name}">
					                       		<option value="${student.id}">${student.studentId}</option>
						                     </c:if>
						                 </c:forEach>
				                    </select>
	                    		</c:if>
        					</div>
        				</div>
        				
        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
        					<div class="col-md-6 col-sm-6">
        						<c:if test="${not empty students}">
        							<label for="fullName" class="control-label"><spring:message code="students.billing.label.fullName" /></label>
				                    <select id="fullName" style="width:100%; font-weight: 0; font-size: 12px;" disabled="disabled">
				                    	<c:forEach items="${students}" var="student">
				                    		<c:if test="${student.user.username == pageContext.request.userPrincipal.name}">
					                       		<option value="${student.id}">${student.user.fullName}</option>
						                     </c:if>
						                 </c:forEach>
				                    </select>
	                    		</c:if>
        					</div>
        					
        					<div class="col-md-6 col-sm-6">
        						<c:if test="${not empty students}">
        							<label for="email" class="control-label"><spring:message code="students.billing.label.email" /></label>
				                    <select id="email" style="width:100%; font-weight: 0; font-size: 12px;" disabled="disabled">
				                    	<c:forEach items="${students}" var="student">
				                    		<c:if test="${student.user.username == pageContext.request.userPrincipal.name}">
					                       		<option value="${student.id}">${student.user.primaryEmail}</option>
						                     </c:if>
						                 </c:forEach>
				                    </select>
	                    		</c:if>
        					</div>
        				</div>
        				
        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
        					<div class="col-md-6 col-sm-6">
        						<c:if test="${not empty students}">
        							<label for="state" class="control-label"><spring:message code="students.billing.label.state" /></label>
				                    <select id="state" style="width:100%; font-weight: 0; font-size: 12px;" disabled="disabled">
				                    	<c:forEach items="${students}" var="student">
				                    		<c:if test="${student.user.username == pageContext.request.userPrincipal.name}">
					                       		<option value="${student.id}">${student.user.state.name}</option>
						                     </c:if>
						                 </c:forEach>
				                    </select>
	                    		</c:if>
        					</div>
        					
        					<div class="col-md-6 col-sm-6">
        						<c:if test="${not empty students}">
        							<label for="lga" class="control-label"><spring:message code="students.billing.label.lga" /></label>
				                    <select id="lga" style="width:100%; font-weight: 0; font-size: 12px;" disabled="disabled">
				                    	<c:forEach items="${students}" var="student">
				                    		<c:if test="${student.user.username == pageContext.request.userPrincipal.name}">
					                       		<option value="${student.id}">${student.user.lga.name}</option>
						                     </c:if>
						                 </c:forEach>
				                    </select>
	                    		</c:if>
        					</div>
        				</div>
        				
        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
        					<div class="col-md-12">
        						<c:if test="${not empty students}">
        							<label for="address" class="control-label"><spring:message code="students.billing.label.address" /></label>
				                    <select id="address" style="width:100%; font-weight: 0; font-size: 12px;" disabled="disabled">
				                    	<c:forEach items="${students}" var="student">
				                    		<c:if test="${student.user.username == pageContext.request.userPrincipal.name}">
					                       		<option value="${student.id}">${student.user.streetAddress}</option>
						                     </c:if>
						                 </c:forEach>
				                    </select>
	                    		</c:if>
        					</div>
        				</div>
        				
        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
        					<div class="col-md-6 col-sm-6">
        						<c:if test="${not empty semesters}">
        							<label for="session" class="control-label"><spring:message code="students.billing.label.session" /></label>
				                    <select id="session" style="width:100%; font-weight: 0; font-size: 12px;" disabled="disabled">
				                    	<c:forEach items="${semesters}" var="semester">
					                       	<option value="${semester.id}">${semester.session}</option>
						                 </c:forEach>
				                    </select>
	                    		</c:if>
        					</div>
        					
        					<div class="col-md-6 col-sm-6">
        						<c:if test="${not empty students}">
        							<label for="programme" class="control-label"><spring:message code="students.billing.label.programme" /></label>
				                    <select id="programme" style="width:100%; font-weight: 0; font-size: 12px;" disabled="disabled">
				                    	<c:forEach items="${students}" var="student">
				                    		<c:if test="${student.user.username == pageContext.request.userPrincipal.name}">
					                       		<option value="${student.id}">${student.studyProgramme.name}</option>
						                     </c:if>
						                 </c:forEach>
				                    </select>
	                    		</c:if>
        					</div>
        				</div>
        				
        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
        					<div class="col-md-6 col-sm-6">
        						<label for="paymentMethod" class="control-label"><spring:message code="students.billing.label.method" /></label>
		                    	<input class="form-control" id="paymentMethod" name="paymentMethod" placeholder="Enter Method Name" value="ONLINE (WebPay)" type="text" disabled>
        					</div>
        					
        					<div class="col-md-6 col-sm-6">
        						<label for="amount" class="control-label"><spring:message code="students.billing.label.amount" /></label>
		                    	<input class="form-control" id="amount" name="amount" placeholder="Enter Amount" value="65600.00" type="text" disabled>
        					</div>
        				</div>
        				
        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                  <div class="col-md-1 col-sm-1">
		                  	<button type="button" class="btn btn-success btn-cons" name="payBill" id="payBill">
		                  		<div class="lsf-icon" title="right"><spring:message code="students.billing.pay.button" /></div>
		               		</button>
		                  </div>
		                </div>
        			</div>
        		</div>
        </form>
	</div>
</div>