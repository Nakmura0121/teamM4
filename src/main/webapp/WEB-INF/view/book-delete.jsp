<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書削除</title>
</head>
<body> 
         <h1>図書削除</h1>
         <h2>削除する図書のIDを入力してください。</h2>
         
         <form action="BookDeleteResultServlet" method="post">
         <input type="text" name="isbn"> <br>
         
         <input type="submit" class="button" value="削除"> <br>
         
         </form>
         <a href="./">トップへ</a> <br>
         
</body>
</html>