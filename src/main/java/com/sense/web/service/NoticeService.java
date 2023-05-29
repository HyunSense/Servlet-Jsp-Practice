package com.sense.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sense.web.entity.Notice;

public class NoticeService {
	
	public List<Notice> getNoticeList(){
		return getNoticeList("title", "", 1);
	}
	
	public List<Notice> getNoticeList(int page){
		
		
		return getNoticeList("title", "", page);
	}
	
	public List<Notice> getNoticeList(String field, String query, int page){
		
		List<Notice> list = new ArrayList<>();
//		String sql = "SELECT * FROM NOTICE ORDER BY ID DESC LIMIT ?,5"; // OFFSET 5 간격으로 5줄씩
		String sql = "SELECT * FROM NOTICE WHERE " + field + " LIKE ? ORDER BY ID DESC LIMIT ?,5";
		
		String url = "jdbc:mysql://localhost/JDBC?serverTimezone=UTC";
		String mysqlId = "root";
		String pw = "0000"; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, mysqlId, pw);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, "%" + query + "%");
			st.setInt(2, 5*(page-1));
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
			
			int nid = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("Writer_ID");
			Date reg = rs.getDate("REGDATE");
			int hit = rs.getInt("HIT");
			
			Notice notice = new Notice(nid, title, writerId, reg, hit);
			list.add(notice);
			
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
		
		return list;
	}
	
	public int getNoticeCount() {
		return getNoticeCount("title", "");
	}
	
	public int getNoticeCount(String field, String query) {
		
		String sql = "SELECT COUNT(*) AS COUNT FROM NOTICE WHERE " + field + " LIKE ?";
		
		String url = "jdbc:mysql://localhost/JDBC?serverTimezone=UTC";
		String mysqlId = "root";
		String pw = "0000"; 
		
		int count = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, mysqlId, pw);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, "%" + query + "%");
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				
			count = rs.getInt("COUNT");
			
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
		
		return count;
	}
	
	public Notice getNotice(int id) {
		
		String url = "jdbc:mysql://localhost/JDBC?serverTimezone=UTC";
		String mysqlId = "root";
		String pw = "0000"; 


		String sql = "SELECT * FROM NOTICE WHERE ID=?";
		Notice notice = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, mysqlId, pw);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {

			int nid = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("Writer_ID");
			Date reg = rs.getDate("REGDATE");
			int hit = rs.getInt("HIT");
			String content = rs.getString("Content");
			String files = rs.getString("FILES");
			boolean pub = rs.getBoolean("PUB");
			
			notice = new Notice(nid, title, writerId, reg, hit, content, files, pub);
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
		
		return notice;
	}
	
	public Notice getNextNotice(int id) {
		
		String url = "jdbc:mysql://localhost/JDBC?serverTimezone=UTC";
		String mysqlId = "root";
		String pw = "0000"; 

		String sql = "SELECT * FROM NOTICE WHERE ID > ? ORDER BY ID ASC LIMIT 1";
		
		Notice notice = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, mysqlId, pw);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {

			int nid = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("Writer_ID");
			Date reg = rs.getDate("REGDATE");
			int hit = rs.getInt("HIT");
			String content = rs.getString("Content");
			String files = rs.getString("FILES");
			boolean pub = rs.getBoolean("PUB");
			
			notice = new Notice(nid, title, writerId, reg, hit, content, files, pub);
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
		
		return notice;
	}
	
	public Notice getPrevNotice(int id) {
		
		String url = "jdbc:mysql://localhost/JDBC?serverTimezone=UTC";
		String mysqlId = "root";
		String pw = "0000"; 

		String sql = "SELECT * FROM NOTICE WHERE ID < ? ORDER BY ID DESC LIMIT 1";
		
		Notice notice = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, mysqlId, pw);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {

			int nid = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("Writer_ID");
			Date reg = rs.getDate("REGDATE");
			int hit = rs.getInt("HIT");
			String content = rs.getString("Content");
			String files = rs.getString("FILES");
			boolean pub = rs.getBoolean("PUB");
			
			notice = new Notice(nid, title, writerId, reg, hit, content, files, pub);
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
		return notice;
	}
}
