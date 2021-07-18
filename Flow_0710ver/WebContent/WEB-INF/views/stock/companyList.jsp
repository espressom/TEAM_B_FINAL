<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>CompanyList</title>
</head>
<body>
	<div class="container" style="margin-top: 150px;">
		<div id="contentsWrap">
			<div id="contents">

				<!-- 메인컨텐츠 영역 시작 -->
  <div class="head_tit"><h3>섹터 별 상장 기업 목록 (섹터별 페이지 추후 추가 예정, 일단 전체 기업 리스트 띄움)</h3></div>
				<p>회사명을 클릭하면 자세한 정보를 확인할 수 있습니다.</p>
				<!-- 리스트 -->
				<div class="list_area">
					<table class="tb01" style="width:130%;" >
						<caption>공시정보 테이블</caption>
		 		 	<colgroup>
							<col width="8%" />
							<col width="10%" />
							<col width="15%" />
							<col width="20%" />
							<col width="10%" />
							<col width="8%" />
							<col width="8%" />
							<col width="15%" />
							<col width="8%" />
						</colgroup>
						<thead>
							<tr align="center">
								<th scope="col"><label>종목 코드</label></th>
								<th scope="col"><label>회사명</label></th>
								<th scope="col"><label>업종</label></th>
								<th scope="col"><label>주요 제품</label></th>
								<th scope="col"><label>상장일</label></th>
								<th scope="col"><label>결산월</label></th>
								<th scope="col"><label>대표자명</label></th>
								<th scope="col"><label>홈페이지</label></th>
								<th scope="col"><label>지역</label></th>
							</tr>
						</thead>
						
						<tbody> 
						<c:forEach var="c" items="${clist}">
							<tr>
								 <td>${c.c_code}</td>
								 <td><a href="companyDetail?c_code=${c.c_code}&slike_id=${sessionScope.sessionID}">
								 ${c.c_name}</a></td>
								 <td>${c.c_type}</td>
								 <td><font size=2>
								 ${c.c_product}</font></td>
								 <td>${c.c_ipo}</td>
								 <td>${c.c_closingmonth}</td>
								 <td>${c.c_ceo}</td>
								 <td><font size=2>
								 ${c.c_homepage}</font></td>
								 <td><font size=2>
								 ${c.c_location}</font></td>
							</tr>
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