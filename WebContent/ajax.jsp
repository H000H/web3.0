<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js">
</script>
</head>
<body>
<!--  <script type="text/javascript">
	function test(){
		var xmlHttp;
		 xmlHttp=getXhr();
		 var url="AjaxTestServlet";
		 xmlHttp.open("POST",url,true);
		 xmlHttp.send(null);
		 xmlHttp.onreadystatechange = function(){
       　	 if(xmlHttp.readyState == 4&&xmlHttp.status == 200){
    　　　　　 　var data = xmlHttp.responseText;
    　　　　　　 alert(data);
        　　 }  
       };
	}
	function getXhr(){
	     var xhr = null;
	      if(window.XMLHttpRequest){
	          xhr = new XMLHttpRequest();
	      }else{
	        xhr = new ActiveXObject('Microsoft.XMLHttp');
	      }
	      return xhr;
	} 
</script> -->
<div id="table">
<script type="text/javascript">
	function test(){
		$.post("AjaxTestServlet",null,function call(data){
			var str="";
			str="<table border=\"1\"><tr><td>姓名</td><td>id</td></tr>";
			 $.each(data,function(index,item){
				str+="<tr><td>" +item.name+"</td><td>" +item.id+"</td></tr>";
			});  
			str+="</table>";
			$("#table").html(str);
		},"json");
		
	}
</script>
</div>
<button onclick="test()">sss</button>
</body>
</html>