<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<html>
<head>
</head>
<body>
<html:link action="/elements/Locale.do?method=english"><bean:message key="jsp.locale.en" /></html:link>
<html:link action="/elements/Locale.do?method=russian"><bean:message key="jsp.locale.ru" /></html:link>
</body>
</html>