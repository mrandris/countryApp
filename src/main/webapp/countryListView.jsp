<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aandr
  Date: 10/31/2019
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Country List</title>
</head>
<body>
<h2>Country list:</h2>
<table border="1px">
    <tr>
        <td>Country Id</td>
        <td>Country Name</td>
        <td>Region</td>
        <td>Delete</td>
        <td>Update</td>
    </tr>
    <c:forEach var = "country" items = "${countryList}">
        <tr>
            <td>${country.getIdCountry()}</td>
            <td>${country.getName()}</td>
            <td>${country.getRegion().getName()}</td>
            <td>
                <form method = "get" action = "http://localhost:8080/CountryApp/country/deleteButton">
                    <input type = "hidden" name = "id" value = "${country.getIdCountry()}" >
                    <input type = "submit" value = "Remove country" >
                </form>
            </td>
            <td>
                <form method = "get" action = "http://localhost:8080/CountryApp/country/update">
                    <input type = "hidden" name = "id" value = "${country.getIdCountry()}" >
                    <input type = "submit" value = "Update Country" >
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add new country:</h2>
<form method = "post" action = "http://localhost:8080/CountryApp/country/add">
    Add new Country: <br>
    <input type = "text" name = "name" placeholder = "Write country name here" >
    <select name = "region" >
        <c:forEach var = "region" items = "${regionList}">
            <option value="${region.getIdRegion()}">${region.getName()}</option>
        </c:forEach>
    </select>
    <input type = "submit" value = "Add new country" >
</form>

<h2>Delete country:</h2>
<form method = "get" action = "http://localhost:8080/CountryApp/country/delete">
    Remove Country: <br>
    <input type = "text" name = "name" placeholder = "Write country name here" >
    <input type = "submit" value = "Remove county" >
</form>

<br>
<a href="http://localhost:8080/CountryApp/region/list">Click to show all regions</a>
<a href="http://localhost:8080/CountryApp/country/list">Click to show all countries</a>

</body>
</html>
