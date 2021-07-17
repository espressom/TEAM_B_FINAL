<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<div class="container" style="margin-top: 150px;">
 
		<!-- 메인컨텐츠 영역 시작 -->

		<!-- 아이디 찾기 (상단) -->
		<div class="findBox">
			<div class="findTop">
				<div class="findImg">
					<div class="imgWrap"></div>
				</div>

				<div class="titWrap">
					<h4>
						<span class="em">아이디</span>를 잊어버리셨나요?
					</h4>
					<span class="exp">
						<p>아래 정보를 입력하시어 아이디를 찾아보세요.</p>
					</span>
				</div>
			</div>

			<div class="find">
				<div class="titWrap">
					<h5>아이디 찾기</h5>

				</div>
				<div class="inputWrap">
					<label for="userEmail">이름</label> <input type="text"
						placeholder="이름" id="m_name" name=m_name>
				</div>

				<div class="inputWrap">
					<label for="m_tel">전화번호</label> <input type="text"
						placeholder="전화번호" id="m_tel" name="m_tel">
				</div>
				<div class="btnWrap">
					<button class="findBtn" type="button" onclick="findid()">확인</button>
					<button class="findBtn" type="button" onclick="history.back()">뒤로가기</button>
				</div>
			</div>

			<p>
				<span style="width: 30px;" id="target"></span>
			</p>


		</div>
		<!-- 아이디 찾기 (하단) -->


	</div>
	<script>
		function findid() {
			var m_name = $('#m_name').val();
			var m_tel = $('#m_tel').val();

			console.log('m_tel ::: ' + m_tel)

			$.ajaxSetup({
				cache : false
			});
			$.ajax({
				type : "GET",
				url : "findIDProcess?m_name=" + m_name + "&m_tel=" + m_tel,
				success : function(res) {
					console.log("result : " + res);
					if (res == 'null') {
						$('#target').html('정보에 해당하는 아이디가 없습니다.');
					} else {
						$('#target').html(res);
					}
				},
				error : function(e) {
					console.log("error : " + e);
				}
			});

		}
	</script>