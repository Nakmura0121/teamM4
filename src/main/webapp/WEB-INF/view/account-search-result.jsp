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
<link rel="stylesheet" href="css/account-search-result.css">
</head>
<body>
		<a href="BackServlet" class="back">戻る</a>
		
		<h1>【図書貸出】</h1>
		
		 <table   border=1>
            <tr>
               <th>名前</th>
               <th>メール</th>
            </tr>
            
                   <%
                      List<Account> list = (ArrayList<Account>) request.getAttribute("list1"); 
                      for(Account p : list){
                    %>  
            <tr>
              
              <td><%= p.getName()  %></td>
              <td><a href="DetailServlet?mail=<%=p.getMail()%>"><%=p.getMail() %></a></td>
            </tr> 
            
         <%} %> 
         
         </table> <br>
</body>
</html>