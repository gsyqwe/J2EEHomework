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
        //读取类型的函数
        $.ajax({
            type: "post", // 提交方式
            // 返回数据类型
            dataType: "JSON",
            url: "/PickServlet", // 访问路径
            data: { // 提交数据,进行商品与商品列表初始化无需任何提交数据
                flag:"classfication",
            },
              success:function(data) { // 成功调用的回调函数
                  for (var i=0;i<data.length;i++){
                      //进行设置类型
                  }
              },
           })
        //读取具体商品的函数
        $.ajax({
            type: "post", // 提交方式
            // 返回数据类型
            dataType: "JSON",
            url: "/PickServlet", // 访问路径
            data: { // 提交数据,进行商品与商品列表初始化无需任何提交数据
                flag:"commodity",
            },
            success:function(data) { // 成功调用的回调函数
                console.log(data)
                var m=document.getElementById("Commodity")
                for (var i=0; i<data.length;i++) {
                    m.innerHTML += " <dl ><br>" +
                        " <dt><br>" +
                        "      <img src=\"images/" + data[i].curl + "\"><br> " +
                        "<p> <span class=\"title\"><br>" +
                        " <strong>" + data[i].cname + "</strong><br>" +
                        "</span><br>" +
                        " <span class=\"cprice\">" + data[i].cprice + "</span><br>" +
                        " <span class=\"inventory\">" + data[i].inventory + "</span><br>" +
                        "</p>" +
                        "<dd><br>" +
                        " <button class=\"button\" onclick='addGoods(" + data[i].cid + "," + data[i].cprice + ")'>添加商品</button><br>" +
                        "</dd> <br>" +
                        "</dl>"
                }
            },
        })
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
