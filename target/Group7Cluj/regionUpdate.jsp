<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aandr
  Date: 10/20/2019
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update region</title>
</head>
<body>
    <h2>Update region:</h2>
    <form method = "post" action = "http://localhost:8080/CountryApp/region/update">
        Update : <br>
        <input type = "text" name = "name"  value = "${r.getName()}" >
        <input type = "hidden" name = "id" value = "${r.getIdRegion()}" >
        <input type = "submit" value = "Update region" >
    </form>
</body>
</html>
