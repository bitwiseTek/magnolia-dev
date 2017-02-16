<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
    <meta charset="utf-8" />
    <title>Magnolia - ${school.schoolName }</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <link rel="shortcut icon" type="image/jpeg" href="<c:url value="${school.schoolLogo }" />"/>
    <!-- BEGIN PLUGIN CSS -->
    <link href="<c:url value="/resources/assets/plugins/pace/pace-theme-flash.css" /> " rel="stylesheet" type="text/css" media="screen" />
    <link href="<c:url value="/resources/assets/plugins/bootstrapv3/css/bootstrap.min.css" /> " rel="stylesheet" type="text/css" />
    <link href="/resources/assets/plugins/bootstrapv3/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="<c:url value="/resources/assets/plugins/animate.min.css" /> " rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/assets/plugins/jquery-scrollbar/jquery.scrollbar.css" /> " rel="stylesheet" type="text/css" />
    <!-- END PLUGIN CSS -->
    
    
    
    
    <!-- BEGIN PLUGIN CSS -->
    <link href="<c:url value="/resources/assets/plugins/font-awesome/css/font-awesome.css" /> " rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/assets/plugins/bootstrap-datepicker/css/datepicker.css" /> " rel="stylesheet" type="text/css" />
    <!-- END PLUGIN CSS -->
    
    
    <!-- BEGIN THIRED PARTY CSS -->
    
    
    <!-- BEGIN CORE CSS FRAMEWORK -->
    <link href="<c:url value="/resources/webarch/css/webarch.css" /> " rel="stylesheet" type="text/css" />
    <!-- END CORE CSS FRAMEWORK -->
  </head>
  <!-- END HEAD -->
  <!-- BEGIN BODY -->
  <body class="error-body no-top lazy" data-original="<c:url value="/resources/assets/img/work.jpg" /> " style="background-image: url('<c:url value='/resources/assets/img/work.jpg' /> ')">
    <div class="container">


