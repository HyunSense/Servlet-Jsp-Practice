<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
<head>
    <title>detail</title>
    <meta charset="UTF-8">
    <title>공지사항목록</title>
    <link href="/css2/customer/layout.css" type="text/css" rel="stylesheet" />

</head>

<body>	
	<main>
		<h2 class="main title"><a href="/notice/list" style="text-decoration: none;">공지사항</a></h2>
		
		<div class="breadcrumb">
			<h3 class="hidden">breadlet</h3>
			<ul>
				<li>home</li>
				<li>고객센터</li>
				<li>공지사항</li>
			</ul>
		</div>
		
		<div class="margin-top first">
			<h3 class="hidden">공지사항 내용</h3>
			<table class="table">
				<tbody>
					<tr>
						<th>제목</th>
						<td class="text-align-left text-indent text-strong text-orange" colspan="3">${n.title}</td>
					</tr>
					<tr>
						<th>작성일</th>
						<td class="text-align-left text-indent" colspan="3">
						<fmt:formatDate value="${n.reg}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${n.writerId}</td>
						<th>조회수</th>
						<td>${n.hit}</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="3" style="text-align:left;text-indent: 10px;">
						<c:forTokens var="fileName" items="${n.files}" delims="," varStatus="st">
						<c:set var="style" value=""/>
						<c:if test="${fn:endsWith(fileName, '.zip')}">
						<c:set var="style" value="font-weight: bold; color:blue;"/>
						</c:if>
							<a href="${fileName}" style="${style}">${fn:toUpperCase(fileName)}</a>
							<c:if test="${!st.last}">
							/
							</c:if>
						</c:forTokens>
						</td>
					</tr>
					<tr class="content">
						<td colspan="4">${n.content}</td>
					</tr>
				</tbody>
			</table>
		</div>
			
		<div class="margin-top text-align-center">
			<a class="btn btn-list" href="list">목록</a>
		</div>
			
		<div class="margin-top">
			<table class="table border-top-default">
				<tbody>
					
					<tr>
						<th>다음글</th>
						<c:if test="${empty next}">
						<td colspan="3"  class="text-align-left text-indent">다음글이 없습니다.</td>
						</c:if>
						<td colspan="3"  class="text-align-left text-indent">
						<a class="text-blue text-strong" href="?id=${next.nid}">${next.title}</a>
						</td>
					</tr>
					
					<tr>
						<th>이전글</th>
						<c:if test="${empty prev}">
						<td colspan="3"  class="text-align-left text-indent">이전글이 없습니다.</td>
						</c:if>
						<td colspan="3"  class="text-align-left text-indent">
						<a class="text-blue text-strong" href="?id=${prev.nid}">${prev.title}</a></td>
					</tr>
					
				</tbody>
			</table>
		</div>			
	</main>		
</body>
</html>