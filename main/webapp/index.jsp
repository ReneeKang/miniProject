<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<style type="text/css">
body{
	margin:0 auto;
	padding:0;
	height:100%;
	width:auto;    <%--브라우저에 가운데로 와라~ --%>
	
}

#header{
	width:1500px;
 	margin-left:30px;
	margin-right:30px; 
	/* margin:0 auto; */
	/* width:1000px; */
	height:10%;
	text-align:center;  /* 이게 지금 header가 가운데로옴....*/
	/*background: yellow;*/
}


#container{
	/*margin:auto;  */
	width:1500px;
	/* margin-left:30px;
	pargin-right:30px; */ 
	height:800px;
/* 	background: gray; */
 
}

#container:after{
	content:'';
	display:block;
	clear:both;
	float:none;
	
}

#nav{
	margin-left:10px;
	/* width: 1700px*/
	width:28%;
	height:100%;
	float:left;
	background:white;
}
#section{
	width:70%;
	height:100%;
	float:left;
	/* background: #FFFBDB; */
} 

#footer{
	width:1500px;
	height:10%;
	
}




</style>
</head>
<body>
	<div id="header">
		<h1>
			<img src="/miniProject/image/ch4.gif" onclick="location.href='/miniProject/index.jsp'" style="cursor:pointer;" width="70" height="70" alt="춘식이"></a>MVC를 이용한 미니 프로젝트
		</h1>
		<br>
		<jsp:include page="./main/menu.jsp"></jsp:include>
	</div>
	<div id="container">
		<div id="nav">
			<jsp:include page="/main/nav.jsp"></jsp:include>
		</div>
			
			
		<!-- <div id="section"></div> -->
		
		<div id="section">
			<c:if test="${empty display }">
				<h2>Welcome, 홈페이지 방문해주셔서 감사합니다.<br>
					Have a nice day!!<br>
					<img src="/miniProject/image/ch3.gif" width="50" height="50" alt="츈식이">
				</h2>
			</c:if>
			
			<c:if test="${not empty display }">
				<jsp:include page="${display }"/>
			</c:if>
		</div> 
		
		
	
	</div>
	<div id="footer">
		<p>비트캠프</p>
	</div>
	
	
	
</body>
</html>