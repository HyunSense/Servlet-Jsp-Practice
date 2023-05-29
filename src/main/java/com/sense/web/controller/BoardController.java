package com.sense.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sense.web.entity.Board;

@WebServlet("/board/list")
public class BoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Board> list = new ArrayList<>();
		String url = "jdbc:mysql://localhost/JDBC?serverTimezone=UTC";
		String id = "root";
		String pw = "0000"; 

		String sql = "SELECT * FROM NOTICE ORDER BY ID DESC";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, id, pw);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			
			while(rs.next()) {
			
			int nid = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("Writer_ID");
			Date reg = rs.getDate("REGDATE");
			int hit = rs.getInt("HIT");
			String content = rs.getString("content");
			
			Board board = new Board(nid, title, writerId, reg, hit, content);
			list.add(board);
			
			}
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
		
		
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/board/board.jsp");
		dispatcher.forward(request, response);
		
	}
}
