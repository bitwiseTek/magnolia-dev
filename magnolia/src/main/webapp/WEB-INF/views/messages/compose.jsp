<%-- 
    Document   : compose
    Created on : Apr 18, 2017
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

<div align="left" class="page-container row">
        <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
        <div id="portlet-config" class="modal hide">
          <div class="modal-header">
            <button data-dismiss="modal" class="close" type="button"></button>
            <h3>Widget Settings</h3>
          </div>
          <div class="modal-body"> Widget settings form goes here </div>
        </div>
        <div class="clearfix"></div>
        <div class="content">
        	<form class="animated fadeIn validate" id="" name="compose">
	          <div class="row">
	            <div class="col-md-12">
	              <div class="row">
	                <div class="col-md-12">
	                  <div class="grid simple">
	                    <div class="grid-body no-border" style="min-height: 850px;">
	                      <br>
	                      <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
			                <div class="col-md-12">
			                  	<div class="alert alert-error" style="display: none;">                   
			                      <span class="composeErrorMsg"></span>
			                    </div>
			                 </div>
			                </div>
			                
			                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
				                <div class="col-md-12">
				                  	<div class="alert alert-success" style="display: none;">                   
				                      <span class="composeSuccessMsg"></span>
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
	                      <div class="row-fluid ">
	                        <h2>New Message </h2>
	                        <div class="row">
	                          <div class="form-group col-md-12">
	                            <label class="form-label">To</label>
	                            <span class="help">e.g. "someone@magnoliacad.com"</span>
	                            <div class="controls">
	                              <input class="form-control" id="receiver" name="receiver" type="email" required>
	                            </div>
	                          </div>
	                        </div>
	                        <div class="row">
	                          <div class="form-group col-md-12">
	                            <label class="form-label">Subject</label>
	                            <span class="help">e.g. "MTH 101.1 Assignment"</span>
	                            <div class="controls">
	                              <input type="text" class="form-control" id="subject" name="subject" required>
	                            </div>
	                          </div>
	                        </div>
	                        <div class="row">
	                          <div class="form-group col-md-12">
	                            <textarea id="text-editor" placeholder="Enter text ..." class="form-control" rows="25" name="message"></textarea>
	                          </div>
	                        </div>
	                      </div>
	                    </div>
	                  </div>
	                 </div>
	              </div>
	            </div>
	          </div>
	          <input type="hidden" class="form-control" id="sender" name="sender" value="${pageContext.request.userPrincipal.name}">
	         </form>
        </div>
        <div class="admin-bar" id="quick-access" style="display:">
          <div class="admin-bar-inner">
            <div class="form-horizontal">
            </div>
            <button class="btn btn-danger btn-cons btn-add" type="button" name="sendMsg" id="sendMsg"><i class="icon-envelope"></i> Send</button>
            <button class="btn btn-white btn-cons btn-cancel" type="button">Cancel</button>
          </div>
        </div>
        <div class="clearfix"></div>
      </div>
      <div class="clearfix"></div>