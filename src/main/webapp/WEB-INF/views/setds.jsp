<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="base.jsp" />
	<form:form method="post" modelAttribute="deliveryentry" action="setds">
		<table><tr><td>
		Select Service</td><td>
		<form:select path="dsid">
		<c:if test="${!empty allds}">
		<c:forEach items="${allds}" var="ds" varStatus="loop">
		<form:option value="${ds.getSid()}">${ds.getSid()}(${ds.getName()})</form:option>
		</c:forEach>
		</c:if> 
		</form:select>
		</td><!-- bind to user.name-->
		<td><form:errors path="dsid" /></td></tr>
		
		
		<tr><td>Date of delivery</td>
		<td>
		<form:input required="required" path="dod" type="date" /> </td><!-- bind to user.name-->
		<td><form:errors path="dod" /></td></tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
		<form:hidden path="invid" value="${invid}" />
	</form:form>