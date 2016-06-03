<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>HSI 2016 Innovators' Community</title>
        <link rel="stylesheet" href="/../css/style1.css">
  </head>
  <body>
		<center><img class="logo" src="logo.jpg"></center>
    <div class="wrapper">
	<div class="container">
		<h1>Only For Secretariat.</h1>
		<h4><br>아이디와 비밀번호를 다시 한번 확인하세요.<br></h4>
		<form class="form" action="/user/secretariat/login" method="post">
			<input type="text" name="sec_id" placeholder="Username">
			<input type="password" name="sec_pw" placeholder="Password">
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
        <script src="/../js/index.js"></script>
				<footer>HAEYUM SOCIAL INNOVATION CHALLENGE 2016 - POWERED BY HAEYUM TOGETHER</footer>
  </body>
</html>
