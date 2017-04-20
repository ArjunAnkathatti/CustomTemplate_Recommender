<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<% if (session.getAttribute("emailid") != null) {
	response.sendRedirect("http://localhost:8080/Test_Demo3/network.jsp");
	session.setMaxInactiveInterval(150);
}
%>

<html>
<head>
<script type="text/javascript" language="javascript">
	function login() {
		var username = document.getElementById("username").value;
		window.location.href = "getInformation?username="
				+ document.getElementById("username").value + "&password="
				+ document.getElementById("password").value;
	}
</script>
<script type="text/javascript">
	function python() {
		$.ajax({
			type	: "GET",
			url		: "http://localhost:8080/Test_Demo3/pythonScript.action",
			success	: function(response) {
				alert("python script executed succesfully");
				window.location = 'pythonSuccess.jsp';
			},
			error	: function(e) {
				alert('python script failed');
			}
		});
	}
	
	function doLoginAjaxPost() {
		// get the form values
		var name = $('#username').val();
		var password = $('#password').val();
		if (name == '') {
			alert('Please input your userid');
		} else if (password == '') {
			alert('Please input your password');
		} else {
			$.ajax({
				type : "POST",
				url : "http://localhost:8080/Test_Demo3/getInformation.action",
				data : "username=" + name + "&password=" + password,
				success : function(response) {
					// we have the response
					if (response == 'SUCCESS') {
						window.location = 'services.html';
					} else {
						alert('Wrong password or userid');
					}

				},
				error : function(e) {
					alert('Wrong password or userid');
				}
			});
		}

	}
</script>
<script type="text/javascript">
	function doRegisReset() {
		//set the values of username, password and confirm password to empty string
		$('#regis_username').val('');
		$('#regis_password').val('');
		$('#regis_confirm_password').val('');
	}

	function doRegisAjaxPost() {
		// get the form values
		var name = $('#regis_username').val();
		var password = $('#regis_password').val();
		var confirm_password = $('#regis_confirm_password').val();

		if (name == '') {
			alert('Please input your username');
		} else if (password == '') {
			alert('Please input your password');
		} else if (confirm_password == '') {
			alert('Please confirm your password');
		} else if (password != confirm_password) {
			alert("Please input the same password");
			//following two lines will reset the password and confirem password to empty string
			$('#regis_password').val('');
			$('#regis_confirm_password').val('');
		} else {
			$
					.ajax({
						type : "POST",
						url : "http://localhost:8080/Test_Demo3/registration.action",
						data : "regis_username=" + name + "&regis_password="
								+ password,
						success : function(response) {
							// we have the response
							if (response == 'SUCCESS') {
								alert('Register success');
								window.location = 'services.html';
							} else {
								if (response == 'ERROR') {
									alert('Userid already exist');
								}
							}

						},
						error : function(e) {
							alert('Something went wrong');
						}
					});
		}

	}
</script>
<title>Custom Template Generation</title>
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
						<li><a href="about.html">About Us</a></li>
						<li><a href="services.html">Services</a></li>
						<li><a class="active" href="login.jsp">Account</a></li>
						<li><a href="general.jsp">Start</a></li>
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
		<div class="container">

			<div class="row">
				<div class="signup-wrapper">


					<div class="col-md-6 col-sm-6">
						<strong>Already Registered ? </strong>Please login below to access
						your account.
						<hr />
						<a href="#" class="btn btn-social btn-facebook"> <i
							class="fa fa-facebook"></i>&nbsp; Facebook Account
						</a> &nbsp;OR&nbsp; <a href="#" class="btn btn-social btn-google">
							<i class="fa fa-google-plus"></i>&nbsp; Google Account
						</a>
						<hr>
						<h5>
							Or Login with <strong>Website Account :</strong>
						</h5>
						<label>Enter Email ID : </label> <input name="username"
							id="username" type="text" class="form-control"> <label>Enter
							Password : </label> <input name="password" id="password" type="password"
							class="form-control">
						<hr>
						<!-- <a href="javascript:doLoginAjaxPost();" class="btn btn-info"> -->
						<a href="javascript:python();" class="btn btn-info"><span
							class="fa fa-user"></span>&nbsp;Log Me In </a>
					</div>
					<div class="col-md-6 col-sm-6 alert alert-info">
						<strong>Not Registered </strong>with us ? Login with facebook /
						Google or fill the form belownto get full access.
						<hr />

						<label>Enter Email ID : </label> <input type="text"
							name="regis_username" id="regis_username" class="form-control">
						<label>Enter Password : </label> <input type="password"
							name="regis_password" id="regis_password" class="form-control">
						<label>Retype Password : </label> <input type="password"
							name="regis_confirm_password" id="regis_confirm_password"
							class="form-control">
						<hr>
						<a href="javascript:doRegisAjaxPost();" class="btn btn-warning"><span
							class="fa fa-user-plus"></span>&nbsp;Register Me </a>&nbsp; <a
							href="javascript:doRegisReset();" class="btn btn-success"><span
							class="fa fa-refresh"></span>&nbsp;Reset Entries</a>
					</div>
				</div>
				<!-- END SIGN UP FORM-->
			</div>

		</div>

	</div>

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
</body>
</html>