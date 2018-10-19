<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<jsp:include page="base.jsp" />
 
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h3><a href="/dbms/admin/empregister">Click here to add employee</a></h3>
        <h3><a href="/dbms/admin/manregister">Click here to add manufacturer</a></h3>
        <h3><a href="/dbms/admin/proregister">Click here to add product</a></h3>
        <h3><a href="/dbms/admin/wareregister">Click here to add warehouse</a></h3>
        <h3><a href="/dbms/admin/dsregister">Click here to add delivery service</a></h3>
        <h3><a href="/dbms/admin/showproducts">Click here to show all products</a></h3>
        <h3><a href="/dbms/admin/showemployees">Click here to show all employees</a></h3>
        <h3><a href="/dbms/admin/showmanufacturers">Click here to show all manufacturers</a></h3>
        <h3><a href="/dbms/admin/showwarehouses">Click here to show all warehouses</a></h3>
        <h3><a href="/dbms/admin/showdss">Click here to show all delivery services</a></h3>
        <h3><a href="/dbms/admin/payman">Pay to Manufacturer</a></h3>
        <h3><a href="/dbms/admin/payemp">Pay to Employee</a></h3>
        <h3><a href="/dbms/admin/showlog">Show Payment Log</a></h3>
        <h3><a href="/dbms/admin/showodn">Click here to show all orders not delivered</a></h3>
        <h3><a href="/dbms/admin/showody">Click here to show all orders delivered</a></h3>
        <h3><a href="/dbms/admin/showinvoice">Click here to show all invoices</a></h3>
    </c:if>
</body>
</html>
