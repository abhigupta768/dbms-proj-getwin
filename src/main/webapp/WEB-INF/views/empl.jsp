<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
<jsp:include page="base.jsp" />

 
    <c:if test="${pageContext.request.userPrincipal.name != null}">

        <h3>
        <a href="/dbms/empl/proregister">Click here to add product</a></h3>
        <h3>
        <a href="/dbms/empl/showproducts">Click here to show all products</a></h3>
        <h3>
        <a href="/dbms/empl/showody">Click here to show products that are delivered</a></h3>
        <h3>
        <a href="/dbms/empl/showodn">Click here to show products that are not delivered</a></h3>
    </c:if>
</body>
</html>