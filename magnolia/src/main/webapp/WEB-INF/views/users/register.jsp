<%-- 
    Document   : register user
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
		<form class="animated fadeIn validate" id="" name="user">
        	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">	
              	<div class="col-md-2 col-sm-2">
              		<div class="col-md-12">
	           			<a href="#loc_photo" ></a><div id="preview_photo" class="centered" ><img src="<c:url value="/resources/assets/img/person-icon.png" /> " class="img-circle" width="60"></div>
	           		</div>
           		</div>
           		
           		<div class="col-md-10 col-sm-10">
              		<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-error" style="display: none;">                   
		                      <span class="userErrorMsg"></span>
		                    </div>
		                 </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-success" style="display: none;">                   
		                      <span class="userSuccessMsg"></span>
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
	                    <input class="form-control" id="firstName" name="firstName" placeholder="First Name" type="text" required>
	                  </div>
	                  <div class="col-md-6 col-sm-6">
	                    <input class="form-control" id="lastName" name="lastName" placeholder="Last Name" type="text" required>
	                  </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-12">
		                  <input class="form-control" id="middleName" name="middleName" placeholder="Middle Name" type="text">
		              </div>
	                </div>
                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-6 col-sm-6">
		                    <input class="form-control" id="priEmail" name="priEmail" placeholder="Primary Email" type="email" required>
		              </div>
		              
	                  <div class="col-md-6 col-sm-6">
	                    <input class="form-control" id="secEmail" name="secEmail" placeholder="Secondary Email" type="email">
	                  </div>
	                </div>
                
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
							<div class="input-append success date col-md-10 col-lg-10 no-padding">
						 	 	<input type="text" placeholder="Date of Birth" id="dob" name="dob" class="form-control">
						  		<span class="add-on"><span class="arrow"></span><i class="fa fa-th"></i></span>
							</div>
		                </div>
	                  	<div class="col-md-6 col-sm-6">
	                  		<select id="sex" style="width:100%">
	                       		<option value="SG">Select Gender</option>
	                       		<option value="MALE">Male</option>
	                       		<option value="FEMALE">Female</option>
	                     	</select>
	                  	</div>
	               	</div>
                
	               	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
		                  	<select id="state" style="width:100%; font-weight: 0; font-size: 12px;">
		                       <option value="0">Select State</option>
			                      <c:if test="${not empty states}">
			                      	<c:forEach items="${states}" var="state">
			                      	 	<option value="${state.id}">${state.name}</option>
			                      	</c:forEach>
			                      </c:if>
	                        </select>
	                    </div>
	                    
	                  	<div class="col-md-6 col-sm-6">
	                  		<select id="lga" style="width:100%; font-weight: 0; font-size: 12px;">
		                       <option value="0">Select LGA</option>
	                       </select>
	                    </div>
	               	</div>
                 
                 	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                 <div class="col-md-6 col-sm-6">
		                    <input class="form-control" id="priPhone" name="priPhone" placeholder="Primary Phone Number" type="text" required>
		                 </div>
		                 
		                 <div class="col-md-6 col-sm-6">
		                   <input class="form-control" id="secPhone" name="secPhone" placeholder="Secondary Phone Number" type="text">
		                 </div>
                 	</div>
                 	
                 	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-12">
	                  	<input id="address" name="address" placeholder="Enter Street Address ..." class="form-control" required>
	                  </div>
	                </div>
                 	
                 	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-6 col-sm-6">
		                  	<select id="secretQ" style="width:100%; font-weight: 0; font-size: 12px;">
		                       <option value="Q0">Select Secret Question</option>
		                       <option value="Q1">What is your mother's maiden name?</option>
		                       <option value="Q2">What is the name of your first dog?</option>
		                       <option value="Q3">What is the color of your building?</option>
		                       <option value="Q4">What is your favorite dish?</option>
		                       <option value="Q5">At what age did you graduate secondary school?</option>
	                        </select>
	                    </div>
	                    
	                  	<div class="col-md-6 col-sm-6">
	                  		<input class="form-control" id="secAnswer" name="secAnswer" placeholder="Secret Answer" type="password" required>
	                    </div>
	               	</div>
                	<div>&nbsp;</div>
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                	<div class="col-md-12">
	                		<label for="imageUpload" class="control-label">Upload Image:</label>
	                		<input type="file" name="user_upload_photo" id="user_upload_photo" />
	                	</div>
	                  	<div>&nbsp;</div>
	                  	<div class="col-md-1 col-sm-1">
	                  		<button type="button" id="userRegister" class="btn btn-success btn-cons">
	                  			<div class="lsf-icon" title="save">Sign Up</div>
	               			</button>
	                  	</div>
	                </div>
              	</div>
             </div>
             <input type="hidden" id="status" name="status" value="pending" />
        </form>
	</div>
</div>