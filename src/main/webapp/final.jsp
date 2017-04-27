<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ page import="com.geni.beans.GeneralARI,com.geni.beans.NetworkARI,com.geni.beans.StorageARI,com.geni.beans.ComputationARI,com.geni.beans.SoftwareARI,com.geni.beans.AdditionalSoftware,java.util.Collection" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Custom Template</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
</head>
<body>
	<!-- header-section-starts -->
	<%@ include file="/Header.jsp" %>
	
	<!-- header-section-ends -->
	<div class="container">
		<div class="db-wrapper">
    		<div class="db-pricing-one">
            	 <div class="pricing-header db-bk-color-two">
                 	<h4><strong>Recommended Solutions</strong></h4>
                 </div>
            </div>
        </div>
        <div class="row ">
            <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
                <div class="db-wrapper">
                    <div class="db-pricing-one">
                        <div class="pricing-header db-bk-color-two" style="background-color:#BFBFBF;">
                            <h3><s:text name="silverCost"></s:text> USD / <small>MONTH </small></h3>
                            <hr />
                            Basic Plan With Basic Features
                        </div>
                        <ul>
                          <li class="db-color-two"><strong>BASIC PLAN</strong></li>
			                            <li><s:text name="silverNetwork"></s:text></li>
			                            <li><s:text name="silverStorage"></s:text></li>
			                            <li><s:text name="silverCompute"></s:text></li>

                            
                        </ul>
                        <div class="pricing-footer db-bk-color-two" style="background-color:#BFBFBF;">

                           <!--  <button class="btn db-button-trans-black" data-toggle="modal" data-target="#myModal">
                              Buy Product
                            </button> -->
                            <a href="/CustomTemplateDocker/launchNewEC2Instance.action" class="btn db-button-trans-black">Buy Product</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
                <div class="db-wrapper">
                    <div class="db-wrapper">
                        <div class="db-pricing-one">
                            <div class="pricing-header db-bk-color-two" style="background-color:#FFC245;">
                                <h3><s:text name="goldCost"></s:text>USD / <small>MONTH</small></h3>
                                <hr />
                                Popular And Recommended Plan
                            </div>
                            <ul> <li class="db-color-two"><strong>POPULAR PLAN</strong></li>
                            			<li><s:text name="goldNetwork"></s:text></li>
			                            <li><s:text name="goldStorage"></s:text></li>
			                            <li><s:text name="goldCompute"></s:text></li>
                            </ul>
                            <div class="pricing-footer db-bk-color-two" style="background-color:#FFC245;">

                               <!--  <button class="btn db-button-trans-black" data-toggle="modal" data-target="#myModal"> Buy Product </button>-->
                              <a href="/CustomTemplateDocker/launchNewEC2Instance.action" class="btn db-button-trans-black">Buy Product</a>
                            
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
                <div class="db-wrapper">
                    <div class="db-wrapper">
                        <div class="db-pricing-one">
                            <div class="pricing-header db-bk-color-two" style="background-color:#98BA5A;">
                                <h3><s:text name="greenCost"></s:text> USD /<small>MONTH </small></h3>
                            <hr />
                            Advance And Extended Features
                            </div>
                           <ul>
                             <li class="db-color-two"><strong>ADVANCE PLAN</strong></li>
                            			<li><s:text name="greenNetwork"></s:text></li>
			                            <li><s:text name="greenStorage"></s:text></li>
			                            <li><s:text name="greenCompute"></s:text></li>
                        </ul>
                            <div class="pricing-footer db-bk-color-two" style="background-color:#98BA5A;">

                               <!--  <button class="btn db-button-trans-black" data-toggle="modal" data-target="#myModal"> -->
                               
                              <!--  <a class="btn db-button-trans-black" href="/Custom Template/pythonScript.action">Buy Product</a> -->
                              <!--  <a class="btn db-button-trans-black" href="/Custom Template/Account/Instances/index.jsp">Buy Product</a> -->
                           	  <a href="/CustomTemplateDocker/launchNewEC2Instance.action" class="btn db-button-trans-black">Buy Product</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
          </div>
            
            <!-- purchase confirmation -->
          <div class="container">
       		 <div class="row ">
       		  <div class="col-md-12">
                 <!-- MODAL LAUNCH BUTTON END -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Purchase Confirmation</h4>
                                        </div>
                                        <div class="modal-body">
                                            Congratulations! You have already successfully bought this template!<br> 
                                            If you choose "save changes" option, you will return to your account and the purchase fee will automatically be charged. <br>
                                            If you choose "cancle" option, you will abundan this purchase and the purchase fee will not be charged.<br>
                                            
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary" onclick="savechanges()" >Save changes</button>
                                            <script>	
                                            	function savechanges(){
                                            		window.location.href='useraccount.html';
                                            	}
                                            </script>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                 <!--END THE MODAL BODY - THE ACTUAL MODAL THAT WILL APPEAR-->
                        </div>
           		 </div>
           	 </div>
           	 <!--End purchase confirmation -->
          </div>
       
        
        

	<div class="footer text-center">
		<div class="social-icons">
			<a href="#"><i class="facebook"></i></a>
			<a href="#"><i class="twitter"></i></a>
			<a href="#"><i class="googlepluse"></i></a>
			<a href="#"><i class="youtube"></i></a>
			<a href="#"><i class="linkedin"></i></a>
		</div>
		<div class="copyright">
			<p>Copyright &copy; 2015 All rights reserved | Template by  <a href="http://www.baidu.com">  CustomTemplateTeam</a></p>
		</div>
	</div>
	
	<script src="js/jquery-1.11.1.js"></script>
    <!-- REQUIRED BOOTSTRAP SCRIPTS -->
    <script src="js/bootstrap.js"></script>
</body>
</html>