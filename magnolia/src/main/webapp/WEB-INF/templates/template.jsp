<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
  <head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
    <meta charset="utf-8" />
    <title><spring:message code="generic.applicationTitle" /></title>
    <link rel="shortcut icon" href="<c:url value="/resources/assets/img/footer_icon.png" /> " />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="description" content="Magnolia Web App">
    <meta name="author" content="Sika Kay">
    <!-- BEGIN APP CSS -->
    <link href="<c:url value="/resources/assets/css/app/messages.css" /> " rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/assets/css/ligature/ligature.css" /> " rel="stylesheet" type="text/css" />
    <!-- BEGIN PLUGIN CSS -->
    <link href="<c:url value="/resources/assets/plugins/font-awesome/css/font-awesome.css" /> " rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/assets/plugins/jquery-metrojs/MetroJs.min.css" /> " rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/plugins/shape-hover/css/demo.css" /> " />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/plugins/shape-hover/css/component.css" /> " />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/plugins/owl-carousel/owl.carousel.css" /> " />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/plugins/owl-carousel/owl.theme.css" /> " />
    <link href="<c:url value="/resources/assets/plugins/pace/pace-theme-flash.css" /> " rel="stylesheet" type="text/css" media="screen" />
    <link href="<c:url value="/resources/assets/plugins/jquery-slider/css/jquery.sidr.light.css" /> " rel="stylesheet" type="text/css" media="screen" />
    <link rel="stylesheet" href="<c:url value="/resources/assets/plugins/jquery-ricksaw-chart/css/rickshaw.css" /> " type="text/css" media="screen">
    <link rel="stylesheet" href="<c:url value="/resources/assets/plugins/Mapplic/mapplic/mapplic.css" /> " type="text/css" media="screen">
    <!-- END PLUGIN CSS -->
    <!-- BEGIN PLUGIN CSS -->
    <link href="<c:url value="/resources/assets/plugins/pace/pace-theme-flash.css" /> " rel="stylesheet" type="text/css" media="screen" />
    <link href="<c:url value="/resources/assets/plugins/bootstrapv3/css/bootstrap.min.css" /> " rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/assets/plugins/bootstrapv3/css/bootstrap-theme.min.css" /> " rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="<c:url value="/resources/assets/plugins/animate.min.css" /> " rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/assets/plugins/jquery-scrollbar/jquery.scrollbar.css" /> " rel="stylesheet" type="text/css" />
    <!-- END PLUGIN CSS -->
    <!-- BEGIN CORE CSS FRAMEWORK -->
    <link href="<c:url value="/resources/webarch/css/webarch.css" /> " rel="stylesheet" type="text/css" />
    <!-- END CORE CSS FRAMEWORK -->
    <!-- BEGIN CORE JS FRAMEWORK-->
    <script src="<c:url value="/resources/assets/plugins/pace/pace.min.js" /> " type="text/javascript"></script>
    <!-- BEGIN JS DEPENDECENCIES-->
    <script src="<c:url value="/resources/assets/plugins/jquery/jquery-1.11.3.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/bootstrapv3/js/bootstrap.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-block-ui/jqueryblockui.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-unveil/jquery.unveil.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-numberAnimate/jquery.animateNumbers.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-validation/js/jquery.validate.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/bootstrap-select2/select2.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/bootstrap-select2/select2.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/frontend/users/register.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/frontend/users/list.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/frontend/security/addRole.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/frontend/security/addPermission.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/frontend/security/listRoles.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/frontend/security/listPermissions.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/common/imagepreview.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/common/utils.js" /> " type="text/javascript"></script>
    <!-- END CORE JS DEPENDECENCIES-->
    <!-- BEGIN CORE TEMPLATE JS -->
    <script src="<c:url value="/resources/webarch/js/webarch.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/js/chat.js" /> " type="text/javascript"></script>
    <!-- END CORE TEMPLATE JS -->
    <!-- BEGIN PAGE LEVEL JS -->
    <script src="<c:url value="/resources/assets/plugins/jquery-ui/jquery-ui-1.10.1.custom.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-ricksaw-chart/js/raphael-min.js" /> "></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-ricksaw-chart/js/d3.v2.js" /> "></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-ricksaw-chart/js/rickshaw.min.js" /> "></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-sparkline/jquery-sparkline.js" /> "></script>
    <script src="<c:url value="/resources/assets/plugins/skycons/skycons.js" /> "></script>
    <script src="<c:url value="/resources/assets/plugins/owl-carousel/owl.carousel.min.js" /> " type="text/javascript"></script>
    <!-- <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script> -->
    <%-- <script src="<c:url value="/resources/assets/plugins/jquery-gmap/gmaps.js" /> " type="text/javascript"></script> --%>
    <script src="<c:url value="/resources/assets/plugins/Mapplic/js/jquery.easing.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/Mapplic/js/jquery.mousewheel.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/Mapplic/js/hammer.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/Mapplic/mapplic/mapplic.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-flot/jquery.flot.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-metrojs/MetroJs.min.js" /> " type="text/javascript"></script>
    <!-- END PAGE LEVEL PLUGINS -->
    <!-- BEGIN CORE TEMPLATE JS -->
    <script src="<c:url value="/resources/assets/js/dashboard_v2.js" /> " type="text/javascript"></script>
  </head>
  <!-- END HEAD -->
  <!-- BEGIN BODY -->
  <body class="">
    
    <!-- BEGIN CONTAINER -->
    <div class="page-container row-fluid">
      <tiles:insertAttribute name="header" />
      <tiles:insertAttribute name="lsidebar" />
      
      <!-- BEGIN PAGE CONTAINER-->
      <div class="page-content">
        <tiles:insertAttribute name="content" />
      </div>
    </div>
    <!-- END CONTAINER -->
    <tiles:insertAttribute name="footer" />
  </body>
</html>