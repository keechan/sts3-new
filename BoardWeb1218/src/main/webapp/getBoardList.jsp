<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.spring.biz.board.*" %>
<%@ page import="com.spring.biz.board.impl.*" %>
<%@ page import="java.util.*" %>

<%
   BoardService service = new BoardServiceImpl();
   List<BoardVO> li = service.getBoardList();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>목록보기</h1>
<hr>
<table border=1>
<tr><td>번호</td><td>제목</td><td>작성자</td><td>등록일</td><td>조회수</td></tr>

	<%
		for (BoardVO m : li) { %>
		<tr><td><%=m.getSeq() %></td>
		<td><a href="getBoard.do?seq=<%=m.getSeq() %>"><%=m.getTitle() %></a>
		<td><%=m.getWriter() %></td>
		<td><%=m.getRegdate() %></td>
		<td><a href="deleteBoard.do?seq=<%=m.getSeq() %>"><%=m.getCnt() %></a>
		</td>
		
	<%	}
	%>
</table>
<a href=write.jsp>새글등록</a>
<hr>	
</div>
</body>
</html>