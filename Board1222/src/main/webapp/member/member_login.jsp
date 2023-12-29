<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:import url="/include/top.jsp" />
<style>
table {
	width: 350px;
	height: 100px;
}
</style>
<section>
	<br>
	<div align="center">
		<h2>로그인</h2>
		<form action="memberLogin.do" method="POST">
			<table border=1>
				<tr>
					<td>회원번호</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pwd" /></td>
				</tr>
				<tr>
					<td colspan=2 align="center"><input type=submit value="로그인">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>
<c:import url="/include/bottom.jsp" />