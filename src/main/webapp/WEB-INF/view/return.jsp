<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/return.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		   <a href="LoginmainServlet" class="back">戻る</a>
		
		<h1>【図書返却】</h1>
		
		<h1>返却する図書のIDを入力してください</h1>
		 
		<form action="ReturnConfirmServlet" method="post">
		     ID:<input type="text" name="return"> <br>
		
		<input type="submit" class="submit" value="返却"> <br>
		</form>
</body>
</html>