<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${requestScope.userId} 는 <font color="blue">사용 가능</font>합니다.</h3>
	
	<input type="button" value="사용하기" onclick="checkIdClose('${requestScope.userId}')">
									<%--checkIdClose(뭘 넘길까요 ?) 
									찾아놓은아이디 넘겨야함 ㅋ--%>
									<%-- 자바스크립트는 숫자
									'문자' "문자"  뒤에 공백안넘어가게 잘..신경쓰기 --%>
<script type="text/javascript">
function checkIdClose(userId){
	//데이터 전달
	
	
	//window.opener.document.writeForm.id.value=id;
	opener.document.writeForm2.id.value=userId;
	//opener.document.getElementById("   ")=id;
	
	//창닫기
	window.close();
	//포커스
	//window.opener.document.writeForm2.pwd.focus();
	opener.document.writeForm2.pwd.focus();
	
}

</script>
</body>
</html>