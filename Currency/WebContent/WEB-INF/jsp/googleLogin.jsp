<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="793361494596-jju98ipq1ufjj644qhcl8p7gb76s7ecg.apps.googleusercontent.com">

<script type="text/javascript">
	function onSignIn(googleUser) {
		var profile = googleUser.getBasicProfile();
		var imagurl = profile.getImageUrl();
		var name = profile.getName();
		var email = profile.getEmail();
		//alert("RESPONSE : name="+name+",email="+email+",imagurl="+imagurl);
		//window.location="./dashboard?name="+name+"&email="+email+"&imagurl="+imagurl;


		  $('#inset_form').html(
			  '<form action="./dashboard" id="googlesignin" method="post" style="display:none;">'+
			  '<input type="text" name="name" value="' + name + '" />'+
			  '<input type="text" name="email" value="' + email + '" />'+
			  '<input type="text" name="imagurl" value="' + imagurl + '" />'+
			  '</form>'
		  );

		  document.getElementById("googlesignin").submit();
		
		/* 
		var profile = googleUser.getBasicProfile();
		var imagurl = profile.getImageUrl();
		var name = profile.getName();
		var email = profile.getEmail();
		document.getElementById("myImg").src = imagurl;
		document.getElementById("name").innerHTML = name;
		document.getElementById("myP").style.visibility = "hidden";
		document.getElementById("status").innerHTML = 
			'Welcome ' + name + '!<a href=googleLogin.jsp?email='+ email + '&name=' + name + '/>Continue with Google login</a></p>'

		 */
	}
	
	function signout() {
		alert("signout form google login");
		gapi.auth2.getAuthInstance().disconnect();
	    location.reload();
	}
</script>
<div id="inset_form"></div>