<!-- BEGIN RADIO/TOGGLE CONTROLS-->
<div class="row" style="display: none;">
  <div class="col-md-12">
    <div class="grid simple">
      <div class="grid-body no-border">
        <div class="row">
          <div class="col-md-4">
            <div class="row-fluid">
              <div class="slide-primary">
                <input type="checkbox" name="switch" class="ios" checked="checked" />
              </div>
              <div class="slide-success">
                <input type="checkbox" name="switch" class="iosblue" checked="checked" />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- END RADIO/TOGGLE CONTROLS-->
    
      <div class="row login-container animated fadeInUp">
        <div class="col-md-7 col-md-offset-2 tiles white no-padding">
          <div class="p-t-30 p-l-40 p-b-20 xs-p-t-10 xs-p-l-10 xs-p-b-10">
            <h2 class="normal">
          Sign in to ${school.schoolName }
        </h2>
            <p>
              Use Facebook, Twitter or your email to sign in.
              <br>
            </p>
            <p class="p-b-20">
              Sign up Now! for webarch accounts, it's free and always will be..
            </p>
            <div role="tablist">
              <a href="#tab_login" class="btn btn-info btn-cons" role="tab" data-toggle="tab">Login</a> &nbsp;&nbsp;
              <a href="#tab_register" class="btn btn-primary btn-cons" role="tab" data-toggle="tab">Student Registration</a> &nbsp;&nbsp;
              <a href="#tab_register_staff" class="btn btn-info btn-cons" role="tab" data-toggle="tab">Staff Registration</a>
            </div>
          </div>
          <div class="tiles grey p-t-20 p-b-20 no-margin text-black tab-content">
            <div role="tabpanel" class="tab-pane active" id="tab_login">
              <form class="animated fadeIn validate" id="" name="login">
                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
                	<div class="col-md-12">
	                  	<div class="alert alert-error" style="display: none;">
	                      <span class="loginErrorMsg"></span>
	                    </div>
                  	</div>
                  <div class="col-md-5 col-sm-5">
                    <input class="form-control" id="login_username" name="email" placeholder="Username" type="email">
                  </div>
                  <div class="col-md-5 col-sm-5">
                    <input class="form-control" id="login_pass" name="password" placeholder="Password" type="password">
                  </div>
                  <div class="col-md-1 col-sm-1">
                  	<button type="button" class="btn btn-default btn-cons" id="loginBtn">Login</button>
                  </div>
                </div>
                <div class="row p-t-10 m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
                  <div class="control-group col-md-10">
                    <div class="checkbox checkbox check-success">
                      <a href="#">Trouble login in?</a>&nbsp;&nbsp;
                      <input id="checkbox1" type="checkbox" value="1">
                      <label for="checkbox1">Keep me reminded</label>
                    </div>
                  </div>
                </div>
              </form>
            </div>
            
            
            
            
            <div role="tabpanel" class="tab-pane" id="tab_register">
              <form class="animated fadeIn validate" id="" name="student">
              
              	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
              		
              		<div class="col-md-2 col-sm-2">
              			<div class="col-md-12">
	              			<a href="#loc_photo" ></a><div id="preview_photo" class="centered" ><img src="<c:url value="/resources/assets/img/person-icon.png" /> " class="img-circle" width="60"></div>
	              		</div>
              		</div>
              		<div class="col-md-10 col-sm-10">
              			
              			<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                  <div class="col-md-12">
		                  	<div class="alert alert-error" style="display: none;">
		                      
		                      <span class="stdErrorMsg"></span>
		                    </div>
		                  </div>
	                  </div>
           			<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-6 col-sm-6">
	                    <input class="form-control" id="stdFirstName" name="stdFirstName" placeholder="First Name" type="text" required>
	                  </div>
	                  <div class="col-md-6 col-sm-6">
	                    <input class="form-control" id="stdFirstName" name="stdOtherNames" placeholder="Other Names" type="text" required>
	                  </div>
	                </div>
                
                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
                  <div class="col-md-12">
                    <input class="form-control" id="reg_email" name="stdEmail" placeholder="Email" type="email" required>
                  </div>
                </div>
                
                
                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
                	<div class="col-md-6 col-sm-6">
					<div class="input-append success date col-md-10 col-lg-10 no-padding">
					  <input type="text" placeholder="Date of Birth" name="stdDob" class="form-control">
					  <span class="add-on" style="background-color: #BBB;"><span></span><i class="fa fa-th"></i></span>
					</div>
                  </div>
                  <div class="col-md-6 col-sm-6">
                  	<!-- <select id="stdGender" style="width:100%">
                       <option value="SG">Select Gender</option>
                       <option value="MALE">Male</option>
                       <option value="FEMALE">Female</option>
                     </select>-->
                  </div>
                </div>
                
                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
                	<div class="col-md-6 col-sm-6">
	                  	<select id="stdState" style="width:100%; font-weight: 0; font-size: 12px;">
	                       <option value="0">Select State</option>
	                       <option value="MALE">River State</option>
	                       <option value="FEMALE">Lagos State</option>
                        </select>
                    </div>
                  	<div class="col-md-6 col-sm-6">
                  		<select id="stdLga" style="width:100%; font-weight: 0; font-size: 12px;">
	                       <option value="0">Select LGA</option>
	                       <option value="MALE">Obor Akpor</option>
	                       <option value="FEMALE">Eleme</option>
                       </select>
                    </div>
                 </div>
                 
                 <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                 <!-- <div class="col-md-6 col-sm-6">
	                    <input class="form-control" id="reg_first_Name" name="reg_first_Name" placeholder="Primary Phone Number" type="text" required>
	                 </div>
	                 <div class="col-md-6 col-sm-6">
	                   <input class="form-control" id="reg_first_Name" name="reg_first_Name" placeholder="Secondary Phone Number" type="text" required>
	                 </div>-->
	                 
	                 <div class="col-md-4">
                       <input name="stdTeleCode" id="stdTeleCode" type="text" class="form-control" placeholder="+234">
                     </div>
                     <div class="col-md-8">
                       <input name="stdTeleNo" id="stdTeleNo" type="text" class="form-control" placeholder="Phone Number">
                     </div>
                 </div>
                 
                 <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
                	<div class="col-md-6 col-sm-6">
	                  	<select id="stdFaculty" style="width:100%; font-weight: 0; font-size:12px;">
	                       <option value="0">Select Faculty</option>
	                       <c:if test="${facultyList.success }">
		                      	<c:forEach items="${facultyList.object }" var="faculty">
		                      	 	<option value="${faculty.facultyId }">${faculty.name }</option>
		                      	</c:forEach>
		                      </c:if>
		                      <c:if test="${not facultyList.success }">
		                      	<option value="0">${facultyList.error }</option>
		                      </c:if>
                        </select>
                    </div>
                  	<div class="col-md-6 col-sm-6">
                  		<select id="stdDepartment" style="width:100%; font-weight: 0; font-size: 12px;">
	                       <option value="0">Select Faculty</option>
                       </select>
                    </div>
                 </div>
                 
                 <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                 <div class="col-md-12">
	                  	<div class="col-md-6">
		                    <div class="radio">
		                      <input id="male" type="radio" name="stdGender" value="male">
		                      <label for="male">Male</label>
		                      <input id="female" type="radio" name="stdGender" value="female">
		                      <label for="female">Female</label>
		                    </div>
		                  </div>
	                  </div>
                  </div>
                
                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
                  <div class="col-md-12">
                  	<textarea id="stdAddress" placeholder="Enter Street Address ..." class="form-control" rows="10"></textarea>
                  </div>
                  <div class="col-md-12">
                  	<input type="file" name="std_upload_photo" />
                  </div>
                  <div class="col-md-1 col-sm-1">
                  	<button type="button" id="stdRegister" class="btn btn-default btn-cons">Register</button>
                  </div>
                </div>
              		</div>
              	</div>
              </form>
            </div>
            <div role="tabpanel" class="tab-pane" id="tab_register_staff">
              <form class="animated fadeIn validate" id="" name="staff">
              
              	<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
              		
              		<div class="col-md-2 col-sm-2">
              			<div class="col-md-12">
	              			<a href="#loc_photo" ></a><div id="staff_preview_photo" class="centered" ><img src="<c:url value="/resources/assets/img/person-icon.png" /> " class="img-circle" width="60"></div>
	              		</div>
              		</div>
              		<div class="col-md-10 col-sm-10">
              			
              			<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
		                  <div class="col-md-12">
		                  	<div class="alert alert-error" style="display: none;">
		                      
		                      <span class="staffErrorMsg"></span>
		                    </div>
		                  </div>
	                  </div>
           			<div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                  <div class="col-md-6 col-sm-6">
	                    <input class="form-control" id="staffFirstName" name="staffFirstName" placeholder="First Name" type="text" required>
	                  </div>
	                  <div class="col-md-6 col-sm-6">
	                    <input class="form-control" id="staffFirstName" name="staffOtherNames" placeholder="Other Names" type="text" required>
	                  </div>
	                </div>
                
                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
                  <div class="col-md-12">
                    <input class="form-control" id="reg_email" name="staffEmail" placeholder="Email" type="email" required>
                  </div>
                </div>
                
                
                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
                	<div class="col-md-6 col-sm-6">
					<div class="input-append success date col-md-10 col-lg-10 no-padding">
					  <input type="text" placeholder="Date of Birth" name="staffDob" class="form-control">
					  <span class="add-on" style="background-color: #BBB;"><span></span><i class="fa fa-th"></i></span>
					</div>
                  </div>
                  <div class="col-md-6 col-sm-6">
                  	<select id="staffRole" style="width:100%; font-weight: 0; font-size:12px;">
                       <option value="0">Select Role</option>
                       <option value="MALE">Teaching Staff</option>
                       <option value="FEMALE">Vice Principal</option>
                     </select>
                  </div>
                </div>
                
                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
                	<div class="col-md-6 col-sm-6">
	                  	<select id="staffState" style="width:100%; font-weight: 0; font-size:12px;">
	                       <option value="0">Select State</option>
	                       <option value="MALE">River State</option>
	                       <option value="FEMALE">Lagos State</option>
                        </select>
                    </div>
                  	<div class="col-md-6 col-sm-6">
                  		<select id="staffLga" style="width:100%; font-weight: 0; font-size:12px;">
	                       <option value="0">Select LGA</option>
	                       <option value="MALE">Obor Akpor</option>
	                       <option value="FEMALE">Eleme</option>
                       </select>
                    </div>
                 </div>
                 
                 <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                 <!-- <div class="col-md-6 col-sm-6">
	                    <input class="form-control" id="reg_first_Name" name="reg_first_Name" placeholder="Primary Phone Number" type="text" required>
	                 </div>
	                 <div class="col-md-6 col-sm-6">
	                   <input class="form-control" id="reg_first_Name" name="reg_first_Name" placeholder="Secondary Phone Number" type="text" required>
	                 </div>-->
	                 
	                 <div class="col-md-4">
                       <input name="staffTeleCode" id="staffTeleCode" type="text" class="form-control" placeholder="+234">
                     </div>
                     <div class="col-md-8">
                       <input name="staffTeleNo" id="staffTeleNo" type="text" class="form-control" placeholder="Phone Number">
                     </div>
                 </div>
                 
                 <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
                	<div class="col-md-6 col-sm-6">
	                  	<select id="staffFaculty" style="width:100%; font-weight: 0; font-size:12px;">
	                       <option value="0">Select Faculty</option>
	                       <option value="MALE">River State</option>
	                       <option value="FEMALE">Lagos State</option>
                        </select>
                    </div>
                  	<div class="col-md-6 col-sm-6">
                  		<select id="staffDepartment" style="width:100%; font-weight: 0; font-size: 12px;">
	                       <option value="0">Select Department</option>
	                       <option value="MALE">Obor Akpor</option>
	                       <option value="FEMALE">Eleme</option>
                       </select>
                    </div>
                 </div>
                 
                 <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
	                 <div class="col-md-12">
	                  	<div class="col-md-6">
		                    <div class="radio">
		                      <input id="staffMale" type="radio" name="staffGender" value="male">
		                      <label for="staffMale">Male</label>
		                      <input id="staffFemale" type="radio" name="staffGender" value="female">
		                      <label for="staffFemale">Female</label>
		                    </div>
		                  </div>
	                  </div>
                  </div>
                
                <div class="row form-row m-l-20 m-r-20 xs-m-l-10 xs-m-r-10">
                  <div class="col-md-12">
                  	<textarea id="staffAddress" placeholder="Enter Street Address ..." class="form-control" rows="10"></textarea>
                  </div>
                  <div class="col-md-12">
                  	<input type="file" name="staff_upload_photo" />
                  </div>
                  <div class="col-md-1 col-sm-1">
                  	<button type="button" id="staffRegister" class="btn btn-default btn-cons">Register</button>
                  </div>
                </div>
              		</div>
              	</div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    
    <!-- END CONTAINER -->     
    
    <!-- END CONTAINER -->
    <script src="<c:url value="/resources/resources/assets/plugins/pace/pace.min.js" /> " type="text/javascript"></script>
    <!-- BEGIN JS DEPENDECENCIES-->
    <script src="<c:url value="/resources/assets/plugins/jquery/jquery-3.1.1.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/bootstrapv3/js/bootstrap.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-block-ui/jqueryblockui.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-unveil/jquery.unveil.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-numberAnimate/jquery.animateNumbers.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/jquery-validation/js/jquery.validate.min.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/bootstrap-select2/select2.min.js" /> " type="text/javascript"></script>
    <!-- END CORE JS DEPENDECENCIES-->
    <!-- BEGIN CORE TEMPLATE JS -->
    <script src="<c:url value="/resources/webarch/js/webarch.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/js/chat.js" /> " type="text/javascript"></script>
    <!-- END CORE TEMPLATE JS -->
    
    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <script src="<c:url value="/resources/assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js" /> " type="text/javascript"></script>
    <script src="<c:url value="/resources/assets/plugins/ios-switch/ios7-switch.js" /> " type="text/javascript"></script>
    <!-- END PAGE LEVEL PLUGINS -->
    <!-- BEGIN PAGE LEVEL SCRIPTS -->
    <script src="<c:url value="/resources/assets/js/form_elements.js" /> " type="text/javascript"></script>
    <!-- END PAGE LEVEL SCRIPTS -->
    <!-- END JAVASCRIPTS -->
    
    <!-- BEGIN PAGE SPECIFIC SCRIPTS -->
   	<script type="text/javascript" src="<c:url value="/resources/src/js/common/imagepreview.js" />"></script>
   	<script type="text/javascript" src="<c:url value="/resources/src/js/common/utils.js" />"></script>
   	<script type="text/javascript" src="<c:url value="/resources/src/js/frontend/account/studentRegistration.js" />"></script>
   	<script type="text/javascript" src="<c:url value="/resources/src/js/frontend/account/staffRegistration.js" />"></script>
   	<script type="text/javascript" src="<c:url value="/resources/src/js/frontend/account/login.js" />"></script>
    <!-- END PAGE SPECIFIC SCRIPTS -->
    
    
  </body>
</html>