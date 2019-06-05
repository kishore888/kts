<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jssor-slider/26.6.0/jssor.slider.min.js"></script>

<script>
    jQuery(document).ready(function ($) {
        var options = { $AutoPlay: 1 };
        var jssor_slider1 = new $JssorSlider$('slider1_container', options);
    });
</script>

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
/*  	padding: 20px;  */
 	margin: 10px auto; 
	background: #9796ae;
/* 	-webkit-border-radius: 2px; */
/* 	-moz-border-radius: 2px; */
/* 	border: 1px solid #000; */
}
</style>

<style> 
#test {
/*     background-image: url(images/hotelmngt.jpg); */
/*     background-position: right bottom, left top; */
    background-repeat: no-repeat, repeat;
/*     padding: 15px; */
    width:100%;
    height:400px;
}
</style>


</head>
<body id="body" style="background-color:#e9bef2;" onload='document.loginForm.username.focus();'>

<div id="slider1_container" style="position: relative; top: 0px; left: 0px; width: 600px; height: 300px;">
    <!-- Slides Container -->
    <div u="slides" style="cursor: move; position: absolute; overflow: hidden; left: 0px; top: 0px; width: 1000px; height: 300px;">
        <div><img u="image" src="images/hotelmngt.jpg" /></div>
        <div><img u="image" src="images/Hotel-Management-Studies.jpeg" /></div>
        <div><img u="image" src="images/Desert.jpg" /></div>
    </div>
</div>



<!-- 	<h1>Spring Security Custom Login Form (XML)</h1> -->
<div class="row">

<div class="col-md-12" id="test">
<div class="col-md-8">

<!-- <img src="images/hotelmngt.jpg" alt="Smiley face" width="500" height="300"> -->
<div>
<!-- <span>Smart Work</span> -->
</div>
</div>

	<div class="col-md-4" id="login-box">

		<h3>Login with Username and Password</h3>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'>
<!-- 		<form name='loginForm' action="login2" method='POST'> -->

		  <table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input type="submit" class="btn btn-primary" value="Login" /></td>
			</tr>
		  </table>

<!-- 		Spring requires sending the csrf token on every form submit -->
		  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

		</form>
	</div>


</div>

</div>

<div class="row">
	<div class="col-md-12">
		<div id="example1">
			<h1>Lorem Ipsum Dolor</h1>
			<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
			<p>Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>
		</div>
	</div>

</div>


<script src="js/snowfalling.js"></script>

</body>
</html>
