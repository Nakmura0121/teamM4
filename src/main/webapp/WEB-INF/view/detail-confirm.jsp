<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>    
<%@ page import="dto.Rental" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detail-confirm.css">
</head>
<body>
		<a href="BackServlet" class="back">戻る</a>
	   
	   <h1>下記の図書を貸出します。よろしいですか？</h1>
	   
	   <%
		request.setCharacterEncoding("UTF-8");
		Rental r = (Rental)session.getAttribute("list3");
		%>
		
		<p>メール:<%= r.getMail() %></p>
		<p>ID:<%= r.getBook_id() %></p>
		<p>図書名:<%= r.getBook_name() %></p>
		
	   
	   <div class="ok" >
		<a href="DetailExecuteServlet" class="ok2"  >OK</a> <br>
		</div>
</body>
</html>