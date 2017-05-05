<%@page import="com.amazonaws.util.EC2MetadataUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.amazonaws.*"%>
<%@ page import="com.amazonaws.auth.*"%>
<%@ page import="com.amazonaws.auth.profile.*"%>
<%@ page import="com.amazonaws.services.ec2.*"%>
<%@ page import="com.amazonaws.services.ec2.model.*"%>

<%!// Share the client objects across threads to
	// avoid creating new clients for each web request
	private AmazonEC2 ec2;%>
<%
	/*
	 * AWS Elastic Beanstalk checks your application's health by periodically
	 * sending an HTTP HEAD request to a resource in your application. By
	 * default, this is the root or default resource in your application,
	 * but can be configured for each environment.
	 *
	 * Here, we report success as long as the app server is up, but skip
	 * generating the whole page since this is a HEAD request only. You
	 * can employ more sophisticated health checks in your application.
	 */
	if (request.getMethod().equals("HEAD"))
		return;
%>
<%
	if (ec2 == null) {
		AWSCredentialsProviderChain credentialsProvider = new AWSCredentialsProviderChain(
				new InstanceProfileCredentialsProvider(), new ProfileCredentialsProvider("Eclipse"));

		ec2 = new AmazonEC2Client(credentialsProvider);
	}
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
<link href="<%=request.getContextPath()%>/css/sidebar.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/dropdownmenu.css" rel="stylesheet" type="text/css"
	media="all" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
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

.hidden {
	display: none;
}

.running {
	color: #69CF36;
}

.stopped {
	color: #FF6E3E;
}
</style>

<script type="text/javascript">
	function loadInstanceDetails_old(instanceID) {
		alert("clicked " + instanceID);
		var xhttp = new XMLHttpRequest();
		xhttp.open("GET", "AWSInstanceDetails.jsp?instanceID=" + instanceID,
				false);
		xhttp.send();
		document.getElementById("demoDemo").innerHTML = xhttp.responseText;
	}

	$(document).ready(
			function() {
				var currentInstanceID = $(
						"#instanceList input[type='radio']:checked").val();
				$("#" + currentInstanceID).removeClass("hidden");
			});

	$(document)
			.ready(
					function() {
						$("#instanceList input[type='radio']")
								.mouseup(
										function() {
											var currentInstanceID = $(
													"#instanceList input[type='radio']:checked")
													.val();
											$("#" + currentInstanceID)
													.addClass("hidden");
										})
								.change(
										function() {
											var currentInstanceID = $(
													"#instanceList input[type='radio']:checked")
													.val();
											$("#" + currentInstanceID)
													.removeClass("hidden");
										});
					});
