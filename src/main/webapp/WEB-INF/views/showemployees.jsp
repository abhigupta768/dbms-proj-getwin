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
	<th>Shift Timings</th>
</tr>
<c:forEach items="${allemp}" var="emp">
	<tr>
		<td>${emp.getName()}</td>
		<td>${emp.getAddress()}</td>
		<td>${emp.getCity()}</td>
		<td>${emp.getState()}</td>
		<td>${emp.getPin()}</td>
		<td>${emp.getPhno()}</td>
		<td>${emp.getUsername()}</td>
		<td>${emp.getTimings()}</td>
		<td><a href="/dbms/admin/showemployees/delete/${emp.getUsername()}">Delete</a></td>
		<td><a href="/dbms/admin/showemployees/update?user=${emp.getUsername()}">Update</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>