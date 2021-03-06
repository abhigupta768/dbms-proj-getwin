<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="base.jsp" />
	<form:form method="post" modelAttribute="manufacturer" action="update">
		<table>
		
		<tr><td>Address</td>
		<td>
		<form:input path="address" type="text" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="address" /></td></tr>
		
		<tr><td>PIN</td>
		<td>
		<form:input path="pin" type="number" required="required" min="100000" max="999999"/> </td><!-- bind to user.name-->
		<td><form:errors path="pin" /></td></tr>
		
		<tr><td>City</td>
		<td>
		<form:input path="city" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="city" /></td></tr>
		
		<tr><td>State</td>
		<td>
		<form:input path="state" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="state" /></td></tr>
		
		<tr><td>Website</td>
		<td>
		<form:input path="website" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="website" /></td></tr>
		
		<tr><td>Email</td>
		<td>
		<form:input path="email" type="email" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="email" /></td></tr>
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
		<form:hidden path="name" value="${name}" />
	</form:form>