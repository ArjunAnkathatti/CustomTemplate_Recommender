<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>General</title>
<script>

</script>

<style>
#added by arjun for error messages displayed by server
.errorMessage {
	color: 		red;
	list-style: none;
}

</style>
</head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
<h3>Step 1/5 : General</h3>
<div class="container">
<div class="row">
<div class="col-md-6 contact_left">
		<h4>Application Details</h4>
   					<p class="m_6">In this step, we only focus on the general info of the applicaiton.
   					<br>
   					In order to have a good understanding of your application, we need to know some basic ideas and functions of your application.
   					<h4>Questions Explanation</h4>
   			<br>
   			<div class="row">
   				<div class="col-md-12">
	   				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
	   				
						 <!-- Q1 -->
						  <div class="panel panel-default">
						    <div class="panel-heading" role="tab" id="headingOne">
						      <h5 class="panel-title">
						        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
						          <strong>What is Application Type?</strong>
						        </a>
						      </h5>
						    </div>
						    <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
						      <div class="panel-body">
						        	The main function of your application is about what you are going to do with your application. 
						        	For example, if you want your application can transmit your data in an efficient way, 
						        	then the main function of your application should include data transferring. 
						        	If you want your application can handle large amount of data and do some complex computation 
						        	between these data, then the main function of your application should also include computation.
						         </div>
						    </div>
						  </div>
					  
					
						  <!-- Q2 -->
						  <div class="panel panel-default">
						    <div class="panel-heading" role="tab" id="headingThree">
						      <h5 class="panel-title">
						        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
						          <strong>What is Application Priority?</strong>
						        </a>
						      </h5>
						    </div>
						    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
						      <div class="panel-body">
						        	The priority of the application includes network, storage and computation. 
						        	The priority of the application means which part plays the most important role in the your application. 
						        	For example, the priority of an application that needs lots of data processing is computation and similarly
						        	if you are worried about the data transfer time then your priority is network and if you need storing large
						        	size data then your application priority will be storage.
						      </div>
						    </div>
						  </div>
						  
						  <!-- Q3 -->
						  <div class="panel panel-default">
						    <div class="panel-heading" role="tab" id="headingFour">
						      <h5 class="panel-title">
						        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
						          <strong>What is the DataSize of your Application?</strong>
						        </a>
						      </h5>
						    </div>
						    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
						      <div class="panel-body">
						       Data size of your application is the typical amount of data you handle or compute.
						       It may also include the amount of data you send or receive. This parameter is used to 
						       guess your local storage of the vm instance.
						      </div>
						    </div>
						  </div>
						 
						 
						 <!-- Q4 --> 
						  <div class="panel panel-default">
						    <div class="panel-heading" role="tab" id="headingFour">
						      <h5 class="panel-title">
						        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
						          <strong>What is Preferred Dimension?</strong>
						        </a>
						      </h5>
						    </div>
						    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
						      <div class="panel-body">
						       Preferred dimension is the component(network, storage, compute) which is very important to the user.
						      </div>
						    </div>
						  </div>
						 
		 			
		 			</div>
		 		
	 			</div>
	 		</div>
	 			<p class="m_7">If you have any problem in this step, please contact us using the following contact information.</p>   
   			<!-- End Frequent Ques Part --><div class="contact_grid contact_address">
						
						<h5>Contact Information:</h5>	
						<p>Telephone : 573-999-1234</p>
						<p>Fax : 573-999-1234</p>
						<p>Email : <a href="http://www.baidu.com">mizzou@mail.missouri.edu</a></p>
						<p>Address: EBW Room 237, MU, Columbia, MO, USA
					</div>
					
</div>
	<div class="col-md-6">
		<div class="contact_right">
			<div class="contact-form_grid">
			
				<s:form action="setGeneralReq" method="post" namespace="/">
				
					<p><s:text name="appName"></s:text></p>
					<s:fielderror fieldName="appName"></s:fielderror>
					<s:textfield class="textbox" name="appName" key="appName"/>
					
					<p><s:text name="appKind"></s:text></p>
					<s:fielderror fieldName="appKind"></s:fielderror>
					<s:select name="appKind" key="appKind" headerKey="null"
						headerValue="Choose one" list="appKindList">
					</s:select>
					
					<p><s:text name="appPriority"></s:text></p>
					<s:fielderror fieldName="appPriority"></s:fielderror>
					<s:select name="appPriority" key="appPriority" headerKey="null" 
						headerValue="Choose one" list="appPriorityList">
					</s:select>
					
					<p><s:text name="appDataSize"></s:text></p>
					<s:fielderror fieldName="appDataSize"></s:fielderror>
					<s:select name="appDataSize" key="appDataSize" headerKey="null"
						headerValue="Choose one" list="appDataSizeList">
					</s:select>
					
					<%-- <p><s:text name="appPreferredDimension"></s:text></p>
					<s:fielderror fieldName="appPreferredDimension"></s:fielderror>
					<s:select name="appPreferredDimension" key="appPreferredDimension" headerKey="null" 
						headerValue="Choose one" list="appPreferredDimensionList">
					</s:select> --%>
					
					<s:submit value="Next" />
				</s:form>
			</div>
		</div>
	</div>
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
<p>Copyright &copy; 2016 All rights reserved | Template by <a
	href="http://www.baidu.com"> CustomTemplateTeam</a></p>
</div>
</div>
</body>
</html>