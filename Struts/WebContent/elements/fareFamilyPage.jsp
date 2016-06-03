<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-nested.tld" prefix="nested"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<html>
<head>
</head>
<body>
	<html:form action="/fareFamilyPage">
		<nested:nest property="fareFamily">
			<h2>
				<b><bean:message key="jsp.fare.code" /></b>
				<nested:write property="fareFamilyCode" />
			</h2>

			<h4 class="list">
				<bean:message key="jsp.fare.components" />
			</h4>
			<ul class="list">
				<nested:iterate property="ancillaryAirComponent">
					<li><nested:write property="ancillaryAirComponentCode" /></li>
				</nested:iterate>
			</ul>
		</nested:nest>
	</html:form>
</body>
</html>