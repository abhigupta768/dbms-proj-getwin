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
	<th>Invoice ID</th>
	<th>Username</th>
	<th>Date of generation</th>
	<th>Amount</th>
</tr>
<c:forEach items="${allinv}" var="inv">
	<tr>
		<td>${inv.getInvid()}</td>
		<td>${inv.getUsername()}</td>
		<td>${inv.getDog()}</td>
		<td>${inv.getAmount()}</td>
		<td><a href="/dbms/user/showinvoice/invoice?id=${inv.getInvid()}">Show details</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>