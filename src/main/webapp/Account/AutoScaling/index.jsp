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
					<li><a href="/CustomTemplateDocker/Account/Instances/index.jsp">Running
							Instances </a></li>
					<li><a href="/CustomTemplateDocker/Account/Monitoring/index.jsp">Monitoring</a></li>
					<li class="sidebar-brand"><a
						href="/CustomTemplateDocker/Account/AutoScaling/index.jsp">Auto
							Scaling</a></li>
					<li><a href="/CustomTemplateDocker/Account/Recommendation/index.jsp">Recommendations</a></li>
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
										<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
											<span class="glyphicon glyphicon-plus"></span> Add
										</button>
										<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">New Scaling Rule</h4>
      </div>
      <div class="modal-body">
        <p>Some text in the modal.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Add</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
													<th>Time Period</th>
												</tr>
												<tr>
													<td style="text-align: center;"><input type="radio"
														name="ruleRadioBtn" value="" /></td>
													<td>Scale UP 01</td>
													<td>CPU Usage</td>
													<td>Greater than or equal to 50%</td>
													<td>10 Minutes</td>
												</tr>
												<tr>
													<td style="text-align: center;"><input type="radio"
														name="ruleRadioBtn" value="" /></td>
													<td>Scale UP 02</td>
													<td>No of user requests</td>
													<td>Greater than or equal to 10000</td>
													<td>5 Minutes</td>
												</tr>
												<tr>
													<td style="text-align: center;"><input type="radio"
														name="ruleRadioBtn" value="" /></td>
													<td>Scale Down 01</td>
													<td>CPU Usage</td>
													<td>Less than or equal to 30%</td>
													<td>15 Minutes</td>
												</tr>
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