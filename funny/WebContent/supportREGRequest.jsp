<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE HTML>
<html>
<head>
<title>정기후원신청</title>

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

<!-- contact css  -->
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/signup_mypage.css">
<link rel="stylesheet" href="css/supportRequest.css">

<!-- Material Icons -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

</head>

<body>

	<!-- Page Header-->
	<mytag:pageHeader />

	<div class="breadcrumbs">
		<div class="container">
			<div class="row">
				<div class="col">
					<p class="bread">
						<span><a href="support.jsp">후원신청</a></span> / <span>정기후원</span>
					</p>
				</div>
			</div>
		</div>
	</div>


	<h1 id="menuTitle">정기후원신청</h1>
	<hr>

	<div class="volReqFirstDiv">
		<div style="display: inline-block;">

			<form action="supportREGInsert.sp" method="post" name="frm"
				class="woocommerce-form woocommerce-form-register register">
				<div class="input-container">
					<label class="reg_signup">은행&nbsp;</label> <select
						name="regular_bank"
						class="woocommerce-Input woocommerce-Input--text input-text select"
						id="regular_bank">
						<mytag:bankList />
					</select>
				</div>
				<div class="input-container">
					<label class="reg_signup">계좌번호&nbsp;</label> <input type="text"
						class="woocommerce-Input woocommerce-Input--text input-text"
						id="regular_account" name="regular_account">
				</div>
				<div class="input-container">
					<label class="reg_signup">금액&nbsp;</label> <select
						name="regular_amount"
						class="woocommerce-Input woocommerce-Input--text input-text select"
						id="regular_amount">
						<option value="">🌼 후원금액을 선택해 주세요 🌼</option>
						<option value="">========================================</option>
						<option value="10,000">10,000</option>
						<option value="30,000">30,000</option>
						<option value="50,000">50,000</option>
						<option value="100,000">100,000</option>
						<option value="150,000">150,000</option>
						<option value="200,000">200,000</option>
						<option value="250,000">250,000</option>
						<option value="300,000">300,000</option>
					</select>
				</div>
				<div class="input-container">
					<label class="reg_signup">출금일&nbsp;</label> <select
						name="regular_paymentDate"
						class="woocommerce-Input woocommerce-Input--text input-text select"
						id="regular_paymentDate">
						<option value="">🌼 출금일을 선택해 주세요 🌼</option>
						<option value="">========================================</option>
						<option value="05">매월 05일</option>
						<option value="10">매월 10일</option>
						<option value="17">매월 17일</option>
						<option value="25">매월 25일</option>
					</select>
				</div>

				<input type="submit" onClick="sendit(); return false;"
					class="btn btn-primary supprot" value="신청하기">
			</form>
		</div>
	</div>

	<hr>
	<mytag:howToUseSupport />


	<script>
		function sendit() {

			let frm = document.frm;
			let regular_bank = frm.regular_bank;
			let regular_account = frm.regular_account;
			let regular_paymentDate = frm.regular_paymentDate;
			let checkString = /[-!%^@#$&*+.?]/gi;
			let supporter_id = "${supporter_id}";

			if (checkString.test(regular_amount.value)) {
				alert("특수문자는 입력할 수 없습니다!");
				regular_amount.focus();
				return false;
			}

			if (regular_bank.value == "") {
				alert("은행을 선택해 주세요!");
				regular_bank.focus();
				return false;
			}

			if (regular_account.value == "") {
				alert("계좌번호를 입력하세요!");
				regular_account.focus();
				return false;
			}

			if (regular_amount.value == "") {
				alert("후원금액을 선택해 주세요!");
				regular_amount.focus();
				return false;
			}

			if (regular_paymentDate.value == "") {
				alert("출금일을 선택해 주세요!");
				regular_paymentDate.focus();
				return false;
			}

			if (supporter_id == "") {
				alert("로그인 후 이용해주세요!");
				return false;
			}
			frm.submit();
		}
	</script>


	<!-- Page Footer-->
	<mytag:pageFooter />
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
