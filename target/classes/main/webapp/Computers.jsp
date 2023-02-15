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
<form method ="post" action ="navigationServlet">
<table>
<c:forEach items="${requestScope.allComputers}"var="currentcomputer">
<tr>
<td><input type="radio" name="id" value="${currentcomputer.id}"></td>
<td>${currentcomputer.manufacturer}</td>
<td>${currentcomputer.type}</td>
<td>${currentcomputer.os}</td>
</tr>
</c:forEach>
</table>
<input type ="submit" value ="edit" name="doThisToComputer">
<input type ="submit" value ="delete" name="doThisToComputer">
<input type ="submit" value ="add" name="doThisToComputer">
</form>
</body>
</html>