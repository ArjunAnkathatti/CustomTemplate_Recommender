<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Requirement Review</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


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


<!--webfont-->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>

<style>
html, body {
	margin: 0;
	padding: 0;
	height: 100%;
}

#page_arjun {
	min-height: 100%;
	position: relative;
}

#header_arjun {
	padding: 10px;
}

#content_arjun {
	padding: 10px;
	padding-bottom: 60px; /* Height of the footer */
}

#footer_arjun {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px; /* Height of the footer */
}
</style>
</head>
<body>
	<div id="page_arjun">
		<!-- header-section-starts -->
		<div id="header_arjun" class="header">
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
							<li><s:text name="link.home"></s:text></li>
							<li><s:text name="link.products"></s:text></li>
							<li><s:text name="link.about"></s:text></li>
							<li><s:text name="link.servecies"></s:text></li>
							<li><s:text name="link.account"></s:text></li>
							<li><s:text name="link.start"></s:text></li>
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
		<div id="content_arjun">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<span class="pull-left"><h3>Requirement Review</h3></span>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">

						<s:if test="hasActionMessages()">
							<div class="alert alert-success alert-dismissable role="alert">
								<span type="button" class="close" data-dismiss="alert"
									aria-label="Close"><span aria-hidden="true">&times;</span></span>
								<s:actionmessage />
							</div>
						</s:if>

						<s:if test="hasActionErrors()">
							<div class="alert alert-danger alert-dismissable role="alert">
								<span type="button" class="close" data-dismiss="alert"
									aria-label="Close"><span aria-hidden="true">&times;</span></span>
								<s:actionerror />
							</div>
						</s:if>

						<h3>Here goes the review of the requirements collected so far</h3>


					</div>
				</div>
			</div>
		</div>

		<div id="footer_arjun" class="footer text-center">
			<div class="copyright">
				<p>
					Copyright &copy; 2016 All rights reserved | Template by <a
						href="http://www.baidu.com">CustomTemplateTeam</a>
				</p>
			</div>
		</div>

	</div>
</body>
</html>