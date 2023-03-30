<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書一覧</title>
</head>
<body>
	<a href="BackServlet">戻る</a>

	<table border="1" id="table1">
		<tr>
			<th>ID</th>
			<th>ISBN</th>
			<th>図書名</th>
			<th>出版社</th>
			<th>出版日</th>
			<th>新・旧</th>
		</tr>
	<%List<Book> list = (ArrayList<Book>)request.getAttribute("list");
		for(Book b: list){
	%>
		<tr>
			<td><%=b.getId() %></td>
			<td><%=b.getIsbn() %></td>
			<td><%=b.getBook_name() %></td>
			<td><%=b.getPublisher() %></td>
			<td><%=b.getDay() %></td>
			<td><%=b.getVersion() %></td>
		</tr>
	<%} %>
	</table>
</body>
</html>