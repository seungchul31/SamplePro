<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
 String fieldValue =(String)request.getAttribute("fieldValue");
 String fileName = (String)request.getAttribute("fileName");
 long fileSize = (Long)request.getAttribute("fileSize");
%>

업로드파일명 : <a href="FileDown?fileName=<%=fileName%>"><%=fileName%></a><br>
업로드파일크기: <%=fileSize%><br>
텍스트값: <%=fieldValue%><br>
 <img src="/images/<%= fileName %>" width="100" height="100">

</body>
</html>