<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE HTML>
<html>
<head>
<title>상세글</title>
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
<link rel="stylesheet" href="css/boardOne.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	function choose() {
		ans = confirm("${application.supporter_id}님을 ${application.animal_name}의 입양자로 결정하시겠습니까?");
		if (ans == true) {
			location.href = "animalUpdate.am?animal_number=${application.animal_number}&application_number=${application.application_number}&supporter_id=${application.supporter_id}";
		} else {
			event.preventDefault();
		}
	}
</script>
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
							<span><a href="adminApplicationList.ap">입양신청목록</a></span> / <span>상세글</span>
						</p>
					</div>
				</div>
			</div>
		</div>

		<c:if test="${application.adoptionSupporter_id != null}">
			<c:choose>
				<c:when
					test="${application.adoptionSupporter_id == application.supporter_id}">
					<h1 id="menuTitle" style="color: #595959a6;">🎉🎉🎉&nbsp;&nbsp;&nbsp;가족으로
						선정된 신청서 입니다!&nbsp;&nbsp;&nbsp;🎉🎉🎉</h1>
				</c:when>
				<c:otherwise>
					<h1 id="menuTitle" style="color: #595959a6;">🌼🌼🌼🌼&nbsp;&nbsp;&nbsp;이미
						가족을 찾았습니다.&nbsp;&nbsp;&nbsp;🌼🌼🌼🌼</h1>
				</c:otherwise>
			</c:choose>
		</c:if>

		<div style="text-align: center; margin-top: 2em; margin-bottom: 7em;">
			<div class="col-sm-4 text-left total writeForm"
				style="display: inline-block;">
				<div class="form-group">

					<div class="form-group boardOne">
						<h5 class="h5-detail title" style="width: 100%;">신청자</h5>
						<h5 class="h5-detail title info">${application.application_date}</h5>
					</div>
					<div class="title-box">
						<h5 style="padding: 14px;">${application.supporter_id}</h5>
					</div>
					<div class="form-group boardOne">
						<h5 class="h5-detail title" style="width: 100%;">입양 신청
							동물번호(동물이름)</h5>
					</div>
					<div class="title-box">
						<h5 style="padding: 14px;">${application.animal_number}(${application.animal_name})</h5>
					</div>

					<div class="form-group boardOne">
						<h5 class="h5-detail title" style="width: 100%;">제목</h5>
					</div>
					<div class="title-box">
						<h5 style="padding: 14px;">${application.application_title}</h5>
					</div>
					<div class="form-group">
						<h5>내용</h5>
						<textarea name="board_content" id="autoHeight"
							class="form-control gap one" disabled>${application.application_content}</textarea>
					</div>
					<script type="text/javascript">
						function adjustHeight() {
							var textEle = $('#autoHeight');
							var textEleHeight = textEle.prop('scrollHeight');
							console.log(textEleHeight);
							textEle.css("height", textEleHeight);
						};
						adjustHeight();
					</script>
					<div style="float: right;">
						<a href="adminApplicationList.ap" class="btn btn-primary boardUD">목록보기</a>
					</div>
					<!-- 관리자인지 한번 더 확인  -->
					<c:if
						test="${(supporter_id == 'admin') && (application.adoptionSupporter_id == null)}">
						<div style="float: right;">
							<a href="#" class="btn btn-primary boardUD" onclick="choose()">입양자
								확정</a>
						</div>
					</c:if>


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















