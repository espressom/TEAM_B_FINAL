<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="boardUpdate" method="get">
<input type="hidden" id="b_num" name="b_num" value="${vo.b_num}">
<ul>
<li>���� : <input type="text" id="b_subject" name="b_subject" value="${vo.b_subject}"></li>
<li>ī�װ� :<select id="b_category" name="b_category">
    <option value="�ڻ�Խ���" selected> �ڻ�Խ���
    <option value="�ֽİԽ���"> �ֽİԽ���
</select></li>
<li>�ۼ��� : ${vo.b_regdate}</li>
<li>���� : <textarea rows="30" id="b_content" name="b_content" cols="30">${vo.b_content}</textarea>
<li><input type="file" id="b_filename" name="b_filename"  value="${vo.b_filename}"></li>
</ul>
<input type="submit" value="����">
</form>
</body>
</html>