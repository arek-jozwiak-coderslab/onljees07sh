<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 05.04.2022
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/book/add"/>">dodaj nowy</a>
<table>
    <tr>
        <th>Id</th>
        <th>Tytuł</th>
        <th>Wydawca</th>
        <th>Akcje</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.publisher.name}</td>
            <td>
                <a href="<c:url value="/book/delete/${book.id}"/>">usuń</a>
                <a href="<c:url value="/book/edit/${book.id}"/>">edytuj</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
