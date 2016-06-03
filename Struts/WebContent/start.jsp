<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html:base />
<title><tiles:getAsString name="title" /></title>
<link rel='stylesheet' href='styles/bootstrap.min.css' type='text/css'
	media='all'>
<link rel='stylesheet' href='styles/bootstrap.css' type='text/css'>
<link rel='stylesheet' href='styles/main.css' type='text/css'>
</head>
<body>
	<table>
		<tr>
			<td><tiles:insert attribute="content" /></td>
		</tr>
		<tr>
			<td><tiles:insert attribute="footer" /></td>
		</tr>
	</table>
</body>
</html>