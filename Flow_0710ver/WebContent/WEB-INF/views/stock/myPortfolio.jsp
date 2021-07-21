<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
							<col width="10%" /> <!-- 종목코드 -->
							<col width="20%" /> <!-- 회사명 -->
							<col width="20%" /> <!-- 현재가 -->
							<col width="10%" /> <!-- 전일가 -->
							<col width="10%" /> <!-- 시가 -->
							<col width="15%" /> <!-- 고가 -->
							<col width="10%" /> <!-- 저가 -->
							<col width="10%" /> <!-- 거래량 -->
						</colgroup>
						<thead>
							<tr align="center">
								<th scope="col"><label>종목 코드</label></th>
								<th scope="col"><label>회사명</label></th>
								<th scope="col"><label>현재가 <br>
								<font size=2 style="font-weight:normal">( <fmt:formatDate value="${now}" pattern="yyyy-MM-dd hh:mm:ss" />  기준 )</font> </label></th>
							<th scope="col"><label>전일가</label></th>
							<th scope="col"><label>시가</label></th>
							<th scope="col"><label>고가 / 상한가 </label></th>
							<th scope="col"><label>저가</label></th>
							<th scope="col"><label>거래량</label></th>
							</tr>
						</thead>
						
						<tbody> 
						<c:forEach var="c" items="${slist}" >
							<tr>
								 <td>${c.c_code}</td>
								 <td><a href="companyDetail?c_code=${c.c_code}&slike_id=${sessionScope.sessionID}">${c.c_name}</a></td>
								  <td>${c.price} 원 <br>
				
                 				  <c:if test="${c.compare == '하락 -'}">
								  <font size=2 color="blue">▼ ${c.com_price} 원 / ${c.com_percent} %</font></c:if>
				 				  <c:if test="${c.compare == '상승 +'}">
								  <font size=2 color="red">▲ ${c.com_price} 원 / ${c.com_percent} %</font></c:if>
								  
								  </td> 
								  <td>${c.exday} </td>
								  <td>${c.open}</td>
								  <td>${c.high}</td>
								  <td>${c.low}</td>
								  <td>${c.volume} 주</td>
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