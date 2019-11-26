<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aandr
  Date: 10/20/2019
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Region List</title>
</head>
<body>
    <h2>Region list:</h2>
    <table border="1px">
        <tr>
            <td>Region Id</td>
            <td>Region Name</td>
            <td>Country List</td>
            <td>Delete</td>
            <td>Update</td>
        </tr>
    <c:forEach var = "region" items = "${regionList}">
        <tr>
            <td>${region.getIdRegion()}</td>
            <td>${region.getName()}</td>
            <td>
                <form method = "get" action = "http://localhost:8080/CountryApp/region/country/list">
                    <input type = "hidden" name = "id" value = "${region.getIdRegion()}" >
                    <input type = "submit" value = "Show countries for this region" >
                </form>
            </td>
            <td>
                <form method = "get" action = "http://localhost:8080/CountryApp/region/deleteButton">
                    <input type = "hidden" name = "id" value = "${region.getIdRegion()}" >
                    <input type = "submit" value = "Remove region" >
                </form>
            </td>
            <td>
                <form method = "get" action = "http://localhost:8080/CountryApp/region/update">
                    <input type = "hidden" name = "id" value = "${region.getIdRegion()}" >
                    <input type = "submit" value = "Update Region" >
                </form>
            </td>
        </tr>
    </c:forEach>
    </table>

    <h2>Add new region:</h2>
    <form method = "post" action = "http://localhost:8080/CountryApp/region/add">
        Add new Region: <br>
        <input type = "text" name = "name" placeholder = "Write region name here" >
        <input type = "submit" value = "Add new region" >
    </form>

    <h2>Delete region:</h2>
    <form method = "get" action = "http://localhost:8080/CountryApp/region/delete">
        Remove Region: <br>
        <input type = "text" name = "name" placeholder = "Write region name here" >
        <input type = "submit" value = "Remove region" >
    </form>

    <br>
    <a href="http://localhost:8080/CountryApp/region/list">Click to show all regions</a>
    <a href="http://localhost:8080/CountryApp/country/list">Click to show all countries</a>

</body>
</html>
