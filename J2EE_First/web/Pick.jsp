<%@ page import="java.util.List" %>
<%@ page import="net.sf.json.JSON" %>
<%@ page import="net.sf.json.JSONArray" %>
<%@ page import="net.sf.json.JSONObject" %>
<%@ page import="model.CommodityClassfication" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Commodity" %>
<%--
选择商品，并加入购物车界面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body onload="load()">
<link href="css/pick.css" rel="stylesheet" type="text/css" />
<%--类别--%>
<div class="header" id="CommodityClassfication">
    <div class="switch" id="switch">
        <a class="switch_btn_focus" id="all"  tabindex="7" onclick="change()">全部商品</a>
        <div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
    </div>
</div>

<div id="Commodity">

</div>

<button onclick="buy()">购买</button>

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

    var idArray=new Array()
    var numArray=new Array()
    var money=0

    function change(){

    }

    function load(){
                var m=document.getElementById("Commodity")
                    <%
                    ArrayList<CommodityClassfication> CommodityClassficationlist=(ArrayList)request.getSession(false).getAttribute("CommodityClassfication");
                    //先将分类加载进来
                    if (CommodityClassficationlist!=null){
                        for (int i = 0;i<CommodityClassficationlist.size();i++){
                            %>
        <%
                        }
                    }
                    //首先创建一个全部的商品分类
                    ArrayList<Commodity> Commoditylist=(ArrayList)request.getSession(false).getAttribute("Commodity");
                    //在将全部的商品加载进来
                    if (Commoditylist!=null){
                        for (int i =0;i<Commoditylist.size();i++){
                        %>m.innerHTML+="<dl class=\"com\">\n"+
                        "  <dt>\n" +
                        "     <img src=\"images/"+ "<%=Commoditylist.get(i).getCurl()%>" +"\"/>\n"+
                        "      </dt>\n"+
                        "<p> <span class=\"price\">\n"+
                        "    价格\n"+
                        "     <strong>"+ "<%=Commoditylist.get(i).getCprice()%>" +"</strong>\n"+
                        "</span><br>" +
                        " <span class=\"mail\">包邮</span> <br>"+
                        " <span class=\"inven\">库存 "+ "<%=Commoditylist.get(i).getInventory()%> " +"</span><br>" +
                        "<span class=\"title\">"+ " <%=Commoditylist.get(i).getCname()%> " +"</span>\n"+
                        "<dd>\n"+
                        "<button class=\"add\" onclick='addGoods(" + <%=Commoditylist.get(i).getCid()%> + ","+ <%=Commoditylist.get(i).getCprice()%> + ")'>加入购物车</button>\n" +
                        "</dd>\n"+
                        "</dl>";
                        <%}
                }
                %>
    }

    function buy(){
        var id=""
        for (var i=0;i<idArray.length-1;i++){
            id=id+idArray[i]+";"
        }
        id=id+idArray[idArray.length-1]
        var num=""
        for(var i=0;i<numArray.length-1;i++){
            num=num+numArray[i]+";"
        }
        num=num+numArray[numArray.length-1]
        window.location.href = "Buy.jsp?money="+money+"&id="+id+"&num="+num;
    }

    function addGoods(id,Money){
        var m=false
        for (var i =0;i<idArray.length;i++){
            if (idArray[i]==id){
                numArray[i]++
                m=true
            }
        }
        if(m==false){
            idArray.push(id)
            numArray.push(1)
        }
        money=money+Money;
    }
</script>
</html>
