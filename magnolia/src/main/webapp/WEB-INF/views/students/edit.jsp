<%-- 
    Document   : edit student I
    Created on : Apr 18, 2017
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

<!-- BEGIN CONTAINER -->
<div align="left" class="page-container row">
      <a href="#" class="scrollup ">Scroll</a>
      <!-- END SIDEBAR -->
      <!-- BEGIN PAGE CONTAINER-->
      <div align="left">
        <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
        <div id="portlet-config" class="modal hide">
          <div class="modal-header">
            <button data-dismiss="modal" class="close" type="button"></button>
            <h3>Widget Settings</h3>
          </div>
          <div class="modal-body"> Widget settings form goes here </div>
        </div>
        <div class="clearfix"></div>
        <div align="left" class="content">
          <div class="row">
            <div class="col-md-6">
              <div class=" tiles white col-md-12 no-padding">
                <div class="tiles green cover-pic-wrapper">
                  <div class="overlayer bottom-right">
                    <div class="overlayer-wrapper">
                      <div class="padding-10 hidden-xs">
                      	<c:if test="${not empty students}">
                      		<c:forEach items="${students}" var="student">
                      			<spring:url value="/students/edit/student/${student.id}/" var="editStudent" />
								<c:if test="${student.user.username == pageContext.request.userPrincipal.name}">
									<c:if test="${student.status == 'pending'}">
										<p><b>Student Profile Still Under Review</b></p>
									</c:if>
									<c:if test="${student.status == 'active'}">
										<a href="${editStudent}"><button type="button" class="btn btn-danger btn-small" type="submit" formmethod="get" formaction="${editStudent}"><i class="fa fa-edit"></i>&nbsp;&nbsp;<spring:message code="users.systemUsers.button.edit" /></button></a>
									</c:if>
		                        </c:if>
	                        </c:forEach>
                        </c:if>
                      </div>
                    </div>
                  </div>
                  <img src="<c:url value="/resources/assets/img/cover_pic.png" /> " alt="">
                </div>
                <div class="tiles white">
                  <div class="row">
                    <div class="col-md-3 col-sm-3">
                      <div class="user-profile-pic">
                        <img width="69" height="69" data-src-retina="<c:url value="/resources/assets/img/mg/${pageContext.request.userPrincipal.name}.png" /> " data-src="<c:url value="/resources/assets/img/mg/${pageContext.request.userPrincipal.name}.png" /> " src="<c:url value="/resources/assets/img/mg/${pageContext.request.userPrincipal.name}.png" /> " alt="">
                      </div>
                      <div class="user-mini-description">
                      	<c:if test="${not empty students}">
                      		<c:forEach items="${students}" var="student">
                      			<c:if test="${student.user.username == pageContext.request.userPrincipal.name}">
			                        <h3 class="text-success semi-bold">
												${student.user.daysActive}
												</h3>
			                        <h5>Days Active</h5>
			                        <h3 class="text-success semi-bold">
												457
												</h3>
			                        <h5>Courses Completed</h5>
			                    </c:if>
	                        </c:forEach>
                        </c:if>
                      </div>
                    </div>
                    <c:if test="${not empty students}">
	                    <div class="col-md-8 user-description-box  col-sm-8">
	                    	<c:forEach items="${students}" var="student">
	                    		<c:if test="${student.user.username == pageContext.request.userPrincipal.name}">
			                      <h4 class="semi-bold no-margin">${student.user.firstName} ${student.user.lastName}</h4>
			                      <h6 class="no-margin">${student.studentId}</h6>
			                      <br>
			                      <p><i class="fa fa-building-o"></i>${student.studentDepartment.name}</p>
			                      <p><i class="fa fa-film"></i>${student.studyProgramme.name}</p>
			                      <p><i class="fa fa-home"></i>${student.lodging}</p>
			                      <p><i class="fa fa-clock-o"></i>${currentTime}</p>
		                      	</c:if>
	                      </c:forEach>
	                    </div>
                    </c:if>
                  </div>
                  <div class="tiles-body">
                    <div class="row">
                      <div class="post col-md-12">
                        <div class="user-profile-pic-wrapper">
                          <div class="user-profile-pic-normal">
                            <img width="35" height="35" data-src-retina="assets/img/profiles/c2x.jpg" data-src="assets/img/profiles/c.jpg" src="assets/img/profiles/c.jpg" alt="">
                          </div>
                        </div>
                        <div class="info-wrapper">
                          <div class="username">
                            <span class="dark-text">John Drake</span> in <span class="dark-text">nervada hotspot</span>
                          </div>
                          <div class="info">
                            Great design concepts by <span class="dark-text">John Smith</span> and his crew! Totally owned the WCG!, Best of luck for your future endeavours, Special thanks for <span class="dark-text">Jane smith</span> for her motivation ;)
                          </div>
                          <div class="more-details">
                            <ul class="post-links">
                              <li><a href="#" class="muted">2 Minutes ago</a></li>
                              <li><a href="#" class="text-info">Collapse</a></li>
                              <li><a href="#" class="text-info"><i class="fa fa-reply"></i> Reply</a></li>
                              <li><a href="#" class="text-warning"><i class="fa fa-star"></i> Favourited</a></li>
                              <li><a href="#" class="muted">More</a></li>
                            </ul>
                          </div>
                          <div class="clearfix"></div>
                          <ul class="action-bar">
                            <li><a href="#" class="muted"><i class="fa fa-comment"></i> 1584</a> Comments</li>
                            <li><a href="#" class="text-error"><i class="fa fa-heart"></i> 47k</a> likes</li>
                          </ul>
                          <div class="clearfix"></div>
                          <div class="post comments-section">
                            <div class="user-profile-pic-wrapper">
                              <div class="user-profile-pic-normal">
                                <img width="35" height="35" alt="" src="assets/img/profiles/e.jpg" data-src="assets/img/profiles/e.jpg" data-src-retina="assets/img/profiles/e2x.jpg">
                              </div>
                            </div>
                            <div class="info-wrapper">
                              <div class="username">
                                <span class="dark-text">Thunderbolt</span>
                              </div>
                              <div class="info">
                                Congrats, <span class="dark-text">John Smith</span> & <span class="dark-text">Jane Smith</span>
                              </div>
                              <div class="more-details">
                                <ul class="post-links">
                                  <li><a href="#" class="muted">2 Minutes ago</a></li>
                                  <li><a href="#" class="text-error"><i class="fa fa-heart"></i> Like</a></li>
                                  <li><a href="#" class="muted">Details</a></li>
                                </ul>
                              </div>
                            </div>
                            <div class="clearfix"></div>
                          </div>
                          <div class="post comments-section">
                            <div class="user-profile-pic-wrapper">
                              <div class="user-profile-pic-normal">
                                <img width="35" height="35" src="assets/img/profiles/h.jpg" data-src="assets/img/profiles/h.jpg" data-src-retina="assets/img/profiles/h2x.jpg" alt="">
                              </div>
                            </div>
                            <div class="info-wrapper">
                              <div class="username">
                                <span class="dark-text">Thunderbolt</span>
                              </div>
                              <div class="info">
                                Congrats, <span class="dark-text">John Smith</span> & <span class="dark-text">Jane Smith</span>
                              </div>
                              <div class="more-details">
                                <ul class="post-links">
                                  <li><a href="#" class="muted">2 Minutes ago</a></li>
                                  <li><a href="#" class="text-error"><i class="fa fa-heart"></i> Like</a></li>
                                  <li><a href="#" class="muted">Details</a></li>
                                </ul>
                              </div>
                            </div>
                            <div class="clearfix"></div>
                          </div>
                        </div>
                        <div class="clearfix"></div>
                        <br>
                        <br>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="row">
                <div class="tiles white col-md-12  no-padding">
                  <div class="tiles-body">
                    <h5><span class="semi-bold">You many also know</span>&nbsp;&nbsp; <a href="#" class="text-info normal-text">view more</a></h5>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="friend-list">
                          <div class="friend-profile-pic">
                            <div class="user-profile-pic-normal">
                              <img width="35" height="35" src="assets/img/profiles/d.jpg" data-src="assets/img/profiles/d.jpg" data-src-retina="assets/img/profiles/d2x.jpg" alt="">
                            </div>
                          </div>
                          <div class="friend-details-wrapper">
                            <div class="friend-name">
                              Johne Drake
                            </div>
                            <div class="friend-description">
                              James Smith in commman
                            </div>
                          </div>
                          <div class="action-bar pull-right">
                            <button class="btn btn-primary" type="button">Add</button>
                          </div>
                          <div class="clearfix"></div>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="friend-list">
                          <div class="friend-profile-pic">
                            <div class="user-profile-pic-normal">
                              <img width="35" height="35" src="assets/img/profiles/b.jpg" data-src="assets/img/profiles/b.jpg" data-src-retina="assets/img/profiles/b2x.jpg" alt="">
                            </div>
                          </div>
                          <div class="friend-details-wrapper">
                            <div class="friend-name">
                              Johne Drake
                            </div>
                            <div class="friend-description">
                              James Smith in commman
                            </div>
                          </div>
                          <div class="action-bar pull-right">
                            <button class="btn btn-primary" type="button">Add</button>
                          </div>
                          <div class="clearfix"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <br>
              <div class="row">
                <div class="col-md-12 no-padding">
                  <div class="tiles white">
                    <textarea rows="3" class="form-control user-status-box post-input" placeholder="Whats on your mind?"></textarea>
                  </div>
                  <div class="tiles grey padding-10">
                    <div class="pull-left">
                      <button class="btn btn-default btn-sm btn-small" type="button"><i class="fa fa-camera"></i></button>
                      <button class="btn btn-default btn-sm btn-small" type="button"><i class="fa fa-map-marker"></i></button>
                    </div>
                    <div class="pull-right">
                      <button class="btn btn-primary btn-sm btn-small" type="button">POST</button>
                    </div>
                    <div class="clearfix"></div>
                  </div>
                </div>
              </div>
              <br>
              <br>
              <div class="row">
                <div class="post col-md-12">
                  <div class="user-profile-pic-wrapper">
                    <div class="user-profile-pic-normal">
                      <img width="35" height="35" src="assets/img/profiles/c.jpg" data-src="assets/img/profiles/c.jpg" data-src-retina="assets/img/profiles/c2x.jpg" alt="">
                    </div>
                  </div>
                  <div class="info-wrapper">
                    <div class="username">
                      <span class="dark-text">John Drake</span> in <span class="dark-text">nervada hotspot</span>
                    </div>
                    <div class="info">
                      Great design concepts by <span class="dark-text">John Smith</span> and his crew! Totally owned the WCG!, Best of luck for your future endeavours, Special thanks for <span class="dark-text">Jane smith</span> for her motivation ;)
                    </div>
                    <div class="more-details">
                      <ul class="post-links">
                        <li><a href="#" class="muted">2 Minutes ago</a></li>
                        <li><a href="#" class="text-info">Collapse</a></li>
                        <li><a href="#" class="text-info"><i class="fa fa-reply"></i> Reply</a></li>
                        <li><a href="#" class="text-warning"><i class="fa fa-star"></i> Favourited</a></li>
                        <li><a href="#" class="muted">More</a></li>
                      </ul>
                    </div>
                    <div class="clearfix"></div>
                    <ul class="action-bar">
                      <li><a href="#" class="muted"><i class="fa fa-comment"></i> 1584</a> Comments</li>
                      <li><a href="#" class="text-error"><i class="fa fa-heart"></i> 47k</a> likes</li>
                    </ul>
                    <div class="clearfix"></div>
                    <div class="post comments-section">
                      <div class="user-profile-pic-wrapper">
                        <div class="user-profile-pic-normal">
                          <img width="35" height="35" data-src-retina="assets/img/profiles/e2x.jpg" data-src="assets/img/profiles/e.jpg" src="assets/img/profiles/e.jpg" alt="">
                        </div>
                      </div>
                      <div class="info-wrapper">
                        <div class="username">
                          <span class="dark-text">Thunderbolt</span>
                        </div>
                        <div class="info">
                          Congrats, <span class="dark-text">John Smith</span> & <span class="dark-text">Jane Smith</span>
                        </div>
                        <div class="more-details">
                          <ul class="post-links">
                            <li><a href="#" class="muted">2 Minutes ago</a></li>
                            <li><a href="#" class="text-error"><i class="fa fa-heart"></i> Like</a></li>
                            <li><a href="#" class="muted">Details</a></li>
                          </ul>
                        </div>
                      </div>
                      <div class="clearfix"></div>
                    </div>
                    <div class="post comments-section">
                      <div class="user-profile-pic-wrapper">
                        <div class="user-profile-pic-normal">
                          <img width="35" height="35" data-src-retina="assets/img/profiles/b2x.jpg" data-src="assets/img/profiles/b.jpg" src="assets/img/profiles/b.jpg" alt="">
                        </div>
                      </div>
                      <div class="info-wrapper">
                        <div class="username">
                          <span class="dark-text">Thunderbolt</span>
                        </div>
                        <div class="info">
                          Congrats, <span class="dark-text">John Smith</span> & <span class="dark-text">Jane Smith</span>
                        </div>
                        <div class="more-details">
                          <ul class="post-links">
                            <li><a href="#" class="muted">2 Minutes ago</a></li>
                            <li><a href="#" class="text-error"><i class="fa fa-heart"></i> Like</a></li>
                            <li><a href="#" class="muted">Details</a></li>
                          </ul>
                        </div>
                      </div>
                      <div class="clearfix"></div>
                    </div>
                    <div class="post comments-section">
                    </div>
                  </div>
                  <div class="clearfix"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
</div>