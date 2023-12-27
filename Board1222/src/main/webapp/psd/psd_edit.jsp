<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:import url="/include/top.jsp" />
<style>
table {
	width: 500px;
	height: 150px;
}
</style>
<section>
	<br>
	<div align="center">
		<h2>자료실 수정</h2>
		<form action="psdUpdateOK.do" enctype="multipart/form-data" method="post">
			<table border=1>
				<tr>
					<td align="center" >번호</td>
					<td><input type="text" name="seq" size=20 value="${m.seq }"/></td>
					<td align="center" rowspan=3 size=30><img src="${path}/psd/img/${m.getUploadFileStr()}" /></td>
				</tr>
				<tr>
					<td align="center" >제목</td>
					<td><input type="text" name="title" size=20 value="${m.title}"/></td>
				</tr>				
				<tr>
					<td align="center">날짜</td>
					<td><input type="text" name="regDate" size=20 value="${m.regDate}"/></td>
				</tr>				
				<tr>
					<td align="center">조회수</td>
					<td colspan=3 ><input type="text" name="cnt" size=20 value="${m.cnt }"/></td>
				</tr>				
				<tr>
					<td align="center">첨부자료</td>
					<td colspan=3 ><input type="file" name="uploadFile"></td>
				</tr>
				<tr>
					<td colspan=3 align="center"><input type=submit value="수정하기">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>
<c:import url="/include/bottom.jsp" />