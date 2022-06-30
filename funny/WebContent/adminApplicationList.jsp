<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE HTML>
<html>
<head>
<title>후원신청목록</title>

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

<!-- contect boardList.css -->
<link rel="stylesheet" href="css/boardList.css">

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
							<span><a href="main.do">HOME</a></span> / <span>입양신청목록</span>
						</p>
					</div>
				</div>
			</div>
		</div>

		<h1 id="menuTitle">입양신청목록</h1>


		<div class="boardListFirstDiv">
			<div style="display: inline-block;">
				<h6 align="right" style="color: #8d8d8d;">🎉: 선정된
					신청서&nbsp;|&nbsp;🌼: 이미 입양된 동물&nbsp;|&nbsp;글 개수 : ${totalCnt}개</h6>
				<table class="board table">
					<tbody>
						<tr class="boardHead">
							<td style="width: 5em;">신청번호</td>
							<td style="width: 8em;">동물번호</td>
							<td style="width: 20em;">제목</td>
							<td style="width: 6em;">신청자 ID</td>
							<td style="width: 8em;">신청날짜</td>
						</tr>
					</tbody>
					<c:choose>
						<c:when
							test="${applicationList != null and fn:length(applicationList) > 0 }">
							<tbody class="boardTbottom">
								<!-- 게시글 작성 : 글이 있는 경우 -->
								<c:forEach var="application" items="${applicationList}">
									<tr>
										<td>${application.application_number }</td>
										<td>${application.animal_number}(${application.animal_name})</td>
										<td class="boardTitle"><a
											href="adminApplicationOne.ap?application_number=${application.application_number}">
												<c:if test="${application.adoptionSupporter_id != null}">
													<c:choose>
														<c:when
															test="${application.adoptionSupporter_id == application.supporter_id}">
														🎉
													</c:when>
														<c:otherwise>
														🌼
													</c:otherwise>
													</c:choose>
												</c:if> ${application.application_title}
										</a></td>
										<td>${application.supporter_id}</td>
										<td>${application.application_date}</td>
									</tr>
								</c:forEach>
							</tbody>
						</c:when>
						<c:otherwise>
							<tbody class="boardTbottom">
								<tr style="height: 50px">
									<td colspan="5"><h3>입양신청 목록이 없습니다!</h3></td>
								</tr>
							</tbody>
						</c:otherwise>
					</c:choose>
				</table>
				<br>


				<div>
					<div class="col-md-12 text-center">
						<div class="block-27">
							<ul>
								<c:if test="${nowPage > 1 }">
									<li><a href="adminApplicationList.ap?page=${nowPage-1}"><i
											class="ion-ios-arrow-back"></i></a></li>
								</c:if>
								<c:forEach var="i" begin="${startPage }" end="${endPage }">
									<c:choose>
										<c:when test="${i == nowPage }">
											<li class="active"><span>${i }</span></li>
										</c:when>
										<c:otherwise>
											<li><a href="adminApplicationList.ap?page=${i}">${i }</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:if test="${nowPage < totalPage }">
									<li><a href="adminApplicationList.ap?page=${nowPage+1}"><i
											class="ion-ios-arrow-forward"></i></a></li>
								</c:if>
							</ul>
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
