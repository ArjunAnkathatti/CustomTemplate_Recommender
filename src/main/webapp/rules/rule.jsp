<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Rule</title>
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
html,
body {
   margin:0;
   padding:0;
   height:100%;
}
#page_arjun {
   min-height:100%;
   position:relative;
}
#header_arjun {
   padding:10px;
}
#content_arjun {
   padding:10px;
   padding-bottom:60px;   /* Height of the footer */
}
#footer_arjun {
   position:absolute;
   bottom:0;
   width:100%;
   height:60px;   /* Height of the footer */
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

					<s:if test="rule.rule_id > 0">
						<div class="panel panel-default">
							<div class="panel-heading">Edit Rule</div>
							<div class="panel-body">
								<s:form action="updateQuestion" method="post" namespace="/"
									cssClass="form-horizontal">

									<s:hidden name="rule_id" key="rule_id" value="%{rule.rule_id}"></s:hidden>

									<div class="form-group">
										<label class="control-label col-sm-2" for="email">Question
											Text:</label>
										<div class="col-sm-10">
											<s:textfield name="question_id" key="question_id"
												value="%{rule.question_id}" cssClass="form-control"></s:textfield>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="email">Condition:</label>
										<div class="col-sm-10">
											<s:select name="condition" key="condition"
												value="%{rule.condition}" headerKey="null"
												headerValue="Choose one" list="conditionList"
												cssClass="form-control">
											</s:select>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<input type="submit" value="Update" class="btn btn-primary">
											<a href="/CustomTemplateDocker/addQuestion.action"><button
													type="button" class="btn btn-default">Cancel</button></a>
										</div>
									</div>
								</s:form>
							</div>
						</div>
					</s:if>

					<s:else>
						<div class="panel panel-default">
							<div class="panel-heading">Add Rule</div>
							<div class="panel-body">
								<s:form action="addRule" method="post" namespace="/"
									cssClass="form-horizontal">

									<div class="form-group">
										<label class="control-label col-sm-2">Parent
											Question</label>
										<div class="col-sm-10">
											<s:select key="parentQuestionId" headerKey="null"
												headerValue="Choose one" list="questionList"
												cssClass="form-control">
											</s:select>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="email">Condition</label>
										<div class="col-sm-10">
											<s:select key="condition" headerKey="null"
												headerValue="Choose one" list="conditionList"
												cssClass="form-control">
											</s:select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="email">Value</label>
										<div class="col-sm-10">
											<s:textfield key="value" cssClass="form-control"></s:textfield>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="email">Child
											Question</label>
										<div class="col-sm-10">
											<s:select key="childQuestionId" headerKey="null"
												headerValue="Choose one" list="questionList"
												cssClass="form-control">
											</s:select>
										</div>
									</div>

									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<input type="submit" value="Add" class="btn btn-primary">
											<input type="reset" value="Clear" class="btn btn-default">
										</div>
									</div>
								</s:form>
							</div>
						</div>
					</s:else>

				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">List of Rules</div>
						<div class="panel-body">
							<table class="table table-striped">
								<tr>
									<th>Action</th>
									<th>Rule ID</th>
									<th>Parent Question</th>
									<th>Condition</th>
									<th>Value</th>
									<th>Child Question</th>
								</tr>
								<s:iterator value="ruleList" var="rule">
									<tr>
										<s:url action="editRule.action" var="urlTag">
											<s:param name="id">
												<s:property value="#rule.ruleId" />
											</s:param>
										</s:url>
										<td><a href="<s:property value="#urlTag" />">Edit</a></td>
										<td><s:property value="#rule.ruleId" /></td>
										<%-- <td><s:property value="#rule.parentQuestionId" /></td> --%>
										<td><s:property value="#rule.parentQuestionText" /></td>
										<td><s:property value="#rule.condition" /></td>
										<td><s:property value="#rule.value" /></td>
										<%-- <td><s:property value="#rule.childQuestionId" /></td> --%>
										<td><s:property value="#rule.childQuestionText" /></td>
									</tr>
								</s:iterator>
							</table>
						</div>
					</div>
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