<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE HTML>
<html>
<head>
<title>봉사신청</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
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
</head>
<body>

	<div class="colorlib-loader"></div>

	<div id="page">

		<!-- Page Header-->
		<mytag:pageHeader pageSector=" " />
		<div class="breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col">
						<p class="bread">
<!-- href수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
							<span><a href="boardList.jsp">봉사자모집</a></span> / <span>게시글작성</span>
						</p>
					</div>
				</div>
			</div>
		</div>
		<h1 id="menuTitle">게시글 상세내용</h1>
		<hr>
<!-- 본인 게시물일때 수정하기/삭제하기 버튼추가//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
		<div style="text-align: center; margin-top: 2em; margin-bottom: 7em;">
			<div class="col-sm-4 text-left total writeForm"
				style="display: inline-block;">
				<form action="boardDone.jsp" method="post">
					<div class="form-group">
						<h5 class="h5-detail title">제목</h5>
						<div class="title-box">
<!-- 제목 수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
								<h5 style="padding: 14px;">안녕하세요 반갑습니다.</h5>
						</div>
						<div class="form-group">
							<h5 class="h5-detail comment">내용</h5>
<!-- 내용 수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
							<div class="comment-box">
								<h5 style="padding: 14px;">처음 뵙겠습니다!</h5>
							</div>
						</div>
					</div>
				</form>

			</div>


			<!-- 댓글 -->

			<hr>

			<div class="col-sm-4 text-left total writeForm"
				style="display: inline-block;">

				<div class="col-md-8">
<!-- 개수 수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
					<h3 class="head">23 Reviews</h3>
					<div class="review">
						<div class="desc">
							<h4>
<!-- 데이터 불러온뒤 for문으로 구현//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- 이름 수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
								<span class="text-left">한지민</span>
							</h4>
<!-- 내용 수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
							<p class="p-comment">좋은글 잘보고 갑니다~^^* 오늘도 화이팅 ㅎㅎ!</p>
<!-- 날짜 수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
							<span class="text-right">16 March 2022</span>
						</div>
					</div>
<!-- 데이터 불러온뒤 for문으로 구현//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
					<div class="review">
						<div class="desc">
							<h4>
								<span class="text-left">김우빈</span>
							</h4>
							<p class="p-comment">너무 좋은 글이네요...~~^^~ 언제나 함께하는 느낌이라는~!! 정모때
								봅시다덜~!!!^^</p>
							<span class="text-right">15 March 2022</span>
						</div>
					</div>
					<div class="review">
						<div class="desc">
							<h4>
								<span class="text-left">손예진</span>
							</h4>

							<p class="p-comment">퍼가요~♡</p>
							<span class="text-right">14 March 2022</span>
						</div>
					</div>
				</div>
<!-- 여기까지 페이지 채우기 용//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

<!-- 로그인 안되어있다면 disabled//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- action 수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
				<form action="boardOne.jsp" method="post">
					<textarea name="comment_context" cols="10" rows="3"
						class="form-control gap comment"></textarea>
					<input type="submit" value="댓글등록"
						class="btn btn-primary inputSubmit">
				</form>
			</div>
		</div>
	</div>

	<!-- Page Footer-->
	<mytag:pageFooter />


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

