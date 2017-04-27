<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="form-horizontal" >
        <s:form action="setScalingReq" method="post" namespace="/">
        	<div class="form-group">
        		<lable for="policyName" class="control-lable col-sm-2">Rule Name</lable>
        		<div class="col-sm-10">
        			<s:textfield class="form-control" name="policyName" key="policyName"></s:textfield>
        		</div>
        	</div>
        	<div class="form-group">
        		<lable for="scalingAction" class="control-lable col-sm-2">Action</lable>
        		<div class="col-sm-10">
        			<s:textfield class="form-control" name="scalingAction" key="scalingAction"></s:textfield>
        		</div>
        	</div>
        	<div class="form-group">
        		<lable for="scalingAdjustment" class="control-lable col-sm-2">No. of instances</lable>
        		<div class="col-sm-10">
        			<s:textfield class="form-control" name="scalingAdjustment" key="scalingAdjustment"></s:textfield>
        		</div>
        	</div>
        	<div class="form-group">
        		<lable for="metricType" class="control-lable col-sm-2">Metric Type</lable>
        		<div class="col-sm-10">
        			<s:textfield class="form-control" name="metricType" key="metricType"></s:textfield>
        		</div>
        	</div>
        	<div class="form-group">
        		<lable for="comparisionOperator" class="control-lable col-sm-2">Condition</lable>
        		<div class="col-sm-10">
        			<s:textfield class="form-control" name="comparisionOperator" key="comparisionOperator"></s:textfield>
        		</div>
        	</div>
        	<div class="form-group">
        		<lable for="threshold" class="control-lable col-sm-2">Threshold</lable>
        		<div class="col-sm-10">
        			<s:textfield class="form-control" name="threshold" key="threshold"></s:textfield>
        		</div>
        	</div>
        	<div class="form-group">
        		<div class="col-sm-10 com-sm-offset-2">
        		<s:submit value="Add" class="btn btn-primary"/>
        		</div>
        	</div>
        </s:form>
</body>
</html>