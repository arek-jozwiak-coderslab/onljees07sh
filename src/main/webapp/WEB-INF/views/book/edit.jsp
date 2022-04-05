<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 05.04.2022
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="book" action="/book/update">
    <form:input path="title"/>
    <form:hidden path="id"/>
    <form:select itemValue="id" itemLabel="name" path="publisher"
                 items="${publishers}" />
    <input type="submit"/>
</form:form>

</body>
</html>
