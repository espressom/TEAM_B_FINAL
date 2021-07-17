<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<!-- Ajax용 외부 라이브러리 사용 -->
<script src="resources/js/httpRequest.js"></script>
 
</script>
<!-- 비밀번호 찾기 (상단) -->
<body>
<div class="container" style="margin-top: 150px;">
	<form action="findPWDProcess" method="post">
		<div class="findBox">
			<div class="findTop">
				<div class="findImg">
					<div class="imgWrap"></div>
				</div>

				<div class="titWrap">
					<h4>
						<span class="em">비밀번호</span>를 잊어버리셨나요?
					</h4>
					<span class="exp">
						<p>아래 정보를 입력하시어 비밀번호를 찾아보세요.</p>
					</span>
				</div>
			</div>

			<div class="find">
				<div class="titWrap">
					<h5>비밀번호 찾기</h5>
				</div>
				<div class="inputWrap">
					<label for="userEmail">아이디</label> <input type="text" required
						placeholder="아이디" id="m_id" name=m_id>
				</div>
				<div class="inputWrap">
					<label for="userEmail">이름</label> <input type="text" required
						placeholder="이름" id="m_name" name=m_name>
				</div>

				<div class="inputWrap">
					<label for="m_tel">전화번호</label> <input type="text" required
						placeholder="전화번호" id="m_tel" name="m_tel">
				</div>
				<div class="inputWrap">
					<input type="text" name="jumin1" id="jumin1" maxlength="6" required
						placeholder="주민등록번호" style="width: 50%;"> - <input
						type="password" name="jumin2" id="jumin2" maxlength="1" required
						style="width: 45%;">
				</div>

				<div class="btnWrap">
					<button class="findBtn" type="submit">확인</button>
					<button class="findBtn" type="button" onclick="history.back()">뒤로가기</button>
				</div>
			</div>

			<p>
				<span style="width: 30px;" id="target"></span>
			</p>


		</div>
		<!-- 비밀번호 찾기 (하단) -->


	</form>
</div>
</body>