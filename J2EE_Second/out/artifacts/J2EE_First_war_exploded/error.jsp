<%--
错误界面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error</title>
</head>
<body>
 <div>
     购买失败，账户余额不足
 </div>
</body>

<script>
    <jsp:useBean id="login" class="java.lang.String" scope="session"  ></jsp:useBean>
    //向后台请求数据进行加载
    <%
      if(request.getSession(false).getAttribute("login").equals("")){//没有登录
      response.sendRedirect(request.getContextPath() +"");
      }
    %>
</script>
</html>
