<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<div class="container-fluid">
  <div class="row no-gutter">
    <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
    <div class="col-md-8 col-lg-6">
      <div class="login d-flex align-items-center py-5">
        <div class="container">
          <div class="row">
            <div class="col-md-9 col-lg-8 mx-auto">
              <h3 class="login-heading mb-4">Welcome back!</h3>
              <form>
                <div class="form-label-group">
                  <span>���̵�</span><input type="text" id="inputID" class="form-control" placeholder="ID" required autofocus>
                  <label for="inputID">ID</label>
                </div>

                <div class="form-label-group">
                  <span>��й�ȣ</span><input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                  <label for="inputPassword">Password</label>
                </div>
                
                <div class="form-label-group">
                  <span>�̸�</span><input type="text" id="inputName" class="form-control" placeholder="Name" required autofocus>
                  <label for="inputEmail">Name</label>
                </div>
                
                <div class="form-label-group">
                  <span>�ֹι�ȣ</span><input type="text" id="inputjumin" class="form-control" placeholder="Jumin number" required autofocus>
                  <label for="inputJumin">Jumin</label>
                </div>
                
                <div class="form-label-group">
                  <span>�޴���ȭ</span><input type="text" id="inputPnum" class="form-control" placeholder="Phone Number" required autofocus>
                  <label for="inputPnum">Phone Number</label>
                </div>

                <div class="custom-control custom-checkbox mb-3">
                  <input type="checkbox" class="custom-control-input" id="customCheck1">
                  <label class="custom-control-label" for="customCheck1">Remember password</label>
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Sign in</button>
                <div class="text-center">
                  <a class="small" href="#">Forgot password?</a></div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>