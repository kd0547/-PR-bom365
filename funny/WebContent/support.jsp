<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<div class="colorlib-loader"></div>
<div id="page">

	<!-- Page Header-->
	<mytag:pageHeader />
	<div class="breadcrumbs">
		<div class="container">
			<div class="row">
				<div class="col">
					<p class="bread">
						<!-- href수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
						<span><a href="main.jsp">HOME</a></span> / <span>후원하기</span>
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
					<!-- href수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
					<a href="supportREGRequest.jsp" class="btn btn-primary support">&nbsp;후원하기&nbsp;</a>
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
					<!-- href수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
					<a href="supportTEMRequest.jsp" class="btn btn-primary support">&nbsp;후원하기&nbsp;</a>
				</div>
			</div>
		</div>
	</div>

	<hr style="margin-top: 0;">
	<h3 class="h3support">후원금은 이렇게 사용됩니다</h3>
	<div class="container">
		<div class="row row-pb-md support">
			<div class="col footer-col colorlib-widget">
				<img src="images_sample/supportEX1.jpg" class="img-fluid animals"
					alt="Free html5 bootstrap 4 template">
				<h4>보호 · 입양</h4>
				<p>봄365가 구조한 동물들은 센터로 입소하여 살처분의 위험 없이 청결한 환경에서 따뜻한 보살핌을 받습니다.
					동물들은 봄365의 엄격한 입양심사를 통해 평생가족을 찾습니다.</p>
			</div>
			<div class="col footer-col colorlib-widget">
				<img src="images_sample/supportEX2.jpg" class="img-fluid animals"
					alt="Free html5 bootstrap 4 template">
				<h4>구조 · 구호</h4>
				<p>긴급한 도움이 필요한 동물들을 구조하고, 시민들이 구조한 동물의 치료와 입양을 지원합니다. 사설보호소 지원 및
					봉사, 중성화수술과 사료지원 등 구호활동을 함께합니다.</p>
			</div>
			<div class="col footer-col colorlib-widget">
				<img src="images_sample/supportEX3.jpg" class="img-fluid animals"
					alt="Free html5 bootstrap 4 template">
				<h4>아카이빙</h4>
				<p>동물권 자료와 기록을 보관하고 공유합니다. 동물과 동물권 활동에 대한 정보 공유는 보다 건설적이고 건강한
					동물권 성립을 위한 시민활동의 자양분이 되고 있습니다.</p>
			</div>
		</div>
	</div>

	<div class="container" style="margin-bottom: 14em;">
		<div class="row row-pb-md support">
			<div class="col footer-col colorlib-widget">
				<img src="images_sample/supportEX4.jpg" class="img-fluid animals"
					alt="Free html5 bootstrap 4 template">
				<h4>문화활동 및 캠페인</h4>
				<p>동물영화제·전시회·인문사회 프로그램 등을 통해 생명존중 의식 확장의 장을 마련하여 시민과 함께하는 다양한
					활동으로 성숙한 시민사회를 도모합니다.</p>
			</div>
			<div class="col footer-col colorlib-widget">
				<img src="images_sample/supportEX5.jpg" class="img-fluid animals"
					alt="Free html5 bootstrap 4 template">
				<h4>법 · 정책 연구 및 제안</h4>
				<p>모든 동물의 권리를 보장하기 위해 법과 정책을 연구하고 제안합니다. 동물보호법 강화와 더불어 동물권을 헌법에
					명시하기 위한 활동을 전개합니다.</p>
			</div>
			<div class="col footer-col colorlib-widget">
				<img src="images_sample/supportEX6.jpg" class="img-fluid animals"
					alt="Free html5 bootstrap 4 template">
				<h4>학대대응</h4>
				<p>학대행위에 고발조치를 취하고, 동물보호법의 사각지대에 있는 동물들을 구제하기 위한 전략을 수립하여 정부기관과
					협력해 동물학대가 발생하지 않도록 앞장서고 있습니다.</p>
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


