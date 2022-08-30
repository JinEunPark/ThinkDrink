<%--
  Created by IntelliJ IDEA.
  User: bagjin-eun
  Date: 2022/07/23
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
<%
  int value1 = (int)request.getAttribute("value1");
  int value2 = (int)request.getAttribute("value2");
  int result = (int)request.getAttribute("result");
    %>
<%=value1%>+<%=value2%> = <%=result %>

</body>
</html>
