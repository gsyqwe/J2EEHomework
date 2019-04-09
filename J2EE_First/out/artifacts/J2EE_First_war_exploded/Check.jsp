<%--
查看订单界面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body onload="check()">

</body>
<script src="js/jquery-1.9.0.min.js"></script>
<script>
    <jsp:useBean id="login" class="java.lang.String" scope="session"  ></jsp:useBean>
    //向后台请求数据进行加载
    <%
      if(request.getSession(false).getAttribute("login").equals("")){//没有登录
      response.sendRedirect(request.getContextPath() +"");
      }
    %>

    function check(){

    }
</script>
</html>
