<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Account" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Account ac = (Account)session.getAttribute("user");
	%>
	<h3><%=ac.getName() %>様利用者ページ</h3>
	<a class="button" href="">図書検索はこちら➤</a><br><br><br>
	<a class="button" href="">登録図書一覧➤</a><br><br><br>
	<a class="button" href="LogoutServlet">ログアウト</a><br><br>
	
	
</body>
</html>