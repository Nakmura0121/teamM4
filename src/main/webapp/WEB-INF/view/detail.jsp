<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>    
<%@ page import="dto.Account" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detail.css">
</head>
<body>	
		 <a href="LoginmainServlet" class="back">戻る</a>
		
		<h1>【図書貸出】</h1>
		
		<%
		request.setCharacterEncoding("UTF-8");
		Account s = (Account)session.getAttribute("detail");
		%>
		<p><%= s.getMail() %></p>
		
		<form action="DetailConfirmServlet" method="post">
		図書ID:<input type="text" class="in"  size="30" name="leading"> <br>
		
		       <input type="submit" class="submit"   value="貸出">
 		</form>
</body>
</html>