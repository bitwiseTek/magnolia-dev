<%-- 
    Document   : edit profile
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
		<form:form class="animated fadeIn validate" method="PUT" id="user" modelAttribute="user">
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
	                  	<label for="systemId" class="control-label">System ID:</label>
	                    <label for="systemId" class="form-control">${user.systemId}</label>
	                    <form:input class="form-control" id="systemId" name="systemId" placeholder="System ID" path="systemId" type="hidden" />
	                  </div>
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="username" class="control-label">Username:</label>
	                    <label for="username" class="form-control">${user.username}</label>
	                    <form:input class="form-control" id="username" name="username" placeholder="Username" path="username" type="hidden" />
	                  </div>
	                </div>
	                
           			<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="firstName" class="control-label">First Name:</label>
	                    <form:input class="form-control" id="firstName" name="firstName" placeholder="First Name" path="firstName" />
	                    <form:errors class="error" path="firstName" />
	                  </div>
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="lastName" class="control-label">Last Name:</label>
	                    <form:input class="form-control" id="lastName" name="lastName" placeholder="Last Name" path="lastName" />
	                    <form:errors class="error" path="lastName" />
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-12">
	                  	<label for="middleName" class="control-label">Middle Name:</label>
		              	<form:input class="form-control" id="middleName" name="middleName" placeholder="Middle Name" path="middleName" />
		              	<form:errors class="error" path="middleName" />
		              </div>
	                </div>
                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="priEmail" class="control-label">Primary Email:</label>
	                  	<label for="priEmail" class="form-control">${user.primaryEmail}</label>
		              	<form:hidden class="form-control" id="priEmail" name="priEmail" placeholder="Primary Email" path="primaryEmail" />
		              	<form:errors class="error" path="primaryEmail" />
		              </div>
		              
	                  <div class="col-md-6 col-sm-6">
	                  	<label for="secEmail" class="control-label">Secondary Email:</label>
	                  	<form:input class="form-control" id="secEmail" name="secEmail" placeholder="Secondary Email" path="secondaryEmail" />
	                  	<form:errors class="error" path="secondaryEmail" />
	                  </div>
	                </div>
                
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
	                		<label for="dob" class="control-label">Date of Birth:</label>
							<div class="input-append success date col-md-10 col-lg-10 no-padding">
						 	 	<form:input type="text" placeholder="Date of Birth" id="dob" name="dob" path="birthday" class="form-control" />
						 	 	<form:errors class="error" path="birthday" />
						  		<span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span>
							</div>
	                	</div>
	                  	<div class="col-md-6 col-sm-6">
	                  		<label for="sex" class="control-label">Sex:</label>
	                  		<form:select id="sex" path="sex" style="width:100%">
								<<form:option value="${currentSex}">${currentSex}</form:option>
								<form:options items="${sexes}"></form:options>
							</form:select>
							<form:errors class="error" path="sex" />
	                  	</div>
	               	</div>
                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                    <div class="col-md-6 col-sm-6">
	                    	<label for="state" class="control-label">State of Origin:</label>
	                  		<form:select id="state" path="state.id" style="width:100%; font-weight: 0; font-size: 12px;">
			                		<c:if test="${not empty states}">
				                      	<c:forEach items="${states}" var="state">
				                      	 	<form:option value="${state.id}">${state.name}</form:option>
				                      	</c:forEach>
			                      </c:if>
							</form:select>
							<form:errors class="error" path="state" />
	                  	</div>
	                    
	                  	<div class="col-md-6 col-sm-6">
	                  		<label for="lga" class="control-label">LGA:</label>
	                  		<form:select id="lga" path="lga.id" style="width:100%; font-weight: 0; font-size: 12px;">
			                		<c:if test="${not empty lgas}">
				                      	<c:forEach items="${lgas}" var="lga">
				                      	 	<form:option value="${lga.id}">${lga.name}</form:option>
				                      	</c:forEach>
			                      </c:if>
							</form:select>
							<form:errors class="error" path="lga" />
	                  	</div>
	               	</div>
                 
                 	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                 <div class="col-md-6 col-sm-6">
		                 	<label for="priPhone" class="control-label">Primary Phone:</label>
		                    <form:input class="form-control" id="priPhone" name="priPhone" placeholder="Primary Phone Number" path="primaryNumber" />
		                    <form:errors class="error" path="primaryNumber" />
		                 </div>
		                 
		                 <div class="col-md-6 col-sm-6">
		                 	<label for="secPhone" class="control-label">Secondary Phone:</label>
		                   <form:input class="form-control" id="secPhone" name="secPhone" placeholder="Secondary Phone Number" path="secondaryNumber" />
		                   <form:errors class="error" path="secondaryNumber" />
		                 </div>
                 	</div>
                 	
                 	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-12">
	                  	<label for="address" class="control-label">Street Address:</label>
	                  	<form:input id="address" name="address" placeholder="Enter Street Address ..." class="form-control" path="streetAddress" />
	                  	<form:errors class="error" path="streetAddress" />
	                  </div>
	                </div>
                 	
                 	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
                 		<div class="col-md-6 col-sm-6">
                 			<label for="secretQ" class="control-label">Secret Question:</label>
		                	<form:select id="secretQ" path="secretQuestion" style="width:100%">
								<form:option value="${currentQuestion}">${currentQuestion}</form:option>
			                    <form:options items="${questions}"></form:options>
							</form:select>
							<form:errors class="error" path="secretQuestion" />
						</div>
	                    
	                  	<div class="col-md-6 col-sm-6">
	                  		<label for="secAnswer" class="control-label">Secret Answer:</label>
	                  		<form:input class="form-control" id="secAnswer" name="secAnswer" placeholder="Secret Answer" type="password" path="secretAnswer" />
	                  		<form:errors class="error" path="secretAnswer" />
	                    </div>
	               	</div>
	               	
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	               		<div class="col-md-6 col-sm-6">
	               			<label for="lastLogin" class="control-label">Last Login:</label>
	                  		<label for="lastLogin" class="form-control">${user.lastLogin}</label>
	                  		<form:hidden class="form-control" id="lastLogin" name="lastLogin" placeholder="Last Login" path="lastLogin" />
	                    </div>
	                    
	                  	<div class="col-md-6 col-sm-6">
	                  		<label for="lastLogout" class="control-label">Last Logout:</label>
	                  		<label for="lastLogout" class="form-control">${user.lastLogout}</label>
	                  		<form:hidden class="form-control" id="lastLogout" name="lastLogout" placeholder="Last Logout" path="lastLogout" />
	                    </div>
	               	</div>
	               	
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	               		<div class="col-md-12">
	               			<label for="uploadImage" class="control-label">Upload Image:</label>
	                  		<form:input type="file" name="user_upload_photo" id="user_upload_photo" path="photoBase64" />
	                  		<form:errors class="error" path="photoBase64" />
	                  	</div>
	               	</div>
                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-1 col-sm-1">
	                  	<button class="btn btn-danger btn-cons">
	                  		<div class="lsf-icon" title="edit">Edit</div>
	               		</button>
	                  </div>
	                </div>
              	</div>
             </div>
             <form:hidden id="password" name="password" path="password" />
             <form:hidden id="tempPassword" name="tempPassword" path="tempPassword" />
             <form:hidden id="status" name="status" path="status" />
             <form:hidden id="createdAt" name="createdAt" path="createdAt" />
        </form:form>
	</div>
</div>

