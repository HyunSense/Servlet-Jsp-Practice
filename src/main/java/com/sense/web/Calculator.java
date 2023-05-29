package com.sense.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//html이 바뀌었을경우 서버를 재시작할 필요는 없다.
		//HttpMethod가 무엇으로 왔는지 체크, form의 Method가 넘어올때 대문자로 오기때문에 꼭 주의!!
		if(request.getMethod().equals("GET")) {
			System.out.println("GET 요청이 왔습니다.");
			
		}else if (request.getMethod().equals("POST")) {
			System.out.println("POST 요청이 왔습니다.");
		}
		
		
		super.service(request, response);		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPOST 메소드가 호출되었습니다.");
	}
}
