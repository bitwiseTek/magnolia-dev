<%-- 
    Document   : list courses
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
          <div class="page-title"> <i class="material-icons">library_books</i>
            <h3>Courses - <span class="semi-bold">List</span></h3>
          </div>
          <div class="row-fluid">
            <div class="span12">
              <div class="grid simple ">
                <div class="grid-title">
                  <h4>Courses <span class="semi-bold">List</span></h4>
                  <div class="tools">
                    <a href="javascript:;" class="collapse"></a>
                    <a href="#grid-config" data-toggle="modal" class="config"></a>
                    <a href="javascript:;" class="reload"></a>
                    <a href="javascript:;" class="remove"></a>
                  </div>
                </div>
                <div class="grid-body ">
                	<form:form class="animated fadeIn validate" id="" name="course" method="POST" modelAttribute="courses">
                		<c:if test="${not empty courses}">
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
		                        <th style="width:10%">Code</th>
		                        <th style="width:12%" data-hide="phone,tablet">Semester</th>
		                        <th style="width:7%">Credit Unit</th>
		                        <th style="width:8%" data-hide="phone,tablet">Academic Level</th>
		                        <th style="width:5%">Status</th>
		                        <th style="width:15%">Actions</th>
		                      </tr>
		                    </thead>
		                    <tbody>
		                    	<c:forEach items="${courses}" var="course">
		                    	  <spring:url value="/courses/edit/course/${course.id}/" var="editAdminCourse" />
								  <spring:url value="/courses/show/course/${course.id}/" var="showAdminCourse" />
			                      <tr>
			                        <td class="v-align-middle">
			                          <div class="checkbox check-default">
			                            <input type="checkbox" value="3" id="checkbox2">
			                            <label for="checkbox2"></label>
			                          </div>
			                        </td>
			                        <td class="v-align-middle">${course.id}</td>
			                        <td class="v-align-middle"><span class="muted">${course.name}</span></td>
			                        <td class="v-align-middle">${course.code}</td>
			                        <td class="v-align-middle"><span class="muted">${course.semester.name}</span></td>
			                        <td class="v-align-middle">${course.creditUnit}</td>
			                        <td class="v-align-middle"><span class="muted">${course.academicLevel}</span></td>
			                        <td class="v-align-middle">
			                          <div>
			                          	<c:if test="${course.status == 'active'}">
			                            	<span class="label label-success">${course.status}</span>
			                            </c:if>
			                            <c:if test="${course.status == 'pending'}">
			                            	<span class="label label-warning">${course.status}</span>
			                            </c:if>
			                          </div>
			                        </td>
			                        <td class="text-center">
                                       <div class="btn-group">
                                         <a href="${showAdminCourse}"><button class="btn btn-xs btn-default" type="submit" formmethod="get" formaction="${showAdminCourse}" data-toggle="tooltip" title="View Course"><i class="fa fa-eye"></i></button></a>
                                         <a href="${editAdminCourse}"><button class="btn btn-xs btn-default" type="submit" formmethod="get" formaction="${editAdminCourse}" data-toggle="tooltip" title="Edit Course"><i class="fa fa-edit"></i></button></a>
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