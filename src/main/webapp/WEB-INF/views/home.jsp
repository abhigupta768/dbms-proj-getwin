<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style>
</style>
</head>
<body>
	<jsp:include page="base.jsp" />
	<table>
		<tr>
			<th>Name</th>
			<th>Product Type</th>
			<th>HSN Code</th>
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
				<td>${product.getType()}</td>
				<td>${product.getHsncode()}</td>
				<td>${product.getPrice()}</td>
				<td>${product.getCap()}</td>
				<td>${product.getPcksize()}</td>
				<td>${product.getSwpsize()}</td>
				<td>${product.getColor()}</td>
				<td>${product.getCarea()}</td>
				<td><a href="/dbms/login">Add to cart</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>