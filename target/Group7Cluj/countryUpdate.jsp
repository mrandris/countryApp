<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aandr
  Date: 10/31/2019
  Time: 8:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Country</title>
</head>
<body>
<h2>Update country:</h2>
<form method = "post" action = "http://localhost:8080/CountryApp/country/update">
    Update : <br>
    <input type = "text" name = "name"  value = "${country.getName()}" >
    <input type = "hidden" name = "id" value = "${country.getIdCountry()}" >
    <select name = "region" >
        <c:forEach var = "region" items = "${regionList}">
            <option value="${region.getIdRegion()}">${region.getName()}</option>
        </c:forEach>
    </select>
    <input type = "submit" value = "Update country" >
</form>
</body>
</html>
