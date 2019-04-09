<%--
支付成功界面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
购买成功
<button onclick="back()">返回</button>
</body>
<script>
    <jsp:useBean id="login" class="java.lang.String" scope="session"  ></jsp:useBean>
    //向后台请求数据进行加载
    <%
      if(request.getSession(false).getAttribute("login").equals("")){//没有登录
      response.sendRedirect(request.getContextPath() +"");
      }
    %>
    function back(){
        window.location = "Pick.jsp";
    }
</script>
</html>
