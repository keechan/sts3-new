<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>글 쓰 기</h1>
		<hr>
		<form action="insertBoard.do" >
		<table border=1>
		<tr><td>제목</td><td><input type=text name="title"></td></tr>
		<tr><td>글쓴이</td><td><input type=text name="writer"></td></tr>
		<tr><td>내용</td><td><textarea rows="5" cols="40" name="content"></textarea></td></tr>
		<tr>
			<td colspan=2 align="center">
			<input type=submit value="등록">
			</td>
		</tr>
		</table>
		</form>
		<hr>
	</div>	
</body>
</html>