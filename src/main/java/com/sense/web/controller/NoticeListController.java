package com.sense.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sense.web.entity.Board;
import com.sense.web.entity.Notice;
import com.sense.web.service.NoticeService;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Notice> list = new ArrayList<>();
		NoticeService service = new NoticeService();
		int page = 1;
		
		
		String page_ = request.getParameter("p");
		if(page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		
		list = service.getNoticeList(page);
		int count = service.getNoticeCount();
		
		String field = request.getParameter("f");
		String query = request.getParameter("q");
		
		if(field != null && !field.equals("") || query != null && !query.equals("")) {
			list = service.getNoticeList(field, query, page);
			count = service.getNoticeCount(field, query);
		}
		
		
//		request.setAttribute("field", field);
//		request.setAttribute("query", query);
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/notice/list.jsp");
		dispatcher.forward(request, response);
		
	}
}
