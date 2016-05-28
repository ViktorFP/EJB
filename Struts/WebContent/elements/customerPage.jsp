<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/reservation" prefix="reservation"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bean:message key="jsp.customer.title"/></title>
</head>
<body>
	<%@ include file="tabs.jsp"%>
	<div>
		<reservation:customer />
		<h3><bean:message key="jsp.customer.customer"/></h3>
		<h5>
			<b><bean:message key="jsp.customer.id"/></b>			
			<bean:write name="customer" property="customerDocID" />
		</h5>
		<h5>
			<b><bean:message key="jsp.customer.fName"/></b>
			<bean:write name="customer" property="firstName" />
		</h5>
		<h5>
			<b><bean:message key="jsp.customer.lName"/></b>
			<bean:write name="customer" property="lastName" />
		</h5>
	</div>
	<div>
		<reservation:email />
		<h3><bean:message key="jsp.customer.email"/></h3>
		<h5>
			<a href="mailto:<bean:write name="email" property="emailAddress" />"><bean:write
					name="email" property="emailAddress" /></a> (
			<bean:write name="email" property="emailType" />
			) -
			<bean:write name="email" property="syncStatus" />
		</h5>
	</div>

	<div>
		<reservation:phone />
		<h3><bean:message key="jsp.customer.phone"/></h3>
		<h5>
			<a
				href="skype:+<bean:write name="phone" property="phoneNumber" />?call"><bean:write
					name="phone" property="phoneNumber" /></a> (
			<bean:write name="phone" property="phoneType" />
			) -
			<bean:write name="phone" property="syncStatus" />
		</h5>
	</div>
	<reservation:pays />
	<table class="table table-striped table-hover table-condensed">
		<caption><bean:message key="jsp.customer.payments"/></caption>
		<thead>
			<tr>
				<th><bean:message key="jsp.customer.currencyCode"/></th>
				<th><bean:message key="jsp.customer.amount"/></th>
				<th><bean:message key="jsp.customer.formOfPayment"/></th>
			</tr>
		</thead>
		<logic:iterate name="payments" id="pay">
			<tr>
				<td><bean:write name="pay" property="currencyCode" /></td>
				<td><bean:write name="pay" property="amountPaid" /></td>
				<td><bean:write name="pay" property="formOfPaymentTypeCode" /></td>
			</tr>
		</logic:iterate>
	</table>
</body>
</html>