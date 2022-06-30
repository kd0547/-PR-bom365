<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE HTML>
<html>
<head>
<title>봉사신청목록</title>
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
<link rel="stylesheet" href="css/signup_mypage.css">
<script>
	window.name = "main"

	function openPopup(url) {
		window.open(url, '봉사신청목록', 'width=700, height=500, left=595, top=200');
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
							<span><a href="main.do">HOME</a></span> / <span>봉사신청목록</span>
						</p>
					</div>
				</div>
			</div>
		</div>

		<h1 id="menuTitle">신청목록조회</h1>

		<section style="margin-bottom: 7em;">
			<div class="boardListFirstDiv" style="margin-bottom: 0;">
				<div style="display: inline-block;">
					<table class="calendar">
						<tr>
							<td>
								<!-- 저번달로 이동 -->
								<button type="button"
									onclick="location='volunteerList.vt?year=${volCal.beforeYear}&month=${volCal.beforeMonth}'">
									<i class="ion-ios-arrow-back"></i>&nbsp;${volCal.beforeMonth}월
								</button>
							</td>

							<td colspan="5"><h4 style="margin: 0">${volCal.year}년${volCal.month}월</h4></td>

							<td>
								<!-- 다음달로 이동 -->
								<button type="button"
									onclick="location='volunteerList.vt?year=${volCal.afterYear}&month=${volCal.afterMonth}'">
									${volCal.afterMonth}월&nbsp;<i class="ion-ios-arrow-forward"></i>
								</button>
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

								<td class="calendarDate"><c:choose>
										<c:when test="${supporter_id != 'admin'}">
											<button style="color: ${color}" disabled>${v.date}</button>
										</c:when>
										<c:otherwise>
											<button
												onclick="openPopup('adminVolunteerDateList.vt?yyyyMMdd=${v.yyyyMMdd}')"
												style="color: ${color}">${v.date}</button>
										</c:otherwise>
									</c:choose></td>

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
			<hr>
			<form method="post" action="volunteerList.vt"
				style="display: flex; justify-content: center;">
				<input type="text"
					class="woocommerce-Input woocommerce-Input--text input-text unique post"
					name="search_id"><input type="submit"
					style="width: 150px; font-size: 19px;" class="searchingPostcode"
					value="아이디로 검색">
			</form>
			<c:if test="${searchList != null}">
				<div class="boardListFirstDiv" style="margin: 0;">
					<div style="display: inline-block; width: 510px;">
						<c:choose>
							<c:when test="${searchList.size() == 0}">
								<h4 style="color: #7c7454;">검색 결과가 없습니다</h4>
							</c:when>
							<c:otherwise>
								<table class="board table"
									style="text-align: center; margin-bottom: 14px;">
									<tbody>
										<tr class="boardHead">
											<td colspan="4" class="removeBorderTop"
												style="padding: 0 0 1em 0; color: #cbbd89;">${search_id}님은 총&nbsp;<span
												style="color: #978d67;">${totalCnt}번</span> 방문하셨습니다.
											</td>
										</tr>
										<tr class="boardHead">
											<td>봉사자명</td>
											<td>날짜</td>
											<td>파트</td>
											<td>완료여부</td>
										</tr>
									</tbody>
									<tbody class="boardTbottom">
										<c:forEach var="v" items="${searchList}">
											<c:choose>
												<c:when test="${today gt v.volunteer_date}">
													<tr>
														<td>${v.supporter_id}</td>
														<td>${v.volunteer_date}</td>
														<td>${v.volunteer_time}</td>
														<td>완료</td>
													</tr>
												</c:when>
												<c:otherwise>
													<tr style="color: #59595978;">
														<td>${v.supporter_id}</td>
														<td>${v.volunteer_date}</td>
														<td>${v.volunteer_time}</td>
														<td>예정</td>
													</tr>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</tbody>
								</table>
								<!-- 페이징 처리 -->
								<div style="margin-top: 2rem;">
									<div class="col-md-12 text-center">
										<div class="block-27">
											<ul>
												<c:if test="${nowPage > 1 }">
													<li><a
														href="volunteerList.vt?search_id=${search_id}&page=${nowPage-1}"><i
															class="ion-ios-arrow-back"></i></a></li>
												</c:if>
												<c:forEach var="i" begin="${startPage }" end="${endPage }">
													<c:choose>
														<c:when test="${i == nowPage }">
															<li class="active"><span>${i }</span></li>
														</c:when>
														<c:otherwise>
															<li><a
																href="volunteerList.vt?search_id=${search_id}&page=${i}">${i }</a></li>
														</c:otherwise>
													</c:choose>
												</c:forEach>
												<c:if test="${nowPage < totalPage }">
													<li><a
														href="volunteerList.vt?search_id=${search_id}&page=${nowPage+1}"><i
															class="ion-ios-arrow-forward"></i></a></li>
												</c:if>
											</ul>
										</div>
									</div>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</c:if>
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

