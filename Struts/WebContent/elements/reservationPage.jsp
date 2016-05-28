<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/reservation" prefix="reservation"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bean:message key="jsp.reservation.title"/></title>
</head>
<body>
	<%@ include file="tabs.jsp"%>
	<h1><bean:message key="jsp.reservation.reservation"/></h1>
	<h2>
		<bean:message key="jsp.reservation.code"/>
		<reservation:resCode />
	</h2>
	<h2>
		<bean:message key="jsp.reservation.description"/>
		<reservation:resDescr />
	</h2>

	<reservation:resComp />
	<table class="table table-striped table-hover table-condensed">
		<caption><bean:message key="jsp.reservation.components"/></caption>
		<thead>
			<tr>
				<th><bean:message key="jsp.reservation.sequence"/></th>
				<th><bean:message key="jsp.reservation.typeCode"/></th>
				<th><bean:message key="jsp.reservation.dtCreation"/></th>
				<th><bean:message key="jsp.reservation.status"/></th>
			</tr>
		</thead>
		<logic:iterate name="components" id="comp">
			<tr>
				<td><bean:write name="comp" property="sequence" /></td>
				<td><bean:write name="comp" property="componentTypeCode" /></td>
				<td><bean:write name="comp" property="createDateTime" /></td>
				<td><bean:write name="comp" property="internalStatus" /></td>
			</tr>
		</logic:iterate>
	</table>
</body>
</html>