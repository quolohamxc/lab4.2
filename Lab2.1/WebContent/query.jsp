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
	<s:form name = "listbook" action="listbook" namespace="/">
		<s:textfield name="name" label="authorname" />
		<s:submit />
	</s:form>

	<s:if test="books.size()>0">
		<table cellspacing="0">
			<thead>
				<tr>
					<th>Title</th>
					<th>Operation</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="books">
					<tr>
						<td><a
							href='<s:url action="query"><s:param name="isbn" value="isbn" /></s:url>'>
								<s:property value="title" /></a></td>
						<td><a
							href='<s:url action="editbook"><s:param name="isbn" value="isbn" /></s:url>'>
								Edit Detail </a> &nbsp; <a
							href='<s:url action="removebook"><s:param name="isbn" value="isbn" /></s:url>'>
								Delete Book </a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<a href="editbook.jsp">Add Book</a>
	</s:if>

</body>
</html>