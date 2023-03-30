<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<link rel="icon" href="favicon/book.jpeg">
<title>図書登録</title>
</head>
<body>
<% 
		String error = request.getParameter("error");
		if(error != null){
			
	%>
		<p style="color:red">図書の登録に失敗しました。</p>
		<h3>図書登録</h3>
		<form action="BookRegisterConfirmServlet" method="post">
			図書名：<input type="text" name="name" value="<%=request.getParameter("book_name") %>"><br>
			著者：<input type="text" name="author" value="<%=request.getParameter("author") %>"><br>
			出版社：<input type="text" name="company" value="<%=request.getParameter("publisher") %>"><br>
			ISBN：<input type="text" name="isbn"><br>
			出版日：<input type="date" name="date"><br>
			新・旧: <input type="radio" name="version" value="新">新<br>
			        <input type="radio" name="version" value="旧">旧<br>
				  <input type="submit" value="登録">
		</form>
	<%	
		} else {
	%>
	<h3>図書登録</h3>
	<form action="BookRegisterConfirmServlet" method="post">
			図書名：<input type="text" name="book_name"><br>
			著者：<input type="text" name="author"><br>
			出版社：<input type="text" name="publisher"><br>
			ISBN：<input type="text" name="isbn"><br>
			出版日：<input type="date" name="day"><br>
			新・旧: <input type="radio" name="version" value="新">新
			        <input type="radio" name="version" value="旧">旧<br>
				  <input type="submit" value="登録">
	
	</form>
	<% } %>
	<a href="TopServlet">戻る</a>
	
</body>
</html>