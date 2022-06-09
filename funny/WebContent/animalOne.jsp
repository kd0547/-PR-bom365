<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE HTML>
<html>
<head>
<title>마이페이지</title>

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

<!-- contect detailPage -->
<link rel="stylesheet" href="css/animalOne.css">

<!-- Material Icons -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

</head>

<body>


	<div class="colorlib-loader"></div>
	<div id="page">

		<!-- Page Header-->
		<mytag:pageHeader/>
		<div class="breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col">
						<p class="bread">
<!-- href수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
							<span><a href="supportMain.jsp">입양하기</a></span> / <span>상세페이지</span>
						</p>
					</div>
				</div>
			</div>
		</div>
		<!--  외부페이지 상단-->

		<h1 id="menuTitle">보호동물 정보</h1>

		<!--  외부페이지 ul-->
		<div class="colorlib-about">



			<div class="container">
				<div class="row row-pb-lg">
					<div class="col-sm-6 mb-3" style="margin-left: 5em;">
<!-- src수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
						<img class="img-fluid w-100" src="images_sample/강록.png">
					</div>
				<div class="about-wrap">
<!-- 데이터 수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
						<span class="animal-name">강록</span> 
						
						<hr class="my-5">
						
						<ul class="list-unstyled mb-0">
							<li class="media mb-1">
								<div class="d-flex w-40 w-sm-30">
									<small class="text-muted"> 종/품종 </small>
								</div>
									<div class="h6-container">
<!-- 데이터 수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
									<p class="h6">개 / 믹스</p>
									</div>
							</li>
							<li class="media mb-1">
								<div class="d-flex w-40 w-sm-30">
									<small class="text-muted"> 성별(중성화) </small>
								</div>
								<div class="h6-container">
<!-- 데이터 수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
									<h3 class="h6">암컷 / 중성화 X</h3>
								</div>
							</li>
							<li class="media mb-1">
								<div class="d-flex w-40 w-sm-30">
									<small class="text-muted"> 추정나이 </small>
								</div>
								<div class="h6-container">
<!-- 데이터 수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
									<h3 class="h6">1살 1개월</h3>
								</div>
							</li>
							<li class="media mb-1">
								<div class="d-flex w-40 w-sm-30">
									<small class="text-muted"> 몸무게 </small>
								</div>
								<div class="h6-container">
<!-- 데이터 수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
									<h3 class="h6">6.1kg</h3>
								</div>
							</li>
						</ul>
<!-- href 수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
					<a href="adoptionRequest.jsp" class="btn btn-primary adopt">&nbsp;입양하기&nbsp;</a>
					</div>
			</div>
					
			</div>
		</div>
	</div>

	<!-- Page Footer-->
	<mytag:pageFooter />
	</div>
	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="ion-ios-arrow-up"></i></a>
	</div>

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
