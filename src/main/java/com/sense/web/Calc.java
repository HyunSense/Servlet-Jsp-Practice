package com.sense.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc")
public class Calc extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext application = request.getServletContext();
		HttpSession  session = request.getSession();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;
		if(!v_.equals(""))
			v = Integer.parseInt(v_);
		
		if(op.equals("=")) {
			
//			int x = (Integer)application.getAttribute("value");
			int x = (Integer)session.getAttribute("value");
			int y = v;
//			String oper = (String)application.getAttribute("op");
			String oper = (String)session.getAttribute("op");
			int result = 0;
			
			if(oper.equals("+"))
				result = x + y;
			else
				result = x - y;
			
			System.out.println("result = " + result);
			PrintWriter out = response.getWriter();
			out.println("계산 결과값은 " + result + "입니다.");
			
		}else{
//			application.setAttribute("value", v);
//			application.setAttribute("op", op);
			session.setAttribute("value", v);
			session.setAttribute("op", op);
		}
	}
}
