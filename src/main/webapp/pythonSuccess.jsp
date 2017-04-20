<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ page
	import="com.geni.beans.GeneralARI,com.geni.beans.NetworkARI,com.geni.beans.StorageARI,com.geni.beans.ComputationARI,com.geni.beans.SoftwareARI,com.geni.beans.AdditionalSoftware,java.util.Collection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<script src="js/jquery-1.11.1.js"></script>
<!-- REQUIRED BOOTSTRAP SCRIPTS -->
<script src="js/bootstrap.js"></script>
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
				<a href="index.html"><img src="images/logo.png"
					class="img-responsive" alt="" /></a>
			</div>
			<div class="header-right">
				<h4>
					<i class="phone"></i>(573) 999 1234
				</h4>
				<span class="menu"></span>
				<div class="top-menu">
					<ul>
						<li><a href="index.html">Home</a></li>
						<li><a href="404.html">Products</a></li>
						<li><a href="about.hmtl">About Us</a></li>
						<li><a href="services.html">Services</a></li>
						<li><a href="login.jsp">Account</a></li>
						<li><a class="active" href="final.html">ApplicationInfo</a></li>
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
	<div class="content">
		<div class="contact about-desc">
			<h3>Python Script Results</h3>
			<div class="container">
				<div class="row">
						<br />
						<%
							//out.println("Deployment time" + session.getAttribute("dTime"));
						%>
						<s:text name="deployTime"></s:text>
						<table border="1" width="100%">
							<tr align="center">
								<th>Sl No</th>
								<th>Application Name</th>
								<th>VM Connection Details</th>
							</tr>
							<tr>
								<td>01</td>
								<td>SoyKB</td>
								<!--   <td><s:text name="pythonScriptResult"></s:text></td> -->
								<td>arjunank@utahddc.com -p 34127</td>
							</tr>
						</table>
						<br />
					</div>
				</div>
			</div>
		</div>

					<div class="footer text-center">
						<div class="social-icons">
							<a href="#"><i class="facebook"></i></a> <a href="#"><i
								class="twitter"></i></a> <a href="#"><i class="googlepluse"></i></a>
							<a href="#"><i class="youtube"></i></a> <a href="#"><i
								class="linkedin"></i></a>
						</div>

						<div class="copyright">
							<p>
								Copyright &copy; 2015 All rights reserved | Template by <a
									href="http://www.baidu.com"> CustomTemplateTeam</a>
							</p>
						</div>
					</div>
</body>
</html>