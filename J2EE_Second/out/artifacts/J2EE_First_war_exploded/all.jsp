<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/25
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<ul>
    <%
        System.out.println(application.getAttribute("allUser"));
        if(null != application.getAttribute("allUser")){
            List<String> list = (List<String>)application.getAttribute("allUser");
            int visitors=(Integer)application.getAttribute("visitors");
    %>
    <h2>在线人数:<%=list.size() %></h2>
    <h2>游客人数:<%=visitors%></h2>
    <%
        for(String s:list){
    %>
    <a>姓名：</a><%=s %><a>---->此时在线</a><br>

    <%
            }
        }
    %>
</ul>
</body>
</html>
