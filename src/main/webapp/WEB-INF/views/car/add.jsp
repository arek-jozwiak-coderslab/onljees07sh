<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Dodawanie pojazdu</h1>
<form:form modelAttribute="car">
<jsp:include page="_form.jsp"/>
    <input type="submit" value="Zapisz">
</form:form>

<form method="post">
    SomeOther: <input type="text" name="other"><br>
    Brand: <input type="text" name="brand"><br>
    Model: <input type="text" name="model"><br>
    Rok: <input type="text" name="age"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
