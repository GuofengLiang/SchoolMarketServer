<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>校园便利店</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">
    <link href="css/ziti.css" rel="stylesheet">
	<%
    String base = request.getContextPath();
    String captchaId = UUID.randomUUID().toString();
    %>
  </head>
  
  <body>
    <div class="row">
        <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="panel panel-default"  style="vertical-align:middle;" >
            <div class="panel-heading glyphicon glyphicon-user">
                <span style="font-weight: 600;font-family: 'Microsoft YaHei'">&nbsp;&nbsp;登陆</span>
            </div>
            <div class="panel-body">
                <form role="form">
                    <fieldset>
                        <div class="form-group">
                            <input data-placement="right"
                                   class="form-control popover-show1" placeholder="账号" id="adminName" type="email"  autofocus="">
                        </div>
                        <div class="form-group">
                            <input class="form-control popover-show2" data-placement="right"
                                   placeholder="请输入密码" id="password" type="password">
                        </div>

                        <div class="row" >
                            <div class="col-md-5">
                                <span class="btn btn-primary" id="btnLogin">登陆</span>
                            </div>
                            <div class="col-md-4" style="line-height: 40px">
                                <input class="form-control popover-show3" data-placement="bottom"
                                       id="validator" placeholder="验证码">
                            </div>
                            <div class="col-md-0"style="line-height: 28px">
                                <img class="img-rounded" id="imgValidate" title="看不清，点击换一张" src="captcha.jhtml?captchaId=<%=captchaId%>" align="absbottom" style="width: 80px;height: 33px;cursor:hand">
                            </div>
                        </div>

                    </fieldset>
                </form>
            </div>
        </div>
    </div>
  </div>
  </body>
  <script src="js/jquery-1.11.1.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script type="text/javascript" language="javascript">

    function Isvalid() {
        if ($("#adminName").val() == "") {
            alert("用户名不能为空");
            return false;
        }
        if ($("#password").val() == "") {
             alert("密码不能为空");
            $("#password").focus();
            return false;
        }
        if ($("#validator").val() == "") {
             alert("验证码不能为空");
            $("#validator").focus();
            return false;
        }
        return true;
    }

    jQuery(function ($) {

        $("#btnLogin").click(function () {
            if(Isvalid()){
                $.ajax({
                    type: "POST",
                    dataType:"json",
                    url: "<%=base%>/login.jhtml?captchaId=<%=captchaId%>",
                    data: {adminName:$("#adminName").val(),password:$("#password").val(),validator:$("#validator").val()},
                    success:function(data){
                    if(data.message!="success"){
                       $("#imgValidate").attr("src", "captcha.jhtml?captchaId=<%=captchaId%>&timestamp=" + (new Date()).valueOf());
                      if(data.message=="codeError"){            
                       alert("验证码错误");
                       }
                       else if(data.message=="adminError"){            
                       alert("登陆账号错误");
                       }
                       else if(data.message=="passwordError"){            
                       alert("密码错误");
                       }                
                 }else{
                        window.location.href="<%=base%>/managecomm.html"
                    }  
                    }
                });
            }
        });
    });
    // 更换验证码
    $("#imgValidate").click( function() {
        $("#imgValidate").attr("src", "captcha.jhtml?captchaId=<%=captchaId%>&timestamp=" + (new Date()).valueOf());
    });

</script>
</html>
