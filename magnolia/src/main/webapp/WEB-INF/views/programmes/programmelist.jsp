<%-- 
    Document   : list programmes
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
          <div class="page-title"> <i class="material-icons">videocam</i>
            <h3>Programmes- <span class="semi-bold">List</span></h3>
          </div>
          <div class="row-fluid">
            <div class="span12">
              <div class="grid simple ">
                <div class="grid-title">
                  <h4>Programmes <span class="semi-bold">List</span></h4>
                  <div class="tools">
                    <a href="javascript:;" class="collapse"></a>
                    <a href="#grid-config" data-toggle="modal" class="config"></a>
                    <a href="javascript:;" class="reload"></a>
                    <a href="javascript:;" class="remove"></a>
                  </div>
                </div>
                <div class="grid-body ">
                	<form:form class="animated fadeIn validate" id="" name="programme" method="POST" modelAttribute="programmes">
                		<c:if test="${not empty programmes}">
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
		                        <th style="width:7%">Code</th>
		                        <th style="width:22%" data-hide="phone,tablet">Category</th>
		                        <th style="width:22%" data-hide="phone,tablet">Department</th>
		                        <th style="width:5%">Status</th>
		                        <th style="width:15%">Actions</th>
		                      </tr>
		                    </thead>
		                    <tbody>
		                    	<c:forEach items="${programmes}" var="programme">
		                    	  <spring:url value="/programmes/edit/programme/${programme.id}/" var="editAdminPrg" />
								  <spring:url value="/programmes/show/programme/${programme.id}/" var="showAdminPrg" />
			                      <tr>
			                        <td class="v-align-middle">
			                          <div class="checkbox check-default">
			                            <input type="checkbox" value="3" id="checkbox2">
			                            <label for="checkbox2"></label>
			                          </div>
			                        </td>
			                        <td class="v-align-middle">${programme.id}</td>
			                        <td class="v-align-middle"><span class="muted">${programme.name}</span></td>
			                        <td class="v-align-middle">${programme.code}</td>
			                        <td class="v-align-middle"><span class="muted">${programme.category.name}</span></td>
			                        <td class="v-align-middle">${programme.department.name}</td>
			                        <td class="v-align-middle">
			                          <div>
			                          	<c:if test="${programme.status == 'active'}">
			                            	<span class="label label-success">${programme.status}</span>
			                            </c:if>
			                            <c:if test="${programme.status == 'pending'}">
			                            	<span class="label label-warning">${programme.status}</span>
			                            </c:if>
			                          </div>
			                        </td>
			                        <td class="text-center">
                                       <div class="btn-group">
                                         <a href="${showAdminPrg}"><button class="btn btn-xs btn-default" type="submit" formmethod="get" formaction="${showAdminPrg}" data-toggle="tooltip" title="View Programme"><i class="fa fa-eye"></i></button></a>
                                         <a href="${editAdminPrg}"><button class="btn btn-xs btn-default" type="submit" formmethod="get" formaction="${editAdminPrg}" data-toggle="tooltip" title="Edit Programme"><i class="fa fa-edit"></i></button></a>
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