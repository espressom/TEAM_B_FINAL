<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
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
							<form>
								<div class="form-label-group">
									<span>���̵�</span>
									<table>
										<tr>
											<td style="width: 270px;"><input type="text"
												id="inputID" class="form-control" placeholder="ID" required
												autofocus></td>
											<td>
												<button
													class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2"
													type="submit"
													style="width: 100px; background-color: #0c69ef">�ߺ�Ȯ��</button>
											</td>
										</tr>
										<tr>
											<td style="height:30px;"><span id="idchk" name="idchk"></span></td>
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
											<td><input type="password" id="inputPassword"
												class="form-control" placeholder="Password"
												style="width: 240px;" required></td>
											<td><input type="password" id="inputPassword"
												class="form-control" placeholder="Password" required>
											</td>
										</tr>

									</table>
								</div>

								<div class="form-label-group">
									<span>�̸�</span>
									<table>
										<tr>
											<td><input type="text" id="inputName"
												class="form-control" placeholder="Name" required autofocus>
											</td>
										</tr>
									</table>
								</div>

								<div class="form-label-group">
									<span>�ֹι�ȣ</span>
									<table>
										<tr>
											<td><input type="text" id="inputjumin"
												class="form-control" placeholder="Jumin number" required
												autofocus></td>
										</tr>
									</table>
								</div>

								<div class="form-label-group">
									<span>�޴���ȭ</span>
									<table>
										<tr>
											<td><input type="text" id="inputPnum"
												class="form-control" placeholder="Phone Number" required
												autofocus></td>
										</tr>
									</table>

								</div>

								<!--                 <div class="custom-control custom-checkbox mb-3">
                  <input type="checkbox" class="custom-control-input" id="customCheck1" name="customCheck1">
                </div> -->
								<!-- <input type="submit" class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2"> -->
								<button
									class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2"
									type="submit" style="width: 200px; background-color: #0c69ef">�����ϱ�</button>
								<!--                 <div class="text-center">
                  <a class="small" href="#">���</a></div> -->
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>