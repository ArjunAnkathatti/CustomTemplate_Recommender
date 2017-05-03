<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.geni.beans.ScalingRule"%>
<%@ page import="java.util.List" %>

<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, shrink-to-fit=no, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Simple Sidebar - Start Bootstrap Template</title>


<!-- Custom CSS -->
<link href="<%=request.getContextPath()%>/css/sidebar.css"
	rel="stylesheet">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
html, body {
	height: 100%
}
</style>
</head>

<body>
	<div id="holder">
		<!-- header-section-starts -->
		<div class="header">
			<div class="container">
				<div class="logo">
					<a href="index.jsp"><img width="110px" height="63px"
						src="<%=request.getContextPath()%>/images/logo.png"
						class="img-responsive" alt="" /></a>
				</div>
				<div class="header-right">
					<h4></h4>
					<span class="menu"></span>
					<div class="top-menu">
						<ul>
							<li><a href="/CustomTemplateDocker/index.html">Home</a></li>
							<li><a href="/CustomTemplateDocker/404.html">Products</a></li>
							<li><a href="/CustomTemplateDocker/about.hmtl">About Us</a></li>
							<li><a href="/CustomTemplateDocker/services.html">Services</a></li>
							<li><a href="/CustomTemplateDocker/login.jsp">Account</a></li>
							<li><a class="active" href="#">ApplicationInfo</a></li>
						</ul>
					</div>
					<!-- script for menu -->
					<script>
						$("span.menu").click(function() {
							$(".top-menu").slideToggle("slow", function() {
								// Animation complete.
							});
						});
					</script>
					<!-- script for menu -->
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<!-- header section ends here -->
		<div id="wrapper" class="toggled">
			<!-- Sidebar -->
			<div id="sidebar-wrapper">
				<ul class="sidebar-nav">
					<li><a
						href="/CustomTemplateDocker/Account/Instances/index.jsp">Running
							Instances </a></li>
					<li><a
						href="/CustomTemplateDocker/Account/Monitoring/index.jsp">Monitoring</a></li>
					<li class="sidebar-brand"><a
						href="/CustomTemplateDocker/getScalingReq">Auto
							Scaling</a></li>
					<li><a
						href="/CustomTemplateDocker/Account/Recommendation/index.jsp">Recommendations</a></li>
				</ul>
			</div>
			<!-- /#sidebar-wrapper -->

			<!-- Page Content -->
			<div id="page-content-wrapper">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-12">
							<div class="panel-group">
								<div class="panel panel-primary">
									<div class="panel-heading">Scaling Rules</div>
									<div class="panel-body">
										<button type="button" class="btn btn-primary"
											data-toggle="modal" data-target="#addScalingRule">
											<span class="glyphicon glyphicon-plus"></span> Add
										</button>
										<!--  <a class="btn btn-success" href="/CustomTemplateDocker/launchNewEC2Instance.action" >Launch VM</a> -->
										<!-- Modal -->
										<div id="addScalingRule" class="modal fade" role="dialog">
											<div class="modal-dialog">

												<!-- Modal content-->
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal">&times;</button>
														<h4 class="modal-title">New Scaling Rule</h4>
													</div>
													<div class="modal-body">
														<div class="form-horizontal">
															<s:form action="setScalingReq" method="post"
																namespace="/">
																<div class="form-group">
																	<lable for="policyName" class="control-lable col-sm-4">Rule
																	Name</lable>
																	<div class="col-sm-8">
																		<s:textfield class="form-control" name="policyName"
																			key="policyName"></s:textfield>
																	</div>
																</div>
																<div class="form-group">
																	<lable for="scalingAction"
																		class="control-lable col-sm-4">Action</lable>
																	<div class="col-sm-8">
																		<s:select class="form-control" name="scalingAction"
																			key="scalingAction" list="actionList"></s:select>
																	</div>
																</div>
																<div class="form-group">
																	<lable for="scalingAdjustment"
																		class="control-lable col-sm-4">No. of
																	instances</lable>
																	<div class="col-sm-8">
																		<s:select list="noOfInstancesList"
																			class="form-control" name="scalingAdjustment"
																			key="scalingAdjustment"></s:select>
																	</div>
																</div>
																<div class="form-group">
																	<lable for="metricType" class="control-lable col-sm-4">Metric
																	Type</lable>
																	<div class="col-sm-8">
																		<s:select list="metricTypeList" class="form-control"
																			name="metricType" key="metricType"></s:select>
																	</div>
																</div>
																<div class="form-group">
																	<lable for="comparisionOperator"
																		class="control-lable col-sm-4">Condition</lable>
																	<div class="col-sm-8">
																		<s:select list="conditionList" class="form-control"
																			name="comparisionOperator" key="comparisionOperator"></s:select>
																	</div>
																</div>
																<div class="form-group">
																	<lable for="threshold" class="control-lable col-sm-4">Threshold</lable>
																	<div class="col-sm-8">
																		<s:textfield class="form-control" name="threshold"
																			key="threshold"></s:textfield>
																	</div>
																</div>
																<div class="form-group">
																	<div class="col-sm-8 col-sm-offset-4">
																		<s:submit value="Add" class="btn btn-primary" />
																		<button type="button" class="btn btn-default"
																			data-dismiss="modal">Close</button>
																	</div>
																</div>
															</s:form>
														</div>
													</div>
												</div>

											</div>
										</div>
										<!-- modal ends here -->
										<div class="table-responsive">
											<table class="table table-bordered">
												<tr>
													<th>Select</th>
													<th>Rule Name</th>
													<th>Metric Type</th>
													<th>Condition</th>
													<th>Threshold</th>
													<th>Time Period</th>
													<th>Action</th>
													<th>No Of Instances</th>
												</tr>
									<s:iterator value="scalingRulesList">
									<tr>
									<td style="text-align: center;"><input type="radio"
														name="ruleRadioBtn" value="" /></td>
 									<td><s:property value="ruleName"/> </td>
									<td><s:property value="metricType"/> </td>
									<td><s:property value="condition"/> </td>
									<td><s:property value="threshold"/> </td>
									<td><s:property value="period"/></td>
									<td><s:property value="action"/> </td>
									<td><s:property value="noOfInstances"/> </td>
									</tr>
									</s:iterator>
											</table>
										</div>
									</div>
								</div>
								<!-- /.panel-primary -->
								<div class="panel panel-info">
									<div class="panel-heading">Scaling Rule Details</div>
									<div class="panel-body">
										<button class="btn btn-primary">
											<span class="glyphicon glyphicon-pencil"></span> Edit
										</button>
										<div class="table-responsive">
											<table class="table">
												<tr>
													<th>Rule Name</th>
													<td>Scale Up 01</td>
													<th>Metric Type</th>
													<td>CPU Usage</td>
												</tr>
												<tr>
													<th>Condition</th>
													<td>Greater than or equal to 50%</td>
													<th>Time Period</th>
													<td>10 Minutes</td>
												</tr>
												<tr>
													<th>Action Type</th>
													<td>Spin Up a VM</td>
													<th>Action Parameter</th>
													<td>1</td>
												</tr>
												<tr>
													<th>Associated Instances</th>
													<td colspan="3">My Simple Web Server<br /> SoyKB
														Instance<br /> WheelSim Instance
													</td>
												</tr>
											</table>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
			<!-- /#page-content-wrapper -->
		</div>

	</div>
	<!-- /#holder -->
	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>
</body>

</html>