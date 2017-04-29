<%-- 
    Document   : register student
    Created on : Apr 16, 2017
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
		<form class="animated fadeIn validate" id="" name="std">
        	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">	
              	<div class="col-md-2 col-sm-2">
              		<div class="col-md-12">
	           			<a href="#loc_photo" ></a><div id="preview_photo" class="centered" ><img src="<c:url value="/resources/assets/img/mg/${pageContext.request.userPrincipal.name}.png" /> " class="img-circle" width="80"></div>
	           		</div>
           		</div>
           		
           		<div class="col-md-10 col-sm-10">
              		<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-error" style="display: none;">                   
		                      <span class="stdErrorMsg"></span>
		                    </div>
		                 </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-success" style="display: none;">                   
		                      <span class="stdSuccessMsg"></span>
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
	                  	<c:if test="${not empty users}">
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
	                  		<select id="partType" style="width:100%">
	                       		<option value="PT">Select Participation Type</option>
	                       		<option value="ON">ONLINE</option>
	                       		<option value="OC">ON-CAMPUS</option>
	                     	</select>
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-6 col-sm-6">
	                  		<select id="enrolType" style="width:100%">
	                       		<option value="ET">Select Enrollment Type</option>
	                       		<option value="ON">ONLINE</option>
	                       		<option value="OFF">OFFLINE</option>
	                     	</select>
	                  </div>
	                  <div class="col-md-6 col-sm-6">
	                  		<select id="lodging" style="width:100%">
	                       		<option value="AC">Select Accommodation Preference</option>
	                       		<option value="ON">ON-CAMPUS</option>
	                       		<option value="OFF">OFF-CAMPUS</option>
	                     	</select>
	                  </div>
	                </div>
                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
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
	                  		<select id="programme" style="width:100%; font-weight: 0; font-size: 12px;">
		                       <option value="0">Select Study Programme</option>
	                       </select>
	                    </div>
	               	</div>
                
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-12">
							<select id="endReason" style="width:100%">
	                       		<option value="SE">Select Study End Reason</option>
	                       		<option value="R1">NOT ENDED</option>
	                       		<option value="R2">FINANCIAL</option>
	                       		<option value="R3">EXPULSION</option>
	                       		<option value="R4">MEDICAL</option>
	                       		<option value="R5">TRANSFER</option>
	                       		<option value="R6">CONCLUDED</option>
	                     	</select>
		                </div>
	               	</div>
	               	
                 	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                 <div class="col-md-12">
                         	<textarea class="form-control" id="endText" name="endText" rows="15" placeholder="Enter Study End Text"></textarea>
                         </div>
                 	</div>
                 	
                 	
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  	<div>&nbsp;</div>
	                  	<div class="col-md-1 col-sm-1">
	                  		<button type="button" id="stdRegister" class="btn btn-success btn-cons">
	                  			<div class="lsf-icon" title="save">Register</div>
	               			</button>
	                  	</div>
	                </div>
              	</div>
             </div>
             <input type="hidden" id="status" name="status" value="pending" />
        </form>
	</div>
</div>