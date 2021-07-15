<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<!-- Ajax용 외부 라이브러리 사용 -->
<script src="resources/js/httpRequest.js"></script>
<script>
	function OnCheckPhone(oTa) {
		var oForm = oTa.form;
		var sMsg = oTa.value;
		var onlynum = "";
		var imsi = 0;
		onlynum = RemoveDash2(sMsg); //하이픈 입력시 자동으로 삭제함 
		onlynum = checkDigit(onlynum); // 숫자만 입력받게 함 
		var retValue = "";
		if (onlynum.substring(0, 2) == 01) { //휴대폰일 경우 
			if (GetMsgLen(onlynum) <= 2)
				oTa.value = onlynum;
			if (GetMsgLen(onlynum) == 3)
				oTa.value = onlynum + "-";
			if (GetMsgLen(onlynum) == 4)
				oTa.value = onlynum.substring(0, 3) + "-"
						+ onlynum.substring(3, 4);
			if (GetMsgLen(onlynum) == 5)
				oTa.value = onlynum.substring(0, 3) + "-"
						+ onlynum.substring(3, 5);
			if (GetMsgLen(onlynum) == 6)
				oTa.value = onlynum.substring(0, 3) + "-"
						+ onlynum.substring(3, 6);
			if (GetMsgLen(onlynum) == 7)
				oTa.value = onlynum.substring(0, 3) + "-"
						+ onlynum.substring(3, 7);
			if (GetMsgLen(onlynum) == 8)
				oTa.value = onlynum.substring(0, 3) + "-"
						+ onlynum.substring(3, 7) + "-"
						+ onlynum.substring(7, 8);
			if (GetMsgLen(onlynum) == 9)
				oTa.value = onlynum.substring(0, 3) + "-"
						+ onlynum.substring(3, 7) + "-"
						+ onlynum.substring(7, 9);
			if (GetMsgLen(onlynum) == 10)
				oTa.value = onlynum.substring(0, 3) + "-"
						+ onlynum.substring(3, 6) + "-"
						+ onlynum.substring(6, 10);
			if (GetMsgLen(onlynum) == 11)
				oTa.value = onlynum.substring(0, 3) + "-"
						+ onlynum.substring(3, 7) + "-"
						+ onlynum.substring(7, 11);
			if (GetMsgLen(onlynum) == 12)
				oTa.value = onlynum.substring(0, 3) + "-"
						+ onlynum.substring(3, 7) + "-"
						+ onlynum.substring(7, 11);
		}

	}

	function RemoveDash2(sNo) {
		var reNo = ""
		for (var i = 0; i < sNo.length; i++) {
			if (sNo.charAt(i) != "-") {
				reNo += sNo.charAt(i)
			}
		}
		return reNo
	}

	function GetMsgLen(sMsg) { // 0-127 1byte, 128~ 2byte 
		var count = 0
		for (var i = 0; i < sMsg.length; i++) {
			if (sMsg.charCodeAt(i) > 127) {
				count += 2
			} else {
				count++
			}
		}
		return count
	}

	function checkDigit(num) {
		var Digit = "1234567890";
		var pnum = num;
		var len = pnum.length
		var retVal = "";

		for (i = 0; i < len; i++) {
			if (Digit.indexOf(pnum.substring(i, i + 1)) >= 0) {
				retVal = retVal + pnum.substring(i, i + 1);

			}
		}
		return retVal;
	}

	//-----------비번 확인------------------------
	//----------Ajax를 통한 아이디중복 확인 ---------------------
</script>
<div class="container">
	<form action="findPWDProcess" method="post">

		<p></p>
		<p></p>
		<h1>비밀번호 찾기</h1>
		<p></p>
		<hr>
		<label for="req">비밀번호 찾기</label><br>
		<br> <label for="m_id"><b>아이디</b></label><br> <input
			type="text" name="m_id" id="m_id" required style="width: 500px;"><br>

		<label for="m_name"><b>이름</b></label><br> <input type="text"
			name="m_name" id="m_name" required style="width: 500px;"><br>

		<label for="m_tel"><b>연락처</b></label><br>
		<!-- 입력값을 this로 function에 넣어줌-->
		<!-- onfocus : 입력 필드가 포커스를 취득했을 때에 자바 스크립트를 실행 -->
		<!-- onkeyup :    사용자가 키보드의 키를 눌렀다가 땠을 때 -->
		<input type="tel" name="m_tel" id="m_tel" onfocus="OnCheckPhone(this)"
			onKeyup="OnCheckPhone(this)" size="14" maxlength="14"
			style="width: 500px;"> <br>
		<br> <label for="psw-repeat"><b>주민등록번호</b></label><br> <input
			type="text" name="jumin1" id="jumin1" maxlength="6"
			style="width: 240px;">- <input type="password" name="jumin2"
			id="jumin2" maxlength="1" style="width: 260px;"><br>


		<div class="clearfix">
			<button type="button" class="cancelbtn"
				style="width: 150px; background: gray;">취소</button>
			<button type="submit" style="width: 150px; background: #6466ea;">비밀번호
				찾기</button>
		</div>
	</form>
</div>
