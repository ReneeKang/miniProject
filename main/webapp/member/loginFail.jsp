<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  


<body>

<%-- <h3>${requestScope.msg }</h3> --%> 
 로그인에 실패 <br><br>

<c:if test="${param.failNum==1}">
	패스워드가 일치하지 않습니다.
</c:if>

<c:if test="${param.failNum==2}">
	아이디가 존재하지 않습니다. 회원가입 해주세요.
</c:if>	
	
</body>
