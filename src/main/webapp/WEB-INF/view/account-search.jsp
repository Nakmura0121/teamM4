<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/account-search.css">
</head>
<body>
		<a href="BackServlet" class="back">戻る</a>
		
		<h1>【図書貸出】</h1>
		 
	    <p>利用者検索:名前を入力してください</p>
	     
	    <form action="AccountSearchResultServlet" method="post">
	    <input type="text" class="in"   name="search"> <br>
	    
	    <input type="submit" class="submit"  value="次へ"> <br>
	    </form>  
</body>
</html>