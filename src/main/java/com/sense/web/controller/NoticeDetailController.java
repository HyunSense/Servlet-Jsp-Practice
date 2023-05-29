package com.sense.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sense.web.entity.Board;
import com.sense.web.entity.Notice;
import com.sense.web.service.NoticeService;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noticeId = Integer.parseInt(request.getParameter("id"));
		NoticeService service = new NoticeService();
		
		Notice notice = service.getNotice(noticeId);
		Notice prevNotice = service.getPrevNotice(noticeId);
		Notice nextNotice = service.getNextNotice(noticeId);

		request.setAttribute("n", notice);
		request.setAttribute("prev", prevNotice);
		request.setAttribute("next", nextNotice);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/notice/detail.jsp");
		dispatcher.forward(request, response);
	}
}
