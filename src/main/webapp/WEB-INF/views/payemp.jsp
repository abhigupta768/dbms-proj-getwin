<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="base.jsp" />
	<form:form method="post" modelAttribute="paylog" action="payemp">
		<table><tr><td>Employee ID</td>
		<td>
		<form:select path="emp_id">
		<c:if test="${!empty allemp}">
		<c:forEach items="${allemp}" var="emp" varStatus="loop">
		<form:option value="${emp.getEmp_id()}">${emp.getEmp_id()}(${emp.getName()})</form:option>
		</c:forEach>
		</c:if>
		</form:select>
		</td><!-- bind to user.name -->
		<td><form:errors path="emp_id" /></td>
		</tr>
		
		<tr><td>
		Amount</td><td>
		<form:input path="amount" type="number" required="required" min="1"/> </td><!-- bind to user.name-->
		<td><form:errors path="amount" /></td></tr>
		
		<tr><td>Date</td>
		<td>
		<form:input path="dop" type="date" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="dop" /></td></tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
	</form:form>