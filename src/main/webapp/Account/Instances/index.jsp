<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="../../css/sidebar.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="../../css/style.css" rel="stylesheet" type="text/css"
	media="all" />
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
						src="../../images/logo.png" class="img-responsive" alt="" /></a>
				</div>
				<div class="header-right">
					<h4></h4>
					<span class="menu"></span>
					<div class="top-menu">
						<ul>
							<li><a href="/Custom Template/index.html">Home</a></li>
							<li><a href="/Custom Template/404.html">Products</a></li>
							<li><a href="/Custom Template/about.hmtl">About Us</a></li>
							<li><a href="/Custom Template/services.html">Services</a></li>
							<li><a href="/Custom Template/login.jsp">Account</a></li>
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
						href="/Custom Template/Account/Instances/index.jsp">Running
							Instances </a></li>
					<li><a href="/Custom Template/Account/Monitoring/index.jsp">Monitoring</a></li>
					<li><a href="/Custom Template/Account/AutoScaling/index.jsp">Auto
							Scaling</a></li>
					<li><a href="/Custom Template/Account/Recommendation/index.jsp">Recommendations</a></li>
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
									<div class="panel-heading">Running Instances</div>
									<div class="panel-body">
										<div class="table-responsive" style="min-height: 200px;">
											<table class="table table-bordered">
												<tr>
													<th>Select</th>
													<th>Action</th>
													<th>Application Name</th>
													<th>State</th>
													<th>Instance Type</th>
													<th>VM Connection Details</th>
												</tr>
												<tr>
													<td style="text-align: center;"><input type="radio"
														name="instanceRadioBtn" value="" /></td>
													<td>
														<div class="btn-group">
															<button type="button" class="dropdown-toggle"
																data-toggle="dropdown">
																Manage <span class="caret"></span>
															</button>
															<ul class="dropdown-menu" role="menu">
																<li><a href="#">Stop</a></li>
																<li><a href="#">ShutDown</a></li>
																<li><a href="#">Terminate</a></li>
																<li><a href="#">Create Image</a></li>
															</ul>
														</div>
													</td>
													<td>SoyKB</td>
													<td>Active Running</td>
													<td>Geni exoVM</td>
													<!--   <td><s:text name="pythonScriptResult"></s:text></td> -->
													<td>arjunank@utahddc.com -p 34127</td>
												</tr>
												<tr>
													<td style="text-align: center;"><input type="radio"
														name="instanceRadioBtn" value="" /></td>
													<td>
														<div class="btn-group">
															<button type="button" class="dropdown-toggle"
																data-toggle="dropdown">
																Manage <span class="caret"></span>
															</button>
															<ul class="dropdown-menu" role="menu">
																<li><a href="#">Stop</a></li>
																<li><a href="#">ShutDown</a></li>
																<li><a href="#">Terminate</a></li>
																<li><a href="#">Create Image</a></li>
															</ul>
														</div>
													</td>
													<td>WheelSim</td>
													<td>Active Running</td>
													<td>Amazon m2.large</td>
													<!--   <td><s:text name="pythonScriptResult"></s:text></td> -->
													<td>arjunank-ecw@aws.amazon.com -p 34127</td>
												</tr>
												<tr>
													<td style="text-align: center;"><input type="radio"
														name="instanceRadioBtn" value="" /></td>
													<td>
														<div class="btn-group">
															<button type="button" class="dropdown-toggle"
																data-toggle="dropdown">
																Manage <span class="caret"></span>
															</button>
															<ul class="dropdown-menu" role="menu" style="float:">
																<li><a href="#">Stop</a></li>
																<li><a href="#">ShutDown</a></li>
																<li><a href="#">Terminate</a></li>
																<li><a href="#">Create Image</a></li>
															</ul>
														</div>
													</td>
													<td>SoyKB</td>
													<td>Active Running</td>
													<td>Geni exoVM</td>
													<!--   <td><s:text name="pythonScriptResult"></s:text></td> -->
													<td>arjunank@utahddc.com -p 34127</td>
												</tr>
											</table>
										</div>
									</div>
									<!-- /.panel-body -->
								</div>
								<div class="panel panel-info">
									<div class="panel-heading">Instance Details</div>
									<div class="panel-body">
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
													<td>t2.micro</td>
												</tr>
												<tr>
													<th>Solution Name</th>
													<td>SoyKB</td>
													<th>xyz</th>
													<td>abc</td>
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