<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 헤더 영역 시작 -->
   <!-- 웹 헤더 영역 시작 -->
    <div id="header">
        <div class="headerWrap">
         <div class="headerTop">
            <h1><a href="index"><img src="resources/images/logo.svg" style="width: 120px; padding-top: 5px"/></a></h1>
            <div class="util_menu">
            <form name="selectOne" method="post">
               <ul>
               <c:choose>
                 <c:when test="${sessionScope.sessionID == null}">
                  <li><a href='signup'>JOIN</a></li>
                  <li><a href='loginForm'>LOGIN</a></li>
               </c:when>
               <c:when test="${sessionScope.sessionID != null}">
                  <li>${sessionScope.sessionName}님 반갑습니다</li>
                  <li><a href='selectUserInfoView'>MY PAGE</a></li>
                  <li><a href='logout'>LOGOUT</a></li>
               </c:when>
               </c:choose>   
                  <li><a href="/sitemap/main.do">SITE MAP</a></li>
               </ul>
               </form>
            </div>
         </div>
            <ul class="gnb">
                <li>
                    <a href="#">Flow 소개</a>
                    <ul class="first">
                        <li><a href="/intro/main.do">오픈API 소개</a></li>
                        <li><a href="/intro/infoApiList.do">오픈API 서비스 소개</a></li>
                  <li><a href="/intro/terms.do">이용약관</a></li>
                  <li><a href="/intro/confirm.do">개인정보 수집이용동의</a></li>
                    </ul>
                </li>
                <li>
                     <a href="#">개인 재무/자산</a>
                    <ul>
                  <li><a href="/uss/umt/EgovMberInsertView.do">인증키 신청</a></li>
                  <li><a href="/mng/userApiKeyListView.do">인증키 관리</a></li>
                        <li><a href="/mng/apiUsageStatusView.do">오픈API 이용현황</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">주식 및 기업정보</a>
                    <ul>
                        <li><a href="companyList">상장 기업 정보</a></li>
                 
                  <li><a href="/guide/main.do?apiGrpCd=DS003">종목 분석</a></li>
                  <li><a href="/guide/main.do?apiGrpCd=DS004">실시간 뉴스</a></li>
                  <li><a href="economicIndication">경제 지표</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">My Flow (회원전용)</a>
                    <ul>
                    <li><a href="#">마이 포트폴리오</a></li>
                   <li><a href="myStock?slike_id=${sessionScope.sessionID}">관심종목</a></li>
                  <li><a href="/disclosureinfo/biz/main.do">분석자료위주메뉴</a></li>
                  <li><a href="/disclosureinfo/fnltt/singl/main.do">재무정보조회</a></li>
                  <li><a href="/disclosureinfo/fnltt/dwld/main.do">재무정보일괄다운로드</a></li>
                 
                    </ul>
                </li>
                <li>
                    <a href="/cop/bbs/selectArticleList.do?bbsId=B0000000000000000001">소통창구</a>
                    <ul>
                        <li><a href="/cop/bbs/selectArticleList.do?bbsId=B0000000000000000001">공지사항</a></li>
                  <li><a href="/cop/bbs/selectArticleList.do?bbsId=B0000000000000000002">FAQ </a></li>
                  <li><a href="/cop/bbs/selectArticleList.do?bbsId=B0000000000000000003">Q&A</a></li>
                  <li><a href="/cop/bbs/selectArticleList.do?bbsId=B0000000000000000004">변동내역알림</a></li>
                    </ul>
                </li> 
            </ul>
        </div>
        <div class="bg01"></div>
    </div>
   <!-- 웹 헤더 영역 끝 -->
   <!-- 헤더 영역 끝 --> 