<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<form:form method="post" modelAttribute="warehouse" action="wareregister">
		<jsp:include page="base.jsp" />
	
		<table><tr><td>
		Address</td><td>
		<form:input path="address" type="text" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="address" /></td></tr>
		
		<tr><td>City</td>
		<td>
		<form:input path="city" type="text" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="city" /></td></tr>
		
		<tr><td>State</td>
		<td>
		<form:input path="state" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="state" /></td></tr>
		
		<tr><td>Pincode</td>
		<td>
		<form:input path="pincode" type="number" min="100000" max="999999"/> </td><!-- bind to user.name-->
		<td><form:errors path="pincode" /></td></tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
	</form:form>