<%-- 
    Document   : header
    Created on : Jan 30, 2017
    Author(s)  : Sika Kay, Success Otto
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>

<tilesx:useAttribute name="current" />

<!-- BEGIN HEADER -->
    <div class="header navbar navbar-inverse ">
      <!-- BEGIN TOP NAVIGATION BAR -->
      <div class="navbar-inner">
        <div class="header-seperation">
          <ul class="nav pull-left notifcation-center visible-xs visible-sm">
            <li class="dropdown">
              <a href="#main-menu" data-webarch="toggle-left-side">
                <i class="material-icons">menu</i>
              </a>
            </li>
          </ul>
          <!-- BEGIN LOGO -->
          <a href="<c:url value="/" /> ">
            <img src="<c:url value="/resources/assets/img/school_logo.png" /> " class="logo" alt="" data-src="<c:url value="/resources/assets/img/school_logo.png" /> " data-src-retina="<c:url value="/resources/assets/img/school_logo.png" /> " width="40" height="40" />
            <span style="font-size: 20px; font-weight: bold;">magnolia</span>
          </a>
          <!-- END LOGO -->
          
        </div>
        <!-- END RESPONSIVE MENU TOGGLER -->
        <div class="header-quick-nav">
          <!-- BEGIN TOP NAVIGATION MENU -->
          <div class="pull-left">
            <ul class="nav quick-section">
              <li class="quicklinks">
                <a href="#" class="" id="layout-condensed-toggle">
                  <i class="material-icons">menu</i>
                </a>
              </li>
            </ul>
            <ul class="nav quick-section">
              <li class="m-r-10 input-prepend inside search-form no-boarder">
                <span class="add-on"> <i class="material-icons">search</i></span>
                <input name="" type="text" class="no-boarder " placeholder="Search Magnolia" style="width:250px;">
              </li>
            </ul>
          </div>
          <!-- END TOP NAVIGATION MENU -->
          <!-- BEGIN CHAT TOGGLER -->
          <sec:authorize access="fullyAuthenticated">
          	<div class="pull-right">
	            <div class="chat-toggler sm">
	              <div class="profile-pic">
	                <img src="<c:url value="/resources/assets/img/mg/${pageContext.request.userPrincipal.name}.png" /> " alt="" data-src="<c:url value="/resources/assets/img/mg/${pageContext.request.userPrincipal.name}.png" /> " data-src-retina="<c:url value="/resources/assets/img/mg/${pageContext.request.userPrincipal.name}.png" /> " width="35" height="35" />
	                <div class="availability-bubble online"></div>
	              </div>
	            </div>
	            <ul class="nav quick-section ">
	              <li class="quicklinks">
	                <a data-toggle="dropdown" class="dropdown-toggle  pull-right " href="#" id="user-options">
	                  <i class="material-icons">tune</i>
	                </a>
	                <ul class="dropdown-menu  pull-right" role="menu" aria-labelledby="user-options">
	                  <li>
	                    <a href="<c:url value="/users/profile/edit" /> "> My Account</a>
	                  </li>
	                  <sec:authorize access="hasRole('ROLE_STUDENT')">
		                  <li>
		                    <a href="<c:url value="/students/timetable" /> ">My Timetable</a>
		                  </li>
	                  </sec:authorize>
	                  <sec:authorize access="hasRole('ROLE_STAFF')">
		                  <li>
		                    <a href="<c:url value="/staff/timetable" /> ">My Timetable</a>
		                  </li>
	                  </sec:authorize>
	                  <li>
	                    <a href="<c:url value="/messages/inbox" /> "> My Inbox&nbsp;&nbsp;
	                  		<span class="badge badge-important animated bounceIn">2</span>
	                  	</a>
	                  </li>
	                  <li class="divider"></li>
	                  <li>
	                    <a href="<c:url value="/auth/logout" /> "><i class="material-icons">exit_to_app</i>&nbsp;&nbsp;Logout</a>
	                  </li>
	                </ul>
	              </li>
	            </ul>
	          </div>
          </sec:authorize>
          <!-- END CHAT TOGGLER -->
        </div>
        <!-- END TOP NAVIGATION MENU -->
      </div>
      <!-- END TOP NAVIGATION BAR -->
    </div>
    <!-- END HEADER -->