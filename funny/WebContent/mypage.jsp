<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<!-- contect boardList.css -->
<link rel="stylesheet" href="css/boardList.css">

<!-- contect signup.css -->
<link rel="stylesheet" href="css/signup_mypage.css">

<!-- contact deleteAccount.css -->
<link rel="stylesheet" href="css/deleteAccount.css">
<link rel="stylesheet" href="css/supportRequest.css">
<link rel="stylesheet" href="css/support.css">
</head>

<body>
	<div id="page">

		<!-- Page Header-->
		<mytag:pageHeader />

		<div class="breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col">
						<p class="bread">
							<span><a href="main.do">HOME</a></span> / <span>my page</span>
						</p>
					</div>
					<div class="col">
						<ul class="nav nav-pills mb-3">

							<li class="nav-item"><a class="nav-link active show"
								id="pills-description-tab" data-toggle="pill"
								href="#pills-description" role="tab"
								aria-controls="pills-description" aria-expanded="true"
								aria-selected="true">정보수정</a></li>
							<li class="nav-item"><a class="nav-link"
								id="pills-manufacturer-tab" data-toggle="pill"
								href="#pills-manufacturer" role="tab"
								aria-controls="pills-manufacturer" aria-expanded="true"
								aria-selected="false">내역조회</a></li>
							<li class="nav-item"><a class="nav-link"
								id="pills-review-tab" data-toggle="pill" href="#pills-review"
								role="tab" aria-controls="pills-review" aria-expanded="true"
								aria-selected="false">회원탈퇴</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<h1 id="menuTitle">My Page</h1>


		<div class="twin container">
			<div class="col-sm-12">
				<div class="row">
					<div class="col-md-12 pills">
						<div class="bd-example bd-example-tabs">
							<div class="tab-content" id="pills-tabContent">

								<div class="tab-pane border fade active show"
									id="pills-description" role="tabpanel"
									aria-labelledby="pills-description-tab">
									<mytag:updateSupporter />
								</div>

								<div class="tab-pane border fade" id="pills-manufacturer"
									role="tabpanel" aria-labelledby="pills-manufacturer-tab"
									style="padding: 32px 0 4em 0;">
									<mytag:myTable />
								</div>

								<div class="tab-pane border fade" id="pills-review"
									role="tabpanel" aria-labelledby="pills-review-tab">
									<mytag:withdrawal />

								</div>
							</div>
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
