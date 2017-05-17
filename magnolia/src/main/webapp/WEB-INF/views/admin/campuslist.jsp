<%-- 
    Document   : list campuses
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

<div class="content">
          <div class="page-title"> <i class="material-icons">hourglass_full</i>
            <h3>Campuses - <span class="semi-bold">List</span></h3>
          </div>
          <div class="row-fluid">
            <div class="span12">
              <div class="grid simple ">
                <div class="grid-title">
                  <h4>Campuses <span class="semi-bold">List</span></h4>
                  <div class="tools">
                    <a href="javascript:;" class="collapse"></a>
                    <a href="#grid-config" data-toggle="modal" class="config"></a>
                    <a href="javascript:;" class="reload"></a>
                    <a href="javascript:;" class="remove"></a>
                  </div>
                </div>
                <div class="grid-body ">
                	<form:form class="animated fadeIn validate" id="" name="campus" method="POST" modelAttribute="campuses">
                		<c:if test="${not empty campuses}">
		                  <table class="table table-hover table-condensed" id="example">
		                    <thead>
		                      <tr>
		                        <th style="width:1%">
		                          <div class="checkbox check-default" style="margin-right:auto;margin-left:auto;">
		                            <input type="checkbox" value="1" id="checkbox1">
		                            <label for="checkbox1"></label>
		                          </div>
		                        </th>
		                        <th style="width:12%">ID</th>
		                        <th style="width:12%">Name</th>
		                        <th style="width:12%" data-hide="phone,tablet">Sub-School</th>
		                        <th style="width:12%" data-hide="phone,tablet">Created At</th>
		                        <th style="width:12%" data-hide="phone,tablet">Updated At</th>
		                        <th style="width:5%">Status</th>
		                        <th style="width:15%">Actions</th>
		                      </tr>
		                    </thead>
		                    <tbody>
		                    	<c:forEach items="${campuses}" var="campus">
		                    	  <spring:url value="/admin/campuses/edit/campus/${campus.campusId}/" var="editAdminCampus" />
								  <spring:url value="/admin/campuses/show/campus/${campus.campusId}/" var="showAdminCampus" />
			                      <tr>
			                        <td class="v-align-middle">
			                          <div class="checkbox check-default">
			                            <input type="checkbox" value="3" id="checkbox2">
			                            <label for="checkbox2"></label>
			                          </div>
			                        </td>
			                        <td class="v-align-middle">${campus.campusId}</td>
			                        <td class="v-align-middle"><span class="muted">${campus.name}</span></td>
			                        <td class="v-align-middle">${campus.subSchool.name}</td>
			                        <td class="v-align-middle">${campus.createdAt}</td>
			                        <td class="v-align-middle">${campus.updatedAt}</td>
			                        <td class="v-align-middle">
			                          <div>
			                          	<c:if test="${campus.status == 'active'}">
			                            	<span class="label label-success">${campus.status}</span>
			                            </c:if>
			                            <c:if test="${campus.status == 'pending'}">
			                            	<span class="label label-warning">${campus.status}</span>
			                            </c:if>
			                          </div>
			                        </td>
			                        <td class="text-center">
                                       <div class="btn-group">
                                         <a href="${showAdminCampus}"><button class="btn btn-xs btn-default" type="submit" formmethod="get" formaction="${showAdminCampus}" data-toggle="tooltip" title="View Campus"><i class="fa fa-eye"></i></button></a>
                                         <a href="${editAdminCampus}"><button class="btn btn-xs btn-default" type="submit" formmethod="get" formaction="${editAdminCampus}" data-toggle="tooltip" title="Edit Campus"><i class="fa fa-edit"></i></button></a>
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