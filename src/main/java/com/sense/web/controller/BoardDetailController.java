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

@WebServlet("/board/detail")
public class BoardDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noticeId = Integer.parseInt(request.getParameter("id"));

		String url = "jdbc:mysql://localhost/JDBC?serverTimezone=UTC";
		String id = "root";
		String pw = "0000"; 


		String sql = "SELECT * FROM NOTICE WHERE ID=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, id, pw);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, noticeId);
			ResultSet rs = st.executeQuery();
			rs.next();

			int nid = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("Writer_ID");
			Date reg = rs.getDate("REGDATE");
			int hit = rs.getInt("HIT");
			String content = rs.getString("Content");
			
			Board board = new Board(nid, title, writerId, reg, hit, content);
			
			request.setAttribute("b", board);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/board/detail.jsp");
			dispatcher.forward(request, response);

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
