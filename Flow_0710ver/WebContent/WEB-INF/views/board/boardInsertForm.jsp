<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="boardInsert" method="get">
<input type="hidden" id="bl_num" name="bl_num" value ="${bl_num}">
<ul>
<li>제목 : <input type="text" id="b_subject" name="b_subject" required></li>
<li>카테고리 :<select id="b_category" name="b_category">
    <option value="자산게시판" selected> 자산게시판
    <option value="주식게시판"> 주식게시판
</select></li>
<li>내용 : <textarea rows="30" id="b_content" name="b_content" cols="30"></textarea>
<li><input type="file" id="b_filename" name="b_filename" ></li>
</ul>
<input type="submit" value="작성">
</form>
</body>
</html>