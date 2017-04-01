<%-- 
    Document   : edit role I
    Created on : Mar 31, 2017
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
		<form:form class="animated fadeIn validate" id="" modelAttribute="roles">
        	<c:if test="${not empty roles}">
		 		<table width="40%" border="0" cellspacing="10" cellpadding="10">
					<c:forEach items="${roles}" var="role">
						<spring:url value="/roles/edit/${role.id}/" var="editRole" />									
						<tr>
							<td><label for="role" class="form-control">${role.roles}</label></td>
							<td style="margin-right: 10px !important;"><a href="${editRole}"><button class="btn btn-info" type="submit" formmethod="get" formaction="${editRole}">
							<div class="lsf-icon" title="edit"><spring:message code="users.systemUsers.button.edit" /></div></button></a></td>
						</tr>
			 		</c:forEach>
				</table>
		 	</c:if>
        </form:form>
	</div>
</div>