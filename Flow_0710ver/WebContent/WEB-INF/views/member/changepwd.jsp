<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!doctype html>
<script>
//-----------��� Ȯ��------------------------
function check_pw(){
 
            var pw = document.getElementById('pwd').value;
            var SC = ["!","@","#","$","%"];
            var check_SC = 0;
 
            if(pw.length < 6 || pw.length>16){
                window.alert('��й�ȣ�� 6���� �̻�, 16���� ���ϸ� �̿� �����մϴ�.');
                document.getElementById('pwd').value='';
            }
            for(var i=0;i<SC.length;i++){
                if(pw.indexOf(SC[i]) != -1){
                    check_SC = 1;
                }
            }
            if(check_SC == 0){
                window.alert('!,@,#,$,% �� Ư�����ڰ� �� ���� �ʽ��ϴ�.')
                document.getElementById('pwd').value='';
            }
            if(document.getElementById('pwd').value !='' && document.getElementById('pwd-repeat').value!=''){
                if(document.getElementById('pwd').value==document.getElementById('pwd-repeat').value){
                    document.getElementById('check').innerHTML='��й�ȣ�� ��ġ�մϴ�.'
                    document.getElementById('check').style.color='blue';
                }
                else{
                    document.getElementById('check').innerHTML='��й�ȣ�� ��ġ���� �ʽ��ϴ�.';
                    document.getElementById('check').style.color='red';
                }
            }
        }
</script>
<section class="container1">
	<article class="half">
		<h1>
			<a class="navbar-brand h1" href="index"> <span
				class="text-dark h4"
				style="font-family: 'Sunflower'; font-weight: 500">��й�ȣ</span>
			</a>
		</h1>
		<label>��й�ȣ�� �������ּ���.</label>
		<div class="content">
			<div class="signin-cont cont">
				<form action="pwdsuccess" method="post" nctype="multipart/form-data">
					<input type="hidden" id="m_name" name="m_name" value="${vo.m_name }">
					<input type="hidden" id="m_id" name="m_id" value="${vo.m_id }">
					
					<label for="pwd"><b>* �н�����</b></label><br> <input
						type="password" placeholder="Enter Password" name="m_pwd" id="m_pwd"
						required style="width: 300px;" onchange="check_pw()"><br>

					<label for="pwd-repeat"><b>* �н����� Ȯ��</b></label><br> <input
						type="password" placeholder="Repeat Password" name="pwd-repeat"
						id="pwd-repeat" required style="width: 300px;"
						onchange="check_pw()">&nbsp;<span id="check"></span><br>


					<input type="submit" value="��й�ȣ ����" class="submit">
			</form>
			</div>
		</div>

	</article>
	<div class="half bg"></div>
</section>
