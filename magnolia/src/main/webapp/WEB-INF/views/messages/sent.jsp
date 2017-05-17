<%-- 
    Document   : sent
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
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ page isELIgnored="false" %>

<spring:message code="created.date.pattern" var="createdDatePattern" />

<div align="left" class="page-container row">
        <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
        <div class="modal hide" id="portlet-config">
          <div class="modal-header">
            <button class="close" data-dismiss="modal" type="button"></button>
            <h3>
          Widget Settings
        </h3>
          </div>
          <div class="modal-body">
            Widget settings form goes here
          </div>
        </div>
        <div class="clearfix">
        </div>
        <div class="content">
          <div class="page-title" style="display:none">
            <a href="#" id="btn-back"><i class="icon-custom-left"></i></a>
            <h3>
          Back- <span class="semi-bold">Sent</span>
        </h3>
          </div>
          <div class="row" id="inbox-wrapper">
            <div class="col-md-12">
              <div class="row">
                <div class="col-md-12">
                  <div class="grid simple">
                    <div class="grid-body no-border email-body">
                      <br>
                      <div class="row-fluid">
                        <div class="row-fluid dataTables_wrapper">
                          <h2 class=" inline">
                        Sent
                      </h2>
                          <div class="btn-group m-l-10 m-b-10">
                            <a class="btn btn-white btn-mini dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret single"></span></a>
                            <ul class="dropdown-menu">
                              <li>
                                <a href="#">Action</a>
                              </li>
                              <li>
                                <a href="#">Another action</a>
                              </li>
                              <li>
                                <a href="#">Something else here</a>
                              </li>
                              <li class="divider">
                              </li>
                              <li>
                                <a href="#">Separated link</a>
                              </li>
                            </ul>
                          </div>
                          <div class="pull-right margin-top-20">
                            <div class="dataTables_paginate paging_bootstrap pagination">
                              <ul>
                                <li class="prev disabled">
                                  <a href="#"><i class="fa fa-chevron-left"></i></a>
                                </li>
                                <li class="active">
                                  <a href="#">1</a>
                                </li>
                                <li>
                                  <a href="#">2</a>
                                </li>
                                <li class="next">
                                  <a href="#"><i class="fa fa-chevron-right"></i></a>
                                </li>
                              </ul>
                            </div>
                            <div class="dataTables_info hidden-xs" id="example_info">
                              Showing <b>1 to 10</b> of 14 entries
                            </div>
                          </div>
                          <div class="clearfix">
                          </div>
                        </div>
                        <div id="email-list">
                        	<form:form class="animated fadeIn validate" id="" name="messagesmessage" method="POST" modelAttribute="messages">
		                		<c:if test="${not empty messages}">
		                          <table class="table table-striped table-fixed-layout table-hover" id="emails">
		                            <thead>
		                              <tr>
		                                <th class="small-cell">
		                                </th>
		                                <th class="small-cell">
		                                </th>
		                                <th class="large-cell">
		                                </th>
		                                <th>
		                                </th>
		                                <th class="large-cell">
		                                </th>
		                              </tr>
		                            </thead>
		                            <tbody>
		                            	<c:forEach items="${messages}" var="message">
		                            		<tr>
				                                <td class="small-cell v-align-middle">
				                                  <div class="checkbox check-success">
				                                    <input id="checkbox8" type="checkbox" value="1">
				                                    <label for="checkbox8"></label>
				                                  </div>
				                                </td>
				                                <td class="small-cell v-align-middle">
				                                  <div class="star">
				                                    <input id="checkbox11" type="checkbox" value="1">
				                                    <label for="checkbox11"></label>
				                                  </div>
				                                </td>
				                                <td class="clickable v-align-middle">
				                                  ${message.sender}
				                                </td>
				                                <td class="clickable tablefull v-align-middle">
				                                  <span class="muted">${message.subject}</span>
				                                </td>
				                                <td></td>
				                                <td class="clickable">
				                                  <span class="muted"><joda:format value="${message.sentAt}" pattern="${createdDatePattern}"/></span>
				                                </td>
				                              </tr>
		                              	</c:forEach>
		                            </tbody>
                          		</table>
                          	</c:if>
                          </form:form>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12" id="preview-email-wrapper" style="display:none">
              <div class="row">
                <div class="col-md-12">
                  <div class="grid simple">
                    <div class="grid-title no-border">
                      <h4>
                  </h4>
                      <div class="tools">
                        <a class="remove" href="javascript:;"></a>
                      </div>
                    </div>
                    <div class="grid-body no-border" style="min-height: 850px;">
                    	<c:forEach items="${messages}" var="message">
	                      <div class="">
	                        <h1 id="emailheading">
	                      	${message.subject}</h1>
	                        <br>
	                        <div class="control">
	                          <div class="pull-left">
	                            <div class="btn-group">
	                              <a class="btn btn-mini dropdown-toggle" data-toggle="dropdown" href="#">${message.sender} <span class="caret"></span></a>
	                              <ul class="dropdown-menu">
	                                <li>
	                                  <a href="#">Action</a>
	                                </li>
	                                <li>
	                                  <a href="#">Another action</a>
	                                </li>
	                                <li>
	                                  <a href="#">Something else here</a>
	                                </li>
	                                <li class="divider">
	                                </li>
	                                <li>
	                                  <a href="#">Separated link</a>
	                                </li>
	                              </ul>
	                            </div>
	                            <label class="inline"><span class="muted">&nbsp;&nbsp;to</span> <span class="bold small-text">${message.receiver}</span></label>
	                          </div>
	                          <div class="pull-right">
	                            <span class="muted small-text"><joda:format value="${message.sentAt}" pattern="${createdDatePattern}"/></span>
	                          </div>
	                          <div class="clearfix">
	                          </div>
	                        </div>
	                        <br>
	                        <div class="email-body">
	                          <p>
	                            ${message.message}
	                          </p>
	                        </div>
	                      </div>
	                     </c:forEach>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="clearfix">
          </div>
        </div>
        <div class="clearfix">
        </div>
        <div class="admin-bar" id="quick-access" style="display:">
          <div class="admin-bar-inner">
            <button class="btn btn-danger btn-add" type="button"><i class="icon-trash"></i> Move to trash</button>
            <button class="btn btn-white btn-cancel" type="button">Cancel</button>
          </div>
        </div>
        <!-- END PAGE -->
      </div>