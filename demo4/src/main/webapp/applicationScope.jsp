<%--
  Created by IntelliJ IDEA.
  User: bagjin-eun
  Date: 2022/07/25
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  try{
    int value = (int)application.getAttribute("value");
    value = value +2;
    application.setAttribute("value",value);

%>

<h1><%=value%></h1>

<%
  }catch(NullPointerException e){
%>
<h1> 설정된 값이 없습니다.</h1>

<%
  }
%>
</body>
</html>
