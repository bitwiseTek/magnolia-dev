<%-- 
    Document   : bill review
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
		
		<form class="animated fadeIn validate" name="reviewBill" method="POST" action="https://stageserv.interswitchng.com/test_paydirect/pay">
        		<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
        			<h3 align="left" class="appTitle"><span class="lsf-icon" title="memo"><spring:message code="students.billing.review" /></span></h3>
        			<div>&nbsp;</div>
        			<div class="col-md-10 col-sm-10">
        				<c:if test="${not empty bills}">
	        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	        					<c:forEach items="${bills}" var="bill">
		        					<div class="col-md-6 col-sm-6">
		        						<h3 style="color: green;"><b><label for="refNo" class="control-label"><spring:message code="students.billing.label.ref" /></label></b></h3>
		        						<c:if test="${bill.studentId.user.username == pageContext.request.userPrincipal.name}">
				                    		<label for="refNo" class="control-label">${bill.referenceNumber}</label>
				                    	</c:if>
		        					</div>
	        					</c:forEach>
	        				</div>
        				</c:if>
        				<div>&nbsp;</div>
	        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	        					<div class="col-md-6 col-sm-6">
	        						<c:if test="${not empty bills}">
	        							<h3 style="color: green;"><b><label for="fullName" class="control-label"><spring:message code="students.billing.label.fullName" /></label></b></h3>
					                    	<c:forEach items="${bills}" var="bill">
					                    		<c:if test="${bill.studentId.user.username == pageContext.request.userPrincipal.name}">
						                       		<label for="fullName" class="control-label">${bill.studentId.user.fullName}</label>
							                     </c:if>
							                 </c:forEach>
		                    		</c:if>
	        					</div>
	        				</div>
	        				<div>&nbsp;</div>
	        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	        					<c:if test="${not empty bills}">
			        					<c:forEach items="${bills}" var="bill">
				        					<div class="col-md-6 col-sm-6">
				        						<h3 style="color: green;"><b><label for="amount" class="control-label"><spring:message code="students.billing.label.amount" /></label></b></h3>
				        						<c:if test="${bill.studentId.user.username == pageContext.request.userPrincipal.name}">
						                    		<label for="amount" class="control-label">${bill.feesAmount}</label>
						                    	</c:if>
				        					</div>
			        					</c:forEach>
		        				</c:if>
	        				</div>
        					<div>&nbsp;</div>
	        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
			                  <div class="col-md-1 col-sm-1">
			                  	<button type="submit" class="btn btn-success btn-cons" name="revBill" id="revBill">
			                  		<div class="lsf-icon" title="right"><spring:message code="students.billing.pay.button" /></div>
			               		</button>
			                  </div>
			                </div>
	        			</div>
	        		</div>
	        		<c:forEach items="${bills}" var="bill">
	        			<c:if test="${bill.studentId.user.username == pageContext.request.userPrincipal.name}">
			        		<input name="cust_name" type="hidden" value="${bill.userId.firstName}" />
		                    <input name="cust_name_desc" type="hidden" value="Paying customer first name." />
		                    <input type="hidden" name="user_id" value="${bill.userId.id}" />
		                    <input type="hidden" name="txn_ref" value="${bill.referenceNumber}" />
		                    <input type="hidden" name="product_id" value="${bill.productId}" />
		                    <input type="hidden" name="amount" value="${bill.feesAmountKobo}" />
		                    <input type="hidden" name="currency" value="566" />
		                    <input type="hidden" name="pay_item_id" value="${bill.payItemId}" />
		                  	<input name="pay_item_name" type="hidden" value="School Fees" />
		                    <input name="cust_id" type="hidden" value="${bill.userId.lastName}" />
		                    <input name="cust_id_desc" type="hidden" value="last_name" />
		                    <input type="hidden" name="site_name" value="http://portal.magnoliacad.com" />
		                    <input type="hidden" name="site_redirect_url" value="${bill.siteRedirectUrl}" />
		                    <input type="hidden" name="hash" value="${bill.hashVal}" />
	                    </c:if>
                    </c:forEach>
	        </form>
		</div>
	</div>