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
	<th>Address</th>
	<th>City</th>
	<th>State</th>
	<th>Pincode</th>
</tr>
<c:forEach items="${allware}" var="man">
	<tr>
		<td>${man.getAddress()}</td>
		<td>${man.getCity()}</td>
		<td>${man.getState()}</td>
		<td>${man.getPincode()}</td>
		<td><a href="/dbms/admin/showwarehouses/delete/${man.getWid()}">Delete</a></td>
		<td><a href="/dbms/admin/showwarehouses/update?war=${man.getWid()}">Update</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>