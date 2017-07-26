<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div type="background-color:#ff00cc">
			<table>
				<tr><td>用户名</td><td>${sessionScope.adminName }</td></tr>
				<tr><td>用户id</td><td>${sessionScope.adminId }</td></tr>
				<tr><td>查询数据</td><td><a href="./SelectPrivateOBServlet?obpage=1">点这里</a></td></tr>
			</table>
		</div>
	</div>
</body>
</html>