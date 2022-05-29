<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write_jsp</title>
</head>
<body>

<c:if test="${requestScope.su==1 }">
회원가입을 축하합니다.
</c:if>
<c:if test="${requestScope.su==0 }">
회원가입을 다시 작성하세요
</c:if>

</body>
</html>