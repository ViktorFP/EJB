<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<html:link action="/elements/Locale.do?method=english"><bean:message key="jsp.locale.en" /></html:link>
<html:link action="/elements/Locale.do?method=russian"><bean:message key="jsp.locale.ru" /></html:link>
</body>
</html>