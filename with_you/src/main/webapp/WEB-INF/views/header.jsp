<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
<script>
function popup_open(){
	window.open('login.do','login','width=550, height=300, top=100, left=300');
}
</script>
<c:if test="${empty sessionScope.sid}">
	<div align="right"><a href="memberJoin.do">회원가입</a> | <a href='javascript:popup_open();'>로그인</a></div>
</c:if>
<c:if test="${!empty sessionScope.sid}">
	<div align="right">${sessionScope.sid}님 로그인중.. | <a href='logout.do'>로그아웃</a></div>
</c:if>

<h1 align="center">너 와 함 께</h1>
<br>
<hr width="1200">
<table width="1200" height="40" align="center">
	<tr>
		<th width="300">소 개</th>
		<th width="300">코스추천</th>
		<th width="300">예약하기</th>
		<th width="300">커뮤니티</th>
	</tr>
</table>
<hr width="1200">
</header>