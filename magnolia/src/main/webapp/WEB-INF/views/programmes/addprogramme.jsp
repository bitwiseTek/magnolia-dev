<%-- 
    Document   : add study programme
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
<%@ page isELIgnored="false" %>

<div align="left" class="container">
	<div align="left" class="login-container animated fadeInUp">
		<div style="margin-top: -80px;" align="left">
	 		<a href="<c:url value="/" /> "><img src="<c:url value="/resources/assets/img/school_logo.png" /> " class="logo" width="40" height="40" /></a>
		</div>
		<form class="animated fadeIn validate" id="" name="prg">
        	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
           		<div class="col-md-10 col-sm-10">
           			<div class="row">
           				<h3 align="left" class="appTitle"><span class="lsf-icon" title="video"><spring:message code="programmes.add.programme.new" /></span></h3>
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
	                  	<label for="name" class="control-label"><spring:message code="programmes.add.programme.name" /></label>
		                <input class="form-control" id="name" name="name" placeholder="Enter Programme Name" type="text" required>
	                  </div>
	                  
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="code" class="control-label"><spring:message code="programmes.add.programme.code" /></label>
		                <input class="form-control" id="code" name="code" placeholder="Enter Programme Code" type="text" required>
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
		                  	<label for="category" class="control-label"><spring:message code="programmes.add.programme.cat" /></label>
			                <select id="category" style="width:100%; font-weight: 0; font-size: 12px;">
				                       <option value="0">Select Programme Category</option>
					                      <c:if test="${not empty categories}">
					                      	<c:forEach items="${categories}" var="category">
					                      	 	<option value="${category.id}">${category.name}</option>
					                      	</c:forEach>
					                      </c:if>
			                </select>
		               </div>
		               
	                   <div class="col-md-6 col-sm-6">
		                  	<label for="descr" class="control-label"><spring:message code="programmes.add.programme.descr" /></label>
			                <textarea class="form-control" id="descr" name="descr" placeholder="Enter Programme Description" rows="5"></textarea>
	                   </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
		                  	<label for="dept" class="control-label"><spring:message code="programmes.add.programme.dept" /></label>
			                <select id="dept" style="width:100%; font-weight: 0; font-size: 12px;">
				                       <option value="0">Select Department</option>
					                      <c:if test="${not empty depts}">
					                      	<c:forEach items="${depts}" var="dept">
					                      	 	<option value="${dept.departmentId}">${dept.name}</option>
					                      	</c:forEach>
					                      </c:if>
			                </select>
		               </div>
		               
	                   <div class="col-md-6 col-sm-6">
		                  	<label for="length" class="control-label"><spring:message code="programmes.add.programme.length" /></label>
			                <select id="length" style="width:100%; font-weight: 0; font-size: 12px;">
				                       <option value="0">Select Course Length</option>
					                      <c:if test="${not empty lengths}">
					                      	<c:forEach items="${lengths}" var="length">
					                      	 	<option value="${length.id}">${length.name}</option>
					                     	</c:forEach>
					                      </c:if>
			                </select>
	                   </div>
	                </div>
	                
	               <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
        						<label for="parts" class="control-label"><spring:message code="programmes.add.programme.parts" /></label>
		                    	<input class="form-control" id="parts" name="parts" placeholder="Enter Number of Participants" type="number" required>
        					</div>
        					
        					<div class="col-md-6 col-sm-6">
        						<label for="maxPart" class="control-label"><spring:message code="programmes.add.programme.max" /></label>
		                    	<input class="form-control" id="maxPart" name="maxPart" placeholder="Enter Max Participants" type="number" required>
		                    </div>
	               	</div>
	               	
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-12">
        						<label for="days" class="control-label"><spring:message code="programmes.add.programme.days" /></label>
		                    	<input class="form-control" id="days" name="days" placeholder="Enter Programme Days" type="number" required>
        					</div>
	               	</div>
	               	
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
        						<label for="createdBy" class="control-label"><spring:message code="programmes.add.programme.createdby" /></label>
		                    	<c:if test="${not empty users}">
				                    <select id="createdBy" style="width:100%; font-weight: 0; font-size: 12px;" disabled="disabled">
				                    	<c:forEach items="${users}" var="user">
				                    		<c:if test="${user.username == pageContext.request.userPrincipal.name}">
					                       		<option value="${user.id}">${user.username}</option>
						                     </c:if>
						                 </c:forEach>
				                    </select>
			                    </c:if>
        					</div>
        					
        					<div class="col-md-6 col-sm-6">
        						<label for="updatedBy" class="control-label"><spring:message code="programmes.add.programme.updatedby" /></label>
		                    	<c:if test="${not empty users}">
				                    <select id="updatedBy" style="width:100%; font-weight: 0; font-size: 12px;" disabled="disabled">
				                    	<c:forEach items="${users}" var="user">
				                    		<c:if test="${user.username == pageContext.request.userPrincipal.name}">
					                       		<option value="${user.id}">${user.username}</option>
						                     </c:if>
						                 </c:forEach>
				                    </select>
			                    </c:if>
		                    </div>
	               	</div>
	               	
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  	<div>&nbsp;</div>
	                  	<div class="col-md-1 col-sm-1">
	                  		<button type="button" class="btn btn-success btn-cons" name="prgAdd" id="prgAdd">
		                  		<div class="lsf-icon" title="plus"><spring:message code="programmes.add.programme.button" /></div>
		               		</button>
	                  	</div>
	                </div>
              	</div>
             </div>
             <input type="hidden" id="status" name="status" value="active" />
        </form>
	</div>
</div>