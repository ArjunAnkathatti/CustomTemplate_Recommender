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
					<li><a href="/Custom Template/Account/Instances/index.jsp">Running
							Instances </a></li>
					<li><a href="/Custom Template/Account/Monitoring/index.jsp">Monitoring</a></li>
					<li><a href="/Custom Template/Account/AutoScaling/index.jsp">Auto
							Scaling</a></li>
					<li class="sidebar-brand"><a
						href="/Custom Template/Account/Recommendation/index.jsp">Recommendations</a></li>
				</ul>
			</div>
			<!-- /#sidebar-wrapper -->

			<!-- Page Content -->
			<div id="page-content-wrapper">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-primary">Check for alternatives</button>
							<button class="btn btn-primary">Compare</button>
							<div style="margin-top:10px"></div>
							<div id="" class="panel-group">
								<div class="panel panel-primary">
									<div class="panel-heading">Showing 1 - 3 of 3 Results</div>
									<div class="panel-body">
										<div class="table-responsive">
											<table class="table">
												<tr>
												<th>Sl No</th>
												<th>Descritption</th>
												<th></th>
												</tr>
												<tr>
												<td>01</td>
												<td><img src="https://s3.amazonaws.com/web-bucket-aacwb/rec_01.jpg" style="width:500px; height:60px"/></td>
												<td><input type="checkbox" name=""/> Add to Compare</td>
												</tr>
												<tr>
												<td>02</td>
												<td><img src="https://s3.amazonaws.com/web-bucket-aacwb/rec_02.jpg" style="width:500px; height:60px"/></td>
												<td><input type="checkbox" name=""/> Add to Compare</td>
												</tr>
												<tr>
												<td>03</td>
												<td><img src="https://s3.amazonaws.com/web-bucket-aacwb/rec_03.jpg" style="width:500px; height:60px"/></td>
												<td><input type="checkbox" name=""/> Add to Compare</td>
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