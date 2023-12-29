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
<script>
	function listK() {
		location.href="${path}/productList.do";
	}
	function delK(k, str) {		
		str = encodeURI(encodeURIComponent(str));
		//alert("삭제확인"+k+", "+str);
		//alert("${path}/productDelete.do?product_id="+k+"&product_imgStr="+str);
		//첨부파일명을 인코딩하여 넘기기
		location.href="${path}/productDelete.do?product_id="+k+"&product_imgStr="+str;
	}
	function buyK(pid, mid) {
		var amount = f1.amount.value;
		alert(pid+":" +amount +"/"+mid);
		location.href="${path}/ShopBuy.do?product_id="+k+"&amount="+amount+"&memberid="+mid;	
	}
</script>
<section>
	<br>
	<div align="center">
		<h2>상품 상세/수정</h2>
		<form name=f1 action="productUpdateOK.do" enctype="multipart/form-data" method="post">
			<table border=1>
				<tr>
					<td width=150 align="center">상품번호</td>
					<td width=300><input type=text name=product_id size=30
						value="${m.product_id}" readonly></td>					
					<td rowspan=4><img src="${path}/shop/img/${m.product_imgStr}" width=130 height=100 /></td>
				</tr>
				<tr>
					<td align="center">상품명</td>
					<td><input type=text name=product_name size=30 value="${m.product_name}">
					</td>
				</tr>
				<tr>
					<td align="center">상품가격</td>
					<td><input type=text name=product_price size=30 value="${m.product_price}"></td>
				</tr>
				<tr>
					<td align="center">수량</td>
					<td>
						<select name="amount">
							<option value=1>1개</option>
							<option value=1>2개</option>
							<option value=1>3개</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="center">상품특징</td>
					<td colspan=2><textarea cols=50 rows=5 name="product_desc">${m.product_desc}</textarea></td>
				</tr>

				<tr>
					<td align="center">첨부자료</td>
					<td colspan=2><input type=file name=product_img></td>
				</tr>

				<tr>
					<td colspan=3 align="center"><input type=button value="상품구매" 
					                              onClick="buyK('${m.product_id}', '${sessionMemberId}')">&nbsp;
					                             <input type=submit value="수정하기">&nbsp;
					                             <input type=button value="목록보기" onClick="listK()">&nbsp;
					                             <input type=submit value="삭제하기" onClick="delK('${m.product_id}', '${m.product_imgStr}')">
					</td>
				</tr>
			</table>
		</form>

	</div>
	<br />
</section>
<c:import url="/include/bottom.jsp" />