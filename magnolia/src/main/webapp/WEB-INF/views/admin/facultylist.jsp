<%-- 
    Document   : list faculties
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
          <div class="page-title"> <i class="material-icons">account_balance</i>
            <h3>Faculties - <span class="semi-bold">List</span></h3>
          </div>
          <div class="row-fluid">
            <div class="span12">
              <div class="grid simple ">
                <div class="grid-title">
                  <h4>Faculties <span class="semi-bold">List</span></h4>
                  <div class="tools">
                    <a href="javascript:;" class="collapse"></a>
                    <a href="#grid-config" data-toggle="modal" class="config"></a>
                    <a href="javascript:;" class="reload"></a>
                    <a href="javascript:;" class="remove"></a>
                  </div>
                </div>
                <div class="grid-body ">
                	<form:form class="animated fadeIn validate" id="" name="faculty" method="POST" modelAttribute="faculties">
                		<c:if test="${not empty faculties}">
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
		                        <th style="width:22%">Name</th>
		                        <th style="width:12%" data-hide="phone,tablet">Campus</th>
		                        <th style="width:12%" data-hide="phone,tablet">Created At</th>
		                        <th style="width:12%" data-hide="phone,tablet">Updated At</th>
		                        <th style="width:5%">Status</th>
		                        <th style="width:15%">Actions</th>
		                      </tr>
		                    </thead>
		                    <tbody>
		                    	<c:forEach items="${faculties}" var="faculty">
		                    	  <spring:url value="/admin/faculties/edit/faculty/${faculty.facultyId}/" var="editAdminFaculty" />
								  <spring:url value="/admin/faculties/show/faculty/${faculty.facultyId}/" var="showAdminFaculty" />
			                      <tr>
			                        <td class="v-align-middle">
			                          <div class="checkbox check-default">
			                            <input type="checkbox" value="3" id="checkbox2">
			                            <label for="checkbox2"></label>
			                          </div>
			                        </td>
			                        <td class="v-align-middle">${faculty.facultyId}</td>
			                        <td class="v-align-middle"><span class="muted">${faculty.name}</span></td>
			                        <td class="v-align-middle">${faculty.campus.name}</td>
			                        <td class="v-align-middle">${faculty.createdAt}</td>
			                        <td class="v-align-middle">${faculty.updatedAt}</td>
			                        <td class="v-align-middle">
			                          <div>
			                          	<c:if test="${faculty.status == 'active'}">
			                            	<span class="label label-success">${faculty.status}</span>
			                            </c:if>
			                            <c:if test="${faculty.status == 'pending'}">
			                            	<span class="label label-warning">${faculty.status}</span>
			                            </c:if>
			                          </div>
			                        </td>
			                        <td class="text-center">
                                       <div class="btn-group">
                                         <a href="${showAdminFaculty}"><button class="btn btn-xs btn-default" type="submit" formmethod="get" formaction="${showAdminFaculty}" data-toggle="tooltip" title="View Faculty"><i class="fa fa-eye"></i></button></a>
                                         <a href="${editAdminFaculty}"><button class="btn btn-xs btn-default" type="submit" formmethod="get" formaction="${editAdminFaculty}" data-toggle="tooltip" title="Edit Faculty"><i class="fa fa-edit"></i></button></a>
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