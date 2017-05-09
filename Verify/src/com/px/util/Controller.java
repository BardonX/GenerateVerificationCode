package com.px.util;

import java.io.IOException;

import javax.enterprise.inject.New;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String code=req.getParameter("code");
		HttpSession session=req.getSession();
		String sessionString=session.getAttribute("vailcode").toString();
		if(code.equals(sessionString)){
			resp.getWriter().print("验证成功");
		}else{
			resp.getWriter().print("验证失败");
		}
	}
	
	

}
