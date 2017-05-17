<%-- 
    Document   : view
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
<%@ page isELIgnored="false" %>

<div align="left" class="container">
	<div align="left" class="login-container animated fadeInUp">
		<div style="margin-top: -80px;" align="left">
	 		<a href="<c:url value="/" /> "><img src="<c:url value="/resources/assets/img/school_logo.png" /> " class="logo" width="40" height="40" /></a>
		</div>
		<form:form class="animated fadeIn validate" id="" modelAttribute="messages">
        	<c:if test="${not empty messages}">
		 		<table width="40%" border="0" cellspacing="10" cellpadding="10">
					<c:forEach items="${messages}" var="message">
						<spring:url value="/messages/inbox/${message.sender}/" var="inbox" />	
						<spring:url value="/messages/sent/${message.receiver}/" var="sent" />	
						<spring:url value="/messages/trash/${message.id}/" var="trash" />									
						<tr>
							<c:if test="${message.sender == pageContext.request.userPrincipal.name}">
								<td style="margin-right: 10px !important;"><a href="${inbox}"><button class="btn btn-danger" type="submit" formmethod="get" formaction="${inbox}">
								<div class="lsf-icon" title="mail"><spring:message code="messages.view.button.inbox" /></div></button></a></td>
							
								<td style="margin-right: 10px !important;"><a href="${sent}"><button class="btn btn-success" type="submit" formmethod="get" formaction="${sent}">
								<div class="lsf-icon" title="logout"><spring:message code="messages.view.button.sent" /></div></button></a></td>
							</c:if>
						</tr>
			 		</c:forEach>
				</table>
		 	</c:if>
        </form:form>
	</div>
</div>