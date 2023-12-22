<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:import url="/include/top.jsp" />
<style>

</style>
<section>
	<br>
	<div align="center">
		<h1>목록보기</h1>
		<hr>
		<table border=1>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>등록일</td>
				<td>조회수</td>
			</tr>

			<c:forEach items="${li}" var="m">
				<tr>
					<td>&nbsp;${m.getSeq()}</td>
					<td><a href="boardEdit.do?seq=${m.getSeq() }">&nbsp;${m.getTitle() }</a></td>
					<td>${m.getWriter()}</td>
					<td>${m.getRegDate()}</td>
					<td><a href="boardDelete.do?seq=${m.getSeq()}">${m.getCnt()}</a></td>
				</tr>
			</c:forEach>
		</table>
		<form action="boardGetBoardList.do">
			<select name="ch1">
				<option value="title">제목</option>
				<option value="writer">글쓴이</option>
			</select>
			<input type=text name="ch2">
			<input type=submit value="검색하기">
		</form>
	</div>
</section>
<br>
<c:import url="/include/bottom.jsp" />