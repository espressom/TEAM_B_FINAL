<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<div class="container" style="margin-top: 150px;">
	<p></p>
	<p></p>
	<h1>���̵� ã��</h1>
	<p></p>
	<hr>
	<label for="req">���̵� ã��</label><br>
	<br> <label for="uname"><b>�̸�</b></label><br> <input
		type="text" name="m_name" id="m_name" required style="width: 500px;"><br>

	<label for="phonenum"><b>����ó</b></label><br> <input type="tel"
		name="m_tel" id="m_tel" size="14" maxlength="14" style="width: 500px;">
	<br>
	<br>

	<div class="clearfix" style="margin-bottom: 30px;">
		<button type="button" class="cancelbtn"
			style="width: 150px; background: gray;">���ư���</button>
		<button type="submit" style="width: 150px; background: #6466ea;" onclick="findid()">���̵�
			ã��</button>
	</div>
	<span style="width: 30px;" id="target"></span>
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
					$('#target').html('������ �ش��ϴ� ���̵� �����ϴ�.');
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
