<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<style>
:root {
  --input-padding-x: 1.5rem;
  --input-padding-y: 0.75rem;
}

.login,
.image {
  min-height: 100vh;
}

.bg-image {
  background-image: url('resources/images/signup/signup.png');
  background-size: 800px;
  background-position: center;
  background-repeat: no-repeat;
}

.login-heading {
  font-weight: 300;
}

.btn-login {
  font-size: 0.9rem;
  letter-spacing: 0.05rem;
  padding: 0.75rem 1rem;
  border-radius: 2rem;
}

.form-label-group {
  position: relative;
  margin-bottom: 1rem;
}

.form-label-group>input,
.form-label-group>label {
  padding: var(--input-padding-y) var(--input-padding-x);
  height: auto;
  border-radius: 2rem;
}

.form-label-group>label {
  position: absolute;
  top: 0;
  left: 0;
  display: block;
  width: 100%;
  margin-bottom: 0;
  /* Override default `<label>` margin */
  line-height: 1.5;
  color: #495057;
  cursor: text;
  /* Match the input under the label */
  border: 1px solid transparent;
  border-radius: .25rem;
  transition: all .1s ease-in-out;
}

.form-label-group input::-webkit-input-placeholder {
  color: transparent;
}

.form-label-group input:-ms-input-placeholder {
  color: transparent;
}

.form-label-group input::-ms-input-placeholder {
  color: transparent;
}

.form-label-group input::-moz-placeholder {
  color: transparent;
}

.form-label-group input::placeholder {
  color: transparent;
}

.form-label-group input:not(:placeholder-shown) {
  padding-top: calc(var(--input-padding-y) + var(--input-padding-y) * (2 / 3));
  padding-bottom: calc(var(--input-padding-y) / 3);
}

.form-label-group input:not(:placeholder-shown)~label {
  padding-top: calc(var(--input-padding-y) / 3);
  padding-bottom: calc(var(--input-padding-y) / 3);
  font-size: 12px;
  color: #777;
}

/* Fallback for Edge
-------------------------------------------------- */

@supports (-ms-ime-align: auto) {
  .form-label-group>label {
    display: none;
  }
  .form-label-group input::-ms-input-placeholder {
    color: #777;
  }
}

/* Fallback for IE
-------------------------------------------------- */

@media all and (-ms-high-contrast: none),
(-ms-high-contrast: active) {
  .form-label-group>label {
    display: none;
  }
  .form-label-group input:-ms-input-placeholder {
    color: #777;
  }
}
</style>
<div class="container-fluid" style="margin-top: 100px;">
	<div class="row no-gutter">
		<div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
		<div class="col-md-8 col-lg-6">
			<div class="login d-flex align-items-center py-5">
				<div class="container">
					<div class="row">
						<div class="col-md-9 col-lg-8 mx-auto">
							<h3 class="login-heading mb-4">
								<strong>ȸ������</strong>
							</h3>
							<form action="insertmem" method="post">
								
								<div class="form-label-group">
									<span>���̵�</span>
									<table>
										<tr>
											<td style="width: 270px;"><input type="text" id="id"
												class="form-control" name="m_id" required autofocus style="height:50px;"></td>
											<td><input type="button"
												class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2"
												style="width: 100px; background-color: #0c69ef"
												onclick="idchk()" value="�ߺ�Ȯ��"></td>
										</tr>
										<tr>
											<td style="height: 30px;"><span id="idchk" name="idchk"></span></td>
										</tr>
									</table>
								</div>

								<div class="form-label-group">

									<table style="width: 500px;">
										<tr>
											<td><span>��й�ȣ</span></td>
											<td><span>��й�ȣ Ȯ��</span></td>
										</tr>
										<tr>
											<td><input type="password" id="pwd" class="form-control"
												style="width: 240px; height:50px;" name="m_pwd"
												required></td>
											<td><input type="password" id="pwd_re"
												class="form-control"
												onchange="test()" style="height:50px;" required></td>
										</tr>
										<tr>
											<td style="height: 30px;"><span id="pwdchk"
												name="pwdchk"></span></td>
										</tr>

									</table>
								</div>

								<div class="form-label-group">
									<span>�̸�</span>
									<table>
										<tr>
											<td><input type="text" id="inputName"
												class="form-control" name="m_name"
												autofocus required style="height:50px;"></td>
										</tr>
									</table>
								</div>

								<div class="form-label-group">
									<span>�ֹι�ȣ</span>
									<table>
										<tr>
											<td><input type="text" id="inputjumin" name="m_jumin"
												class="form-control" style="height:50px;" required></td>
										</tr>
									</table>
								</div>

								<div class="form-label-group">
									<span>�޴���ȭ</span>
									<table>
										<tr>
											<td><input type="text" id="inputPnum" name="m_tel"
												class="form-control" style="height:50px;" autofocus
												required></td>
										</tr>
									</table>

								</div>
								<button
									class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2"
									type="submit" id="submit"
									style="width: 200px; background-color: #0c69ef" disabled>�����ϱ�</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	function idchk() {
		var mid = $('#id').val();
		console.log('idchk ����')
		console.log('mid ::: ' + mid)
		$.ajaxSetup({
			cache : false
		});
		$.ajax({
			type : "GET",
			url : "idchk?mid=" + mid,
			success : function(res) {
				console.log("result : " + res);
				if (res != 0) {
					$('#submit').prop('disabled', true);
					$('#idchk').html('�̹� �����ϴ� ���̵��Դϴ�.');
				} else {
					$('#submit').prop('disabled', false);
					$('#idchk').html('��� ������ ���̵��Դϴ�.');
				}

			},
			error : function(e) {
				console.log("error : " + e);
			}
		});
	}

	function test() {
		var pwd = $('#pwd').val();
		var pwd_re = $('#pwd_re').val();
		if (pwd != pwd_re) {
			$('#submit').prop('disabled', true);
			$('#pwdchk').html('��й�ȣ�� ��ġ ���� �ʽ��ϴ�');
		} else {
			$('#submit').prop('disabled', false);
			$('#pwdchk').html('��й�ȣ�� ��ġ�մϴ�');
		}

	}
</script>