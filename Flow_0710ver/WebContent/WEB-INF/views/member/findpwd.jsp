<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<!-- Ajax�� �ܺ� ���̺귯�� ��� -->
<script src="resources/js/httpRequest.js"></script>
<script>
	function OnCheckPhone(oTa) {
		var oForm = oTa.form;
		var sMsg = oTa.value;
		var onlynum = "";
		var imsi = 0;
		onlynum = RemoveDash2(sMsg); //������ �Է½� �ڵ����� ������ 
		onlynum = checkDigit(onlynum); // ���ڸ� �Է¹ް� �� 
		var retValue = "";
		if (onlynum.substring(0, 2) == 01) { //�޴����� ��� 
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

	//-----------��� Ȯ��------------------------
	//----------Ajax�� ���� ���̵��ߺ� Ȯ�� ---------------------
</script>
<div class="container">
	<form action="findPWDProcess" method="post">

		<p></p>
		<p></p>
		<h1>��й�ȣ ã��</h1>
		<p></p>
		<hr>
		<label for="req">��й�ȣ ã��</label><br>
		<br> <label for="m_id"><b>���̵�</b></label><br> <input
			type="text" name="m_id" id="m_id" required style="width: 500px;"><br>

		<label for="m_name"><b>�̸�</b></label><br> <input type="text"
			name="m_name" id="m_name" required style="width: 500px;"><br>

		<label for="m_tel"><b>����ó</b></label><br>
		<!-- �Է°��� this�� function�� �־���-->
		<!-- onfocus : �Է� �ʵ尡 ��Ŀ���� ������� ���� �ڹ� ��ũ��Ʈ�� ���� -->
		<!-- onkeyup :    ����ڰ� Ű������ Ű�� �����ٰ� ���� �� -->
		<input type="tel" name="m_tel" id="m_tel" onfocus="OnCheckPhone(this)"
			onKeyup="OnCheckPhone(this)" size="14" maxlength="14"
			style="width: 500px;"> <br>
		<br> <label for="psw-repeat"><b>�ֹε�Ϲ�ȣ</b></label><br> <input
			type="text" name="jumin1" id="jumin1" maxlength="6"
			style="width: 240px;">- <input type="password" name="jumin2"
			id="jumin2" maxlength="1" style="width: 260px;"><br>


		<div class="clearfix">
			<button type="button" class="cancelbtn"
				style="width: 150px; background: gray;">���</button>
			<button type="submit" style="width: 150px; background: #6466ea;">��й�ȣ
				ã��</button>
		</div>
	</form>
</div>
