<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ page
	import="com.geni.beans.GeneralARI,com.geni.beans.NetworkARI,com.geni.beans.StorageARI,com.geni.beans.ComputationARI,com.geni.beans.SoftwareARI,com.geni.beans.AdditionalSoftware,java.util.Collection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Application Requirement Review</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="UNITED COMMS Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 







</script>
<!--webfont-->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<!-- header-section-starts -->
	<div class="header">
		<div class="container">
			<div class="logo">
				<a href="index.jsp"><img width="110px" height="63px"
					src="images/logo.png" class="img-responsive" alt="" /></a>
			</div>
			<div class="header-right">
				<h4></h4>
				<span class="menu"></span>
				<div class="top-menu">
					<ul>
						<li><a href="index.html">Home</a></li>
						<li><a href="404.html">Products</a></li>
						<li><a href="about.html">About Us</a></li>
						<li><a href="services.html">Services</a></li>
						<li><a href="login.jsp">Account</a></li>
						<li><a class="active" href="review.jsp">Start</a></li>
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
	<!-- header-section-ends -->
	<div class="content">
		<div class="contact about-desc">
			<h3>Requirement Review</h3>
			<div class="container">
				<div class="row">

					<div class="col-sm-6">
						<div class="panel-info">
							<div class="panel-heading">
								General<span class="pull-right"><button
										class="btn btn-xs">Edit</button></span>
							</div>
							<div class="panel-body">
								<%
									GeneralARI general = (GeneralARI) session.getAttribute("general");
								%>
								<table class="table">
									<tr>
										<th>Application Name</th>
										<td><%=general.getAppName()%></td>
									</tr>
									<tr>
										<th>Application Type</th>
										<td><%=general.getAppKind()%></td>
									</tr>
									<tr>
										<th>Application Priority</th>
										<td><%=general.getAppPriority()%></td>
									</tr>
									<tr>
										<th>Application DataSize</th>
										<td><%=general.getAppDataSize()%></td>
									</tr>
								</table>
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="panel-success">
							<div class="panel-heading">
								Network<span class="pull-right"><button
										class="btn btn-xs">Edit</button></span>
							</div>
							<div class="panel-body">
								<%
									NetworkARI network = (NetworkARI) session.getAttribute("network");
								%>
								<table class="table">
									<tr>
										<th>Public IP Type</th>
										<td><%=network.getPublicIp()%></td>
									</tr>
									<tr>
										<th>VPN Network</th>
										<td><%=network.getVpn()%></td>
									</tr>
									<tr>
										<th>NFV</th>
										<td><%=network.getFirewall()%></td>
									</tr>
									<tr>
										<th>Network Type</th>
										<td><%=network.getSdn()%></td>
									</tr>
								</table>
							</div>
						</div>
					</div>

					<div class="col-sm-6">
						<div class="panel-warning">
							<div class="panel-heading">
								Computation<span class="pull-right"><button
										class="btn btn-xs">Edit</button></span>
							</div>
							<div class="panel-body">
								<%
									ComputationARI compute = (ComputationARI) session.getAttribute("computation");
								%>
								<table class="table">
									<tr>
									<tr>
										<th>No. of Nodes</th>
										<td><%=compute.getNoOfNodes()%></td>
									</tr>
									<tr>
										<th>BandwidthK</th>
										<td><%="" + compute.getBandwidth() + " Mbps"%></td>
									<tr>
										<th>No. of cores</th>
										<td><%=compute.getNoOfCores()%></td>
									</tr>
									<tr>
										<th>Ram Size</th>
										<td><%=compute.getRamSize()%></td>
									</tr>
									<tr>
										<th>OS</th>
										<td><%=compute.getOperatingSystem()%></td>
									</tr>
									<tr>
										<th>Dedicated Server</th>
										<td><%=compute.getDedicatedServer()%></td>
									</tr>
									<tr>
										<th>Gpu Size</th>
										<td><%=compute.getGpuSize()%></td>
									</tr>
								</table>

							</div>
						</div>
					</div>

					<div class="col-sm-6">
						<div class="panel-danger">
							<div class="panel-heading">
								Storage<span class="pull-right"><button
										class="btn btn-xs">Edit</button></span>
							</div>
							<div class="panel-body">
								<%
									StorageARI storage = (StorageARI) session.getAttribute("storage");
								%>
								<table class="table">
									<tr>
										<th>Storage Size</th>
										<td><%="" + storage.getStorageSize() + " GB"%></td>
									</tr>
									<tr>
										<th>SSD Disk</th>
										<td><%=storage.getStorageDisk()%></td>
									</tr>
								</table>
							</div>
						</div>
					</div>

					<div class="col-md-12">
						<div class="panel-info">
							<div class="panel-heading">
								Software Requirements<span class="pull-right"><button
										class="btn btn-xs">Edit</button></span>
							</div>
							<div class="panel-body">
								<%
									SoftwareARI software = (SoftwareARI) session.getAttribute("software");
								%>
								<table class="table">
									<tr>
										<th><p>Web Server</p></th>
										<td><%=software.getWebServer()%></td>
									</tr>
									<tr>
										<th><p>DB Server</p></th>
										<td><%=software.getDatabaseServer()%></td>
									</tr>
									<tr>
										<th colspan="2" align="center">Additional Softwares</th>
									</tr>
									<tr>
										<th>Name</th>
										<th>Github URL</th>
									</tr>
									<%
										Collection<AdditionalSoftware> additionalSoftwares = software.getAdditionalSoftware();
										for (AdditionalSoftware as : additionalSoftwares) {
									%>
									<tr>
										<td><%=as.getName()%></td>
										<td><%=as.getGithubURL()%></td>
									</tr>
									<%
										}
									%>
								</table>
							</div>
						</div>
					</div>

					<div class="col-sm-12">
						<a href="#" class="btn btn-warning"> <span
							class="fa fa-user-plus"></span>&nbsp;Edit
						</a>&nbsp; <a href="/CustomTemplateDocker/generateARI.action"
							class="btn btn-success">  <!-- <a href="/CustomTemplateDocker/pythonScript.action" class="btn btn-success"> -->
							<span class="fa fa-refresh"></span>&nbsp;Submit
						</a>
					</div>



				</div>
			</div>
		</div>
	</div>
	<!-- footer-section-starts -->
	<div class="footer text-center">
		<div class="social-icons">
			<a href="#"><i class="facebook"></i></a> <a href="#"><i
				class="twitter"></i></a> <a href="#"><i class="googlepluse"></i></a> <a
				href="#"><i class="youtube"></i></a> <a href="#"><i
				class="linkedin"></i></a>
		</div>
		<div class="copyright">
			<p>
				Copyright &copy; 2015 All rights reserved | Template by <a
					href="http://www.baidu.com"> CustomTemplateTeam</a>
			</p>
		</div>
	</div>
	<!-- footer-section-ends -->
</body>
</html>