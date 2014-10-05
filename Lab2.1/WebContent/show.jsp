<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

table thead tr th {
	border: 1px solid black;
	padding: 3px;
	background-color: #cccccc;
}

table tbody tr td {
	border: 1px solid black;
	padding: 3px;
}
</style>
</head>
<body>
	<table cellspacing="0">
		<thead>
			<tr>
				<th>ISBN</th>
				<th>Title</th>
				<th>Publisher</th>
				<th>PublishDate</th>
				<th>Price</th>
				<th>Name</th>
				<th>Age</th>
				<th>Country</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><s:property value="book.isbn" /></td>
				<td><s:property value="book.title" /></td>
				<td><s:property value="book.publisher" /></td>
				<td><s:property value="book.publishdate" /></td>
				<td><s:property value="book.price" /></td>
				<td><s:property value="author.name" /></td>
				<td><s:property value="author.age" /></td>
				<td><s:property value="author.country" /></td>
			</tr>
		</tbody>
	</table>
	<a href="query.jsp">return</a>
</body>
</html>