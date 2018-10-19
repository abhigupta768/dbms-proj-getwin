<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<jsp:include page="base.jsp" />
 
    <c:if test="${pageContext.request.userPrincipal.name != null}">

        <h3><a href="/dbms/user/showuser">Show profile</a></h3>
        <h3><a href="/dbms/user/update">Edit Profile</a></h3>
        <h3><a href="/dbms/user/showcart">Show Cart</a></h3>
        <h3><a href="/dbms/user/showinvoice">Show Orders</a></h3>
    </c:if>
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
		<c:choose>
		<c:when test="${product.getQinstock()==0}">
		<td>Out of Stock</td>
		</c:when>
		<c:otherwise>
		<td><a href="/dbms/user/cart?pid=${product.getProduct_id()}">Add to cart</a></td>
		</c:otherwise>
		</c:choose>
	</tr>
</c:forEach>
</table>
</body>
</html>
