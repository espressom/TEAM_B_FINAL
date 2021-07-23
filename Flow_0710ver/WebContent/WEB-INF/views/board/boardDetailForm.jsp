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
<li>제목 : ${vo.b_subject}</li>
<li>카테고리 : ${vo.b_category }</li>
<li>작성일 : ${vo.b_regdate }</li>
<li>내용 : ${vo.b_content }</li>
<li>파일첨부 : ${vo.b_filename}</li>
</ul>
<a href="boardUpdateForm?b_num=${vo.b_num}">
<button type="button" id="submit">수정</button></a>
<a href="boardDelete?b_num=${vo.b_num}">
<button type="button" id="submit">삭제</button></a>
<input type="submit" value="목록">
</body>
</html>
