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
	<th>Invoice Id</th>
	<th>Address</th>
	<th>City</th>
	<th>State</th>
	<th>Pincode</th>
	<th>Phone No</th>
</tr>
<c:forEach items="${allde}" var="de">
	<tr>
		<td>${de.getInvid()}</td>
		<td>${de.getAddress()}</td>
		<td>${de.getCity()}</td>
		<td>${de.getState()}</td>
		<td>${de.getPincode()}</td>
		<td>${de.getPhno()}</td>
		<c:choose>
			<c:when test="${role=='ROLE_ADMIN'}">
				<td><a href="/dbms/admin/showodn/setds?invid=${de.getInvid()}">Send delivery</a></td></c:when>
			<c:otherwise>
				<td><a href="/dbms/empl/showodn/setds?invid=${de.getInvid()}">Send delivery</a></td></c:otherwise>
		</c:choose>
	</tr>
</c:forEach>
</table>
</body>
</html>