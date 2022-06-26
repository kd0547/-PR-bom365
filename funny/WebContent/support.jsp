<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE HTML>
<html>
<head>
<title>후원하기</title>

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

<!-- contect signup.css -->
<link rel="stylesheet" href="css/support.css">

<!-- Material Icons -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

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
							<span><a href="main.do">HOME</a></span> / <span>후원하기</span>
						</p>
					</div>
				</div>
			</div>
		</div>

		<h1 id="menuTitle">후원하기</h1>
		<hr>

		<div class="twin container support">
			<div class="row">
				<div class="col-md-6" style="padding-left: 15em;">
					<div class="twins-wrap">
						<h2 class="sub-title">정기후원</h2>
						<div>
							<div></div>
						</div>
						<h5 class="subscript">
							매달 약정된 금액을 후원하여<br>다양한 영역에서의<br>캠페인과 문화 영역에서의 활동 등<br>봄365의
							전반적인 활동과 운영을<br>지지해 주실 수 있습니다.
						</h5>
						<c:choose>
							<c:when test="${regular_end == '진행중'}">
								<a style="color: white;" class="btn btn-primary del support">이미
									후원 중 입니다!</a>
							</c:when>
							<c:otherwise>
								<a href="#"
									onclick="${supporter_id == null? 'loginCheck()':'goREG()'}"
									class="btn btn-primary del support">후원하기</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>

				<div class="col-md-6" style="padding-right: 15em;">
					<div class="twins-wrap">
						<h2 class="sub-title">일시후원</h2>
						<div>
							<div></div>
						</div>
						<h5 class="subscript">
							반려동물의 생일이나 입양일 등<br>소중한 날을 기념하여<br>동물들에게 사랑을 전해주세요.<br>한
							번의 따뜻한 사랑이<br>큰 기적을 이루게 됩니다.
						</h5>
						<a href="#"
							onclick="${supporter_id == null? 'loginCheck()':'goTEM()'}"
							class="btn btn-primary del support">후원하기</a>
					</div>
				</div>
			</div>
		</div>

		<hr>
		<mytag:howToUseSupport />

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


