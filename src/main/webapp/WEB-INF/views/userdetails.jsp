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
	<th>Name</th>
	<th>Address</th>
	<th>City</th>
	<th>State</th>
	<th>Pincode</th>
	<th>Phone No.</th>
	<th>Username</th>
	<th>Email</th>
</tr>
<c:forEach items="${allusr}" var="usr">
	<tr>
		<td>${usr.getName()}</td>
		<td>${usr.getAddress()}</td>
		<td>${usr.getCity()}</td>
		<td>${usr.getState()}</td>
		<td>${usr.getPin()}</td>
		<td>${usr.getPhno()}</td>
		<td>${usr.getUsername()}</td>
		<td>${usr.getEmail()}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>