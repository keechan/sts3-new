<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:import url="/include/top.jsp" />
<style>
	table {
		width: 500px;
	}
</style>
<section>
	<br>
	<div align="center">
		<h1>목록보기</h1>
		<hr>
		<table border=1>
			<tr>
				<td>학번</td>
				<td>성명</td>
				<td>국어</td>
				<td>영어</td>
				<td>수학</td>
				<td>역사</td>
			</tr>

			<c:forEach items="${li}" var="m">
				<tr>
					<td>${m.getSno()}</td>
					<td>${m.getSname() }</td>
					<td>${m.getKor()}</td>
					<td>${m.getEng()}</td>
					<td>${m.getMath()}</td>
					<td>${m.getHist()}</td>
				</tr>
			</c:forEach>
		</table>
		<form action="examList.do">
			<select name="ch1">
				<option value=sno>학번</option>
				<option value=sname>이름</option>
			</select>
			<input type=text name="ch2">
			<input type=submit value="검색하기">			
		</form>
	</div>
</section>
<br>
<c:import url="/include/bottom.jsp" />