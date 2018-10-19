<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<jsp:include page="base.jsp" />

	<form:form method="post" modelAttribute="employee" action="empregister">
		<table><tr><td>
		username</td><td>
		<form:input path="username" type="text" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="username" /></td></tr>
		
		<tr><td>
		password</td><td>
		<form:input path="password" type="password" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="password" /></td></tr>
		
		<tr><td>Confirm password</td>
		<td>
		<form:input path="mpassword" type="password" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="mpassword" /></td></tr>
		
		<tr><td>Name</td>
		<td>
		<form:input path="name" type="text" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="name" /></td></tr>
		
		<tr><td>Address</td>
		<td>
		<form:input path="address" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="address" /></td></tr>
		
		<tr><td>City</td>
		<td>
		<form:input path="city" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="city" /></td></tr>
		
		<tr><td>State</td>
		<td>
		<form:input path="state" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="state" /></td></tr>
		
		<tr><td>PIN</td>
		<td>
		<form:input path="pin" type="number" required="required" min="100000" max="999999" /> </td><!-- bind to user.name-->
		<td><form:errors path="pin" /></td></tr>
		
		<tr><td>Shift Timings</td>
		<td>
		<form:input path="timings" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="timings" /></td></tr>
		
		<tr><td>Phone No.</td>
		<td>
		<form:input  path="phno" type="number" required="required" min="1000000000" max="9999999999"/> </td><!-- bind to user.name-->
		<td><form:errors path="phno" /></td></tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
	</form:form>