<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:import url="/include/top.jsp" />
<style>
.td1 {
	text-align: center;
}

.tr1 {
	text-align: center;
}

table {
	width: 500px;
	height: 150px;
}
</style>

<section>
	<br>
	<div align="center">

		<h2>자료실 상세/수정</h2>
		<form action="psdUpdateOK.do" enctype="multipart/form-data"
			method="post">
			<table border=1>
				<tr>
					<td width=150 align="center">번호</td>
					<td width=300><input type=text name=seq size=30
						value="${m.seq}" readonly></td>
					<td rowspan=3><img src=${path}/psd/img/${m.uploadFileStr}
						width=130 height=100 /></td>
				</tr>
				<tr>
					<td align="center">제목</td>
					<td><input type=text name=title size=30 value="${m.title}">
					</td>
				</tr>

				<tr>
					<td align="center">날짜</td>
					<td>${m.regDate}</td>
				</tr>
				<tr>
					<td align="center">조회수</td>
					<td colspan=2>${m.cnt}</td>
				</tr>

				<tr>
					<td align="center">첨부자료</td>
					<td colspan=2><input type=file name=uploadFile></td>
				</tr>

				<tr>
					<td colspan=3 align="center"><input type=submit value="수정하기">
					</td>
				</tr>
			</table>
		</form>

	</div>
	<br />
</section>
<c:import url="/include/bottom.jsp" />