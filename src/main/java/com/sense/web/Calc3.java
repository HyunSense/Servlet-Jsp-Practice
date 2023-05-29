package com.sense.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();

		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");

		String exp = "";
		if(cookies != null) // 쿠키가 null이 아닐경우
			for(Cookie c : cookies) {
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		
		
		if(operator != null && operator.equals("=")) {
//			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
//			try {
//				exp = String.valueOf(engine.eval(exp));
//			} catch (ScriptException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("graal.js");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				e.printStackTrace();
			}
			
		// 쿠키삭제
		}else if(operator != null && operator.equals("C")){
			exp="";
		}
		else{
		exp += (value == null)? "" : value;
		exp += (operator == null)? "" : operator;
		exp += (dot == null)? "" : dot;
		}
		
		Cookie expCookie = new Cookie("exp", exp);
		if(operator != null && operator.equals("C")){
			expCookie.setMaxAge(0);
		}
		response.addCookie(expCookie);
		response.sendRedirect("/calcpage"); // 경로가 같기때문에 경로를 생략할 수 있다.
		
	

	}

}
