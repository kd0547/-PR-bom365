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
<script>
	window.name="main"

	function openPopup(url) {
		window.open(url, '봉사신청', 'width=400, height=300, left=745, top=200');
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
							<span><a href="main.do">HOME</a></span> / <span>봉사신청</span>
						</p>
					</div>
				</div>
			</div>
		</div>

		<h1 id="menuTitle">봉사신청</h1>

		<section>
			<div class="boardListFirstDiv">
				<div style="display: inline-block;">
					<table class="calendar">
						<tr>
							<td>
								<!-- 저번달로 이동 --> <c:choose>
									<c:when
										test="${volCal.beforeYear le volCal.currentYear and volCal.beforeMonth lt volCal.currentMonth}">
										<!-- 저번달이 과거일때 -->
										<button type="button" class="volFull" disabled>
											<i class="ion-ios-arrow-back"></i>&nbsp;${volCal.beforeMonth}월
										</button>
									</c:when>
									<c:otherwise>
										<button type="button"
											onclick="location='volunteerList.vt?year=${volCal.beforeYear}&month=${volCal.beforeMonth}'">
											<i class="ion-ios-arrow-back"></i>&nbsp;${volCal.beforeMonth}월
										</button>
									</c:otherwise>
								</c:choose>
							</td>

							<td colspan="5"><h4 style="margin: 0">${volCal.year}년${volCal.month}월</h4></td>

							<td>
								<!-- 다음달로 이동 --> <c:choose>
									<c:when test="${volCal.afterMonth ge volCal.currentMonth+3}">
										<!-- 다음달이 지금으로부터 +4개월 이상일때 -->
										<button type="button" class="volFull" disabled>
											${volCal.afterMonth}월&nbsp;<i class="ion-ios-arrow-forward"></i>
										</button>
									</c:when>
									<c:otherwise>
										<button type="button"
											onclick="location='volunteerList.vt?year=${volCal.afterYear}&month=${volCal.afterMonth}'">
											${volCal.afterMonth}월&nbsp;<i class="ion-ios-arrow-forward"></i>
										</button>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>

						<tr class="calendarDay">
							<td>일</td>
							<td>월</td>
							<td>화</td>
							<td>수</td>
							<td>목</td>
							<td>금</td>
							<td>토</td>
						</tr>

						<tr>
							<c:set var="cnt" value="0" />

							<!-- 1일 요일 위치 맞추기 -->
							<c:forEach var="i" begin="2" end="${volCal.dayOfweek}">
								<td></td>
								<c:set var="cnt" value="${cnt+1}" />
							</c:forEach>

							<!-- 날짜 채우기 -->
							<c:forEach var="v" items="${volCnts}">
								<c:set var="cnt" value="${cnt+1}" />

								<!-- 주말 색 지정 -->
								<c:choose>
									<c:when test="${cnt % 7 == 1}">
										<c:set var="color" value="#b74a55" />
									</c:when>
									<c:when test="${cnt % 7 == 0}">
										<c:set var="color" value="#4a67b7" />
									</c:when>
									<c:otherwise>
										<c:set var="color" value="#595959" />
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when
										test="${volCal.month eq volCal.currentMonth and v.date le volCal.currentDate}">
										<!-- 봉사 신청 가능 여부 확인 -->
										<td class="calendarDate"><button class="volFull" disabled>${v.date}</button></td>
									</c:when>
									<c:when test="${v.isfull}">
										<!-- 봉사 신청 가능 여부 확인 -->
										<td class="calendarDate"><button class="volFull" disabled>마감</button></td>
									</c:when>
									<c:otherwise>
										<td class="calendarDate"><c:choose>
												<c:when test="${supporter_id == null}">
													<button onclick="loginCheck()" style="color: ${color}">${v.date}</button>
												</c:when>
												<c:otherwise>
													<button
														onclick="openPopup('volunteerRequest.vt?yyyyMMdd=${v.yyyyMMdd}&cntAM=${v.cntAM}&cntPM=${v.cntPM}')"
														style="color: ${color}">${v.date}</button>
												</c:otherwise>
											</c:choose></td>
									</c:otherwise>
								</c:choose>

								<!-- 토요일에서 줄 바꿈 -->
								<c:if test="${cnt % 7 == 0}">
									<%="</tr><tr>"%>
									<c:set var="cnt" value="0" />
								</c:if>
							</c:forEach>

							<!-- 남은 칸 채우기 -->
							<c:forEach var="i" begin="1" end="${7-cnt}">
								<td></td>
							</c:forEach>
						</tr>
					</table>
				</div>
			</div>
		</section>

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

