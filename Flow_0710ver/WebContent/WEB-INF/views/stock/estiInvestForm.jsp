<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>투자 예상</title>
<script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
</head>
<body>
<body>
	<div class="container" style="margin-top: 150px;">
		<div id="contentsWrap">
			<div id="contents">
			
			<!-- 메인컨텐츠 영역 시작 -->
  <div class="head_tit"><h3>내 투자 예상해보기!</h3></div>
			 
				
				<h3>실행시마다 내 포트폴리오의 위치가 바뀌는 문제가 있음 수정해야함</h3>
				<div id="graph"></div>
				<!-- 메인컨텐츠 영역 끝 -->

			</div>
		</div>
	</div>
</body>
<script>
$(function(){

        $.ajax({
            url:'http://192.168.0.5:8099/shop/myPortfolio?callback',
            type:'GET',
            dataType:'jsonp',
            success:function(data){
                console.log(data);
                Plotly.plot('graph', data, {});
            }
        });
});
</script>
</html>