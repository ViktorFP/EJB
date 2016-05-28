<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bean:message key="jsp.login.title" /></title>
<link rel='stylesheet' href='styles/bootstrap.min.css' type='text/css'
	media='all'>
	<link rel='stylesheet' href='styles/bootstrap.css' type='text/css'
	>
	<link rel='stylesheet' href='styles/main.css' type='text/css'
	>
</head>
<body>
	<logic:messagesPresent>
		<div class="alert alert-danger">
			<html:errors />
		</div>
	</logic:messagesPresent>

	<html:form action="/Login" focus="userName" method="post">
		<h3>
			<bean:message key="jsp.login.user" />
			<html:text property="userName" />
		</h3>
		<h3>
			<bean:message key="jsp.login.password" />
			<html:password property="password" />
		</h3>
		<button class="btn btn-warning" type="submit">
			<bean:message key="jsp.login.button" />
		</button>
	</html:form>
</body>
</html>