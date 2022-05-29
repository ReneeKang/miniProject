<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
<style>

.boardWrite_title{
	margin-left:20px;
	margin-top:60px;
	margin-bottom:40px;
	
}
.board-container{
	border:1px solid black;
	border-collapse: collapse;
	width:80%;
	
}
.board-tr>th{
	border:1px solid black;
	cellspacing:0;
	cellpadding:5;
	width:20%;
	

}
.board-tr>td{
	border:1px solid black;
	cellspacing:0;
	cellpadding:5;
	width:70%;
}
.board-tr{ 
	border:1px solid black;
	cellspacing:0;
	cellpadding:5;
}
.alertMsg{
   
   color : red;
   font-size : 10px;
   width : 150px;
}

</style>

</style>
</head>
<body>
	<div class="boardWrite_title">
	<h2>Board Edit(Update글수정)</h2>
	</div>
	<form name="boardUpdateForm" action="boardUpdate.do" method="POST"  >
		<input type="hidden" name="seq" value="${boardDTO.seq }">
		<input type="hidden" name="pg" value="${pg}">
		
		
		<table class="board-container" cellpadding="5">
			<tr class="board-tr">
				<th >제목</th>
				<td>
					<input name="subject" id="subject" type="text" value="${boardDTO.subject}">
					<div class = "alertMsg" id = "subjectDiv"></div>
				</td>
				
			</tr>
			<tr class="board-tr">
				<th>내용</th>
				<td>
					<textarea name="content" id="content" cols="100%" rows="20">${boardDTO.content }</textarea>
					<div class = "alertMsg" id = "contentDiv"></div>
				</td>
			</tr>
			<tr class="board-tr">
				<td colspan="2" align="center">
					<input type="button"  value="글수정" onclick="checkBoardUpdate()">
				<!-- <button type="submit" onclick="check()">글쓰기</button> -->	
					<button type="reset" >다시작성</button>
<!-- 				<input type="button" value="목록" style="margin:5px;" onclick="location.href='/mvcBoard/board/boardList.do'"> -->	
					<input type="button" value="목록" style="margin:5px;" onclick="location.href='/miniProject/board/boardList.do?pg=${pg}'">
				</td>
			</tr>
			
		</table>
	</form>
	
	 <script>
      function checkBoardUpdate(){
    	 console.log("update??");
         const subjectEle = document.getElementById('subject');
         const contentEle = document.getElementById('content');
         const subjectDiv = document.getElementById('subjectDiv');
         const contentDiv = document.getElementById('contentDiv');

         subjectDiv.innerText = "";
         contentDiv.innerText = "";
         
         if(subjectEle.value === ""){
            subjectDiv.innerText = "제목을 입력해야합니다.";
         }else{
            if(contentEle.value === ""){
               contentDiv.innerText = "내용을 입력해야합니다.";
            }else{
                 document.boardUpdateForm.submit();     
            }
                  
         }
      }
   </script>
   
   
</body>
</html>




