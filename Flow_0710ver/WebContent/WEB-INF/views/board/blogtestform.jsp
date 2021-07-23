<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>${sessionScope.sessionName}님의 블로그</h1>
<form action="boardIn"  method="get">
<input type="hidden" id="bl_num" name="bl_num" value="2" class="form-control" required>
<input type="hidden" id="b_category" name="b_category" value="자산게시판" class="form-control" required>
<input type='submit' value="자산게시판">
</form>
<form action="boardIn"  method="get">
<input type="hidden" id="bl_num" name="bl_num" value="2" class="form-control" required>
<input type="hidden" id="b_category" name="b_category" value="주식게시판" class="form-control" required>
<input type='submit' id="주식게시판" value="주식게시판">
</form>
<a href="boardInsertForm?bl_num=2">
<button type="button" name="boardInsertForm">글작성</button></a>
</body>
</html>