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
	<th>Manufacturer Id</th>
	<th>Warehouse Id</th>
	<th>Product Type</th>
	<th>HSN Code</th>
	<th>Quantity In Stock</th>
	<th>Price</th>
	<th>Capacity</th>
	<th>Pack Size</th>
	<th>Sweep Size</th>
	<th>Color</th>
	<th>Conductor Area</th>
</tr>
<c:forEach items="${allpro}" var="product">
	<tr>
		<td>${product.getName()}</td>
		<td>${product.getMid()}</td>
		<td>${product.getWid()}</td>
		<td>${product.getType()}</td>
		<td>${product.getHsncode()}</td>
		<td>${product.getQinstock()}</td>
		<td>${product.getPrice()}</td>
		<td>${product.getCap()}</td>
		<td>${product.getPcksize()}</td>
		<td>${product.getSwpsize()}</td>
		<td>${product.getColor()}</td>
		<td>${product.getCarea()}</td>
		<c:choose>
			<c:when test="${role=='ROLE_ADMIN'}">
				<td><a href="/dbms/admin/showproducts/delete/${product.getProduct_id()}">Delete</a></td></c:when>
			<c:otherwise>
				<td><a href="/dbms/empl/showproducts/delete/${product.getProduct_id()}">Delete</a></td></c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${role=='ROLE_ADMIN'}">
				<td><a href="/dbms/admin/showproducts/update?name=${product.getProduct_id()}">Update</a></td></c:when>
			<c:otherwise>
				<td><a href="/dbms/empl/showproducts/update?name=${product.getProduct_id()}">Update</a></td></c:otherwise>
		</c:choose>
	</tr>
</c:forEach>
</table>
</body>
</html>