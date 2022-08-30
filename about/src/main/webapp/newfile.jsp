<%--
  Created by IntelliJ IDEA.
  User: bagjin-eun
  Date: 2022/07/22
  Time: 12:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
page의 contenttype와 그리고 인코딩 그리고 사용된 언어를 표시함
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  int total  = 0;
  for(int i  = 1; i<11; i++){
      total += i;
  }
  %>
1부터 10까지의 합:<%=total%>
</body>
</html>
