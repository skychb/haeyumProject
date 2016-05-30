<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>HSI 2016 Innovators' Community</title>
        <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
		<center><img class="logo" src="logo.jpg"></center>
    <div class="wrapper">
	<div class="container">
		<h1>Innovators, Please login.</h1>
		<h4><br>참가자 여러분들은 이메일로 드린 아이디와 비밀번호로 로그인해주세요.<br></h4>
		<form class="form" action="/user/login" method="post">
			<input type="text" name="par_id" placeholder="Username">
			<input type="password" name="par_pw" placeholder="Password">
			<button type="submit" id="login-button">Login</button>
		</form>
	</div>

	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="js/index.js"></script>
				<footer>HAEYUM SOCIAL INNOVATION CHALLENGE 2016 - POWERED BY HAEYUM TOGETHER</footer>
  </body>
</html>
