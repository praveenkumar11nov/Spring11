<%@include file="decorator.jsp" %>

<script>
$(document).ready(function(){
   $('#login').show();
   $('#forgotpwd').hide();
   $('#registeruser').hide();
   var msg="${msg}";
   if(msg==""||msg==null){
	   
   }else{
	   alert(msg);
   }
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
function checkpwd(){
	if($('#Username').val()==''){
		alert("Insert UserName");
		return false;
	}else if($('#Password').val()==''){
		alert("Insert Password");
		return false;
	}else{
		if($('#Username').val()=='praveen' && $('#Password').val()=='123'){
			$('#Login_Form').submit();
		}else{
			alert('Wrong password or username');
			return false;
		}
	}
}
</script>

<title>JOIN</title>
<body class="hold-transition login-page">
<div class="login-box" id="login">
  <div class="login-logo">
    <a href="#"><b>JOIN</b>Group</a>
  </div>
  <div class="login-box-body">
    <p class="login-box-msg">Sign in to start your session</p>

    <form action="./successPage" method="post" name="Login_Form" id="Login_Form" class="form-signin">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="Email" name="Username" id="Username">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="Password" name="Password" id="Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> Remember Me
            </label>
          </div>
        </div>
        <div class="col-xs-4">
          <button class="btn btn-primary btn-block btn-flat" onclick="return checkpwd();">Sign In</button>
        </div>
      </div>
    </form>

    <div class="social-auth-links text-center">
      <p>- OR -</p>
      <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using
        Facebook</a>
      <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign in using
        Google+</a>
    </div>
    <!-- /.social-auth-links -->

    <a href="#" onclick="getPassword()">Forgot Password</a><br>
    <a href="#" onclick="registeruser()" class="text-center">User Registration</a>

  </div>

</div>

<!-- -----------------------Forgot Password------------------------- -->
<div class="login-box" id="forgotpwd">
  <div class="login-logo">
    <a href="#"><b>JOIN</b>Group</a>
  </div>
  <div class="login-box-body">
    <p class="login-box-msg">Enter your user name or email</p>
    <form action="./forgotpwd" method="post" name="Login_Form" id="Login_Form" class="form-signin">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="Email" name="Username" id="Username" required="">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> Remember Me
            </label>
          </div>
        </div>
        <div class="col-xs-4">
          <button class="btn btn-primary btn-block btn-flat" 
          style="height:30px;width:100px">Get Password</button>
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

    <form action="#" method="post">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="Full name">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="email" class="form-control" placeholder="Email">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="Retype password">
        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> I agree to the <a href="#">terms</a>
            </label>
          </div>
        </div>
        <div class="col-xs-4">
          <button class="btn btn-primary btn-block btn-flat">Register</button>
        </div>
      </div>
    </form>

    <div class="social-auth-links text-center">
      <p>- OR -</p>
      <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign up using
        Facebook</a>
      <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign up using
        Google+</a>
    </div>

    <a href="#" onclick="signin()" class="text-center">Sign In</a>
  </div>
</div>
</body>
<style>
.icheck > label {
    padding-left: 21px;
}

/* .btn{
padding:6px,4px;
} */
</style>




<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<table align="right">
	<tr>
		 <td><input type="text" name="color" id="color"></td>
		<td><label>COLOURS:
			<input list="bgcolor" name="color" id="color" /></label> 
			<datalist id="bgcolor">
				<option value="Violet">
				<option value="Indigo">
				<option value="Black">
				<option value="Blue">
				<option value="Brown">
				<option value="Green">
				<option value="Yellow">
				<option value="Orange">
				<option value="Red">
			</datalist></td>
	</tr>
</table>

<div class = "container">
	<div class="wrapper">
		<form action="./successPage" method="post" name="Login_Form" id="Login_Form" class="form-signin">       
		    <h3 class="form-signin-heading">LOGIN</h3>
			  <hr class="colorgraph"><br>
			  <input type="text" class="form-control" name="Username" id="Username" placeholder="Username" required="" autofocus="" />
			  <input type="password" class="form-control" name="Password" id="Password" placeholder="Password" required=""/>     		  
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" onclick="return checkpwd();">Login</button>  			
		</form>			
	</div>
</div>

<script>
function checkpwd(){
	if($('#Username').val()==''){
		alert("Insert UserName");
	}else if($('#Password').val()==''){
		alert("Insert Password");
	}else{
		if($('#Username').val()=='praveen' && $('#Password').val()=='123'){
			$('#Login_Form').submit();
		}else{
			alert('Wrong password or username');
			return false;
		}
	}
}

$(function() {
	$('#color').keypress(function(e) {
	var key = e.which;
	if (key == 13){
		$("body").css("background-color",$('#color').val());
	}
  });
});
	
</script>

<style>
body {background-color: pink;}

.wrapper {    
	margin-top: 80px;
	margin-bottom: 20px;
}

.form-signin {
  max-width: 420px;
  padding: 30px 38px 66px;
  margin: 0 auto;
  background-color: #eee;
  border: 3px dotted rgba(0,0,0,0.1);  
  }

.form-signin-heading {
  text-align:center;
  margin-bottom: 30px;
}

.form-control {
  position: relative;
  font-size: 16px;
  height: auto;
  padding: 10px;
}

input[type="text"] {
  margin-bottom: 0px;
  border-bottom-left-radius: 0;
  border-bottom-right-radius: 0;
}

input[type="password"] {
  margin-bottom: 20px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

.colorgraph {
  height: 7px;
  border-top: 0;
  background: #c4e17f;
  border-radius: 5px;
  background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
}
</style> -->

