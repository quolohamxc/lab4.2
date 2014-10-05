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
	<h2>
		<s:if test="null == book">
            Add Book
        </s:if>
		<s:else>
            Edit Book
        </s:else>
	</h2>
	<p>Please fill in all blanks</p>
	<s:if test="null == book">
		<s:form action="storebook">
			<s:textfield name="book.isbn" label="ISBN" />
			<s:textfield name="book.title" label="Title" />
			<s:textfield name="author.name" label="Author Name" />
			<s:textfield name="book.publisher" label="Publisher" />
			<s:textfield name="book.publishdate" label="PublishDate" />
			<s:textfield name="book.price" label="Price" />
			<s:submit />
		</s:form>
	</s:if>
	<s:else>
		<s:form action="updatebook">
			<s:textfield name="book.isbn" label="ISBN" />
			<s:textfield name="book.title" label="Title" />
			<s:textfield name="author.name" label="Author Name" />
			<s:textfield name="book.publisher" label="Publisher" />
			<s:textfield name="book.publishdate" label="PublishDate" />
			<s:textfield name="book.price" label="Price" />
			<s:submit />
		</s:form>
	</s:else>
	<a href="query.jsp">return</a>
</body>
</html>