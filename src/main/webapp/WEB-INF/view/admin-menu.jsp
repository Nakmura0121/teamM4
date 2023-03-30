<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/admin-menu.css">
</head>
<body>
		<h1>【図書管理者ページ】</h1>
			
			<ul>
			   <li>
			       <a href="BookRegisterServlet" >図書登録</a>
			       <a href="BookList" >図書一覧</a>
			  </li>
			  <li>
			       <a href="BookSerchServlet" >図書検索</a>
			       <a href="ListServlet" >貸出履歴</a>
			  </li>
			  <li>
			       <a href="LeadingServlet" >図書貸出</a>
			       <a href="ReturnServlet" >図書返却</a>
			  </li>
			</ul>
			
			<div class="logout" >
			<a href="LogoutServlet" class="logout2"  >ログアウト</a>
			</div>
</body>
</html>