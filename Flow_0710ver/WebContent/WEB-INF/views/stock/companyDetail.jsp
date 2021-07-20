<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>CompanyDetail</title>
</head>
<body>
	<div class="container" style="margin-top: 150px;">
		<div id="contentsWrap">
			<div id="contents">

				<!-- 메인컨텐츠 영역 시작 -->
				<div class="head_tit">
					<h3>${cvo.c_name }
					
				<c:choose>
					<c:when test="${sessionScope.sessionID != null}">
						<c:choose>
							<c:when test="${likeStatus == 0}">
								<a href="javascript:likeUpdate()" class="likeRef">
								<img src="./resources/images/btn/heart2.svg" width="20px" class="likeImg"/>
								</a>
							</c:when>
							<c:when test="${likeStatus == 1}">
								<a href="javascript:likeUpdate()" class="likeRef">
								<img src="./resources/images/btn/heart1.svg" width="20px" class="likeImg"/>
								</a>
							</c:when>
						</c:choose>	
					</c:when>
					<c:when test="${sessionScope.sessionID == null}">
						<img src="./resources/images/btn/heart1.svg" width="20px" class="likeImg"/>
						
					</c:when>
				</c:choose>	
					
					</h3>
				</div>

				<!-- 리스트 -->
				<div class="list_area">
					<table class="tb01" style="width: 130%;">
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

							<tr>
								<td>${cvo.c_code }</td>
								<td>${cvo.c_name}</td>
								<td>${cvo.c_type}</td>
								<td><font size=2> ${cvo.c_product}</font></td>
								<td>${cvo.c_ipo}</td>
								<td>${cvo.c_closingmonth}</td>
								<td>${cvo.c_ceo}</td>
								<td><font size=2> ${cvo.c_homepage}</font></td>
								<td><font size=2> ${cvo.c_location}</font></td>
							</tr>

							<!-- 예비 컬럼 (상단) -->
							<tr>
								<td colspan=9></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<!-- 예비 컬럼 (하단) -->


						</tbody>
					</table>
				</div>

				<!-- //리스트 -->
				<!-- 그래프 -->
				<div id="graph">
					
				</div>
				<br>
				<!-- 그래프 -->
				<!-- 뉴스 -->
				<div class="introWarp">
					<c:forEach var="e" items="${list}">
						<div class="intro">
							<div style="width: 260px; height: 180px;
							 text-align: center;">
								<img alt="img" src=${e.img }
									style="max-width: 260px; 
									max-height: 180px;">
							</div>
							<h5>
								<a href=${e.href }>${e.title }</a>
							</h5>
							<div class="cont">여기 내용 넣으려다 실패</div>
						</div>
					</c:forEach>
				</div>


				<div></div>
				<!-- 메인컨텐츠 영역 끝 -->

			</div>
		</div>
	</div>
</body>
<script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function() {
		$.ajax({
		    url:'http://192.168.0.12:8099/shop/make_chart?code=${cvo.c_code }',
		    type:'GET',
		    dataType:'jsonp',
		    success:function(data){
		        console.log(data);
		        Plotly.plot('graph', data, {});
		    }
		});
	 });


	function likeUpdate() {
		$.ajaxSetup({cache: false});
		$.ajax({
			type: "GET",
			url:"likeStatus?slike_code=${cvo.c_code}&slike_id=${sessionScope.sessionID}",
			success:function(res) {
				console.log("Data status : " + res);
				if (res != 1) {
					$('.likeImg').attr('src', "./resources/images/btn/heart2.svg");
				} else {
					$('.likeImg').attr('src', "./resources/images/btn/heart1.svg");
				}
				var likesNum = parseInt(res) + parseInt($('#likes').html());
				console.log("likesNum : " + likesNum);
				$('#likes').html(likesNum);
			},
			error: function (e) {
				console.log("error : " + e);
			}
		});
		//console.log($('forEach').attr("items"));
	}
</script>
</html>