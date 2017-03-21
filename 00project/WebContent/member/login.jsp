<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 
uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" 
uri="http://java.sun.com/jsp/jstl/functions" %> 

<form action="LoginController" method="get">
 아이디:<input type="text" name="userid"><br> <!-- id가 아니라 name으로 해야합니다. by 지훈수정 -->
 비밀번호:<input type="text" name="passwd"><br> <!-- id가 아니라 name으로 해야합니다. -->
 <input type="submit" value="로그인">
 <input type="reset" value="취소">
</form>
 