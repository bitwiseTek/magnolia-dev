<%-- 
    Document   : list staff
    Created on : Apr 30, 2017
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
          <div class="page-title"> <i class="material-icons">recent_actors</i>
            <h3>Staff - <span class="semi-bold">List</span></h3>
          </div>
          <div class="row-fluid">
            <div class="span12">
              <div class="grid simple ">
                <div class="grid-title">
                  <h4>Staff <span class="semi-bold">List</span></h4>
                  <div class="tools">
                    <a href="javascript:;" class="collapse"></a>
                    <a href="#grid-config" data-toggle="modal" class="config"></a>
                    <a href="javascript:;" class="reload"></a>
                    <a href="javascript:;" class="remove"></a>
                  </div>
                </div>
                <div class="grid-body ">
                	<form:form class="animated fadeIn validate" id="" name="staff" method="POST" modelAttribute="staff">
                		<c:if test="${not empty staff}">
		                  <table class="table table-hover table-condensed" id="example">
		                    <thead>
		                      <tr>
		                        <th style="width:1%">
		                          <div class="checkbox check-default" style="margin-right:auto;margin-left:auto;">
		                            <input type="checkbox" value="1" id="checkbox1">
		                            <label for="checkbox1"></label>
		                          </div>
		                        </th>
		                        <th style="width:12%">Staff ID</th>
		                        <th style="width:12%" data-hide="phone,tablet">Name(F)</th>
		                        <th style="width:12%">Name(L)</th>
		                        <th style="width:18%">Department</th>
		                        <th style="width:22%">Type</th>
		                        <th style="width:5%">Status</th>
		                        <th style="width:15%">Actions</th>
		                      </tr>
		                    </thead>
		                    <tbody>
		                    	<c:forEach items="${staff}" var="staff">
		                    	  <spring:url value="/admin/staff/edit/staff/${staff.id}/" var="editAdminStaff" />
								  <spring:url value="/admin/staff/show/staff/${staff.id}/" var="showAdminStaff" />
			                      <tr>
			                        <td class="v-align-middle">
			                          <div class="checkbox check-default">
			                            <input type="checkbox" value="3" id="checkbox2">
			                            <label for="checkbox2"></label>
			                          </div>
			                        </td>
			                        <td class="v-align-middle">${staff.staffId}</td>
			                        <td class="v-align-middle"><span class="muted">${staff.user.firstName}</span></td>
			                        <td class="v-align-middle">${staff.user.lastName}</td>
			                        <td class="v-align-middle">${staff.staffDepartment.name}</td>
			                        <td class="v-align-middle">
			                        	<div>
			                          	<c:if test="${staff.isAcademic == true}">
			                            	<span class="label label-success">Academic</span>
			                            </c:if>
			                            <c:if test="${staff.isTemporary == true}">
			                            	<span class="label label-warning">Temporary</span>
			                            </c:if>
			                          </div>
			                        </td>
			                        <td class="v-align-middle">
			                          <div>
			                          	<c:if test="${staff.status == 'active'}">
			                            	<span class="label label-success">${staff.status}</span>
			                            </c:if>
			                            <c:if test="${staff.status == 'pending'}">
			                            	<span class="label label-warning">${staff.status}</span>
			                            </c:if>
			                          </div>
			                        </td>
			                        <td class="text-center">
                                       <div class="btn-group">
                                         <a href="${showAdminStaff}"><button class="btn btn-xs btn-default" type="submit" formmethod="get" formaction="${showAdminStaff}" data-toggle="tooltip" title="View Staff"><i class="fa fa-eye"></i></button></a>
                                         <a href="${editAdminStaff}"><button class="btn btn-xs btn-default" type="submit" formmethod="get" formaction="${editAdminStaff}" data-toggle="tooltip" title="Edit Staff"><i class="fa fa-edit"></i></button></a>
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