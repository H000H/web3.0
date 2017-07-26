<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<div align="center" >
	<div style="margin-top:100px">
		<img alt="iaho" src="image/user1.jpg" width="400px" height="300px">
	</div>
	
	<div style="margin-top:20px;">
	<form method="post" action="/web3.0/LoginServlet">
		姓名 : <input type="text" name="id"><br>
		密码 : <input type="password" name="password"><br>
		<input type="reset" value="重置" >
		<input type="submit" value="登陆" >
	</form>
	</div>
</div>
</body>
</html>