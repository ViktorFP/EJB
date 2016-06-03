<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<html>
<head>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a data-toggle="tab" href="Tab.do?method=reservationPage"><bean:message
					key="jsp.tabs.reservation" /></a></li>
		<li><a data-toggle="tab" href="Tab.do?method=customerPage"><bean:message
					key="jsp.tabs.customer" /></a></li>
		<li><a data-toggle="tab" href="Tab.do?method=fareFamilyPage"><bean:message
					key="jsp.tabs.fare" /></a></li>
		<li><html:link action="/Exit">
				<bean:message key="jsp.tabs.exit" />
			</html:link></li>
	</ul>
</body>
</html>