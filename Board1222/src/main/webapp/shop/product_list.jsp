<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:import url="/include/top.jsp" />

<style>
	table {
		width: 600px;
	}
</style>
<section>
	<br>
	<div align="center">
		<h1>상품목록보기</h1>
		<hr>
		<table border=1>
			<tr>
				<td align=center>번호</td>
				<td align=center>상품명</td>
				<td align=center>가격</td>
				<td align=center>비고</td>
				<td align=center>이미지</td>
				<td align=center>파일명</td>
			</tr>

			<c:forEach items="${li}" var="m">
				<tr height=10>
					<td>${m.getProduct_id()}</td>
					<td><a href="productEdit.do?product_id=${m.getProduct_id()}">${m.getProduct_name()}</a></td>
					<td>${m.getProduct_price()}</td>
					<td>${m.getProduct_desc()}</td>
					<td>${m.product_imgStr}</td>
					<td align="center"><img src="${path}/shop/img/${m.product_imgStr}" height=100/></td>
				</tr>
			</c:forEach>
		</table>
		<form action="productList.do">
			<select name=ch1>
				<option value="product_name">상품명</option>
				<option value="product_desc">상품특징</option>
			</select>
			<input type="text" name="ch2">
			<input type=submit value="검색하기">
		</form>
	</div>
</section>
<br>
<c:import url="/include/bottom.jsp" />