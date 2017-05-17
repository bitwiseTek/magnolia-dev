<%-- 
    Document   : content only
    Created on : Jan 30, 2017
    Author(s)  : Sika Kay, Success Otto
--%>

<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>

<!-- BEGIN SIDEBAR -->
      <div class="page-sidebar " id="main-menu">
        <!-- BEGIN MINI-PROFILE -->
        <div class="page-sidebar-wrapper scrollbar-dynamic" id="main-menu-wrapper">
          <sec:authorize access="fullyAuthenticated">
          	<div class="user-info-wrapper sm">
	            <div class="profile-wrapper sm">
	              <img src="<c:url value="/resources/assets/img/mg/${pageContext.request.userPrincipal.name}.png" /> " alt="" data-src="<c:url value="/resources/assets/img/mg/${pageContext.request.userPrincipal.name}.png" /> " data-src-retina="<c:url value="/resources/assets/img/mg/${pageContext.request.userPrincipal.name}.png" /> " width="69" height="69" />
	              <div class="availability-bubble online"></div>
	            </div>
	            <div class="user-info sm">
	              <div class="username"><span style="font-size: 13px; color: #000;">${pageContext.request.userPrincipal.name}</span></div>
	            </div>
          	</div>
          </sec:authorize>
          <!-- END MINI-PROFILE -->
          
          <!-- BEGIN SIDEBAR MENU -->
	          <ul>
	          	<sec:authorize access="!authenticated">
	          		<li class="start ${current == 'login' ? 'active' : '' }"> 
	          			<a href="<c:url value="/auth/login" /> "><i class="material-icons">power_settings_new</i> <span class="title">Log In</span></a>
		            </li>
		            
		            <li class="start ${current == 'register' ? 'active' : '' }"> 
	          			<a href="<c:url value="/users/register" /> "><i class="material-icons">speaker_notes</i> <span class="title">Sign Up</span></a>
		            </li>
		            
		             <li class="start ${current == 'help' ? 'active' : '' }"> <a href="#"><i class="material-icons">help</i> <span class="title">Help</span> <span class="selected"></span> <span class="arrow  close "></span> </a>
		              <ul class="sub-menu">
		                <li> <a href="<c:url value="/help/student" /> "> Student Help </a> </li>
		                <li class=""> <a href="<c:url value="/help/staff" /> ">  Staff Help </a></li>
		              </ul>
		            </li>
	          	</sec:authorize>
	          	<div>&nbsp;</div>
	          	<sec:authorize access="fullyAuthenticated">
		            <li class="start ${current == 'profile' ? 'active' : '' }"> <a href="#"><i class="material-icons">account_box</i> <span class="title">Profile</span> <span class="selected"></span> <span class="arrow  close "></span> </a>
		              <ul class="sub-menu">
		                <li> <a href="<c:url value="/users/profile/edit" /> "> Edit </a> </li>
		                <li class=""> <a href="<c:url value="/users/profile/edit" /> ">  View </a></li>
		              </ul>
		            </li>
		            
		            <sec:authorize access="hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')">
		            	<li class="start ${current == 'settings' ? 'active' : '' }"> <a href="#"><i class="material-icons">settings</i> <span class="title">Settings</span> <span class="selected"></span> <span class="arrow  close "></span> </a>
			              <ul class="sub-menu">
			                <li> <a href="#"><span class="selected"></span><span class="title">Sub-School</span> <span class="arrow  close "></span></a>
			                	<ul class="sub-menu">
			                		<li> <a href="<c:url value="/admin/subschools/add" /> ">Add</a></li>
			                		<li> <a href="<c:url value="/admin/subschools/list" /> ">List</a></li>
			                	</ul>
			                </li>
			                <li> <a href="#"><span class="selected"></span><span class="title">Campus</span> <span class="arrow  close "></span></a>
			                	<ul class="sub-menu">
			                		<li> <a href="<c:url value="/admin/campuses/add" /> ">Add</a></li>
			                		<li> <a href="<c:url value="/admin/campuses/list" /> ">List</a></li>
			                	</ul>
			                </li>
			                <li> <a href="#"><span class="selected"></span><span class="title">Faculty</span> <span class="arrow  close "></span></a>
			                	<ul class="sub-menu">
			                		<li> <a href="<c:url value="/admin/faculties/add" /> ">Add</a></li>
			                		<li> <a href="<c:url value="/admin/faculties/list" /> ">List</a></li>
			                	</ul>
			                </li>
			                <li> <a href="#"><span class="selected"></span><span class="title">Department</span> <span class="arrow  close "></span></a>
			                	<ul class="sub-menu">
			                		<li> <a href="<c:url value="/admin/departments/add" /> ">Add</a></li>
			                		<li> <a href="<c:url value="/admin/departments/list" /> ">List</a></li>
			                	</ul>
			                </li>
			                <li> <a href="#"><span class="selected"></span><span class="title">Course Length</span> <span class="arrow  close "></span></a>
			                 	<ul class="sub-menu">
			                		<li> <a href="<c:url value="/course/lengths/add" /> ">Add</a></li>
			                		<li> <a href="<c:url value="/course/lengths/list" /> ">List</a></li>
			                	</ul>
			                </li>
			                <li> <a href="#"><span class="selected"></span><span class="title">Course</span> <span class="arrow  close "></span></a>
			                 	<ul class="sub-menu">
			                		<li> <a href="<c:url value="/courses/add" /> ">Add</a></li>
			                		<li> <a href="<c:url value="/courses/list" /> ">List</a></li>
			                	</ul>
			                </li>
			                <li> <a href="#"><span class="selected"></span><span class="title">Programme Category</span> <span class="arrow  close "></span></a>
			                 	<ul class="sub-menu">
			                		<li> <a href="<c:url value="/programme/categories/add" /> ">Add</a></li>
			                		<li> <a href="<c:url value="/programme/categories/list" /> ">List</a></li>
			                	</ul>
			                </li>
			                <li> <a href="#"><span class="selected"></span><span class="title">Programme</span> <span class="arrow  close "></span></a>
			                 	<ul class="sub-menu">
			                		<li> <a href="<c:url value="/programmes/add" /> ">Add</a></li>
			                		<li> <a href="<c:url value="/programmes/list" /> ">List</a></li>
			                	</ul>
			                </li>
			                <li> <a href="#"><span class="selected"></span><span class="title">Role</span> <span class="arrow  close "></span></a>
			                 	<ul class="sub-menu">
			                		<li> <a href="<c:url value="/roles/add" /> ">Add</a></li>
			                		<li> <a href="<c:url value="/roles/list" /> ">List</a></li>
			                	</ul>
			                </li>
			                <li> <a href="#"><span class="selected"></span><span class="title">Permission</span> <span class="arrow  close "></span></a>
			                 	<ul class="sub-menu">
			                		<li> <a href="<c:url value="/permissions/add" /> ">Add</a></li>
			                		<li> <a href="<c:url value="/permissions/list" /> ">List</a></li>
			                	</ul>
			                 </li>
			              </ul>
			            </li>
		            </sec:authorize>
		            
		            <sec:authorize access="hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')">
		            	<li class="start ${current == 'users' ? 'active' : '' }"> <a href="#"><i class="material-icons">supervisor_account</i> <span class="title">Users</span> <span class="selected"></span> <span class="arrow  close "></span> </a>
			              <ul class="sub-menu">
			                <li> <a href="<c:url value="/users/list" /> ">List</a></li>
			                 <sec:authorize access="hasRole('ROLE_SUPER_ADMIN')"><li> <a href="<c:url value="/users/delete" /> ">Delete</a></li></sec:authorize>
			              </ul>
			            </li>
		            </sec:authorize>

		            <sec:authorize access="hasRole('ROLE_ADMIN')">
		            	<li class="start ${current == 'students' ? 'active' : '' }"> <a href="#"><i class="material-icons">school</i> <span class="title">Students</span> <span class="selected"></span> <span class="arrow  close "></span> </a>
			              <ul class="sub-menu">
			                <li> <a href="<c:url value="/admin/students/list" /> ">List</a></li>
			              </ul>
			            </li>
		            </sec:authorize>

		            <sec:authorize access="hasRole('ROLE_ADMIN')">
		            	<li class="start ${current == 'staff' ? 'active' : '' }"> <a href="#"><i class="material-icons">recent_actors</i> <span class="title">Staff</span> <span class="selected"></span> <span class="arrow  close "></span> </a>
			              <ul class="sub-menu">
			                <li> <a href="<c:url value="/admin/staff/list" /> ">List</a></li>
			              </ul>
			            </li>
		            </sec:authorize>
		            
		            <sec:authorize access="hasRole('ROLE_STUDENT')">
			            <li class="start ${current == 'students' ? 'active' : '' }"> <a href="#"><i class="material-icons">school</i> <span class="title">Student</span> <span class="selected"></span> <span class="arrow  close "></span> </a>
			              <ul class="sub-menu">
			                <li> <a href="<c:url value="/students/register" /> ">Register</a></li>
			                <li class=""> <a href="<c:url value="/students/edit" /> ">Edit</a></li>
			                <li class=""> <a href="<c:url value="/students/handbook" /> ">Handbook</a></li>
			              </ul>
			            </li>
			            
			            <li class="start ${current == 'bills' ? 'active' : '' }"> <a href="#"><i class="material-icons">receipt</i> <span class="title">Billing</span> <span class="selected"></span> <span class="arrow  close "></span> </a>
			              <ul class="sub-menu">
			                <li> <a href="<c:url value="/students/billing/pay" /> ">Fees Payment</a></li>
			                <li class=""> <a href="<c:url value="/students/billing/status" /> ">Fees Status</a></li>
			              </ul>
			            </li>
			            
			            <li class="start ${current == 'courses' ? 'active' : '' }"> <a href="#"><i class="material-icons">library_books</i> <span class="title">Course</span> <span class="selected"></span> <span class="arrow  close "></span> </a>
			              <ul class="sub-menu">
			              	<li> <a href="<c:url value="/students/courses/add" /> ">Add</a></li>
			                <li> <a href="<c:url value="/students/courses/list" /> ">List</a></li>
			                <li class=""> <a href="<c:url value="/students/courses/registered" /> ">Registered</a></li>
			                <li class=""> <a href="<c:url value="/students/courses/pending" /> ">Pending</a></li>
			                <li class=""> <a href="<c:url value="/students/courses/completed" /> ">Completed</a></li>
			                <li class=""> <a href="<c:url value="/students/timetable" /> ">Timetable</a></li>
			              </ul>
			            </li>
			            
			            <li class="start ${current == 'hostels' ? 'active' : '' }"> <a href="#"><i class="material-icons">home</i> <span class="title">Accommodation</span> <span class="selected"></span> <span class="arrow  close "></span> </a>
			              <ul class="sub-menu">
			                <li> <a href="<c:url value="/students/hostels/book" /> ">Hostel Booking</a></li>
			                <li> <a href="<c:url value="/students/hostels/status" /> ">Hostel Status</a></li>
			              </ul>
			            </li>
		            </sec:authorize>
		            
		            <sec:authorize access="hasRole('ROLE_STAFF')">
		            	<li class="start ${current == 'staff' ? 'active' : '' }"> <a href="#"><i class="material-icons">recent_actors</i> <span class="title">Staff</span> <span class="selected"></span> <span class="arrow  close "></span> </a>
			              <ul class="sub-menu">
			                <li> <a href="<c:url value="/staff/register" /> ">Register</a></li>
			                <li class=""> <a href="<c:url value="/staff/edit" /> ">Edit</a></li>
			                <li class=""> <a href="<c:url value="/staff/handbook" /> ">Handbook</a></li>
			              </ul>
			            </li>
			            
			            <li class="start ${current == 'students' ? 'active' : '' }"> <a href="#"><i class="material-icons">school</i> <span class="title">Student</span> <span class="selected"></span> <span class="arrow  close "></span> </a>
			              <ul class="sub-menu">
			                <li> <a href="<c:url value="/staff/students/list" /> ">List</a></li>
			              </ul>
			            </li>
			            
			            <li class="start ${current == 'courses' ? 'active' : '' }"> <a href="#"><i class="material-icons">library_books</i> <span class="title">Course</span> <span class="selected"></span> <span class="arrow  close "></span> </a>
			              <ul class="sub-menu">
			              	<li> <a href="<c:url value="/staff/courses/add" /> ">Add</a></li>
			                <li> <a href="<c:url value="/staff/courses/list" /> ">List</a></li>
			                <li class=""> <a href="<c:url value="/staff/courses/attached" /> ">Attached</a></li>
			                <li class=""> <a href="<c:url value="/staff/courses/pending" /> ">Pending</a></li>
			                <li class=""> <a href="<c:url value="/staff/timetable" /> ">Timetable</a></li>
			              </ul>
			            </li>
		            </sec:authorize>
		            
		            <sec:authorize access="hasRole('ROLE_MANAGER') or hasRole('ROLE_ACCOUNTANT')">
		            	<li class="start ${current == 'staff' ? 'active' : '' }"> <a href="#"><i class="material-icons">recent_actors</i> <span class="title">Staff</span> <span class="selected"></span> <span class="arrow  close "></span> </a>
			              <ul class="sub-menu">
			                <li class=""> <a href="<c:url value="/manager/staff/list" /> ">List</a></li>
			              </ul>
			            </li>
			            
			            <li class="start ${current == 'students' ? 'active' : '' }"> <a href="#"><i class="material-icons">school</i> <span class="title">Student</span> <span class="selected"></span> <span class="arrow  close "></span> </a>
			              <ul class="sub-menu">
			                <li class=""> <a href="<c:url value="/manager/students/list" /> ">List</a></li>
			              </ul>
			            </li>
			            
			            <li class="start ${current == 'courses' ? 'active' : '' }"> <a href="#"><i class="material-icons">library_books</i> <span class="title">Course</span> <span class="selected"></span> <span class="arrow  close "></span> </a>
			              <ul class="sub-menu">
			                <li> <a href="<c:url value="/manager/staff/courses/list" /> ">List</a></li>
			                <li class=""> <a href="<c:url value="/manager/staff/courses/attached" /> ">Attached</a></li>
			                <li class=""> <a href="<c:url value="/manager/staff/courses/pending" /> ">Pending</a></li>
			                <li class=""> <a href="<c:url value="/manager/staff/timetable" /> ">Timetable</a></li>
			              </ul>
			            </li>
			            
			            <li class="start ${current == 'transactions' ? 'active' : '' }"> <a href="#"><i class="material-icons">equalizer</i> <span class="title">Transactions</span> <span class="selected"></span> <span class="arrow  close "></span> </a>
			              <ul class="sub-menu">
			                <li> <a href="<c:url value="/finance/billing/status" /> ">List</a></li>
			              </ul>
			            </li>
		            </sec:authorize>
		            
		            <li class="start ${current == 'messages' ? 'active' : '' }"> <a href="#"><i class="material-icons">email</i> <span class="title">Messages</span> <span class="selected"></span> <span class="arrow  close "></span> </a>
		              <ul class="sub-menu">	
		              	<li class=""> <a href="<c:url value="/messages/compose" /> ">  Compose </a></li>
		                <li class=""> <a href="<c:url value="/messages/view" /> ">  View </a></li>
		              </ul>
		            </li>
		            
		            <li class="start ${current == 'signout' ? 'active' : '' }"> 
	          			<a href="<c:url value="/auth/logout" /> "><i class="material-icons">exit_to_app</i> <span class="title">Logout</span></a>
		            </li>
		        </sec:authorize>
	          </ul>
          	  <div class="clearfix"></div>
          <!-- END SIDEBAR MENU -->
        </div>
      </div>
      <!-- END SIDEBAR -->