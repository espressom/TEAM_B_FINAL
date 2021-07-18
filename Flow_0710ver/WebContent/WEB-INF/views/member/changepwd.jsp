<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!doctype html>
<script>
//-----------비번 확인------------------------
function check_pw(){
 
            var pw = document.getElementById('pwd').value;
            var SC = ["!","@","#","$","%"];
            var check_SC = 0;
 
            if(pw.length < 6 || pw.length>16){
                window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
                document.getElementById('pwd').value='';
            }
            for(var i=0;i<SC.length;i++){
                if(pw.indexOf(SC[i]) != -1){
                    check_SC = 1;
                }
            }
            if(check_SC == 0){
                window.alert('!,@,#,$,% 의 특수문자가 들어가 있지 않습니다.')
                document.getElementById('pwd').value='';
            }
            if(document.getElementById('pwd').value !='' && document.getElementById('pwd-repeat').value!=''){
                if(document.getElementById('pwd').value==document.getElementById('pwd-repeat').value){
                    document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
                    document.getElementById('check').style.color='blue';
                }
                else{
                    document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
                    document.getElementById('check').style.color='red';
                }
            }
        }
</script>


<div class="container" style="margin-top: 150px;">

		<!-- 비밀번호 변경 (상단) -->
		<div class="findBox">
			<div class="findTop">
				<div class="findImg">
					<div class="imgWrap"></div>
				</div>

				<div class="titWrap">
					<h4>
						<span class="em">비밀번호 </span>변경하기
					</h4>
					<span class="exp">
						<p>새로운 비밀번호을 입력 해 주세요</p>
					</span>
				</div>
			</div>

			<div class="find">
				<div class="titWrap">
					<h5>새 비밀번호</h5>

				</div>
				<div class="inputWrap">
				<form action="pwdsuccess" method="post" nctype="multipart/form-data">
					<input type="hidden" id="m_name" name="m_name" value="${vo.m_name }">
					<input type="hidden" id="m_id" name="m_id" value="${vo.m_id }">
				
					 <input type="password"
						placeholder="새 비밀번호 입력" id="m_pwd" name=m_pwd onchange="check_pw()">
				</div>

				<div class="inputWrap">
					 <input type="password"
						placeholder="한 번 더 입력" id="pwd-repeat" name="pwd-repeat" onchange="check_pw()">
				</div>
				<div class="btnWrap">
				<button class="findBtn" type="submit" value="비밀번호 변경" class="submit" class="findBtn" > 변경하기 </button>
			 
					 		 </form>
				</div>
			</div>
		</div>
		<!-- 비밀번호 변경 (하단) -->
