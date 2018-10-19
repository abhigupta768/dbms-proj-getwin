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
<c:choose>
<c:when test="${csize==0}">
<h3>Your cart is empty</h3>
</c:when>
<c:otherwise>
<table>
<tr>
	<th>Name</th>
	<th>Quantity</th>
	<th>Price</th>
	<th>Capacity</th>
	<th>Pack Size</th>
	<th>Sweep Size</th>
	<th>Color</th>
	<th>Conductor Area</th>
	<th>Maximum quantity in stock</th>
</tr>
<c:forEach items="${allcart}" var="cart">
	<tr>
		<td>${cart.getName()}</td>
		<td>${cart.getQincart()}</td>
		<td>${cart.getPrice()}</td>
		<td>${cart.getCap()}</td>
		<td>${cart.getPcksize()}</td>
		<td>${cart.getSwpsize()}</td>
		<td>${cart.getColor()}</td>
		<td>${cart.getCarea()}</td>
		<td>${cart.getMaxq()}</td>
		<td><a href="/dbms/user/showcart/delete?pid=${cart.getPid()}">Delete Item</a></td>
		<td><a href="/dbms/user/showcart/update?pid=${cart.getPid()}">Update Item</a></td>
	</tr>
</c:forEach>
</table>
<h3>Please update to appropriate quantity</h3>
<h3>The total amount is:${price}</h3>
<h3><a href="/dbms/user/showcart/checkout">Checkout</a></h3>
</c:otherwise>
</c:choose>
</body>
</html>