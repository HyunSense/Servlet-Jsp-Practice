<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/detail.css">
    <title>Document</title>
</head>
<style>

</style>
<body>
    <table>
        <tr class="tableHead">
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>날짜</th>
            <th>조회수</th>
        </tr>
        <tr class="tableHead">
            <td>${b.nid}</td>
            <td>${b.title}</td>
            <td>${b.writerId}</td>
            <td>${b.reg}</td>
            <td>${b.hit}</td>
        </tr>
        <tr class="tableBody">
            <td>내용</td>
            <td colspan="4">${b.content}</td>
        </tr>
    </table>
</body>
</html>