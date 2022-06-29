<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE HTML>
<html>
<head>
<title>날짜별조회</title>
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
</head>
<body>

	<div class="container-fluid" style="padding: 0;">
		<div align="center">
			<h3 class="adVolyyyyMMdd">${yyyyMMdd}</h3>
			<div class="row adVol">

				<c:choose>
					<c:when test="${AMList.size() == 0 && PMList.size() == 0}">
						<h4 style="color: #7c7454;">봉사신청자가없습니다!</h4>
					</c:when>
					<c:otherwise>
						<div class="col-sm-6 text-center">
							<table class="board table" style="margin-bottom: 14px;">
								<tbody>
									<tr class="boardHead">
										<td colspan="3" class="adVolTitle">오전</td>
									</tr>
								</tbody>
								<tbody class="boardTbottom">
									<c:set var="cnt" value="0" />
									<tr>
										<c:forEach var="v" items="${AMList}">
											<c:set var="cnt" value="${cnt+1}" />
											<td class="adVolTd">${v.supporter_id}</td>
											<c:if test="${cnt % 3 == 0}">
												<%="</tr><tr>"%>
											</c:if>
										</c:forEach>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="col-sm-6 text-center">
							<table class="board table" style="margin-bottom: 14px;">
								<tbody>
									<tr class="boardHead">
										<td colspan="3" class="adVolTitle">오후</td>
									</tr>
								</tbody>
								<tbody class="boardTbottom">
									<c:set var="cnt" value="0" />
									<tr>
										<c:forEach var="v" items="${PMList}">
											<c:set var="cnt" value="${cnt+1}" />
											<td class="adVolTd">${v.supporter_id}</td>
											<c:if test="${cnt % 3 == 0}">
												<%="</tr><tr>"%>
												<c:set var="cnt" value="0" />
											</c:if>
										</c:forEach>
									</tr>
								</tbody>
							</table>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<button onclick="self.close();" class="btn btn-primary adVol">
				목록보기</button>
		</div>
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

