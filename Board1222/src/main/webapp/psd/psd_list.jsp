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
		<h1>자료실목록보기</h1>
		<hr>
		<table border=1>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>날짜</td>
				<td>파일명</td>
				<td>이미지</td>
				<td>조회수</td>
			</tr>

			<c:forEach items="${li}" var="m">
				<tr>
					<td class="tr1">${m.getSeq()}</td>
					<td><a href=psdEdit.do?seq=${m.getSeq()}>${m.getTitle() }</a></td>
					<td>${m.getRegDate()}</td>
					<td>${m.getUploadFileStr()}</td>
					<td size=30><img src="${path}/psd/img/${m.getUploadFileStr()}" /></td>
					<td><a href="psdDelete.do?seq=${m.getSeq()}&uploadFileStr=${m.getUploadFileStr()}">${m.getCnt()}</a></td>
					<!-- 한글처리 
					<c:url var="url" value="psdDelete.do">
						<c:param name="seq">${m.getSeq() }</c:param>
						<c:param name="uploadFileStr">${m.getUploadFileStr() }</c:param>						
					</c:url>
					<a href="${url}">
						${m.getCnt() }
					</a>-->
				</tr>
			</c:forEach>
		</table>
	</div>
</section>
<br>
<c:import url="/include/bottom.jsp" />