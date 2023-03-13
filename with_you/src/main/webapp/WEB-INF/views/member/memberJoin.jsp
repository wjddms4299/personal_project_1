<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function popup_open(){
	window.open('idCheck.do','idCheck','width=550, height=300, top=100, left=300');
}
</script>
</head>
<body>
<form name="memberJoin" action="memberJoin.do" method="post">
<fieldset>
	<legend>회원가입</legend>
	<ul>
		<li><lable>아이디</lable> <input type="text" name="id" readonly>
			<input type="button" value="중복검사" onclick="popup_open();"></li>
		<li><lable>이름</lable> <input type="text" name="name"></li>
		<li><lable>비밀번호</lable> <input type="text" name="pwd"></li>
		<li><lable>이메일</lable> <input type="text" name="email"></li>
		<li><lable>전화번호</lable> <input type="text" name="tel"></li>
		<li><lable>주소</lable> <input type="text" name="addr"></li>
	</ul>
	<div><input type="submit" value="회원가입"></div>
</fieldset>
</form>
</body>
</html>