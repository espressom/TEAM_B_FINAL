<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- //메인 보드 -->
<div class="container" style="margin-top: 150px;">
	<div id="contentsWrap">
		<div id="contents">

			<!-- 메인컨텐츠 영역 시작 -->
			<div class="head_tit">
				<h3></h3>
			</div>

			<!-- 리스트 -->
			<form name="f"  autocomplete="off">
				<input type="text" style="width: 300px;" name="word" id="word"
					onkeydown="startSuggest();" /> <input type="submit" value="검색" />
				<div id="view"></div>
			</form>

			<!-- //리스트 -->



			<div></div>
			<!-- 메인컨텐츠 영역 끝 -->

		</div>
	</div>
</div>

<script src="resources/js/httpRequest.js"></script>
<script src="resources/js/json2.js"></script>
<script>
	var lastkey = ''; // 최종키
	var check = false; // 검색 체크 상태
	var loopkey = false; // 루프 상태

	function startSuggest() {
		console.log("key push!");
		// 최초 검색일 경우 0.5 대기 후 sendKeyword()호출
		if (check === false) {
			setTimeout("sendKeyword();", 500);
			loopkey = true;
		}
		check = true;
	}

	function sendKeyword() {
		// 키워드를 받아서 파라미터를 AJAX로 전송하는 함수
		if (loopkey === false) {
			return;
		}
		var key = f.word.value; // document.getElementById()로 대체 가능
		// 값이 없거나 공백일때
		if (key === '' || key === ' ') {
			lastkey = '';
			document.getElementById("view").style.display = 'none';
		} else if (key !== lastkey) {
			// 검색값 다를 경우 서버로 전송
			lastkey = key;
			console.log("param : " + key);
			sendRequest("search?key=" + key, null, res, "get");
		} else if (key === lastkey) {
			console.log("key ===lastkey")
		}
		setTimeout("sendKeyword();", 500);
	}
	var jsonObj = null;
	function res() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				var response = xhr.responseText;
				jsonObj = JSON.parse(response);
				console.log("-----------------");
				console.log(jsonObj);
				viewTable();
			} else {
				document.getElementById("view").style.display = 'none';
			}
		}
	}

	function viewTable() { //callback 받은 json 데이터를 ui에 표시
		var vD = document.getElementById("view");
		var htmlTxt = "<table width='300' border='0' cellspacing='0'>";

		for (var i = 0; i < jsonObj.length; i++) {
			htmlTxt += "<tr>";
			htmlTxt += "<td style='cursor:pointer;' ";
			htmlTxt += "onmouseover='this.style.background=\"silver\"' ";
			htmlTxt += "onmouseout='this.style.background=\"white\"' ";
// 			htmlTxt += "onclick='select(" + i + ")'>" + jsonObj[i];
            htmlTxt += "onclick='search(" + parseInt(jsonObj[i]['c_code'], 10) + ")'>" ;
            htmlTxt += jsonObj[i]['c_code'] +" : " + jsonObj[i]['c_name'];
			htmlTxt += "</td></tr>"
		}
		htmlTxt += "</table>";
		vD.innerHTML = htmlTxt;
		vD.style.display = "block";
	}
	function select(i) {
		f.word.value = jsonObj[i];
		document.getElementById("view").style.display = 'none';
		check = false;
		loopkey = false;
	}
	function search(code) {
		code = String(code).padStart(6, '0');
		location.href="companyDetail?c_code="+code+"&slike_id="
	}
</script>