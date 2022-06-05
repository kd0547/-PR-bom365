<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE HTML>
<html>
<head>
<title>봉사자모집</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<mytag:icon />
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

<!-- contect boardList.css -->
<link rel="stylesheet" href="css/boardList.css">

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
							<span><a href="main.jsp">Home</a></span> / <span>봉사자모집</span>
						</p>
					</div>
				</div>
			</div>
		</div>
		<h1 id="menuTitle">봉사자모집</h1>
		<!-- BoardList -->
		<div class="boardListFirstDiv">
			<div style="display: inline-block;">
				<table class="board table">
					<tbody>
						<tr>
							<td class="removeBorderTop"></td>
							<td colspan="2" class="removeBorderTop"
								style="padding-inline: 120px;">
<!-- 로그인상태 아니라면 숨김//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
								<a href="boardRequest.jsp"
								class="btn btn-primary inputSubmit apply">지원하기</a>
<!-- action 수정//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
								<form method="post" action="boardList.jsp"
									style="float: right;">
									<input type="text" name="keyword" class="searchKeyword">
									<input type="submit" value="검색"
										class="btn btn-primary inputSubmit searchButton">
								</form>
							</td>
							<td class="removeBorderTop"></td>
						</tr>
						<tr>
							<td class="removeBorderTop"></td>
							<td colspan="2" class="removeBorderTop" style="float: right;"><h6>
									정렬 :&nbsp; 
<!-- href 수정//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
									<a href="BoardList.jsp">댓글순</a>&nbsp;|&nbsp;
<!-- 로그인이안돼있다면 숨김//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- href 수정//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
									<a href="BoardList.jsp">내글보기</a>&nbsp;
								</h6></td>
							<td class="removeBorderTop"></td>
						</tr>
						<tr class="boardHead">
							<td style="width: 5em;">번호</td>
							<td style="width: 30em;">제목</td>
							<td style="width: 5em;">작성자</td>
							<td style="width: 5em;">날짜</td>
						</tr>
					</tbody>
					<tbody class="boardTbottom">
						<tr>
<!-- 값들 수정//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- 데이터 불러온뒤 for문으로 구현//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
							<td>4</td>
<!-- href 수정//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
							<td class="fontSize-17"><a href="boardOne.jsp">안녕하세요 반갑습니다.</a></td>
							<td>김개똥</td>
							<td>22.05.30</td>
						</tr>
<!-- 페이지 채우기 용//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
						<tr>
							<td>3</td>
							<td class="fontSize-17"><a href="boardOne.jsp">오늘 날씨가 참 좋네요</a></td>
							<td>김말똥</td>
							<td>22.04.21</td>
						</tr>
						<tr>
							<td>2</td>
							<td class="fontSize-17"><a href="boardOne.jsp">가나다라마바사아자차카타파하</a></td>
							<td>김소똥</td>
							<td>22.04.10</td>
						</tr>
						<tr>
							<td>1</td>
							<td class="fontSize-17"><a href="boardOne.jsp">abcdEFDHijklMNOPqrsyUVXXyz</a></td>
							<td>김닭똥</td>
							<td>22.02.12</td>
						</tr>
<!-- 여기까지 페이지 채우기 용//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
					</tbody>
				</table>
			</div>
		</div>
<!-- 페이지네이션 구현한다면 유지//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
		<div style="margin-bottom: 3em;">
			<div class="col-md-12 text-center">
				<div class="block-27">
					<ul>
						<li><a href="#"><i class="ion-ios-arrow-back"></i></a></li>
						<li class="active"><span>1</span></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#"><i class="ion-ios-arrow-forward"></i></a></li>
					</ul>
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
