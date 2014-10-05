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
		Add author
	</h2>
	<p>Please fill in all blanks</p>
	<s:form action="storeauthor">
		<s:textfield name="author.name" label="Name" />
		<s:textfield name="author.age" label="Age" />
		<s:textfield name="author.country" label="Country"/>
		<s:submit />
	</s:form>
	<a href="query.jsp">return</a>
</body>
</html>