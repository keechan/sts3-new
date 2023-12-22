<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:import url="/include/top.jsp" />
<section>
	<br>
	<div align="center">
		<h1>목록보기</h1>
		<hr>
		<form action="updateBoard.do">
			<input type=hidden name=seq value="${m.getSeq()}" />
			<table border=1>
				<tr>
					<td>제목</td>
					<td><input type=text name=title value="${m.getTitle() }"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type=text name=writer value="${m.getWriter()}"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows=5 cols=40 name=content>${m.getContent()}</textarea></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td><input type=text name=regdate value="${m.getRegDate()}">
					</td>
				</tr>
				<tr>
					<td>조회수</td>
					<td><input type=text name=cnt value="${m.getCnt()}"></td>
				</tr>
				<tr>
					<td colspan=2 align="center"><input type=submit value="수정하기">
					</td>
				</tr>
			</table>
		</form>
	</div>
</section>
<br>
<c:import url="/include/bottom.jsp" />