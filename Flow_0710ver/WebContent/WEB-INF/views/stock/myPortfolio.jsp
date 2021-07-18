<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>myPortfolio</title>

</head>
<body>
<body>
	<div class="container" style="margin-top: 150px;">
		<div id="contentsWrap">
			<div id="contents">
			
			<!-- 메인컨텐츠 영역 시작 -->
  <div class="head_tit"><h3>관심종목 리스트</h3></div>
			 
				<!-- 리스트 -->
				<div class="list_area">
					<table class="tb01" style="width:130%;" >
						<caption>관심종목 리스트</caption>
		 		 	<colgroup>
							<col width="20%" />
							<col width="50%" />
							<col width="30%" />
						</colgroup>
						<thead>
							<tr align="center">
								<th scope="col"><label>종목 코드</label></th>
								<th scope="col"><label>회사명</label></th>
								<th scope="col"><label>현재가</label></th>
							</tr>
						</thead>
						
						<tbody> 
						<c:forEach var="c" items="${slist}">
							<tr>
								 <td>${c.c_code}</td>
								 <td><a href="companyDetail?c_code=${c.c_code}&slike_id=${sessionScope.sessionID}">${c.c_name}</a></td>
								 <td>추가 예정</td>
							 
							</c:forEach>
 

						</tbody>
					</table>
				</div>

				<!-- //리스트 -->
 

				<div></div>
				<!-- 메인컨텐츠 영역 끝 -->

			</div>
		</div>
	</div>
</body>
</html>