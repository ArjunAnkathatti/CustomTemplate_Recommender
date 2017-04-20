<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>

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
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
</head>
<body>
<!-- header-section-starts -->
<div class="header">
<div class="container">
<div class="logo"><a href="index.html"><img
	src="images/logo.png" class="img-responsive" alt="" /></a></div>
<div class="header-right">
<h4><i class="phone"></i>(256) 152 3658</h4>
<span class="menu"></span>
<div class="top-menu">
<ul>
	<li><a href="index.html">Home</a></li>
	<li><a href="404.html">Products</a></li>
	<li><a href="about.hmtl">About Us</a></li>
	<li><a href="services.html">Services</a></li>
	<li><a href="blog.html">Blog</a></li>
	<li><a class="active" href="#">Contact Us</a></li>
</ul>
</div>
<!-- script for menu --> <script>
	$("span.menu").click(function() {
		$(".top-menu").slideToggle("slow", function() {
			// Animation complete.
		});
	});
</script> <!-- script for menu --></div>
<div class="clearfix"></div>
</div>
</div>
<!-- header-section-ends -->
<div class="content">
<div class="contact about-desc">
<h3>Network-Connectivity</h3>
<div class="container"><s:form action="getInformation"
	method="post" namespace="/">
	<div class="row">
	<div class="col-md-4">
	<div class="contact_right">
	<div class="contact-form_grid">
	<h4>Your minimum bandwidth requirement</h4>
	<br/>
	<select id="bandwidth" name="bandwidth">
		<option value="volvo" selected>Choose One:</option>
		<option value="saab">10-20 Mbps</option>
		<option value="opel">20-100 Mbps</option>
		<option value="audi">1 Gbps</option>
		<option value="audi">10 Gbps</option>
		<option value="audi">100 Gbps</option>
		<option value="audi">No idea</option>
	</select> 
	<input type="text" class="textbox" name="email" value="Band Width"
		onfocus="this.value = '';"
		onblur="if (this.value == '') {this.value = 'Band Width';}"> 
	<input
		type="text" class="textbox" name="subject" value="Latency"
		onfocus="this.value = '';"
		onblur="if (this.value == '') {this.value = 'Latency';}"> 
	<select id="subject" name="subject1">
		<option value="volvo" selected>Choose One:</option>
		<option value="saab">Saab</option>
		<option value="opel">Opel</option>
		<option value="audi">Audi</option>
	</select> 
	<textarea name="message" value="Additional Requirements:"
		onfocus="this.value = '';"
		onblur="if (this.value == '') {this.value = 'Additional Requirements';}">Additional Requirements</textarea>

	</div>
	</div>
	</div>
	<div class="col-md-4">
	<div class="contact_right">
	<div class="contact-form_grid"><input type="text" class="textbox"
		name="username" value="Application Name" onfocus="this.value = '';"
		onblur="if (this.value == '') {this.value = 'Application Name';}">
	<input type="text" class="textbox" name="email" value="Band Width"
		onfocus="this.value = '';"
		onblur="if (this.value == '') {this.value = 'Band Width';}"> <input
		type="text" class="textbox" name="subject" value="Latency"
		onfocus="this.value = '';"
		onblur="if (this.value == '') {this.value = 'Latency';}"> <textarea
		name="message" value="Additional Requirements:"
		onfocus="this.value = '';"
		onblur="if (this.value == '') {this.value = 'Additional Requirements';}">Additional Requirements</textarea>
	</div>
	</div>
	</div>
	<div class="col-md-4">
	<div class="contact_right">
	<div class="contact-form_grid"><input type="text" class="textbox"
		name="username" value="Application Name" onfocus="this.value = '';"
		onblur="if (this.value == '') {this.value = 'Application Name';}">
	<input type="text" class="textbox" name="email" value="Band Width"
		onfocus="this.value = '';"
		onblur="if (this.value == '') {this.value = 'Band Width';}"> <input
		type="text" class="textbox" name="subject" value="Latency"
		onfocus="this.value = '';"
		onblur="if (this.value == '') {this.value = 'Latency';}"> <textarea
		name="message" value="Additional Requirements:"
		onfocus="this.value = '';"
		onblur="if (this.value == '') {this.value = 'Additional Requirements';}">Additional Requirements</textarea>
	</div>
	</div>
	</div>
	<div class="contact_right_new">
	<div class="contact-form_grid"><input type="submit"
		value="Submit"></div>
	</div>

	</div>
</s:form></div>
</div>

</div>
</div>

</div>
<div class="footer text-center">
<div class="social-icons"><a href="#"><i class="facebook"></i></a>
<a href="#"><i class="twitter"></i></a> <a href="#"><i
	class="googlepluse"></i></a> <a href="#"><i class="youtube"></i></a> <a
	href="#"><i class="linkedin"></i></a></div>
<div class="copyright">
<p>Copyright &copy; 2015 All rights reserved | Template by <a
	href="http://w3layouts.com"> W3layouts</a></p>
</div>
</div>
</body>
</html>