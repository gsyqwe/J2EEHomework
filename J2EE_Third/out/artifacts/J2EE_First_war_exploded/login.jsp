<%@ page import="servlets.ShoppingServlet" %><%--
登陆注册界面
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
  String path  = request.getContextPath();
%>
<html>
<head>
</head>
<body>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<%--
  实现登陆和注册的切换
  --%>
<div class="bg">
  <div style="width: 100%;text-align: center;">
    <h1>购物平台</h1>
  </div>

  <div class="login" style="margin-top:50px;">

    <div class="header">
      <div class="switch" id="switch">
        <a class="switch_btn_focus" id="switch_qlogin"  tabindex="7" >快速登录</a>
        <a class="switch_btn" id="switch_login"  tabindex="8">快速注册</a>
        <div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
      </div>
    </div>


    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">

      <!--登录-->
      <div class="web_login" id="web_login">


        <div class="login-box">


          <div class="login_form">
            <form action="/Login" method="post" onsubmit="return verify();">
            <div class="uinArea" id="uinArea">
              <label class="input-tips" for="u">帐号：</label>
              <div class="inputOuter" id="uArea">
                <input type="text" id="u" name="username"  class="inputstyle"/>
              </div>
            </div>
            <div class="pwdArea" id="pwdArea">
              <label class="input-tips" for="p" >密码：</label>
              <div class="inputOuter" id="pArea">

                <input type="password" id="p" name="userpassword" class="inputstyle"/>
              </div>
            </div>
              <input type="hidden" id="h" name="flag" value="login">

            <div style="padding-left:50px;margin-top:20px;">
              <input type="submit" class="button_blue" style="width:150px;color: white;text-align: center;"  value="登录">
            </div>
            </form>
          </div>

        </div>

      </div>
    </div>

    <!--注册-->
    <div  id="qlogin" style="display:none; ">

      <div class="web_login">
        <form action="/Login" method="post"  onsubmit="return check();">
        <input type="hidden" name="to" value="reg"/>
        <input type="hidden" name="did" value="0"/>
        <input type="hidden" name="flag" value="register"/>
        <ul class="reg_form" id="reg-ul">
          <li>
            <label for="user"  class="input-tips2">账号：</label>
            <div class="inputOuter2">
              <input type="text" id="account" name="account" maxlength="16" class="inputstyle2"/>
            </div>

          </li>

          <li>
            <label for="user"  class="input-tips2">用户名：</label>
            <div class="inputOuter2">
              <input type="text" id="user" name="user" maxlength="16" class="inputstyle2"/>
            </div>

          </li>

          <li>
            <label for="passwd" class="input-tips2">密码：</label>
            <div class="inputOuter2">
              <input type="password" id="passwd"  name="password" maxlength="16" class="inputstyle2"/>
            </div>

          </li>
          <li>
            <label for="passwd2" class="input-tips2">确认密码：</label>
            <div class="inputOuter2">
              <input type="password" id="passwd2" name="pass" maxlength="16" class="inputstyle2" />
            </div>

          </li>
          <li>
            <div class="inputArea">
              <input type="submit" id="reg" style="margin-top:10px;margin-left:85px;" class="button_blue" value="同意协议并注册"/> <a  class="zcxy" target="_blank">注册协议</a>
            </div>

          </li><div class="cl"></div>
        </ul>
        </form>
      </div>
    </div>
  </div>
</div>

</body>
<script src="js/jquery-1.9.0.min.js">
</script>
<script >
  <%--处理登陆与注册的切换--%>
    $(function() {
        $('#switch_qlogin').click(function () {
            $('#switch_login').removeClass("switch_btn_focus").addClass('switch_btn');
            $('#switch_qlogin').removeClass("switch_btn").addClass('switch_btn_focus');
            $('#switch_bottom').animate({left: '0px', width: '70px'});
            $('#qlogin').css('display', 'none');
            $('#web_qr_login').css('display', 'block');
        });
        $('#switch_login').click(function () {
            $('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
            $('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
            $('#switch_bottom').animate({left: '154px', width: '70px'});
            $('#qlogin').css('display', 'block');
            $('#web_qr_login').css('display', 'none');
        });
        if(getParam("a")=='0')
        {
            $('#switch_login').trigger('click');
        }

    });

    //注册前的检查，确保输入正确
    function check(){
        var name=$("#user").val()
        var account=$("#account").val()
        var pass1=$("#passwd").val()
        var pass2=$("#passwd2").val()
        if(name.length<2){
            alert("用户名不能为空且长度不能小于2")
            $("#user").val("")
            return false;
        }else{
            if(account.length<4){
                alert("账号不能为空且长度不能小于4")
                $("#account").val("")
                return false;
            }else{
                if (pass1.length<6){
                    alert("密码不能为空且长度不能小于6")
                    $("#passwd").val("")
                    $("#passwd2").val("")
                    return false;
                }else if(pass1!=pass2){
                    $("#passwd").val("")
                    $("#passwd2").val("")
                    alert("2次密码不一致")
                    return false;
                }
            }
        }
        return true;
    }

    //登陆前的检查
    function verify(){
        var name=$("#u").val()
        var passwd=$("#p").val()
        if(name==""){
            alert("用户名不能为空")
            return false;
        }else if(passwd==""){
            alert("密码不能为空")
            return false;
        }
        return true;
    }

  <%--处理从后端传递数据后的跳转--%>
  <jsp:useBean id="result" class="java.lang.String" scope="session"  ></jsp:useBean>
  <jsp:useBean id="flag" class="java.lang.String" scope="session"  ></jsp:useBean>
  <jsp:useBean id="login" class="java.lang.String" scope="session"  ></jsp:useBean>
  <%
    //注册
    if(flag.equals("register")){
        if(result.equals("true")){//成功
          //转去登陆界面
          response.sendRedirect(request.getContextPath() +"login.jsp");
        }else if (result.equals("false")){//失败
         %> alert("注册失败,用户名或账号已经被注册");
            $("#user").val("")
            $("#account").val("")
            $("#passwd").val("")
            $("#passwd2").val("")
  <%
          }
      }else if (flag.equals("login")){//登陆
        if(result.equals("true")){//登陆成功
        response.sendRedirect(request.getContextPath() +"Pick.jsp");
          %>
  <%
        }else if(result.equals("false")){//登陆失败
         %> alert("登录失败,账号或密码不存在");
            $("#u").val("")
            $("#p").val("")
  <%
          }
        }
      %>
</script>
</html>