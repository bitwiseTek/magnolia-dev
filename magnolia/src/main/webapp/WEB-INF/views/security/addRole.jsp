<%-- 
    Document   : add role
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
		<form class="animated fadeIn validate" id="" name="role">
        		<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
        			<h3 align="left" class="appTitle"><span class="lsf-icon" title="delicious"><spring:message code="roles.add.role.new" /></span></h3>
        			<div>&nbsp;</div>
        			<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-error" style="display: none;">                   
		                      <span class="roleErrorMsg"></span>
		                    </div>
		                 </div>
	                </div>
	                
	                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                <div class="col-md-12">
		                  	<div class="alert alert-success" style="display: none;">                   
		                      <span class="roleSuccessMsg"></span>
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
        					<div class="col-md-6 col-sm-6">
        						<label for="roleName" class="control-label"><spring:message code="roles.add.role.name" /></label>
		                    	<input class="form-control" id="roleName" name="roleName" placeholder="Enter Role Name" type="text" required>
        					</div>
        				</div>
        				
        				<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                  <div class="col-md-1 col-sm-1">
		                  	<button type="button" class="btn btn-success btn-cons" name="roleAdd" id="roleAdd">
		                  		<div class="lsf-icon" title="plus"><spring:message code="roles.add.role.button" /></div>
		               		</button>
		                  </div>
		                </div>
        			</div>
        		</div>
        </form>
	</div>
</div>