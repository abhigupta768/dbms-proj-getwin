<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<jsp:include page="base.jsp" />
<table>
<tr>
	<th>Invoice Id</th>
	<th>Address</th>
	<th>City</th>
	<th>State</th>
	<th>Pincode</th>
	<th>Phone No</th>
	<th>Delivery Service Id</th>
	<th>Date of delivery</th>
</tr>
<c:forEach items="${allde}" var="de">
	<tr>
		<td>${de.getInvid()}</td>
		<td>${de.getAddress()}</td>
		<td>${de.getCity()}</td>
		<td>${de.getState()}</td>
		<td>${de.getPincode()}</td>
		<td>${de.getPhno()}</td>
		<td>${de.getDsid()}</td>
		<td>${de.getDod()}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>