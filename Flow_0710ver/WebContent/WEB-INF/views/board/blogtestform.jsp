<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>${sessionScope.sessionName}���� ��α�</h1>
<form action="boardIn"  method="get">
<input type="hidden" id="bl_num" name="bl_num" value="2" class="form-control" required>
<input type="hidden" id="b_category" name="b_category" value="�ڻ�Խ���" class="form-control" required>
<input type='submit' value="�ڻ�Խ���">
</form>
<form action="boardIn"  method="get">
<input type="hidden" id="bl_num" name="bl_num" value="2" class="form-control" required>
<input type="hidden" id="b_category" name="b_category" value="�ֽİԽ���" class="form-control" required>
<input type='submit' id="�ֽİԽ���" value="�ֽİԽ���">
</form>
<a href="boardInsertForm?bl_num=2">
<button type="button" name="boardInsertForm">���ۼ�</button></a>
</body>
</html>