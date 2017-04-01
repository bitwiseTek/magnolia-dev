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
		
        <form:form class="animated fadeIn validate" id="" modelAttribute="permissions">
        	<c:if test="${not empty permissions}">
		 		<table width="50%" border="0" cellspacing="10" cellpadding="10">
					<c:forEach items="${permissions}" var="permission">									
						<tr>
							<td><label for="role" class="form-control">${permission.permissions}</label></td>
						</tr>
			 		</c:forEach>
				</table>
		 	</c:if>
        </form:form>
	</div>
</div>