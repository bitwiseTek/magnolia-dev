<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false" %>

<!-- BEGIN PAGE CONTAINER-->
      <div align="left" class="page-container row">
        <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
        <div id="portlet-config" class="modal hide">
          <div class="modal-header">
            <button data-dismiss="modal" class="close" type="button"></button>
            <h3>Widget Settings</h3>
          </div>
          <div class="modal-body"> Widget settings form goes here </div>
        </div>
        <div class="clearfix"></div>
        <div class="content sm-gutter">
          <div class="page-title">
          </div>
          <!-- BEGIN DASHBOARD TILES -->
          <div class="row">
            <div class="col-md-4 col-vlg-3 col-sm-6">
              <div class="tiles green m-b-10">
                <div class="tiles-body">
                  <div class="controller">
                    <a href="javascript:;" class="reload"></a>
                    <a href="javascript:;" class="remove"></a>
                  </div>
                  <div class="tiles-title text-black">OVERALL SALES </div>
                  <div class="widget-stats">
                    <div class="wrapper transparent">
                      <span class="item-title">Overall Visits</span> <span class="item-count animate-number semi-bold" data-value="2415" data-animation-duration="700">0</span>
                    </div>
                  </div>
                  <div class="widget-stats">
                    <div class="wrapper transparent">
                      <span class="item-title">Today's</span> <span class="item-count animate-number semi-bold" data-value="751" data-animation-duration="700">0</span>
                    </div>
                  </div>
                  <div class="widget-stats ">
                    <div class="wrapper last">
                      <span class="item-title">Monthly</span> <span class="item-count animate-number semi-bold" data-value="1547" data-animation-duration="700">0</span>
                    </div>
                  </div>
                  <div class="progress transparent progress-small no-radius m-t-20" style="width:90%">
                    <div class="progress-bar progress-bar-white animate-progress-bar" data-percentage="64.8%"></div>
                  </div>
                  <div class="description"> <span class="text-white mini-description ">4% higher <span class="blend">than last month</span></span>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-4 col-vlg-3 col-sm-6">
              <div class="tiles blue m-b-10">
                <div class="tiles-body">
                  <div class="controller">
                    <a href="javascript:;" class="reload"></a>
                    <a href="javascript:;" class="remove"></a>
                  </div>
                  <div class="tiles-title text-black">OVERALL VISITS </div>
                  <div class="widget-stats">
                    <div class="wrapper transparent">
                      <span class="item-title">Overall Visits</span> <span class="item-count animate-number semi-bold" data-value="15489" data- animation-duration="700">0</span>
                    </div>
                  </div>
                  <div class="widget-stats">
                    <div class="wrapper transparent">
                      <span class="item-title">Today's</span> <span class="item-count animate-number semi-bold" data-value="551" data-animation-duration="700">0</span>
                    </div>
                  </div>
                  <div class="widget-stats ">
                    <div class="wrapper last">
                      <span class="item-title">Monthly</span> <span class="item-count animate-number semi-bold" data-value="1450" data-animation-duration="700">0</span>
                    </div>
                  </div>
                  <div class="progress transparent progress-small no-radius m-t-20" style="width:90%">
                    <div class="progress-bar progress-bar-white animate-progress-bar" data-percentage="54%"></div>
                  </div>
                  <div class="description"> <span class="text-white mini-description ">4% higher <span class="blend">than last month</span></span>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-4 col-vlg-3 col-sm-6">
              <div class="tiles purple m-b-10">
                <div class="tiles-body">
                  <div class="controller">
                    <a href="javascript:;" class="reload"></a>
                    <a href="javascript:;" class="remove"></a>
                  </div>
                  <div class="tiles-title text-black">SERVER LOAD </div>
                  <div class="widget-stats">
                    <div class="wrapper transparent">
                      <span class="item-title">Overall Load</span> <span class="item-count animate-number semi-bold" data-value="5695" data-animation-duration="700">0</span>
                    </div>
                  </div>
                  <div class="widget-stats">
                    <div class="wrapper transparent">
                      <span class="item-title">Today's</span> <span class="item-count animate-number semi-bold" data-value="568" data-animation-duration="700">0</span>
                    </div>
                  </div>
                  <div class="widget-stats ">
                    <div class="wrapper last">
                      <span class="item-title">Monthly</span> <span class="item-count animate-number semi-bold" data-value="12459" data-animation-duration="700">0</span>
                    </div>
                  </div>
                  <div class="progress transparent progress-small no-radius m-t-20" style="width:90%">
                    <div class="progress-bar progress-bar-white animate-progress-bar" data-percentage="90%"></div>
                  </div>
                  <div class="description"> <span class="text-white mini-description ">4% higher <span class="blend">than last month</span></span>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-4 col-vlg-3 visible-xlg visible-sm col-sm-6">
              <div class="tiles red m-b-10">
                <div class="tiles-body">
                  <div class="controller">
                    <a href="javascript:;" class="reload"></a>
                    <a href="javascript:;" class="remove"></a>
                  </div>
                  <div class="tiles-title text-black">OVERALL SALES </div>
                  <div class="widget-stats">
                    <div class="wrapper transparent">
                      <span class="item-title">Overall Sales</span> <span class="item-count animate-number semi-bold" data-value="5669" data-animation-duration="700">0</span>
                    </div>
                  </div>
                  <div class="widget-stats">
                    <div class="wrapper transparent">
                      <span class="item-title">Today's</span> <span class="item-count animate-number semi-bold" data-value="751" data-animation-duration="700">0</span>
                    </div>
                  </div>
                  <div class="widget-stats ">
                    <div class="wrapper last">
                      <span class="item-title">Monthly</span> <span class="item-count animate-number semi-bold" data-value="1547" data-animation-duration="700">0</span>
                    </div>
                  </div>
                  <div class="progress transparent progress-small no-radius m-t-20" style="width:90%">
                    <div class="progress-bar progress-bar-white animate-progress-bar" data-percentage="64.8%"></div>
                  </div>
                  <div class="description"> <span class="text-white mini-description ">4% higher <span class="blend">than last month</span></span>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- END DASHBOARD TILES -->
          	<div>&nbsp;</div>
          	<div class="row">
            <div class="col-md-6 col-vlg-4">
              <!-- BEGIN WEATHER DETAIL VIEW WIDGET -->
              <div class="row">
                <div class="col-md-12">
                  <div class="tiles white m-b-10 clearfix">
                    <div class="col-md-7  col-sm-7 b-grey b-r ">
                      <h4 class="semi-bold text-center b-grey b-b no-margin p-t-20 p-b-10">Rivers, Nigeria</h4>
                      <div class="b-grey b-b">
                        <h4 class="semi-bold text-center text-error">${currentDay}</h4>
                        <h1 class="semi-bold text-center text-error">
                    32&deg;
                    </h1>
                        <h5 class="text-center text-error">partly cloudy</h5>
                        <div class="row auto m-t-10 m-b-10">
                          <div class="col-md-3 col-sm-3 col-xs-3  no-padding col-md-offset-2 col-sm-offset-2 col-xs-offset-2">
                            <canvas id="widget-2-cloudy-big" width="48" height="48" class="h-align-middle "></canvas>
                          </div>
                          <div class="col-md-5 col-sm-5 col-xs-5 no-padding">
                            <div class="m-t-10">
                              <div class="pull-left m-l-5">
                                <canvas id="white_widget_13" width="16" height="16" class="inline"></canvas>
                                <div class="inline">
                                  <h5 class="semi-bold no-margin ">54</h5>
                                  <p class="bold text-extra-small ">MPH</p>
                                </div>
                              </div>
                              <div class="pull-right m-r-10">
                                <canvas id="white_widget_14" width="16" height="16" class="inline"></canvas>
                                <div class="inline">
                                  <h5 class="semi-bold no-margin ">53</h5>
                                  <p class="bold text-extra-small ">MM</p>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="row auto m-t-15">
                        <div class="col-md-2 col-sm-2 col-xs-2 no-padding col-md-offset-1 col-xs-offset-1 b-grey b-r">
                          <p class="text-center no-margin">11:30</p>
                          <p class="text-center no-margin">PM</p>
                          <canvas id="white_widget_01" width="20" height="20" class="h-align-middle m-t-10"></canvas>
                          <h5 class="semi-bold text-center text-error">32&deg;</h5>
                        </div>
                        <div class="col-md-2 col-sm-2 col-xs-2 no-padding b-grey b-r">
                          <div class="text-center">11:30</div>
                          <div class="text-center">PM</div>
                          <canvas id="white_widget_02" width="20" height="20" class="h-align-middle m-t-10"></canvas>
                          <h5 class="semi-bold text-center text-error">32&deg;</h5>
                        </div>
                        <div class="col-md-2 col-sm-2 col-xs-2 no-padding b-grey b-r">
                          <div class="text-center">11:30</div>
                          <div class="text-center">PM</div>
                          <canvas id="white_widget_03" width="20" height="20" class="h-align-middle m-t-10"></canvas>
                          <h5 class="semi-bold text-center text-error">32&deg;</h5>
                        </div>
                        <div class="col-md-2 col-sm-2 col-xs-2 no-padding b-grey b-r">
                          <div class="text-center">11:30</div>
                          <div class="text-center">PM</div>
                          <canvas id="white_widget_04" width="20" height="20" class="h-align-middle m-t-10"></canvas>
                          <h5 class="semi-bold text-center text-error">32&deg;</h5>
                        </div>
                        <div class="col-md-2 col-sm-2 col-xs-2 no-padding b-grey">
                          <div class="text-center">11:30</div>
                          <div class="text-center">PM</div>
                          <canvas id="white_widget_05" width="20" height="20" class="h-align-middle m-t-10"></canvas>
                          <h5 class="semi-bold text-center text-error">32&deg;</h5>
                        </div>
                      </div>
                    </div>
                    <div class="col-md-5 col-sm-5 tiles grey">
                      <div class=" p-t-25 p-r-10 p-l-10 p-b-15">
                        <div class="p-b-10 m-b-10 b-grey b-b">
                          <div class="pull-left"> <span class="bold text-black m-r-15 text-right">Sun</span>
                            <canvas id="white_widget_06" width="20" height="20" class="inline m-l-10"></canvas>
                          </div>
                          <div class="pull-right"> <span class="semi-bold text-grey">32 - 28</span> <span class="bold text-error">C&deg; </span> </div>
                          <div class="clearfix"></div>
                        </div>
                        <div class="p-b-10 m-b-10 b-grey b-b">
                          <div class="pull-left"> <span class="bold  text-black m-r-15">Mon</span>
                            <canvas id="white_widget_07" width="20" height="20" class="inline m-l-10"></canvas>
                          </div>
                          <div class="pull-right"> <span class="semi-bold text-grey">32 - 28</span> <span class="bold text-error">C&deg; </span> </div>
                          <div class="clearfix"></div>
                        </div>
                        <div class="p-b-10 m-b-10 b-grey b-b">
                          <div class="pull-left"> <span class="bold  text-black m-r-15">Tue</span>
                            <canvas id="white_widget_08" width="20" height="20" class="inline m-l-10"></canvas>
                          </div>
                          <div class="pull-right"> <span class="semi-bold text-grey">32 - 28</span> <span class="bold text-error">C&deg; </span> </div>
                          <div class="clearfix"></div>
                        </div>
                        <div class="p-b-10 m-b-10 b-grey b-b">
                          <div class="pull-left"> <span class="bold  text-black m-r-5">Wed</span>
                            <canvas id="white_widget_09" width="20" height="20" class="inline m-l-10"></canvas>
                          </div>
                          <div class="pull-right"> <span class="semi-bold text-grey">32 - 28</span> <span class="bold text-error">C&deg; </span> </div>
                          <div class="clearfix"></div>
                        </div>
                        <div class="p-b-10 m-b-10 b-grey b-b">
                          <div class="pull-left"> <span class="bold  text-black m-r-5">Thur</span>
                            <canvas id="white_widget_10" width="20" height="20" class="inline m-l-10"></canvas>
                          </div>
                          <div class="pull-right"> <span class="semi-bold text-grey">32 - 28</span> <span class="bold text-error">C&deg; </span> </div>
                          <div class="clearfix"></div>
                        </div>
                        <div class="p-b-10 m-b-10 b-grey b-b">
                          <div class="pull-left"> <span class="bold  text-black m-r-15">Fri</span>
                            <canvas id="white_widget_11" width="20" height="20" class="inline m-l-10"></canvas>
                          </div>
                          <div class="pull-right"> <span class="semi-bold text-grey">32 - 28</span> <span class="bold text-error">C&deg; </span> </div>
                          <div class="clearfix"></div>
                        </div>
                        <div class="p-b-10 m-b-10 b-grey">
                          <div class="pull-left"> <span class="bold  text-black m-r-10">Sat</span>
                            <canvas id="white_widget_12" width="20" height="20" class="inline m-l-10"></canvas>
                          </div>
                          <div class="pull-right"> <span class="semi-bold text-grey">32 - 28</span> <span class="bold text-error">C&deg; </span> </div>
                          <div class="clearfix"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- END WEATHER DETAIL VIEW WIDGET -->
	       </div>
	       <!-- BEGIN REALTIME SALES GRAPH -->
            <div style="margin-left: 70px;" class="col-md-5 col-vlg-4 m-b-10 ">
              <div class="tiles white">
                <div class="row">
                  <div class="sales-graph-heading">
                    <div class="col-md-5 col-sm-5">
                      <h5 class="no-margin">You have earned</h5>
                      <h4><span class="item-count animate-number semi-bold" data-value="21451" data-animation-duration="700">0</span> USD</h4>
                    </div>
                    <div class="col-md-3 col-sm-3">
                      <p class="semi-bold">TODAY</p>
                      <h4><span class="item-count animate-number semi-bold" data-value="451" data-animation-duration="700">0</span> USD</h4>
                    </div>
                    <div class="col-md-4 col-sm-3">
                      <p class="semi-bold">THIS MONTH</p>
                      <h4><span class="item-count animate-number semi-bold" data-value="8514" data-animation-duration="700">0</span> USD</h4>
                    </div>
                    <div class="clearfix"></div>
                  </div>
                </div>
                <h5 class="semi-bold m-t-30 m-l-30">LAST SALE</h5>
                <table class="table no-more-tables m-t-20 m-l-20 m-b-30">
                  <thead style="display:none">
                    <tr>
                      <th style="width:9%">Project Name</th>
                      <th style="width:22%">Description</th>
                      <th style="width:6%">Price</th>
                      <th style="width:1%"> </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td class="v-align-middle bold text-success">25601</td>
                      <td class="v-align-middle"><span class="muted">Redesign project template</span> </td>
                      <td><span class="muted bold text-success">$4,500</span> </td>
                      <td class="v-align-middle"></td>
                    </tr>
                    <tr>
                      <td class="v-align-middle bold text-success">25601</td>
                      <td class="v-align-middle"><span class="muted">Redesign project template</span> </td>
                      <td><span class="muted bold text-success">$4,500</span> </td>
                      <td class="v-align-middle"></td>
                    </tr>
                  </tbody>
                </table>
                <div id="sales-graph"> </div>
              </div>
            </div>
            <!-- END REALTIME SALES GRAPH -->
	     </div>
	    </div>  
	   </div>
    <!-- END CONTAINER -->