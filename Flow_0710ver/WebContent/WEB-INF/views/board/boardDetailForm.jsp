<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<ul>
<li>���� : ${vo.b_subject}</li>
<li>ī�װ� : ${vo.b_category }</li>
<li>�ۼ��� : ${vo.b_regdate }</li>
<li>���� : ${vo.b_content }</li>
<li>����÷�� : ${vo.b_filename}</li>
</ul>
<a href="boardUpdateForm?b_num=${vo.b_num}">
<button type="button" id="submit">����</button></a>
<a href="boardDelete?b_num=${vo.b_num}">
<button type="button" id="submit">����</button></a>
<input type="submit" value="���">
</body>
</html>
