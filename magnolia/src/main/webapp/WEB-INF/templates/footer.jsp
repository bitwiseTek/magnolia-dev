<%-- 
    Document   : footer
    Created on : Jan 30, 2017
    Author(s)  : Sika Kay, Success Otto
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="pushblock"></div>
<div class="pushblock"></div>
<div class="well-sm footermedia">
	<div class="container">
		<div class="container">
			<spring:url value="/http://www.twitter.com/manageme" var="manageMeUrl"></spring:url>
			<spring:url value="/resources/assets/img/footer_icon.png" var="footerIcon"></spring:url>
			 <p class="foottext"><img src="${footerIcon}"  height="30"  alt="" /><spring:message code="generic.applicationTitle" /> &reg;&nbsp;2016. Powered by <a href="${manageMeUrl}" target="_blank"  class="foottext2"><spring:message code="footer.companyName" /></a></p>
		</div>
	</div>
</div>