<%-- 
    Document   : drafts
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

<!-- BEGIN PAGE -->
      <div align="left" class="page-container row">
        <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
        <div class="modal hide" id="portlet-config">
          <div class="modal-header">
            <button class="close" data-dismiss="modal" type="button"></button>
            <h3>
          Widget Settings
        </h3>
          </div>
          <div class="modal-body">
            Widget settings form goes here
          </div>
        </div>
        <div class="clearfix">
        </div>
        <div class="content">
          <div class="page-title" style="display:none">
            <a href="#" id="btn-back"><i class="icon-custom-left"></i></a>
            <h3>
          Back- <span class="semi-bold">Draft</span>
        </h3>
          </div>
          <div class="row" id="inbox-wrapper">
            <div class="col-md-12">
              <div class="row">
                <div class="col-md-12">
                  <div class="grid simple">
                    <div class="grid-body no-border email-body" style="min-height: 850px;">
                      <br>
                      <div class="row-fluid">
                        <div class="row-fluid dataTables_wrapper">
                          <h2 class=" inline">
                        Draft
                      </h2>
                          <div class="btn-group m-l-10 m-b-10">
                            <a class="btn btn-white btn-mini dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret single"></span></a>
                            <ul class="dropdown-menu">
                              <li>
                                <a href="#">Action</a>
                              </li>
                              <li>
                                <a href="#">Another action</a>
                              </li>
                              <li>
                                <a href="#">Something else here</a>
                              </li>
                              <li class="divider">
                              </li>
                              <li>
                                <a href="#">Separated link</a>
                              </li>
                            </ul>
                          </div>
                          <div class="pull-right margin-top-20">
                            <div class="dataTables_paginate paging_bootstrap pagination">
                              <ul>
                                <li class="prev disabled">
                                  <a href="#"><i class="fa fa-chevron-left"></i></a>
                                </li>
                                <li class="active">
                                  <a href="#">1</a>
                                </li>
                                <li>
                                  <a href="#">2</a>
                                </li>
                                <li class="next">
                                  <a href="#"><i class="fa fa-chevron-right"></i></a>
                                </li>
                              </ul>
                            </div>
                            <div class="dataTables_info hidden-phone" id="example_info">
                              Showing <b>1 to 10</b> of 14 entries
                            </div>
                          </div>
                          <div class="clearfix">
                          </div>
                        </div>
                        <div id="email-list">
                          <table class="table table-striped table-fixed-layout table-hover" id="emails">
                            <thead>
                              <tr>
                                <th class="small-cell">
                                </th>
                                <th class="small-cell">
                                </th>
                                <th class="medium-cell">
                                </th>
                                <th>
                                </th>
                                <th class="medium-cell">
                                </th>
                              </tr>
                            </thead>
                            <tbody>
                              <tr>
                                <td class="small-cell v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox8" type="checkbox" value="1">
                                    <label for="checkbox8"></label>
                                  </div>
                                </td>
                                <td class="small-cell v-align-middle">
                                  <div class="star">
                                    <input checked id="checkbox9" type="checkbox" value="1">
                                    <label for="checkbox9"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  David Nester
                                </td>
                                <td class="clickable tablefull v-align-middle">
                                  <span class="muted">Less spam, and mobile access. Gmail is email that's intuitive, ...efficient, and useful. And maybe even
                              fun.</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="small-cell v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox10" type="checkbox" value="1">
                                    <label for="checkbox10"></label>
                                  </div>
                                </td>
                                <td class="small-cell v-align-middle">
                                  <div class="star">
                                    <input id="checkbox11" type="checkbox" value="1">
                                    <label for="checkbox11"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  Jane Smith
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="label label-important">HOME</span>&nbsp;<span class="muted">Open the door to success, maximum revanue efficient, and
                              useful</span>
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox12" type="checkbox" value="1">
                                    <label for="checkbox12"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input id="checkbox13" type="checkbox" value="1">
                                    <label for="checkbox13"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  David Nester
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted">Less spam, and mobile access. Gmail is email that's intuitive, ...efficient, and useful. And maybe even
                              fun.</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox14" type="checkbox" value="1">
                                    <label for="checkbox14"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input checked id="checkbox15" type="checkbox" value="1">
                                    <label for="checkbox15"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  David Nester
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted"><span class="label label-success">WORK</span>&nbsp;Less spam, and mobile access. Gmail is email that's intuitive, ...efficient, and useful. And maybe even fun.</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox16" type="checkbox" value="1">
                                    <label for="checkbox16"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input checked id="checkbox17" type="checkbox" value="1">
                                    <label for="checkbox17"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  Jane Smith
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted">Open the door to success, maximum revanue efficient, and useful</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox18" type="checkbox" value="1">
                                    <label for="checkbox18"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input id="checkbox19" type="checkbox" value="1">
                                    <label for="checkbox19"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  David Nester
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted">Less spam, and mobile access. Gmail is email that's intuitive, ...efficient, and useful. And maybe even
                              fun.</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox20" type="checkbox" value="1">
                                    <label for="checkbox20"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input id="checkbox51" type="checkbox" value="1">
                                    <label for="checkbox51"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  Jane Smith
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted">Open the door to success, maximum revanue efficient, and useful</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox22" type="checkbox" value="1">
                                    <label for="checkbox22"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input id="checkbox23" type="checkbox" value="1">
                                    <label for="checkbox23"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  David Nester
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted">Less spam, and mobile access. Gmail is email that's intuitive, ...efficient, and useful. And maybe even
                              fun.</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox25" type="checkbox" value="1">
                                    <label for="checkbox25"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input id="checkbox26" type="checkbox" value="1">
                                    <label for="checkbox26"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  Jane Smith
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted">Open the door to success, maximum revanue efficient, and useful</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox27" type="checkbox" value="1">
                                    <label for="checkbox27"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input id="checkbox28" type="checkbox" value="1">
                                    <label for="checkbox28"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  David Nester
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted"><span class="label label-success">WORK</span>&nbsp;Less spam, and mobile access. Gmail is email that's intuitive, ...efficient, and useful. And maybe even fun.</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox29" type="checkbox" value="1">
                                    <label for="checkbox29"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input id="checkbox30" type="checkbox" value="1">
                                    <label for="checkbox30"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  Jane Smith
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted">Open the door to success, maximum revanue efficient, and useful</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox52" type="checkbox" value="1">
                                    <label for="checkbox52"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input checked id="checkbox53" type="checkbox" value="1">
                                    <label for="checkbox53"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  David Nester
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted">Less spam, and mobile access. Gmail is email that's intuitive, ...efficient, and useful. And maybe even
                              fun.</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox54" type="checkbox" value="1">
                                    <label for="checkbox54"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input id="checkbox55" type="checkbox" value="1">
                                    <label for="checkbox55"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  Jane Smith
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="label label-important">HOME</span>&nbsp;<span class="muted">Open the door to success, maximum revanue efficient, and
                              useful</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox56" type="checkbox" value="1">
                                    <label for="checkbox56"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input id="checkbox57" type="checkbox" value="1">
                                    <label for="checkbox57"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  David Nester
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted">Less spam, and mobile access. Gmail is email that's intuitive, ...efficient, and useful. And maybe even
                              fun.</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox58" type="checkbox" value="1">
                                    <label for="checkbox58"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input checked id="checkbox59" type="checkbox" value="1">
                                    <label for="checkbox59"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  David Nester
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted"><span class="label label-success">WORK</span>&nbsp;Less spam, and mobile access. Gmail is email that's intuitive, ...efficient, and useful. And maybe even fun.</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox61" type="checkbox" value="1">
                                    <label for="checkbox61"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input checked id="checkbox80" type="checkbox" value="1">
                                    <label for="checkbox80"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  Jane Smith
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted">Open the door to success, maximum revanue efficient, and useful</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox62" type="checkbox" value="1">
                                    <label for="checkbox62"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input id="checkbox63" type="checkbox" value="1">
                                    <label for="checkbox63"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  David Nester
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted">Less spam, and mobile access. Gmail is email that's intuitive, ...efficient, and useful. And maybe even
                              fun.</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox64" type="checkbox" value="1">
                                    <label for="checkbox64"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input id="checkbox65" type="checkbox" value="1">
                                    <label for="checkbox65"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  Jane Smith
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted">Open the door to success, maximum revanue efficient, and useful</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox66" type="checkbox" value="1">
                                    <label for="checkbox66"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input id="checkbox67" type="checkbox" value="1">
                                    <label for="checkbox67"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  David Nester
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted">Less spam, and mobile access. Gmail is email that's intuitive, ...efficient, and useful. And maybe even
                              fun.</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox68" type="checkbox" value="1">
                                    <label for="checkbox68"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input id="checkbox69" type="checkbox" value="1">
                                    <label for="checkbox69"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  Jane Smith
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted">Open the door to success, maximum revanue efficient, and useful</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox70" type="checkbox" value="1">
                                    <label for="checkbox70"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input id="checkbox71" type="checkbox" value="1">
                                    <label for="checkbox71"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  David Nester
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted"><span class="label label-success">WORK</span>&nbsp;Less spam, and mobile access. Gmail is email that's intuitive, ...efficient, and useful. And maybe even fun.</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                              <tr>
                                <td class="v-align-middle">
                                  <div class="checkbox check-success">
                                    <input id="checkbox72" type="checkbox" value="1">
                                    <label for="checkbox72"></label>
                                  </div>
                                </td>
                                <td class="v-align-middle">
                                  <div class="star">
                                    <input id="checkbox73" type="checkbox" value="1">
                                    <label for="checkbox73"></label>
                                  </div>
                                </td>
                                <td class="clickable v-align-middle">
                                  Jane Smith
                                </td>
                                <td class="clickable v-align-middle">
                                  <span class="muted">Open the door to success, maximum revanue efficient, and useful</span>
                                </td>
                                <td class="clickable">
                                  <span class="muted">Yesterday</span>
                                </td>
                              </tr>
                            </tbody>
                          </table>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12" id="preview-email-wrapper" style="display:none">
              <div class="row">
                <div class="col-md-12">
                  <div class="grid simple">
                    <div class="grid-title no-border">
                      <h4>
                  </h4>
                      <div class="tools">
                        <a class="remove" href="javascript:;"></a>
                      </div>
                    </div>
                    <div class="grid-body no-border" style="min-height: 850px;">
                      <div class="">
                        <h1 id="emailheading">
                      Meeting
                    </h1>
                        <br>
                        <div class="control">
                          <div class="pull-left">
                            <div class="btn-group">
                              <a class="btn btn-mini dropdown-toggle" data-toggle="dropdown" href="#">David Nester <span class="caret"></span></a>
                              <ul class="dropdown-menu">
                                <li>
                                  <a href="#">Action</a>
                                </li>
                                <li>
                                  <a href="#">Another action</a>
                                </li>
                                <li>
                                  <a href="#">Something else here</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                  <a href="#">Separated link</a>
                                </li>
                              </ul>
                            </div>
                            <label class="inline"><span class="muted">&nbsp;&nbsp;to</span> <span class="bold small-text">johnsmith@skyace.com</span></label>
                          </div>
                          <div class="pull-right">
                            <span class="muted small-text">August 5 2013 11.30PM</span>
                          </div>
                          <div class="clearfix">
                          </div>
                        </div>
                        <br>
                        <div class="email-body">
                          <p>
                            Thank you for taking the time to meet with me and other representatives of the last week regarding the challenges facing public transportation, especially. We enjoyed meeting with you and . I’m glad we had the opportunity to discuss an issue that affects so many people in [city/state/community]. We especially appreciate your commitment to [describe any commitment made by the official]. The [coalition name] believes that public transportation is vital to quality of life of our community. As we discussed … Our coalition would greatly appreciate your support in ensuring that public transportation is widely available to all who need it – especially the people living in . On behalf of all our members and the thousands of citizens they represent, I want to thank you for taking the time out of your busy schedule to discuss this important matter.
                          </p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="clearfix">
          </div>
        </div>
        <div class="clearfix">
        </div>
        <div class="admin-bar" id="quick-access" style="display:">
          <div class="admin-bar-inner">
            <button class="btn btn-danger btn-add" type="button"><i class="icon-trash"></i> Move to trash</button>
            <button class="btn btn-white btn-cancel" type="button">Cancel</button>
          </div>
        </div>
        <!-- END PAGE -->
      </div>