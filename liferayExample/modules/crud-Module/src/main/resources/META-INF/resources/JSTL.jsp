<%@ include file="/init.jsp" %>

<h2>JSTL PAGE</h2>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul>
    <c:forEach var="user" items="${usersList}">
        <li>${user.name}</li>
    </c:forEach>
</ul>

<%
out.println("UserLists......" + ${user.name});
%>










