<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.boxwrap {
    display:table;
    width:100%;
    table-layout: fixed;
}
 
.boxwrap .box {
    display:table-cell;
    vertical-align: middle;
}
</style>
<!-- //메인 보드 -->
<div class="container" style="margin-top: 150px;">
	<div id="contentsWrap">
		<div id="contents">

			<!-- 메인컨텐츠 영역 시작 -->
			<div class="head_tit">
				<h3>
				</h3>
			</div>

			<!-- 리스트 -->
			<div class="mainBoardWarp">
				<div class="mainBoard" style="width:40rem">
					<h4>
						실시간 뉴스</h4>
					<ul>
					<c:forEach var="e" items="${list}">
					<li>
					<a href=${e.href }>${e.title }</a>
					</li>
					
					</c:forEach>
					
					</ul>
				</div>
			</div>

			<!-- //리스트 -->



			<div></div>
			<!-- 메인컨텐츠 영역 끝 -->

		</div>
	</div>
</div>