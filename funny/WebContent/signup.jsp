<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE HTML>
<html>
<head>
<title>회원가입</title>

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

<!-- contect signup.css -->
<link rel="stylesheet" href="css/signup_mypage.css">

<!-- Material Icons -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>


	<div class="colorlib-loader"></div>
	<div id="page">

		<!-- Page Header-->
		<mytag:pageHeader/>

		<div class="breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col">
						<p class="bread">
<!-- href수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
							<span><a href="main.jsp">HOME</a></span> / <span>회원가입</span>
						</p>
					</div>
				</div>
			</div>
		</div>


		<h1 id="menuTitle">회원가입</h1>

		<!-- sign up -->

		<div class="signup-form-container">
<!-- action수정하기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<form method="post" action="signupDone.jsp"
				class="woocommerce-form woocommerce-form-register register ">
				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
					<label class="reg_signup">이름&nbsp;</label> <input id="name" type="text"
						class="woocommerce-Input woocommerce-Input--text input-text"
						name="supporter_name" required>
				</p>

				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide"
					style="padding-left: 6px;">
					<label class="reg_signup">아이디&nbsp;</label> <input id="id" type="text"
						class="woocommerce-Input woocommerce-Input--text input-text"
						required>
				</p>
<!-- ajax 구현//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
				
				<div id="text-box" >
				
				</div>
				

				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
					<label class="reg_signup">비밀번호&nbsp;</label> 
<!-- id="pw1"사용하여 ajax구현//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
					<input id="pwd" type="password"
						class="woocommerce-Input woocommerce-Input--text input-text"
						id="pw1" name="supporter_password" placeholder="비밀번호는 안전하게"
						required>
				</p>

				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide"
					style="padding-left: 6px;">
					<label class="reg_signup">비밀번호확인&nbsp;</label>
<!-- id="pw2"사용하여 ajax구현//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
					<input id="pwdcheck" type="password"
						class="woocommerce-Input woocommerce-Input--text input-text"
						id="pw2" required>
				</p>
				<h3 class="check-id-ps">*비밀번호가 일치하지 않습니다.</h3>

				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
					<label class="reg_signup">핸드폰번호&nbsp;</label> <input type="text"
						class="woocommerce-Input woocommerce-Input--text input-text"
						name="phone_number" required>
				</p>
				
				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
					<label class="reg_signup">우편주소&nbsp;</label> <input type="text"
						class="woocommerce-Input woocommerce-Input--text input-text unique post"
						id="sample4_postcode" name="post_code" disabled="disabled" required> <input type="button"
						class="searchingPostcode" onclick="sample4_execDaumPostcode()"
						value="우편번호 찾기">
					<mytag:postcode />
				</p>
				
				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more bottom">
					<label class="reg_signup">상세주소&nbsp;</label> <input type="text"
						class="woocommerce-Input woocommerce-Input--text input-text"
						name="detailed_address">
				</p>
				
				<p class="woocommerce-form-row form-row mb-0 register">
					<button type="submit" class="btn btn-primary btn-register"
						name="register">가입하기</button>
				</p>
			</form>
		</div>
		<script>
				
					$("#id_test").blur(()=>{
						var id = $("#id_test").val();
						$.ajax(
							{
								type:"POST",
								//USER DAO랑 가까운 JAVA OR JSP 파일로 데이터 전송
								url:"/idOverlap",
								data : "id=" + id,
								success : function(data,textStatus,xhr){
									if(data == "true") {
										removeNode();
										createNode("*이미 사용중인 아이디 입니다.");
									} else {
										removeNode();
										createNode ("*사용 가능한 아이디 입니다.");
									}
								} ,
								error : function (request,status,err) {
									console.log("code:"+request.status);
								},

			


							}
						)
					})
					
					function createNode (str) {
						let createText = document.getElementById("text-box");
						removeNode()
						if(createText.childElementCount == 0){
							let h3 = document.createElement('h3');
							h3.setAttribute('class','check-id-ps');
							h3.innerText = str;

							createText.appendChild(h3);
						}
						
					}
					function removeNode() {
						let removeText = document.getElementById("text-box");
						let h3 = removeText.children[0];
						if(removeText.childElementCount) {
							removeText.removeChild(h3);
						}
					}
					$(window).ready(()=>{
						var id_test = document.getElementById("text-box");

						if(!id_test.childElementCount) {
							id_test.style.height = "21px";
						}
					})
				</script>
		
		<script>
			
			
		</script>


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
