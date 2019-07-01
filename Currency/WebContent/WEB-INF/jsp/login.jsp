<%@include file="decorator.jsp"%>
<%@include file="googleLogin.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<style>
.icheck>label {
	padding-left: 21px;
}
</style>

<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}

#img-as-background {
  position: relative;
  overflow: hidden;
}
#img-as-background .container {
  height: 500px;
  padding: 20px;
}

#img-as-background img {
  position: absolute;
  width: 100%;
  top: 0;
  bottom: 0;
  z-index: -1;
}

#img-as-background .container {
    height: 654px;
    padding: 0px;
    padding-left: -39px;
    width: 100%;
}

.login-box-body, .register-box-body {
    background: #c366a1;
    padding: 20px;
    border-top: 0;
    color: #666;
}

 /* 
 #login {
    padding-left: 10%;
    padding-right: 60%;
    padding-top: 8%;
    width: 96%;
} */

.abcRioButton abcRioButtonLightBlue {
    height: 35px;
    width: 320px;

}
</style>

<script>
$(document).ready(function(){
   $('#login').show();
   $('#forgotpwd').hide();
   $('#registeruser').hide();
   var msg="${msg}";
   if(msg==""||msg==null){
	   
   }else{
	   //alert(msg);
   }
<%-- 
   var name="<%=session.getAttribute("name")%>";
   alert("name ===== " + name);
   if(name==null||name==''){
	   signout();
	}
	 --%>
});
</script>

<script type="text/javascript">
function getPassword(){
	$('#login').hide();
	$('#forgotpwd').show();
	$('#registeruser').hide();
}
function signin(){
	   $('#login').show();
	   $('#forgotpwd').hide();
	   $('#registeruser').hide();
}
function registeruser(){
	   $('#registeruser').show();
	   $('#login').hide();
	   $('#forgotpwd').hide();
}
</script>

<title>JOIN</title>
<body class="hold-transition login-page">
	<div id="img-as-background">
	 <div class="container">
		<!-- <img src="https://image.freepik.com/free-vector/modern-abstract-background_1048-1003.jpg" alt="" />  -->
		<!-- <img src="resources/image/background.jpg" alt="" />  -->
		<!-- <img src="resources/image/background2.PNG" alt="" />  -->
		<img src="resources/image/background3.jpg" alt="" /> 

		<a href="./useService">&nbsp;&nbsp;&nbsp;<b>Application's Services</b></a>

		<div class="login-box" id="login">
		<!-- <div id="login" align="left"> -->

			<div class="login-logo">
				<!-- <a href="#"><b>Services</b></a> -->
			</div>
			<div class="login-box-body">
				<p class="login-box-msg">Sign in to start your session</p>

				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>
				</c:if>

				<form name='loginForm'
					action="<c:url value='/j_spring_security_check' />" method='POST'
					class="form-signin">
					<div class="form-group has-feedback">
						<input type="text" class="form-control" placeholder="UserName"
							name="username" id="username"> <span
							class="glyphicon glyphicon-envelope form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="password" class="form-control" placeholder="Password"
							name="password" id="password"> <span
							class="glyphicon glyphicon-lock form-control-feedback"></span>
					</div>
					<div class="row">
						<div class="col-xs-8">
							<div class="checkbox icheck">
								<label> <input type="checkbox"> Remember Me
								</label>
							</div>
						</div>
						<div class="col-xs-4">
							<button class="btn btn-primary btn-block btn-flat" type="submit">Sign
								In</button>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</div>
					</div>
				</form>

				<div class="social-auth-links text-center">
					<p>- OR -</p>
					<a href="#" class="btn btn-block btn-social btn-facebook btn-flat">
						<i class="fa fa-facebook"></i> Sign in using Facebook</a>
						 
				<!-- 	<a href="#" class="btn btn-block btn-social btn-google btn-flat">
						<i class="fa fa-google-plus"></i> Sign in using Google+</a> -->
						
					<div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>
				</div>
				
				
				<!-- /.social-auth-links -->

				<a href="#" onclick="getPassword()">Forgot Password</a><br> <a
					href="#" onclick="registeruser()" class="text-center">User
					Registration</a>

			</div>

		</div>

		<!-- -----------------------Forgot Password------------------------- -->
		<div class="login-box" id="forgotpwd">
			<div class="login-logo">
				<a href="#"><b>JOIN</b>Group</a>
			</div>
			<div class="login-box-body">
				<p class="login-box-msg">Enter your user name or email</p>
				<form action="./forgotpwd" method="post" name="Login_Form"
					id="Login_Form" class="form-signin">
					<div class="form-group has-feedback">
						<input type="text" class="form-control" placeholder="Email"
							name="Username" id="Username" required=""> <span
							class="glyphicon glyphicon-envelope form-control-feedback"></span>
					</div>
					<div class="row">
						<div class="col-xs-8">
							<div class="checkbox icheck">
								<label> <input type="checkbox"> Remember Me
								</label>
							</div>
						</div>
						<div class="col-xs-4">
							<button class="btn btn-primary btn-block btn-flat"
								style="height: 30px; width: 100px">Get Password</button>
						</div>
					</div>
				</form>
				<a href="#" onclick="signin()">Sign In</a><br>
			</div>
		</div>
		<!-- -----------------------Forgot Password------------------------- -->

		<div class="register-box" id="registeruser">
			<div class="register-logo">
				<a href="#"><b>JOIN</b>Group</a>
			</div>

			<div class="register-box-body">
				<p class="login-box-msg">Register a new membership</p>

				<form action="./registerUsers" method="post" name="Register_Form" id="Register_Form" class="form-signin">
					<div class="form-group has-feedback">
						<input type="text" class="form-control" placeholder="Full name" name="username">
						<span class="glyphicon glyphicon-user form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="email" class="form-control" placeholder="Email" name="email">
						<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="password" class="form-control" placeholder="Password" name="password">
						<span class="glyphicon glyphicon-lock form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="password" class="form-control" placeholder="Retype password" name="retypepwd"> 
						<span class="glyphicon glyphicon-log-in form-control-feedback"></span>
					</div>
					<div class="row">
						<div class="col-xs-8">
							<div class="checkbox icheck">
								<label> <input type="checkbox"> I agree to the <a
									href="#">terms</a>
								</label>
							</div>
						</div>
						<div class="col-xs-4">
							<button class="btn btn-primary btn-block btn-flat" type="submit">Register</button>
						</div>
					</div>
				</form>

				<div class="social-auth-links text-center">
					<p>- OR -</p>
					<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i
						class="fa fa-facebook"></i> Sign up using Facebook</a> <a href="#"
						class="btn btn-block btn-social btn-google btn-flat"><i
						class="fa fa-google-plus"></i> Sign up using Google+</a>
				</div>

				<a href="#" onclick="signin()" class="text-center">Sign In</a>
			</div>
		</div>
	  </div>
	</div>
</body>










