<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書検索</title>
</head>
<body>
           <h1>図書検索</h1>
           <h2>検索したい図書の図書名を入力してください</h2>
           
          <form action="BookSerchResult" method="post">
          図書名:<input type="text" name="search"> <br>
          
          <input type="submit" class="button" value="検索"><br>
          
          
          <a href="./">トップへ</a>
          </form>
</body>
</html>