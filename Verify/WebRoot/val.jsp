<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String code=request.getParameter("code");
String sessionString=session.getAttribute("vailcode").toString();
if(code.equals(sessionString)){
	out.print("验证成功");
}else{
	out.print("验证失败");
}
%>


