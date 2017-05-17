<%-- 
    Document   : edit study programme
    Created on : May 03, 2017
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
		<form:form class="animated fadeIn validate" method="PUT" id="programme" modelAttribute="programme">
			<input type="hidden" name="_method" value="PUT" />
        	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
           		<div class="col-md-10 col-sm-10">
           			<div class="row">
           				<h3 align="left" class="appTitle"><span class="lsf-icon" title="video"><spring:message code="programmes.edit.programme.new" arguments="${programme.name}" /></span></h3>
        				<div>&nbsp;</div>
           			</div>
              		<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-error" style="display: none;">                   
		                      <span class="prgErrorMsg"></span>
		                    </div>
		                 </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-success" style="display: none;">                   
		                      <span class="prgSuccessMsg"></span>
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
	                  	<label for="name" class="control-label"><spring:message code="programmes.edit.programme.name" /></label>
		                <form:input class="form-control" id="name" path="name" placeholder="Enter Programme Name" />
	                  </div>
	                  
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="code" class="control-label"><spring:message code="programmes.edit.programme.code" /></label>
		                <form:input class="form-control" id="code" path="code" placeholder="Enter Programme Code" />
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
		                  	<label for="category" class="control-label"><spring:message code="programmes.edit.programme.cat" /></label>
			                <form:select id="category" path="category.id" style="width:100%; font-weight: 0; font-size: 12px;">
			                		<c:if test="${not empty categories}">
				                      	<c:forEach items="${categories}" var="category">
				                      	 	<form:option value="${category.id}">${category.name}</form:option>
				                      	</c:forEach>
			                     	 </c:if>
							</form:select>
		               </div>
		               
	                   <div class="col-md-6 col-sm-6">
		                  	<label for="descr" class="control-label"><spring:message code="programmes.edit.programme.descr" /></label>
			                <form:textarea class="form-control" id="descr" path="description" placeholder="Enter Programme Description" rows="5"></form:textarea>
	                   </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
		                  	<label for="dept" class="control-label"><spring:message code="programmes.edit.programme.dept" /></label>
			                <form:select id="dept" path="department.departmentId" style="width:100%; font-weight: 0; font-size: 12px;">
			                		<c:if test="${not empty depts}">
				                      	<c:forEach items="${depts}" var="dept">
				                      	 	<form:option value="${dept.departmentId}">${dept.name}</form:option>
				                      	</c:forEach>
			                      	</c:if>
							</form:select>
							<form:errors class="error" path="department.departmentId" />
		               </div>
		               
	                   <div class="col-md-6 col-sm-6">
		                  	<label for="length" class="control-label"><spring:message code="programmes.add.programme.length" /></label>
			                <form:select id="length" path="courseLength.id" style="width:100%; font-weight: 0; font-size: 12px;">
					                      <c:if test="${not empty lengths}">
					                      	<c:forEach items="${lengths}" var="length">
					                      	 	<form:option value="${length.id}">${length.name}</form:option>
					                     	</c:forEach>
					                      </c:if>
			                </form:select>
			                <form:errors class="error" path="courseLength.id" />
	                   </div>
	                </div>
	                
	               <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
        						<label for="parts" class="control-label"><spring:message code="programmes.edit.programme.parts" /></label>
		                    	<form:input class="form-control" id="parts" path="participants" placeholder="Enter Number of Participants" type="number" />
        					</div>
        					
        					<div class="col-md-6 col-sm-6">
        						<label for="maxPart" class="control-label"><spring:message code="programmes.edit.programme.max" /></label>
		                    	<form:input class="form-control" path="maxParticipationCount" name="maxPart" placeholder="Enter Max Participants" type="number" />
		                    </div>
	               	</div>
	               	
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-12">
        						<label for="days" class="control-label"><spring:message code="programmes.edit.programme.days" /></label>
		                    	<form:input class="form-control" id="days" path="programDays" placeholder="Enter Programme Days" type="number" />
        					</div>
	               	</div>
	               	
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-12">
	                  		<label for="status" class="control-label">Status:</label>
		                	<form:select id="status" path="status" style="width:100%">
								<form:option value="${currentStatus}">${currentStatus}</form:option>
								<form:options items="${statuses}"></form:options>
							</form:select>
							<form:errors class="error" path="status" />
	                  	</div>
	                </div>
	               	
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
	                  		<label for="createdAt" class="control-label">Created At:</label>
	                  		<label for="createdAt" class="form-control"><joda:format value="${programme.createdAt}" pattern="${createdDatePattern}"/></label>
	                  		<form:hidden class="form-control" id="createdAt" name="createdAt" placeholder="Created At" path="createdAt" />
	                    </div>
	                  	
	                  	<div class="col-md-6 col-sm-6">
	                  		<label for="createdAt" class="control-label">Updated At:</label>
	                  		<label for="createdAt" class="form-control"><joda:format value="${programme.updatedAt}" pattern="${createdDatePattern}"/></label>
	                  		<form:hidden class="form-control" id="updatedAt" name="updatedAt" placeholder="Updated At" path="updatedAt" />
	                    </div>
	               	</div>
	               	
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
        						<label for="createdBy" class="control-label"><spring:message code="programmes.edit.programme.createdby" /></label>
		                    	<c:if test="${not empty users}">
				                    <form:select id="createdBy" path="createdBy.id" style="width:100%; font-weight: 0; font-size: 12px;" disabled="true">
				                    	<c:forEach items="${users}" var="user">
				                    		<c:if test="${user.username == pageContext.request.userPrincipal.name}">
					                       		<form:option value="${user.id}">${user.username}</form:option>
						                     </c:if>
						                 </c:forEach>
				                    </form:select>
			                    </c:if>
        					</div>
        					
        					<div class="col-md-6 col-sm-6">
        						<label for="updatedBy" class="control-label"><spring:message code="programmes.edit.programme.updatedby" /></label>
		                    	<c:if test="${not empty users}">
				                    <form:select id="updatedBy" path="updatedBy.id" style="width:100%; font-weight: 0; font-size: 12px;" disabled="true">
				                    	<c:forEach items="${users}" var="user">
				                    		<c:if test="${user.username == pageContext.request.userPrincipal.name}">
					                       		<form:option value="${user.id}">${user.username}</form:option>
						                     </c:if>
						                 </c:forEach>
				                    </form:select>
			                    </c:if>
		                    </div>
	               	</div>
	               	
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  	<div>&nbsp;</div>
	                  	<div class="col-md-1 col-sm-1">
	                  		<button class="btn btn-danger btn-cons">
		                  		<div class="lsf-icon" title="edit"><spring:message code="programmes.edit.programme.button" /></div>
		               		</button>
	                  	</div>
	                </div>
              	</div>
             </div>
        </form:form>
	</div>
</div>