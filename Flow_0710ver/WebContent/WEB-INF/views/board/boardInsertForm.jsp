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
<li>���� : <input type="text" id="b_subject" name="b_subject" required></li>
<li>ī�װ� :<select id="b_category" name="b_category">
    <option value="�ڻ�Խ���" selected> �ڻ�Խ���
    <option value="�ֽİԽ���"> �ֽİԽ���
</select></li>
<li>���� : <textarea rows="30" id="b_content" name="b_content" cols="30"></textarea>
<li><input type="file" id="b_filename" name="b_filename" ></li>
</ul>
<input type="submit" value="�ۼ�">
</form>
</body>
</html>