<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<script type="text/javascript">
window.onload=function(){
	alert("작성한 글 저장");
	location.href='/miniProject/board/boardList.do?pg=${pg}';
	
}
</script>