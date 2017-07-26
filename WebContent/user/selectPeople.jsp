<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<div align="center" >
<div style="margin-top:100px">
	<div>
		<table>
		<tr>用户名：${sessionScope.adminName }</tr>
		<tr>用户id：${sessionScope.adminId }</tr>
		</table>
	</div>
	<table border="1" >
		<tr><td>货物名</td><td>货物数量</td><td>内容</td><td>尺寸</td><td>关联</td><td><label>user id</label></td><td><button value="删除" onclick=""></button></td></tr>
		<c:forEach items="${requestScope.OBlist }" var="oblist"  >
		<tr><td>${oblist.name}</td><td>${oblist.number}</td><td>${oblist.content}</td><td>${oblist.size}</td><td>${oblist.relation}</td><td>${oblist.id}</td></tr>
		</c:forEach><tr>
		<c:forEach  begin="1" end="${requestScope.allpages}"  var="number">		
			<c:if test="${number eq 1}"><td><a href="./SelectPrivateOBServlet?obpage=${number }">首页</a></td></c:if>
			<c:if test="${number eq requestScope.allpages}"><td><a href="./SelectPrivateOBServlet?obpage=${number }">尾页</a></td></c:if>
			<c:if test="${number ne 1 and number ne requestScope.allpages}"><td><a href="./SelectPrivateOBServlet?obpage=${number }">${number }</a></td></c:if>
		</c:forEach></tr>
	</table>
	
</div>
</div>
</body>
</html>