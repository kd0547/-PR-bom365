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
</head>
<body>
	<div class="volReqFirstDiv">
		<div style="display: inline-block;">
			<form action="volunteerInsert.vt" method="post" target="main">
				<input type="hidden" name="volunteer_date" value="${volCnt.yyyyMMdd}">
				<table style="font-size: 18px">
					<tr>
						<c:choose>
							<c:when test="${checkAM != null}">
								<td colspan="2">🌼 ${volCnt.yyyyMMdd} 오전 신청 완료 🌼</td>
							</c:when>
							<c:when test="${volCnt.cntAM ge 10}">
								<td colspan="2" style="color: #5959597a;">🐶
									${volCnt.yyyyMMdd} 오전 봉사 마감 🐱</td>
							</c:when>
							<c:otherwise>
								<td><input type="radio" name="volunteer_time" value="오전"
									required> 오전 (09:00 ~ 12:00)</td>
								<td><small style="color: #bfb180;">&nbsp;${volCnt.cntAM}
										/ 10</small></td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<c:choose>
							<c:when test="${checkPM != null}">
								<td colspan="2">🌼 ${volCnt.yyyyMMdd} 오후 신청 완료 🌼</td>
							</c:when>
							<c:when test="${volCnt.cntPM ge 10}">
								<td colspan="2" style="color: #5959597a;">🐱
									${volCnt.yyyyMMdd} 오후 봉사 마감 🐶</td>
							</c:when>
							<c:otherwise>
								<td><input type="radio" name="volunteer_time" value="오후"
									required> 오후 (14:00 ~ 17:00)</td>
								<td><small style="color: #bfb180;">&nbsp;${volCnt.cntPM}
										/ 10</small></td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" onclick="self.close();"
							class="btn btn-primary vol" value="신청하기"></td>
					</tr>
					<tr>
						<td colspan="2"><small class="volBack"
							onclick="self.close();">돌아가기</small></td>
					</tr>
				</table>
			</form>
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