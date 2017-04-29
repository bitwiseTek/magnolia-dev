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
    <link href="<c:url value="/resources/assets/plugins/shape-hover/css/demo.css" /> " rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/assets/plugins/shape-hover/css/component.css" /> " rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/assets/plugins/owl-carousel/owl.carousel.css" /> " rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/assets/plugins/owl-carousel/owl.theme.css" /> " rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/assets/plugins/pace/pace-theme-flash.css" /> " rel="stylesheet" type="text/css" media="screen" />
    <link href="<c:url value="/resources/assets/plugins/jquery-slider/css/jquery.sidr.light.css" /> " rel="stylesheet" type="text/css" media="screen" />
    <link href="<c:url value="/resources/assets/plugins/jquery-ricksaw-chart/css/rickshaw.css" /> " rel="stylesheet" type="text/css" media="screen">
    <link rel="stylesheet" href="<c:url value="/resources/assets/plugins/jquery-morris-chart/css/morris.css" /> " type="text/css" media="screen">
    <link href="<c:url value="/resources/assets/plugins/Mapplic/mapplic/mapplic.css" /> " rel="stylesheet" type="text/css" media="screen">
    <link href="<c:url value="/resources/assets/plugins/bootstrap-tag/bootstrap-tagsinput.css" /> "  rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/assets/plugins/dropzone/css/dropzone.css" /> "  rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/assets/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.css" /> "  rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/assets/plugins/bootstrap-datepicker/css/datepicker.css" /> "  rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/assets/plugins/bootstrap-timepicker/css/bootstrap-timepicker.css" /> "  rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/assets/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.css" /> "  rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/assets/plugins/ios-switch/ios7-switch.css" /> " rel="stylesheet"  type="text/css" media="screen">
    <link href="<c:url value="/resources/assets/plugins/bootstrap-select2/select2.css" /> "  rel="stylesheet" type="text/css" media="screen" />
    <link href="<c:url value="/resources/assets/plugins/boostrap-clockpicker/bootstrap-clockpicker.min.css" /> "  rel="stylesheet" type="text/css" media="screen" />
    <link href="<c:url value="/resources/assets/plugins/jquery-datatable/css/jquery.dataTables.css" /> " rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/assets/plugins/datatables-responsive/css/datatables.responsive.css" /> " rel="stylesheet" type="text/css" media="screen" />
    <!-- END PLUGIN CSS -->
    <!-- BEGIN PLUGIN CSS -->
    <link href="<c:url value="/resources/assets/plugins/pace/pace-theme-flash.css" /> " rel="stylesheet" type="text/css" media="screen" />
    <link href="<c:url value="/resources/assets/plugins/bootstrapv3/css/bootstrap.min.css" /> " rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/assets/plugins/bootstrapv3/css/bootstrap-theme.min.css" /> " rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="<c:url value="/resources/assets/plugins/animate.min.css" /> " rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/assets/plugins/jquery-scrollbar/jquery.scrollbar.css" /> " rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/assets/plugins/fullcalendar/fullcalendar.css" /> " rel="stylesheet" type="text/css" media="screen" />
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
    <script src="<c:url value="/resources/src/js/frontend/users/register.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/frontend/users/list.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/frontend/security/addRole.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/frontend/security/addPermission.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/frontend/security/listRoles.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/frontend/security/listPermissions.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/frontend/students/register.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/frontend/messages/compose.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/frontend/messages/messages.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/frontend/students/list.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/frontend/staff/register.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/frontend/staff/list.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/frontend/finance/paybill.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/common/imagepreview.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/src/js/common/utils.js" /> " type="text/javascript"></script>
    <!-- END CORE JS DEPENDECENCIES-->
    <!-- BEGIN CORE TEMPLATE JS -->
    <script src="<c:url value="/resources/webarch/js/webarch.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/js/chat.js" /> " type="text/javascript"></script>
    <!-- END CORE TEMPLATE JS -->
    <!-- BEGIN PAGE LEVEL JS -->
    <script src="<c:url value="/resources/assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/bootstrap-timepicker/js/bootstrap-timepicker.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-inputmask/jquery.inputmask.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-autonumeric/autoNumeric.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/ios-switch/ios7-switch.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/bootstrap-select2/select2.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/bootstrap-wysihtml5/wysihtml5-0.3.0.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/bootstrap-tag/bootstrap-tagsinput.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/boostrap-clockpicker/bootstrap-clockpicker.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/dropzone/dropzone.min.js" /> " type="text/javascript"></script>
    <!-- END PAGE LEVEL PLUGINS -->
    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <script src="<c:url value="/resources/assets/plugins/jquery-datatable/js/jquery.dataTables.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-datatable/extra/js/dataTables.tableTools.min.js" /> " type="text/javascript"></script>
    <script type="text/javascript" src="<c:url value="/resources/assets/plugins/datatables-responsive/js/datatables.responsive.js" /> "></script>
    <script type="text/javascript" src="<c:url value="/resources/assets/plugins/datatables-responsive/js/lodash.min.js" /> "></script>
    <!-- END PAGE LEVEL JS INIT -->
    <script src="<c:url value="/resources/assets/js/datatables.js" /> " type="text/javascript"></script>
    <!-- BEGIN CORE TEMPLATE JS -->
    <script src="<c:url value="/resources/assets/js/form_elements.js" /> " type="text/javascript"></script>
    <!-- BEGIN PAGE LEVEL JS -->
    <script src="<c:url value="/resources/assets/js/email_comman.js" /> " type="text/javascript"></script>
    <script>
	    $(document).ready(function()
		    {
		      $("#quick-access").css("bottom", "0px");
		    });
    </script>
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