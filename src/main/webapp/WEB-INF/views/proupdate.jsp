<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="base.jsp" />
	<form:form method="post" modelAttribute="product" action="update">
		<table><tr><td>Name</td>
		<td>
		<form:input path="name" type="text" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="name" /></td></tr>
		
		<tr><td>Manufacturer Id</td>
		<td>
		<form:select path="mid">
		<c:if test="${!empty allman}">
		<c:forEach items="${allman}" var="man" varStatus="loop">
		<form:option value="${man.getMid()}">${man.getMid()}(${man.getName()})</form:option>
		</c:forEach>
		</c:if> 
		</form:select>
		</td><!-- bind to user.name-->
		<td><form:errors path="mid" /></td></tr>
		
		<tr><td>Warehouse Id</td>
		<td>
		<form:select path="wid">
		<c:if test="${!empty allwar}">
		<c:forEach items="${allwar}" var="war" varStatus="loop">
		<form:option value="${war.getWid()}">${war.getWid()}(${war.getAddress()})</form:option>
		</c:forEach>
		</c:if> 
		</form:select>
		</td><!-- bind to user.name-->
		<td><form:errors path="wid" /></td></tr>
		
		<tr><td>Product Type</td>
		<td>
		<form:input path="type" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="type" /></td></tr>
		
		<tr><td>HSN Code</td>
		<td>
		<form:input path="hsncode" type="text" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="hsncode" /></td></tr>
		
		<tr><td>Quantity In Stock</td>
		<td>
		<form:input path="qinstock" type="number" required="required" min="0"/> </td><!-- bind to user.name-->
		<td><form:errors path="qinstock" /></td></tr>
		
		<tr><td>Price</td>
		<td>
		<form:input path="price" type="number" required="required" min="1"/> </td><!-- bind to user.name-->
		<td><form:errors path="price" /></td></tr>
		
		<tr><td>Capacity</td>
		<td>
		<form:input path="cap" type="number" min="0"/> </td><!-- bind to user.name-->
		<td><form:errors path="cap" /></td></tr>
		
		<tr><td>Pack Size</td>
		<td>
		<form:input path="pcksize" type="number" min="0"/> </td><!-- bind to user.name-->
		<td><form:errors path="pcksize" /></td></tr>
		
		<tr><td>Sweep Size</td>
		<td>
		<form:input path="swpsize" type="number" min="0"/> </td><!-- bind to user.name-->
		<td><form:errors path="swpsize" /></td></tr>
		<tr><td>Color</td>
		<td>
		<form:input path="color" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="color" /></td></tr>
		<tr><td>Conductor Area</td>
		<td>
		<form:input path="carea" type="number" min="0"/> </td><!-- bind to user.name-->
		<td><form:errors path="carea" /></td></tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
				<form:hidden path="product_id" value="${pid}" />
		
	</form:form>