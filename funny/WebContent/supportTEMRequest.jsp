<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<c:set var="request" value="<%= request.getSession().getAttribute(\"supporter_id\")%>"/>
<c:choose>
	<c:when test="${request != null }">
		<c:set var="userInfo" value="${request}" />
	</c:when>
	<c:when test="${request == null }">
		<c:set var="userInfo" value="<%= null%>" /> 
	</c:when>
</c:choose>

<!DOCTYPE HTML>
<html>
<head>
<title>일시후원신청</title>

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

<!-- jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

</head>

<body id="tem">


	<div class="colorlib-loader"></div>

	<!-- Page Header-->
	<mytag:pageHeader />

	<div class="breadcrumbs">
		<div class="container">
			<div class="row">
				<div class="col">
					<p class="bread">
						<!-- href수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
						<span><a href="support.jsp">후원신청</a></span> / <span>일시후원</span>
					</p>
				</div>
			</div>
		</div>
	</div>


	<h1 id="menuTitle">일시후원신청</h1>

	

<!-- action수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container-tem">
			<div class="signup-form-container tem">
				<div class="js-focus-state form-group tem">
						<span class="h4 tem">금액</span> 
						<select name="temporary_amount"class="form-control input tem" id="kakaopay-amount" 
						        data-msg="금액을 선택해 주세요" data-error-class="u-has-error" data-success-class="u-has-success">
							<option value="50,000">50,000</option>
							<option value="100,000">100,000</option>
							<option value="150,000">150,000</option>
							<option value="200,000">200,000</option>
							<option value="250,000">250,000</option>
							<option value="300,000">300,000</option>
						</select>
				</div>
				<c:if test="${userInfo != null }">
						<input type="submit" onclick="requestPay();" class="btn btn-primary supprot tem" value="&nbsp;신청하기&nbsp;">
				</c:if>
				<c:if test="${userInfo == null }">
						<input type="submit" onclick="alert('로그인 후 이용가능합니다!')" class="btn btn-primary supprot tem" value="&nbsp;신청하기&nbsp;">
				</c:if>
						
			</div>
	</div>


	<!-- Page Footer-->
	<mytag:pageFooter />
	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="ion-ios-arrow-up"></i></a>
	</div>


	<script>

	//KAKAO API
	var IMP = window.IMP; // 생략 가능
	IMP.init("imp44896858"); // 가맹점 식별코드

	function requestPay() {
		// IMP.request_pay(param, callback) 결제창 호출
		IMP.request_pay({
			pg : "html5_inicis",
			pay_method : "card",
			temporary_number : "5000_" + new Date().getTime(),
			//관리자페이지(주문명)에 노출될 정보들(밑으론 key값 변경불가능)
			name : "봄365 후원",
			amount : document.getElementById("kakaopay-amount").value,
			supporter_id : "gildong@gmail.com",
			buyer_name : "홍길동",
		}, function(rsp) {
			if (rsp.success) {
				location.href = "supportDone.jsp";
			} else {
				alert("결제에 실패했습니다.");
				location.href = "supportTEMRequest.jsp";
			}
		});
	}
	
	//데이터 Controller로 전송
 var test =$('#kakaopay-amount option:selected').val();
	
	$.ajax({
		url : "supportTEMRequest.sp",
		type : 'get',
		data : {
			
			temporary_amount: $('#kakaopay-amount option:selected').val()
		},
		success : function(data) {
		},
		error : function() {
			console.log($('#kakaopay-amount option:selected').val());
			console.log("supportTEMRequest ajax진입안됨");
		}
	}); 
/* 	
 */</script>
	<!-- popper -->
	<script src="js/popper.min.js"></script>
	<!-- bootstrap 4.1 -->
	<script src="js/bootstrap.min.js"></script>
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
