<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Java开发企业级验证码</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
	    *{margin:0;}
	    /*box Start*/
	    .box{text-align: center; width: 300px; background: #fff; margin: 200px auto;box-shadow: 0px 0px 8px #000; border-radius: 4px;}
	    .box .btn{width: 150px;height: 30px;}
	    .box .sub{ width: 200px;height: 30px;}
	    /*box End */
	
	</style>
  </head>
  
  <body>
    <!-- box Start -->
    <div class="box">
         <input type="text" class="btn" placeholder="请输入验证码" id="code"/>
         <img alt="" src="vailCode.jsp">
         <p><input type="button" value="提交" class="sub" onclick="vailCode()">
    </div>
    <!-- box End --> 
   
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
       function vailCode(){
    	   var code =$("#code").val();
    	   $.ajax({
    		   type:"post",
    		   url:"val.jsp",
    		  // url:"controller",
    		   data:{"code":code},
    		   success:function(message){
    			   alert(message);
    		   }
    	   });
       }
    </script>
    
  </body>
</html>
