<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<html>
<head>
</head>
<body>
	<div>
		<logic:messagesPresent>
			<div class="list alert alert-danger">
				<html:errors />
			</div>
		</logic:messagesPresent>
	</div>

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