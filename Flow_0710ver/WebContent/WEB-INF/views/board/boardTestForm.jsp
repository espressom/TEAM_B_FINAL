<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1></h1>
	<div id="list">
		<ol>
		<table>
			<c:forEach var="e" items="${list}">
				<tr>
					<td>제목 :
					<a href="boardDetail?b_num=${e.b_num}">
					 ${e.b_subject }
					</a>
					</td>
					<td>작성일 : ${e.b_regdate }</td>
				</tr>
			</c:forEach>
		</table>
		</ol>
	</div>
</body>
</html>