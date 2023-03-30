<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
    <a href="BookDeleteServlet">図書削除</a>

	<h1>検索結果</h1>

	<table border=1>
		<tr>
			<th>ID</th>
			<th>ISBN</th>
			<th>図書名</th>
			<th>著者</th>
			<th>出版社</th>
			<th>新・旧</th>
		</tr>

		<%
             List<Book> list = (ArrayList<Book>) request.getAttribute("list1"); 
                            
             for(Book b : list){
         %>
		<tr>
			<td><%= b.getId() %></td>
			<td><%= b.getIsbn() %></td>
			<td><%= b.getBook_name()  %></td>
			<td><%= b.getAuthor()   %></td>
			<td><%= b.getPublisher()  %></td>
			<td><%= b.getVersion() %></td>

		</tr>

		<%} %>

	</table>
	<br>
	<a href="./">トップへ</a>
</body>
</html>