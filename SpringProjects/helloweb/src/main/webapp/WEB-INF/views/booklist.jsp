<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Recommended Books</h1>

<p>Total books : ${books.size() }</p>

<ul>
	<c:forEach var="book" items="${books}">
            <li><a href="/helloweb/book/info/${book.id}">${book.title }</a></li>
     </c:forEach>
</ul>



</body>
</html>