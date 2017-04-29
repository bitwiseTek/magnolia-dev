<%-- 
    Document   : list bills
    Created on : Apr 27, 2017
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
          <div class="page-title"> <i class="material-icons">receipt</i>
            <h3>Bills - <span class="semi-bold">List</span></h3>
          </div>
          <div class="row-fluid">
            <div class="span12">
              <div class="grid simple ">
                <div class="grid-title">
                  <h4>Bills <span class="semi-bold">List</span></h4>
                  <div class="tools">
                    <a href="javascript:;" class="collapse"></a>
                    <a href="#grid-config" data-toggle="modal" class="config"></a>
                    <a href="javascript:;" class="reload"></a>
                    <a href="javascript:;" class="remove"></a>
                  </div>
                </div>
                <div class="grid-body ">
                	<form:form class="animated fadeIn validate" id="" name="bills" method="POST" modelAttribute="bills">
                		<c:if test="${not empty bills}">
		                  <table class="table table-hover table-condensed" id="example">
		                    <thead>
		                      <tr>
		                        <th style="width:1%">
		                          <div class="checkbox check-default" style="margin-right:auto;margin-left:auto;">
		                            <input type="checkbox" value="1" id="checkbox1">
		                            <label for="checkbox1"></label>
		                          </div>
		                        </th>
		                        <th style="width:7%">Bill ID</th>
		                        <th style="width:22%" data-hide="phone,tablet">Reference Code</th>
		                        <th style="width:22%">Student ID</th>
		                        <th style="width:20%" data-hide="phone,tablet">Session</th>
		                        <th style="width:20%">Amount</th>
		                        <th style="width:5%">Status</th>
		                        <th style="width:15%">Actions</th>
		                      </tr>
		                    </thead>
		                    <tbody>
		                    	<c:forEach items="${bills}" var="bill">
		                    	  <spring:url value="/finance/billing/status/edit/${bill.id}/" var="editBill" />
		                    	  <spring:url value="/finance/billing/status/view/${bill.id}/" var="showAdminBill" />
								  <spring:url value="/students/billing/status/view/${bill.id}/" var="showBill" />
			                      <tr>
			                        <td class="v-align-middle">
			                          <div class="checkbox check-default">
			                            <input type="checkbox" value="3" id="checkbox2">
			                            <label for="checkbox2"></label>
			                          </div>
			                        </td>
			                        <td class="v-align-middle">${bill.id}</td>
			                        <td class="v-align-middle"><span class="muted">${bill.referenceNumber}</span></td>
			                        <td class="v-align-middle">${bill.studentId.studentId}</td>
			                        <td><span class="muted">${bill.semester.session}</span></td>
			                        <td class="v-align-middle">${bill.feesAmount}</td>
			                        <td class="v-align-middle">
			                          <div>
			                          	<c:if test="${bill.status == 'complete'}">
			                            	<span class="label label-success">${bill.status}</span>
			                            </c:if>
			                            <c:if test="${bill.status == 'pending'}">
			                            	<span class="label label-warning">${bill.status}</span>
			                            </c:if>
			                          </div>
			                        </td>
			                        <td class="text-center">
                                       <div class="btn-group">
                                       	 <sec:authorize access="hasRole('ROLE_STUDENT')">
                                         	<a href="${showBill}"><button class="btn btn-xs btn-default" type="submit" formmethod="get" formaction="${showBill}" data-toggle="tooltip" title="View Bill"><i class="fa fa-eye"></i></button></a>
                                         </sec:authorize>
                                         <sec:authorize access="hasRole('ROLE_ACCOUNTANT') or hasRole('ROLE_MANAGER')">
                                         	<a href="${showAdminBill}"><button class="btn btn-xs btn-default" type="submit" formmethod="get" formaction="${showAdminBill}" data-toggle="tooltip" title="View Bill"><i class="fa fa-eye"></i></button></a>
                                         	<a href="${editBill}"><button class="btn btn-xs btn-default" type="submit" formmethod="get" formaction="${editBill}" data-toggle="tooltip" title="Edit Bill"><i class="fa fa-edit"></i></button></a>
                                       	 </sec:authorize>
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