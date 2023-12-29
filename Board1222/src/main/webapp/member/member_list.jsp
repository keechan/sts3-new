<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:import url="/include/top.jsp" />
<style>

</style>
<section>
	<br>
	<div align="center">
		<h1>회원목록보기</h1>
		<hr>
		<table border=1>
			<tr>
				<td>번호</td>
				<td>회원번호</td>
				<td>이름</td>
				<td>전화번호</td>
				<td>등급</td>
			</tr>

			<c:forEach items="${li}" var="m" varStatus="status">
				<tr>
					<td class="td1">${status.count}</td>
                    <td class="td1">${m.memberid}</td>
                    <td class="td1">${m.name}</td>
                    <td class="td1">${m.phone}</td>
                    <td class="td1">${m.grade}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</section>
<br>
<c:import url="/include/bottom.jsp" />