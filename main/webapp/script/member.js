
//회원가입
function checkWrite(){
	//alert("오니?")
	console.log("오니?")
	document.getElementById("nameDiv").innerText = "";
	document.getElementById("idDiv_write").innerText = "";
	document.getElementById("pwdDiv_write").innerText = "";
	
	if(document.writeForm2.name.value =="")
		document.getElementById("nameDiv").innerText = "이름을 입력하세요";
	else if(document.writeForm2.id.value =="")
		document.getElementById("idDiv_write").innerText = "아이디를 입력하세요";	
	else if(document.writeForm2.pwd.value =="")
		document.getElementById("pwdDiv_write").innerText = "비밀번호를 입력하세요";
	else if(document.writeForm2.pwd.value != document.writeForm2.repwd.value)
		document.getElementById("pwdDiv_write").innerText = "비밀번호 맞지 않습니다.";
		
	//중복체크 안했으면 하라고 ㅋ 무조건 해야 회원가입 가능 ㅋ
	else if(document.writeForm2.doCheckId.value=="false"){
		alert("id 중복확인 필수");
	}
	//가입버튼 눌렀을때
	//현재 텍스트창에 입력된 아이디?     중복검사때 허용한 아이디 ? 
	//같지 않으면   중복체크 한번 더 해라.  라고 알림띄워주기
	else if(document.writeForm2.id.value!=sId){
		alert("id 다시 중복확인해...");
	}
	else 
		document.writeForm2.submit();	
}


var sId;

//중복체크
function checkId(){
	//회원가입 전 중복체크 버튼 눌렀는지 확인
	console.log("회원가입전에 중복체크했냐구??? 했음 가입하게 해줄게")
	document.writeForm2.doCheckId.value="true";
	
	
	//alert("sldfd");
	sId= document.writeForm2.id.value;
	
	document.getElementById("idDiv_write").innerText = "";
	if(sId==""){
		document.getElementById("idDiv_write").innerText="먼저 아이디 입력";
	}
	//window.open("checkId.jsp","checkId","width=300 height=150 left=700 top=300");

	//window.open("http://localhost:8080/miniProject/member/checkId.jsp?id="+document.writeForm2.id.value,"checkId()");
	//나의실수 window.open("/miniProject/member/checkId.do?sId="+document.writeForm2.id.value,"checkId()");
	else{
		window.open("/miniProject/member/checkId.do?id="+sId, "checkId", "width=450 height=150");
		}
}													//중복확인할때 이 식별자를 보고 알수있다. !!ㅎㅎ
	//윈도우 창에대한 3가지 속성  1)어떤뷰뜰건지 2) 식별자 3) 크기 이렇게 지정가능하다. 
	
	


//다음우편번호
function checkPost() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
  
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zipcode').value = data.zonecode;
            document.getElementById("addr1").value = roadAddr;
            document.getElementById("addr2").value = data.jibunAddress;
        }
    }).open();
}


// 로그인 유효성검사
function loginCheck(){
	console.log("오니?")
	document.getElementById("idDiv").innerText = "";
	document.getElementById("pwdDiv").innerText = "";
	
	if(document.loginForm.id.value =="")
		document.getElementById("idDiv").innerText = "아이디를 입력하세요!!";
	else if(document.loginForm.pwd.value =="")
		document.getElementById("pwdDiv").innerText = "비밀번호를 입력하세요!!";
	else 
		document.loginForm.submit();	
}


//회원정보수정 유효성검사
function checkMyInfo(){
	
	document.getElementById("nameDiv_update").innerText = "";
	document.getElementById("idDiv_update").innerText = "";
	document.getElementById("pwdDiv_update").innerText = "";
	
	if(document.myInfoForm.name.value =="")
		document.getElementById("nameDiv_update").innerText = "이름을 입력하세요";
	else if(document.myInfoForm.pwd.value =="")
		document.getElementById("pwdDiv_update").innerText = "비밀번호를 입력하세요";
	else if(document.myInfoForm.repwd.value =="")
		document.getElementById("repwdDiv_update").innerText = "비밀번호를 다시한번 입력하세요";
	else if(document.myInfoForm.pwd.value != document.myInfoForm.repwd.value)
		document.getElementById("repwdDiv_update").innerText = "비밀번호가 맞지 않습니다.";
	else 
		document.myInfoForm.submit();	
}
