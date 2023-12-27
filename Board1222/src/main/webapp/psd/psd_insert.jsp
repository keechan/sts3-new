<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:import url="/include/top.jsp" />
<style>
table {
	width: 400px;
	height: 150px;
}
</style>
<section>
	<br>
	<div align="center">
		<h2>자료실 입력</h2>
		<form action="psdInsertOK.do" enctype="multipart/form-data" method="post">
			<table border=1>
				<tr>
					<td align="center">제목</td>
					<td><input type="text" name="title" size=30/></td>
				</tr>
				<tr>
					<td align="center">첨부자료</td>
					<td><input type="file" name="uploadFile"></td>
				</tr>
				<tr>
					<td colspan=2 align="center"><input type=submit value="저장하기">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>
<c:import url="/include/bottom.jsp" />