<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:property value="webServerRequired"/>
<s:property value="webServer"/>
<s:property value="dbServerRequired"/>
<s:property value="databaseServer"/>
<table>
<s:iterator value="additionalSoftware">
<tr>
    <td width="50%"><s:property value="name" /></td>
    <td width="50%" ><s:property value="githubURL"/></td>
</tr>
</s:iterator>
</table>
</body>
</html>