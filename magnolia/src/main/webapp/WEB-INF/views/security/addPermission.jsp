<%-- 
    Document   : add permission
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
		<form class="animated fadeIn validate" id="" name="permission">
        		<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
        			<h3 align="left" class="appTitle"><span class="lsf-icon" title="map"><spring:message code="permissions.add.permission.new" /></span></h3>
        			<div>&nbsp;</div>
        			<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-error" style="display: none;">                   
		                      <span class="permissionErrorMsg"></span>
		                    </div>
		                 </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-success" style="display: none;">                   
		                      <span class="permissionSuccessMsg"></span>
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
	                
        			<div class="col-md-10 col-sm-10">
        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
        					<div class="col-md-7 col-sm-7">
		                    	<input class="form-control" id="permissionName" name="permissionName" placeholder="Enter Permission Name" required>
        					</div>
        				</div>
        				
        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                  <div class="col-md-1 col-sm-1">
		                  	<button type="button" class="btn btn-success btn-cons" id="permissionAdd">
		                  		<div class="lsf-icon" title="plus"><spring:message code="permissions.add.permission.button" /></div>
		               		</button>
		                  </div>
		                </div>
        			</div>
        		</div>
        </form>
	</div>
</div>