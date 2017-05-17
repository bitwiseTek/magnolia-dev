<%-- 
    Document   : list course lengths
    Created on : May 04, 2017
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

<div class="content">
          <div class="page-title"> <i class="material-icons">alarm</i>
            <h3>Course Lengths - <span class="semi-bold">List</span></h3>
          </div>
          <div class="row-fluid">
            <div class="span12">
              <div class="grid simple ">
                <div class="grid-title">
                  <h4>Course Lengths <span class="semi-bold">List</span></h4>
                  <div class="tools">
                    <a href="javascript:;" class="collapse"></a>
                    <a href="#grid-config" data-toggle="modal" class="config"></a>
                    <a href="javascript:;" class="reload"></a>
                    <a href="javascript:;" class="remove"></a>
                  </div>
                </div>
                <div class="grid-body ">
                	<form:form class="animated fadeIn validate" id="" name="length" method="POST" modelAttribute="lengths">
                		<c:if test="${not empty lengths}">
		                  <table class="table table-hover table-condensed" id="example">
		                    <thead>
		                      <tr>
		                        <th style="width:1%">
		                          <div class="checkbox check-default" style="margin-right:auto;margin-left:auto;">
		                            <input type="checkbox" value="1" id="checkbox1">
		                            <label for="checkbox1"></label>
		                          </div>
		                        </th>
		                        <th style="width:5%">ID</th>
		                        <th style="width:22%">Name</th>
		                        <th style="width:12%">Hours</th>
		                        <th style="width:12%">Units</th>
		                        <th style="width:15%">Actions</th>
		                      </tr>
		                    </thead>
		                    <tbody>
		                    	<c:forEach items="${lengths}" var="length">
		                    	  <spring:url value="/course/lengths/edit/courselength/${length.id}/" var="editAdminLen" />
								  <spring:url value="/course/lengths/show/courselength/${length.id}/" var="showAdminLen" />
			                      <tr>
			                        <td class="v-align-middle">
			                          <div class="checkbox check-default">
			                            <input type="checkbox" value="3" id="checkbox2">
			                            <label for="checkbox2"></label>
			                          </div>
			                        </td>
			                        <td class="v-align-middle">${length.id}</td>
			                        <td class="v-align-middle"><span class="muted">${length.name}</span></td>
			                        <td class="v-align-middle">${length.tCH}</td>
			                        <td class="v-align-middle">${length.tCU}</td>
			                        <td class="text-center">
                                       <div class="btn-group">
                                         <a href="${showAdminLen}"><button class="btn btn-xs btn-default" type="submit" formmethod="get" formaction="${showAdminLen}" data-toggle="tooltip" title="View Length"><i class="fa fa-eye"></i></button></a>
                                         <a href="${editAdminLen}"><button class="btn btn-xs btn-default" type="submit" formmethod="get" formaction="${editAdminLen}" data-toggle="tooltip" title="Edit Length"><i class="fa fa-edit"></i></button></a>
                                       </div>
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