</script>
<s:head />
</head>
<body>
	<div id="holder">
		<!-- header-section-starts -->
		<div class="header">
			<div class="container">
				<div class="logo">
					<a href="index.jsp"><img width="110px" height="63px"
						src="<%=request.getContextPath()%>/images/logo.png" class="img-responsive" alt="" /></a>
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
					<li class="sidebar-brand"><a
						href="/CustomTemplateDocker/Account/Instances/index.jsp">Running
							Instances </a></li>
					<li><a
						href="/CustomTemplateDocker/Account/Monitoring/index.jsp">Monitoring</a></li>
					<li><a
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
									<div class="panel-heading">Instances</div>
									<div class="panel-body">
										<div class="table-responsive" style="min-height: 200px;">
											<table id="instanceList" class="table table-bordered">
												<tr>
													<th></th>
													<th>InstanceID</th>
													<th>Type</th>
													<th>Action</th>
													<th>State</th>
													<th>Public DNS Name</th>
													<th>Public IP
												</tr>
												<%
													int count = 0;
												%>
												<%
													for (Reservation reservation : ec2.describeInstances().getReservations()) {
												%>
												<%
													for (Instance instance : reservation.getInstances()) {
												%>
												<%
													++count;
												%>
												<%
													String instanceID = instance.getInstanceId();
															String instanceState = instance.getState().getName();
													String startURL = "/CustomTemplateDocker/startEC2Instance.action?instanceID=" + instanceID;
													String stopURL = "/CustomTemplateDocker/stopEC2Instance.action?instanceID=" + instanceID;
													String terminateURL = "/CustomTemplateDocker/shutDownEC2Instance.action?instanceID=" + instanceID;
													String shutDownURL = "/CustomTemplateDocker/terminateEC2Instance.action?instanceID=" + instanceID;
												%>
												<tr>
													<td>
														<%
															if (count == 1) {
														%> <input type="radio" checked="checked" name="instanceID"
														value=<%=instanceID%> /> <%
 	} else {
 %> <input type="radio" name="instanceID" value=<%=instanceID%> />
													</td>
													<%
														}
													%>
													<td><%=instanceID%></td>
													<td><%=instance.getInstanceType()%></td>
													<td>
														<div class="dropdown">
															<button class="">Manage</button>
															<div class="dropdown-content">
																<a href=<%= startURL%>>Start</a> 
																<a href=<%= stopURL %>>Stop</a> 
																<a href=<%= shutDownURL%>>Shutdown</a>
																<a href=<%= terminateURL%>>Terminate</a>
															</div>
														</div>
													</td>
													<td style="text-transform: capitalize"><span
														class="glyphicon glyphicon-stop <%=instanceState%>">&nbsp;</span><%=instanceState%>
													</td>
													<td><%=instance.getPublicDnsName()%></td>
													<td><%=instance.getPublicIpAddress()%></td>
												</tr>
												<%
													}
												%>
												<%
													}
												%>
												<% String geniInstanceID = (String)session.getAttribute("geniInstanceID");
												if (geniInstanceID != null) { %>
												<tr>
												<td><input type="radio" name="instanceID" value="geniInstanceID"></input></td>
												<td>g-lmclyebt562ad</td>
												<td>m1.large</td>
												<td>Action</td>
												<td>Running</td>
												<td><%= geniInstanceID%></td>
												<td><%= geniInstanceID%></td>
												<% } %>
											</table>
										</div>
									</div>
								</div>
								<div class="panel panel-info">
									<div class="panel-heading">Instance Details</div>
									<div class="panel-body">
										<%
											for (Reservation reservation : ec2.describeInstances().getReservations()) {
										%>
										<%
											for (Instance instance : reservation.getInstances()) {
										%>
										<div id=<%=instance.getInstanceId()%> class="hidden">
											<div class="table-responsive">
												<table class="table">
													<tr>
														<th colspan="4" style="background-color: #D9EDF7;">General
															Details :</th>
													</tr>
													<tr>
														<th>Cloud Vendor</th>
														<td>Amazon</td>
														<th>Instance Type/Name</th>
														<td><%=instance.getInstanceType()%></td>
													</tr>
													<tr>
														<th>Instance ID</th>
														<td><%=instance.getInstanceId()%></td>
														<th>AMI ID</th>
														<td><%=instance.getImageId()%></td>
													</tr>
													<tr>
														<th>Public DNS Name</th>
														<td><%=instance.getPublicDnsName()%></td>

														<th>Public IP</th>
														<td><%=instance.getPublicIpAddress()%></td>
													</tr>
													<tr>
														<th colspan="4" style="background-color: #D9EDF7;">Hardware
															Specs :</th>
													</tr>
													<tr>
														<th>No of cores</th>
														<td>2</td>
														<th>Processor</th>
														<td>Xen 1.7Ghz</td>
													</tr>
													<tr>
														<th>RAM</th>
														<td>1 GB</td>
														<th>O S</th>
														<td>Ubuntu</td>
													</tr>
													<tr>
														<th>Local torage</th>
														<td>40 GB</td>
														<th>Extra Volume</th>
														<td>60 GB</td>
													</tr>
													<tr>
														<th colspan="4" style="background-color: #D9EDF7;">Software
															Specs :</th>
													</tr>
													<tr>
														<th>Web Server</th>
														<td>Apache</td>
														<th>DB Server</th>
														<td>MySql</td>
													</tr>
												</table>
											</div>
										</div>
										<%
											}
										%>
										<%
											}
										%>
										<% if (geniInstanceID != null) { %>
										<div id="geniInstanceID" class="hidden">
											<div class="table-responsive">
												<table class="table">
													<tr>
														<th colspan="4" style="background-color: #D9EDF7;">General
															Details :</th>
													</tr>
													<tr>
														<th>Cloud Vendor</th>
														<td>GENI</td>
														<th>Instance Type/Name</th>
														<td>m1.large</td>
													</tr>
													<tr>
														<th>Instance ID</th>
														<td>g-lmclyebt562ad</td>
														<th>AMI ID</th>
														<td>Ubuntu14.0_Docker</td>
													</tr>
													<tr>
														<th>Public DNS Name</th>
														<td><%= geniInstanceID%></td>

														<th>Public IP</th>
														<td><%= geniInstanceID%></td>
													</tr>
													<tr>
														<th colspan="4" style="background-color: #D9EDF7;">Hardware
															Specs :</th>
													</tr>
													<tr>
														<th>No of cores</th>
														<td>4</td>
														<th>Processor</th>
														<td>Xen 2.1Ghz</td>
													</tr>
													<tr>
														<th>RAM</th>
														<td>8 GB</td>
														<th>O S</th>
														<td>Ubuntu</td>
													</tr>
													<tr>
														<th>Local torage</th>
														<td>26 GB</td>
														<th>Extra Volume</th>
														<td>40 GB</td>
													</tr>
													<tr>
														<th colspan="4" style="background-color: #D9EDF7;">Software
															Specs :</th>
													</tr>
													<tr>
														<th>Web Server</th>
														<td>Apache</td>
														<th>DB Server</th>
														<td>MySql</td>
													</tr>
												</table>
											</div>
										</div>
										<% } %>
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