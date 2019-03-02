<%--
  Created by IntelliJ IDEA.
  User: wuyuntian
  Date: 2019/2/26
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.sang.Hello" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<% Hello hello=new Hello();%>
<%=hello.sayHello("测试叔叔")%>
</body>
</html>
