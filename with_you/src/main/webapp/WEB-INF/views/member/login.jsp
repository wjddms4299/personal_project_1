<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form name="login" action="login.do" method="post">
  <fieldset>
   <legend>Login</legend>
    <table align="center">
     <tr>
      <td>ID</td> <td><input type="text" name="userid" placeholder="아이디" value="${cookie.saveid.value}"></td>
     </tr>
     <tr>
      <td>PW</td> <td><input type="password" name="userpwd" placeholder="비밀번호"></td>
     </tr>
     <tr>
      <td colspan="2" align="center">
      <input type="checkbox" name="saveid" value="on" ${empty cookie.saveid.value?'':'checked'}>ID 기억하기
      <input type="submit" value="login"></td>
     </tr>
    </table>
  </fieldset>
 </form>
</body>
</html>