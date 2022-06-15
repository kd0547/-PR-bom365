<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE HTML>
<html>
<head>
<title>신청서작성</title>
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
							<span><a href="animalsList.jsp">입양하기</a></span> / <span>입양신청</span>
						</p>
					</div>
				</div>
			</div>
		</div>
		<div id="menuTitle">
			<h1>입양 신청서</h1>
			<h6>평생 책임질 준비 되셨나요? 구조된 동물들에게 입양은 마지막 기회이자 유일한 희망입니다.</h6>
		</div>
		<hr>

		<div style="text-align: center; margin-top: 2em; margin-bottom: 7em;">
			<div class="col-sm-4 text-left total writeForm"
				style="display: inline-block;">
<!-- action수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
				<form action="adoptDone.jsp" method="post">
					<div class="form-group">
						<h5>입양을 희망하는 동물의 이름</h5>
<!-- placeholder수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
						<input type="text" class="form-control gap"
							placeholder="강록" disabled="disabled">
						<h5>제목</h5>
						<input type="text" class="form-control gap"
							placeholder="제목을 입력해 주세요." name="application_title">

						<div class="form-group">
							<h5>신청 내용</h5>
							<textarea name="message" cols="30" rows="48"
								class="form-control gap" name="application_content">
01. 입양을 결정하시기 까지 얼마나 오랜 시간을 고민하셨나요?
→
							02. 입양을 원하시는 가장 큰 이유는 무엇인가요?
→
							03. 가족 구성원은 몇 명인가요? 구성원을 소개해주세요.
→
							04. 입양결정에 가족 모두 동의하십니까? (동의 / 비동의)
→
							05. 키우고 계신 반려동물이 있나요? 있다면 소개해주세요.
→
							06. 키우던 반려동물을 개인 사정으로 포기한 경험이 있으신가요? 이유는 무엇인가요?
→
							07. 주거의 형태는? (단독주택 / 공동주택 / 아파트)
→
							08. 정원이 있다면 담이나 울타리가 되어있나요? 되어있다면 높이는 얼마나 되나요?
→
							09. 임대한 주택의 경우 집주인의 동의를 얻으셨나요?
→
							10. 소음이나 위생 등으로 인한 이웃과의 마찰로 입양동물의 양육이 불가능해질 경우 어떻게 하실건가요?
→
							11. 이사 또는 해외로 이주 시 반려동물의 거취문제에 대해 어떻게 생각하십니까?
→
							12. 앞으로 결혼, 임신, 출산 등 가족의 변화가 있는 경우 반려동물의 거취문제에 대해 어떻게 생각하십니까?
→
							13. 입양 후 모니터링을 위한 전화연락이나 방문, 인스타그램 가입 및 게시물 공유에 동의하십니까? (동의 / 비동의)
→
							14. 동물 관련 활동경험이 있으신가요? 또는 평소 알고 있던 동물단체들이 있다면 아는대로 적어주세요.
→
							15. 길고양이에게 밥을 주신 적이 있으신가요? 유기동물 구조 경험이 있으신가요?
→
							16. 입양희망 동물에 대해 어떻게 알게 되셨나요? (예시: 네이버 블로그, 기사, 페이스북, 트위터, 인스타그램 등등)
→
							</textarea>
						</div>
					</div>
					<input type="submit" value="입양 신청하기"
						class="btn btn-primary inputSubmit">
				</form>
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

