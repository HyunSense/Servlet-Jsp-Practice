<%@page import="com.sense.web.entity.Board"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/board.css">
    <title>Document</title>
</head>

<body>
	<table>
	    <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>날짜</th>
	        <th>조회수</th>
	    </tr>
<%-- 	    <%
	    List<Board> list = (List<Board>)request.getAttribute("list");
	    for(Board b : list){
	    	pageContext.setAttribute("b", b);
	    %> --%>
	    <c:forEach var="b" items="${list}">
	    <tr class="notice">
	        <td>${b.nid}</td>
	        <td><a href="detail?id=${b.nid}">${b.title}</a></td>
	        <td>${b.writerId}</td>
	        <td>${b.reg}</td>
	        <td>${b.hit}</td>
	    </tr>
	    </c:forEach>
	   <%-- <%} %> --%>
	</table>
</body>
</html>