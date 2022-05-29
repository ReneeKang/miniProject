<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
window.onload=function(){
	alert("글을 삭제하였습니다.");
	location.href='/miniProject/board/boardList.do?pg=${pg}';
}
</script>