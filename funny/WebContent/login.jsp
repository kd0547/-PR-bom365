<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<c:set var="PREVIOUS" value="<%=request.getHeader(\"REFERER\")%>"
    scope="session" />
<!DOCTYPE HTML>
<html>
<head>
<title>로그인</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<mytag:icon />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link
	href="https://fonts.googleapis.com/css2?family=Gowun+Batang:wght@400;700&family=Jua&display=swap"
	rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet" href="css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="css/icomoon.css">
<!-- Ion Icon Fonts-->
<link rel="stylesheet" href="css/ionicons.min.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Magnific Popup -->
<link rel="stylesheet" href="css/magnific-popup.css">

<!-- Flexslider  -->
<link rel="stylesheet" href="css/flexslider.css">

<!-- Owl Carousel -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">

<!-- Date Picker -->
<link rel="stylesheet" href="css/bootstrap-datepicker.css">
<!-- Flaticons  -->
<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

<!-- Theme style  -->
<link rel="stylesheet" href="css/style.css">

</head>
<body>

	<div id="page">

		<!-- Page Header-->
		<mytag:pageHeader/>

		<div class="breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col">
						<p class="bread">
							<span><a href="index.jsp">Home</a></span> / <span>로그인</span>
						</p>
					</div>
				</div>
			</div>
		</div>
		
		<h1 id="menuTitle">로그인</h1>
		<div class="col-md-12 total-wrap" id="login">
			<div class="col-sm-4 text-center total">
				<form action="login.me" method="post" name="loginForm">
					<table id="tableStyle">
						<tr>
							<td id="tableCol">아이디</td>
							<td><input type="text" class="form-control" name="supporter_id"></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" class="form-control" name="supporter_password"></td>
						</tr>
					</table>
					<table id="tableStyle" style="margin-top: 20px;">
						<tr>
							<td><input type="submit" class="btn btn-primary" value="&nbsp;로그인&nbsp;"></td>
							<td><a href="signup.jsp" class="btn btn-primary login">회원가입</a></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

		<!-- Page Footer-->
		<mytag:pageFooter />

	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="ion-ios-arrow-up"></i></a>
	</div>

	<script src="js/loginCheck.js"></script>
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- popper -->
	<script src="js/popper.min.js"></script>
	<!-- bootstrap 4.1 -->
	<script src="js/bootstrap.min.js"></script>
	<!-- jQuery easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Flexslider -->
	<script src="js/jquery.flexslider-min.js"></script>
	<!-- Owl carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Date Picker -->
	<script src="js/bootstrap-datepicker.js"></script>
	<!-- Stellar Parallax -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Main -->
	<script src="js/main.js"></script>

</body>
</html>

