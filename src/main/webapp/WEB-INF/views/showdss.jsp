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
<table>
<jsp:include page="base.jsp" />
<tr>
	<th>Service ID</th>
	<th>Name</th>
	<th>Phone No</th>
</tr>
<c:forEach items="${allds}" var="ds">
	<tr>
		<td>${ds.getSid()}</td>
		<td>${ds.getName()}</td>
		<td>${ds.getPhno()}</td>
		<td><a href="/dbms/admin/showdss/delete/${ds.getSid()}">Delete</a></td>
		<td><a href="/dbms/admin/showdss/update?ds=${ds.getSid()}">Update</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>