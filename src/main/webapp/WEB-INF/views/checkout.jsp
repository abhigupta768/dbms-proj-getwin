<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="base.jsp" />

	<form:form method="post" modelAttribute="deliveryentry" action="checkout">
		<table>
		
		<tr><td>Address</td>
		<td>
		<form:input path="address" type="text" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="address" /></td></tr>
		
		<tr><td>City</td>
		<td>
		<form:input path="city" type="text" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="city" /></td></tr>
		
		<tr><td>State</td>
		<td>
		<form:input path="state" type="text" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="state" /></td></tr>
		
		<tr><td>PIN</td>
		<td>
		<form:input path="pincode" type="number" required="required" min="100000" max="999999"/> </td><!-- bind to user.name-->
		<td><form:errors path="pincode" /></td></tr>

		<tr><td>Phone no.</td>
		<td>
		<form:input path="phno" type="number" required="required" min="1000000000" max="9999999999"/> </td><!-- bind to user.name-->
		<td><form:errors path="phno" /></td></tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
		<form:hidden path="username" value="${username}" />
	</form:form>