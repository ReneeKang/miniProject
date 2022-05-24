<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#failForm2 div{
	color:red;
	font-size: 8pt;
}
</style>
</head>
<body>


<form method="get" name="failForm" id="failForm" action="/miniProject/member/checkId.do">
	<h3>${userId} 는 <font color="red">사용 불가능</font>합니다.</h3>
	<br>
	<input type="text" name="id" id="userId">
	<div id="idDiv_checkFail"></div>
	<!-- 둘중에 선택 ㅋ 바로 걸든지 폼으로 서브밋 하던지 ㅋ  -->
	<!--  <input type="button" value="중복체크" onclick="#">  -->
	
	<input type="button" value="중복체크" onclick="isEmpty()"> 
	<!-- <input type="button" value="중복체크" onclick="submit()">  -->
	</form>
	
	
<script type="text/javascript">
function isEmpty(){
	if(document.failForm.id.value=="")
		document.getElementById("idDiv_checkFail").innerText="새로운 아이디 입력";
	else
		document.failForm.submit();
}
</script>	
</body>
</html>