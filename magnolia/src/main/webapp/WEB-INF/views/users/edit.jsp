<%-- 
    Document   : edit user I
    Created on : Mar 18, 2017
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
		<form:form class="animated fadeIn validate" id="" name="user" method="POST" modelAttribute="users">
        	<c:if test="${not empty users}">
		 					<table width="50%" border="0" cellspacing="10" cellpadding="10">
			 					<c:forEach items="${users}" var="user">
			 						<spring:url value="/users/profile/edit/user/${user.id}/" var="editSystemUser" />
									<spring:url value="/users/show/user/${user.id}/" var="showSystemUser" />
										<tr>
											<td><label for="username" class="form-control">${user.username}</label></td>
											<td style="margin-right: 10px !important;"><a href="${editSystemUser}"><button class="btn btn-info" type="submit" formmethod="get" formaction="${editSystemUser}">
								    		<div class="lsf-icon" title="edit"><spring:message code="users.systemUsers.button.edit" /></div></button></a></td>
								    		
								    		<td><a href="${showSystemUser}"><button class="btn btn-success" type="submit" formmethod="get" formaction="${showSystemUser}">
								    		<div class="lsf-icon" title="view"><spring:message code="users.systemUsers.button.view" /></div></button></a></td>
								    		
								    		<td><a href="${deleteSystemUser}"><button class="btn btn-danger" type="submit" formmethod="get" formaction="${deleteSystemUser}">
								    		<div class="lsf-icon" title="delete"><spring:message code="users.systemUsers.button.delete" /></div></button></a></td>
										</tr>
			 					</c:forEach>
		 					</table>
		 				</c:if>
        </form:form>
	</div>
</div>