<%--
付款界面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
总价为 <%=request.getParameter("money")%>
<button onclick="buy()"> 购买 </button>
</body>
<script src="js/jquery-1.9.0.min.js"></script>
<script>

    var m = ""

    function buy(){
        window.location="all.jsp"
        var money=0
        money=<%=request.getParameter("money")%>
        var id=""
        id="<%=request.getParameter("id")%>"
        var user=""
        user="<%=request.getSession(false).getAttribute("login")%>"
        var num=""
        num="<%=request.getParameter("num")%>"
        $.ajax({
            type:"post",
            async:true,
            url:"/ShoppingServlet",
            data:{
                money:money,
                user:user,
                flag:"buy",
                commodity:id,
                commoditynumber:num,
            },
            success:function(data){
                if(data=="true"){
                    window.location.href="Success.jsp"
                }
            }
        })
    }
    <jsp:useBean id="login" class="java.lang.String" scope="session"  ></jsp:useBean>
    //向后台请求数据进行加载
    <%
      if(request.getSession(false).getAttribute("login").equals("")){//没有登录
          response.sendRedirect(request.getContextPath() +"");
      }
    %>

</script>
</html>
