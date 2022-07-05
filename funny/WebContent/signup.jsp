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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="js/validate-Fun.js"></script>
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
							<span><a href="main.do">HOME</a></span> / <span>회원가입</span>
						</p>
					</div>
				</div>
			</div>
		</div>


		<h1 id="menuTitle">회원가입</h1>

		<!-- sign up -->

		<div class="signup-form-container">
			<!--signupDone.jsp  -->
			<form id="signup" method="post" action="signup.me"
				class="woocommerce-form woocommerce-form-register register ">
				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
					<label class="reg_signup">이름&nbsp;</label> <input id="name"
						type="text"
						class="woocommerce-Input woocommerce-Input--text input-text"
						name="supporter_name">
				</p>

				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide"
					style="padding-left: 6px;">
					<label class="reg_signup">아이디&nbsp;</label> <input id="id"
						type="text"
						class="woocommerce-Input woocommerce-Input--text input-text"
						name="supporter_id">
				</p>
				<div id="text-box"></div>
				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
					<label class="reg_signup">비밀번호&nbsp;</label> <input
						id="supporter_password" type="password"
						class="woocommerce-Input woocommerce-Input--text input-text"
						name="supporter_password" placeholder="비밀번호는 안전하게">
				</p>

				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide"
					style="padding-left: 6px;">
					<label class="reg_signup">비밀번호확인&nbsp;</label> <input
						id="supporter_password_check" type="password"
						class="woocommerce-Input woocommerce-Input--text input-text">

				</p>
				<div id="pwd-box"></div>

				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
					<label class="reg_signup">핸드폰번호&nbsp;</label> <input id="phone"
						type="text"
						class="woocommerce-Input woocommerce-Input--text input-text"
						name="phone_number" placeholder=" '-' 제외하고 입력해 주세요">
				</p>
				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
					<label class="reg_signup">우편주소&nbsp;</label> <input type="text"
						class="woocommerce-Input woocommerce-Input--text input-text unique post"
						id="sample4_postcode" name="post_code" readonly> <input
						type="button" class="searchingPostcode"
						onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
					<mytag:postcode />
				</p>

				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more bottom">
					<label class="reg_signup">상세주소&nbsp;</label> <input id="reg_detail"
						type="text"
						class="woocommerce-Input woocommerce-Input--text input-text"
						name="detailed_address">
				</p>

				<p class="woocommerce-form-row form-row mb-0 register">
					<button id="sendbutton" type="submit"
						class="btn btn-primary btn-register" name="register">가입하기</button>
				</p>
			</form>
			<script>
			
			$("#id").on('input',()=>{
				
				var id_send = $("#id").val();
				if(idOverlap(id_send)){
					$.ajax({
								type:"POST",
								//USER DAO랑 가까운 JAVA OR JSP 파일로 데이터 전송
								url:"idCheck.me",
								data : "id=" + id_send,
								
								success : function(data,textStatus,xhr){
												
									//true - 유저 있음, false - 유저 없음
									if(data == "true") {
										idResultMessage("*이미 사용중인 아이디 입니다.");
									} else {
										idResultMessage("*사용 가능한 아이디 입니다.");
									}
								},
								
								error : function (request,status,err) {
									console.log("code:"+request.status);
								},
							})
				}
				})
			$(window).ready(()=>{
					var result_text = document.getElementById("text-box");
					var result_pwd = document.getElementById("pwd-box");
					if(!result_text.childElementCount) {
						result_text.style.height = "21px";
					}
					if(!result_pwd.childElementCount) {
						result_pwd.style.height = "21px";
					}
				})
			$("#supporter_password").on('input',(e)=>{
					let validatePW = e.target.value;
					
					if(!passwordCheckReg(validatePW)) {
						PWResultMessage("*영문, 숫자 8~20 자리 입력");
						return false;
					}
					if(passwordCheckReg(validatePW)) {
						PWResultMessage("*사용 가능한 비밀번호 입니다");
						return false;
					}
					
					
				})
				
				$("#supporter_password_check").on('input',(e)=>{
					let validatePW = e.target.value;
					let pwdCheck = $("#supporter_password").val();
					
					if(!passwordCheckReg(validatePW)) {
						PWResultMessage("*영문, 숫자 8~20 자리 입력");
						return false;
					}		
					if(!pwd_check(validatePW,pwdCheck)) {
						PWResultMessage("*비밀번호가 일치하지 않습니다");
						return false;
					}
					if(pwd_check(validatePW,pwdCheck)) {
						PWResultMessage("*사용 가능한 비밀번호 입니다");
						return false;
					}				
				})
			
				/*
					전송
				*/
				
				$("#sendbutton").click((e)=>{
					e.preventDefault();
					
					var formValues = $('#signup').serializeArray();
					var check = false;
					formValues.forEach((e)=>{
						console.log(e);
						if(!checkNullCheck(e.value) 
							|| e.value === "") {
							check = true;
						}
		 			})
		 			
		 			if(check){
						console.log(e);
						alert("비어있는 값이 있습니다.");
						return false;
		 			}
					
		 			if(!koreanCheckReg(formValues[0].value)) {
		 				alert("이름에 숫자 또는 영어는 사용할 수 없습니다");
		 				return false;
		 			}
					if(!koreanCheckReg(formValues[0].value)) {
		 				alert("이름에 숫자 또는 영어는 사용할 수 없습니다");
		 				return false;
		 			}
					
					let pwdCheck = $("#supporter_password_check").val();
					console.log(passwordCheckReg(formValues[2].value));
					console.log(passwordCheckReg(pwdCheck));
					
		 			if(!pwd_check(formValues[2].value,pwdCheck)
		 			|| !passwordCheckReg(formValues[2].value)
		 			|| !passwordCheckReg(pwdCheck)) {
		 				alert("비밀번호를 확인해 주세요");
		 				return false;
		 			}
		 			
		 			if(!phoneCheckReg(formValues[3].value)) {
		 				alert("핸드폰 번호를 확인해 주세요");
		 				return false;
		 			}
		 			
		 			
		 			if(!postCheckReg(formValues[4].value)) {
		 				alert("우편 번호를 확인해 주세요");
		 				return false;
		 			}
		 			
		 			$('#signup').submit();
				})
			</script>
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