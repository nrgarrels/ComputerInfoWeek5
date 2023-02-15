<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="editComputerServlet" method="post">
Manufacturer:<input type="text" name="manufacturer" value="${itemToEdit.manufacturer}">
Type:<input type="text" name="type" value="${itemToEdit.type}">
OS:<input type="text" name="os" value="${itemToEdit.os}">
</form>



</body>
</html>