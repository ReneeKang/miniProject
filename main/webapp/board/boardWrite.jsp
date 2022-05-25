<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글등록완료페이지</title>
<style>
h2{
	padding:10px;
}
</style>
</head>
<body>


<c:if test="${requestScope.su==1 }">
	<h2>작성하신 글을 저장하였습니다</h2>
<!-- 	 <button type="button" onclick="location.href='./boardList.do'">목록</button>-->	
<input type="button" value="목록" style="margin:5px;" onclick="location.href='/miniProject/board/boardList.do?pg=1'"> 
</c:if>						

<c:if test="${requestScope.su==0 }">
	<h2>게시물 등록에 실패하였습니다.</h2>
</c:if>

<!-- 
<script>
window.onload=function(){
	alert("작성한글 저장완료~");
	/* location.href='/miniProject/board/boardList.do'; */
}
</script>
 -->

	
</body>
</html>