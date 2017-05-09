<%@page import="javax.imageio.ImageIO"%>
<%@page import="com.px.util.VaildateCodeUtil"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
response.setContentType("image/jpeg");
String[] codes={"豪情万丈","难以抉择","天下第一","闻鸡起舞","毛遂自荐"};
String code=codes[new Random().nextInt(4)];
BufferedImage buf=VaildateCodeUtil.getVaildateCode(code);
session.setAttribute("vailcode", code);
out.clear();
out=pageContext.pushBody();
ImageIO.write(buf, "jpeg", response.getOutputStream());
%>

