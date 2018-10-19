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
	<th>Website</th>
	<th>City</th>
	<th>State</th>
	<th>Pincode</th>
	<th>Email</th>
	<th>Phone No</th>
</tr>
<c:forEach items="${allman}" var="man">
	<tr>
		<td>${man.getName()}</td>
		<td>${man.getAddress()}</td>
		<td>${man.getWebsite()}</td>
		<td>${man.getCity()}</td>
		<td>${man.getState()}</td>
		<td>${man.getPin()}</td>
		<td>${man.getEmail()}</td>
		<td>${man.getPhno()}</td>
		<td><a href="/dbms/admin/showmanufacturers/delete/${man.getName()}">Delete</a></td>
		<td><a href="/dbms/admin/showmanufacturers/update?user=${man.getName()}">Update</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>