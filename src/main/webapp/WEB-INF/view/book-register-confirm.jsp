<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>下記の内容で登録します。よろしいですか？</p>
	<%
		Book teamlibrary = (Book)session.getAttribute("input_data");
	%>
	ISBN：<%=teamlibrary.getIsbn() %><br>
	図書名：<%=teamlibrary.getBook_name() %><br>
	著者:<%=teamlibrary.getAuthor() %><br>
	出版社:<%=teamlibrary.getPublisher() %><br>
	出版日:<%=teamlibrary.getDay() %><br>
	新・旧:<%=teamlibrary.getVersion() %><br>
	<a href="BookRegisterExecuteServlet">OK</a><br>
	<a href="BookRegisterServlet">戻る</a>
</body>
</html>