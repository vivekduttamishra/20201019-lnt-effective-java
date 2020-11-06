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

<a href="/helloweb/books/list">Book List</a>
<h1>${book.title }</h1>

<h2>Author: ${book.author }</h2>
<h3>Price: ${book.price }</h3>



</body>
</html>