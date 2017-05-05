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

.hidden {
	display: none;
}
</style>
<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
		$("#myCarousel").carousel("pause");
	});

	$(document).ready(function() {
		$("#btnCompare").click(function() {
			$("#recTabLink").removeClass("active");
			$("#compTabLink").addClass("active");
			$("#recTabContent").addClass("hidden");
			$("#compTabContent").removeClass("hidden");
		});
	});

	$(document).ready(function() {
		$("#btnMigrate").click(function() {
			$("#compTabLink").removeClass("active");
			$("#migTabLink").addClass("active");
			$("#compTabContent").addClass("hidden");
			$("#migTabContent").removeClass("hidden");
			$.ajax({url: "/CustomTemplateDocker/migrateToGENI.action", success: function(result){
				alert("Migration Complete");
		        window.location.href = "/CustomTemplateDocker/Account/Instances/index.jsp"
		    }});
			$("#myCarousel").carousel("cycle");
			
		});
	});
</script>
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
					<li><a
						href="/CustomTemplateDocker/Account/Instances/index.jsp">Running
							Instances </a></li>
					<li><a
						href="/CustomTemplateDocker/Account/Monitoring/index.jsp">Monitoring</a></li>
					<li><a href="/CustomTemplateDocker/getScalingReq">Auto
							Scaling</a></li>
					<li class="sidebar-brand"><a
						href="/CustomTemplateDocker/Account/Recommendation/index.jsp">Recommendations</a></li>
				</ul>
			</div>
			<!-- /#sidebar-wrapper -->

			<!-- Page Content -->
			<div id="page-content-wrapper">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<ul id="tabs" class="nav nav-tabs">
								<li id="recTabLink" class="active"><a
									href="/CustomTemplateDocker/Account/Recommendation/index.jsp">Recommendations</a></li>
								<li id="compTabLink" class=""><a href="#">Compare</a></li>
								<li id="migTabLink" class=""><a href="#">Migrate</a></li>
							</ul>
							<div style="margin-top: 10px"></div>

							<!-- recTab start -->
							<div id="recTabContent" class="">
								<div class="panel panel-primary">
									<span class="pull-right"
										style="padding-top: 3px; padding-right: 3px;">
										<button data-toggle="tooltip" id="btnCompare"
											title="Compare selected solution with current solution"
											class="btn btn-success">Compare</button>
									</span>
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
													<td><img
														src="https://s3.amazonaws.com/web-bucket-aacwb/rec_01.jpg"
														style="width: 500px; height: 60px" /></td>
													<td><div class="checkbox">
															<label><input type="checkbox" name="" />Add to
																Compare</label>
														</div></td>
												</tr>
												<tr>
													<td>02</td>
													<td><img
														src="https://s3.amazonaws.com/web-bucket-aacwb/rec_02.jpg"
														style="width: 500px; height: 60px" /></td>
													<td><div class="checkbox">
															<label><input type="checkbox" name="" />Add to
																Compare</label>
														</div></td>
												</tr>
											</table>
										</div>
									</div>
								</div>
							</div>
							<!-- rec tab end -->

							<!-- comp tab start -->
							<div id="compTabContent" class="hidden">
								<div class="panel panel-primary">
									<span class="pull-right"
										style="padding-top: 3px; padding-right: 3px;">
										<button data-toggle="tooltip" id="btnMigrate"
											title="Migrates application setup to the selected solution"
											class="btn btn-success">Migrate</button>
									</span>
									<div class="panel-heading">Comparison Results</div>
									<div class="panel-body">
										<div class="table-responsive">
											<table class="table table-bordered">
												<tr>
													<th style="text-align: center;">Select</th>
													<td style="text-align: center;"><input type="radio"
														name="recSolution" /></td>
													<td style="text-align: center;"><input type="radio"
														name="recSolution" /></td>
													<td style="text-align: center;"><input type="radio"
														name="recSolution" /></td>
												</tr>
												<tr>
													<th>Solution Name</th>
													<td>Current Solution</td>
													<td>Amzon Linux M2.Medium</td>
													<td>Geni M1.Large</td>
												</tr>
												<tr>
													<th>Cloud Vendor</th>
													<td>Amazon AWS</td>
													<td>Amazon AWS</td>
													<td>GENI</td>
												</tr>
												<tr>
													<th>Instance Type</th>
													<td>t2.micro</td>
													<td>t2.medium</td>
													<td>m1.large</td>
												</tr>
												<tr>
													<th>RAM</th>
													<td>1 GB</td>
													<td>4 GB</td>
													<td>8 GB</td>
												</tr>
												<tr>
													<th>CPU Cores</th>
													<td>01</td>
													<td>02</td>
													<td>04</td>
												</tr>
												<tr>
													<th>Network Bandwidth</th>
													<td>Upto 100 MBps</td>
													<td>400- 500 MBps</td>
													<td>Upto 800 MBps</td>
												</tr>
												<tr>
													<th>Storage</th>
													<td>20 GB SSD</td>
													<td>20 GB SSD</td>
													<td>26 GB HDD</td>
												</tr>
												<tr>
													<th>GPU</th>
													<td>No</td>
													<td>No</td>
													<td>No</td>
												</tr>
												<tr>
													<th>Availability Zone</th>
													<td>U S East</td>
													<td>U S East</td>
													<td>U S Central</td>
												</tr>
												<tr>
												</tr>
												<tr>
													<th>Average Monthly Cost</th>
													<td>$800</td>
													<td>$1200</td>
													<td>$1000</td>
												</tr>
												<tr>
												</tr>
												<tr>
													<th>CPU Performance</th>
													<td>600 fpi/s</td>
													<td>1000 fpi/s</td>
													<td>1300 fpi/s</td>
												</tr>
												<tr>
												</tr>
											</table>
										</div>
									</div>
								</div>
							</div>
							<!-- comp tab end -->

							<!-- mig tab start -->
							<div id="migTabContent" class="hidden">
								<div class="panel panel-primary">
									<div class="panel-heading">Migration Status</div>
									<div class="panel-body">

										<div id="myCarousel" class="carousel" data-ride="carousel"
											data-wrap="false" data-interval="14000">


											<!-- Wrapper for slides -->
											<div class="carousel-inner">
												<div class="item active">
													<img id="progImg01" class="img-responsive"
														src="<%=request.getContextPath()%>/images/migration_progress/prog_01.png" />
												</div>

												<div class="item">
													<img id="progImg02" class="img-responsive"
														src="<%=request.getContextPath()%>/images/migration_progress/prog_02.png" />
												</div>

												<div class="item">
													<img id="progImg03" class="img-responsive"
														src="<%=request.getContextPath()%>/images/migration_progress/prog_03.png" />
												</div>

												<div class="item">
													<img id="progImg04" class="img-responsive"
														src="<%=request.getContextPath()%>/images/migration_progress/prog_04.png" />
												</div>

												<div class="item">
													<img id="progImg05" class="img-responsive"
														src="<%=request.getContextPath()%>/images/migration_progress/prog_05.png" />
												</div>

												<div class="item">
													<img id="progImg06" class="img-responsive"
														src="<%=request.getContextPath()%>/images/migration_progress/prog_06.png" />
												</div>
											</div>


										</div>

									</div>
								</div>
							</div>
							<!-- mig tab end -->

						</div>

					</div>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->
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