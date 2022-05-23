<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<meta charset="UTF-8">
<style>
#myInfoForm div{
	color:red;
	font-size: 8pt;
	
}

.myInfo_title{
	margin-left:20px;
	margin-top:60px;
	margin-bottom:40px;
	
}
.myInfoForm{
	width:80%;
	margin-left:20px;
	
}
.myInfoForm td{
	height:40px;
}
</style>

<div class="myInfo_title">
<h3>회원정보수정</h3>

</div>
<form name="myInfoForm" id="myInfoForm" method="POST" action="/miniProject/member/update.do">
	<table class="myInfoForm" border="1" cellpadding="5" cellspacing="0">
		<tr >
			<td align="center" width="130">이름</td>
   			<td>
    			<input type="text" name="name" id="name" value="">
    			<div id="nameDiv_update"></div>
   			</td>
  		</tr>
  		
  		<tr>
			<td align="center">아이디</td>
			<td>
				<input type="text" name="id" id="userId" readonly>
				<div id="idDiv_update"></div>
	   		</td>
		</tr>
		
		<tr>
			<td align="center">비밀번호</td>
			<td>
				<input type="password" name="pwd" id="pwd" value="">
				<div id="pwdDiv_update"></div>
	   		</td>
		</tr>
		
		<tr>
			<td align="center">재확인</td>
			<td>
				<input type="password" name="repwd" id="repwd" value="">
				<div id="repwdDiv_update"></div>
	   		</td>
		</tr>
		
		<tr>
			<td align="center">성별</td>
			<td>
				<%-- if문 ? ? ? ? --%>
				<input type="radio" name="gender" value="0" checked="">남
				<input type="radio" name="gender" value="1" checked="">여
			</td>
		</tr>
		
		<tr>
			<td align="center">이메일</td>
			<td>
				<input type="text" name="email1" value="">
				@
				<input type="email" list="email2" name="email2" placeholder="직접입력" value="">
				<datalist id="email2" value="">
					<option value="gmail.com">
					<option value="daum.net">
  	  				<option value="naver.com">
				</datalist>
			</td>
		</tr>
		
		<tr>
			<td align="center">핸드폰</td>
			<td>
				<select name="tel1" style="width: 70px;">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="019">019</option>
				</select>
				-
				<input type="text" name="tel2" size="5" value="">
				-
				<input type="text" name="tel3" size="5" value="">
			</td>
		</tr>
		
		<tr>
			<td align="center">주소</td>
			<td>
				<input type="text" name="zipcode" id="zipcode" readonly value="">
				<input type="button" value="우편번호검색" onclick="checkPost()"><br>
				<input type="text" name="addr1" id="addr1" placeholder="주소" size="50" readonly><br>
				<input type="text" name="addr2" id="addr2" placeholder="상세주소" size="50" value="">
			</td>
		</tr>
		
		<tr>
			<td colspan ="2" align = "center">
				<input type="button" value="회원정보수정" onclick="checkMyInfo()">
				<input type="button"  value="다시작성" onclick="getMyInfo()">
			</td>
		</tr>
	</table>
</form>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="/miniProject/script/member.js">    </script>

<script type="text/javascript">
//var gender="${'${memberDTO.gender}'}'";
function getMyInfo(){
	var name='${requestScope.memberDTO.name}';
	var id="${memberDTO.id}";
	var pwd="${memberDTO.pwd}";
	var gender="${memberDTO.gender}";
	var email1="${memberDTO.email1}";
	var email2="${memberDTO.email2}";
	var tel1="${memberDTO.tel1}";
	var tel2="${memberDTO.tel2}";
	var tel3="${memberDTO.tel3}";
	var zipcode="${memberDTO.zipcode}";
	var addr1="${memberDTO.addr1}";
	var addr2="${memberDTO.addr2}";
	var logtime="${memberDTO.logtime}";
	
	document.myInfoForm.name.value=name;
	document.myInfoForm.id.value=id;
	document.myInfoForm.pwd.value=pwd;
	document.myInfoForm.gender.value=gender;
	document.myInfoForm.email1.value=email1;
	document.myInfoForm.email2.value=email2;
	document.myInfoForm.tel1.value=tel1;
	document.myInfoForm.tel2.value=tel2;
	document.myInfoForm.tel3.value=tel3;
	document.myInfoForm.zipcode.value=zipcode;
	document.myInfoForm.addr1.value=addr1;
	document.myInfoForm.addr2.value=addr2;
}

getMyInfo();
</script>

<!-- 
강사님 수업시간 코드 
<script>
window.onload() = function(){
	document.updateForm.gender['${memberDTO.gender}'].checked = true;
	document.updateForm.email2.value=
</script>

다시작성을 눌렀을 때 
얘는 안읽어진다. 

 -->





