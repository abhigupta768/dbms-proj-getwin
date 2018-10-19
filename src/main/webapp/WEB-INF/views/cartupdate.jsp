<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="base.jsp" />

	<form:form method="post" modelAttribute="cart" action="update">
		<table><tr><td>Quantity</td>
		<td>
		<form:input path="qincart" type="number" required="required" min="1" max="${maxq}"/> </td><!-- bind to user.name-->
		<td><form:errors path="qincart" /></td></tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
				<form:hidden path="username" value="${username}" />
				<form:hidden path="pid" value="${pid}" />
				<form:hidden path="maxq" value="${maxq}" />
		
	</form:form>