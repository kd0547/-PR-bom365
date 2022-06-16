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
<link rel="stylesheet"href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>

<body>

	<div class="colorlib-loader"></div>
	<div id="page">

		<!-- Page Header-->
		<mytag:pageHeader />

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
			<!--signupDone.jsp  -->
			<form id="signup" 
				class="woocommerce-form woocommerce-form-register register ">
				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
					<label class="reg_signup">이름&nbsp;</label> <input id="name"
						type="text"
						class="woocommerce-Input woocommerce-Input--text input-text"
						name="supporter_name" >
				</p>

				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide"
					style="padding-left: 6px;">
					<label class="reg_signup">아이디&nbsp;</label> <input id="id"
						type="text"
						class="woocommerce-Input woocommerce-Input--text input-text" name ="supporter_id"
						>
				</p>
				<!-- ajax 구현//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
				<div id="text-box"></div>
				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
					<label class="reg_signup">비밀번호&nbsp;</label>
					<!-- id="pw1"사용하여 ajax구현//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
					<input id="pwd" type="password"
						class="woocommerce-Input woocommerce-Input--text input-text"
						 name="supporter_password" placeholder="비밀번호는 안전하게"
						>
				</p>

				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide"
					style="padding-left: 6px;">
					<label class="reg_signup">비밀번호확인&nbsp;</label>
					<!-- id="pw2"사용하여 ajax구현//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
					<input id="pwdcheck" type="password"
						class="woocommerce-Input woocommerce-Input--text input-text">
					
				</p>
				<div id="pwd-box"></div>

				<p
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
					<label class="reg_signup">핸드폰번호&nbsp;</label> <input id="phone"
						type="text"
						class="woocommerce-Input woocommerce-Input--text input-text"
						name="phone_number" 
						placeholder=" '-' 제외하고 입력해 주세요"
						>
				</p>		
				<p 
					class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
					<label class="reg_signup">우편주소&nbsp;</label> <input type="text"
						class="woocommerce-Input woocommerce-Input--text input-text unique post"
						id="sample4_postcode" name="post_code" readonly
						> <input type="button" class="searchingPostcode"
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
					<button id="sendbutton" type="submit" class="btn btn-primary btn-register"
						name="register">가입하기</button>
				</p>
			</form>
			<script>
				window.idresult = false;
				window.pwdResult = false;
				$("#id").on('input',()=>{
				
				var id_send = $("#id").val();
				// if(checkNullCheck(id_send)) {
				// 	if(!checkSpecialCheck(id_send)) {
				// 		if(!checkNumberReg(id_send)){
				// 			$.ajax({
				// 				type:"POST",
				// 				//USER DAO랑 가까운 JAVA OR JSP 파일로 데이터 전송
				// 				url:"/idOverlap",
				// 				data : "id=" + id_send,
				// 				success : function(data,textStatus,xhr){
												
				// 					//true - 유저 있음, false - 유저 없음
				// 					if(data == "true") {
				// 						idResultMessage("*이미 사용중인 아이디 입니다.");
				// 					} else {
				// 						idResultMessage("*사용 가능한 아이디 입니다.");
				// 					}
				// 				},
								
				// 				error : function (request,status,err) {
				// 					console.log("code:"+request.status);
				// 				},
				// 			})} else {
				// 				idResultMessage("*숫자만 사용할 수 없습니다.");
				// 			}
				// 	} else {
				// 	idResultMessage("*특수문자는 사용할 수 없습니다.");
				// }} else {
				// 	idResultMessage("*아이디를 입력해 주세요")
				// }
				if(idOverlap(id_send)){
					$.ajax({
								type:"POST",
								//USER DAO랑 가까운 JAVA OR JSP 파일로 데이터 전송
								url:"/idCheck.me",
								data : 	"id=" + id_send,
								
								success : function(data,textStatus,xhr){
												
									//true - 유저 있음, false - 유저 없음
									if(data == "true") {
										idResultMessage("*이미 사용중인 아이디 입니다.");
									} else {
										idResultMessage("*사용 가능한 아이디 입니다.");
										window.idresult = true;
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
				/*
					전송
				*/
				
				$("#sendbutton").click((e)=>{
					let n= document.getElementById("name").value;
					
					let i= document.getElementById("id").value;
					let ph= document.getElementById("phone").value;
					let pwd= document.getElementById("pwd").value;
					let pwdck= document.getElementById("pwdcheck").value;
					let p = document.getElementById("sample4_postcode").value;
	
					let reg_detail= document.getElementById("reg_detail").value;
					if(name_check(n) && checkNumberReg(i) && pwd_check(pwd,pwdck) && phoneCheckReg(ph) && reg_detail != null && p != null) {
						//document.getElementById("name").value = encodeURI(document.getElementById("name").value)
						
						send(document.getElementById("signup"));
					} else {
						alert("입력되지 않는 값이 있습니다.");
						event.preventDefault();
						
					}
				})
				
				$("#pwd").on('input',(e)=> {
					let val = e.target.value;
					
					if(checkSpecialCheck(val)) {
						PWResultMessage("*특수문자는 사용할 수 없습니다.");
					} else if(!passwordCheckReg(val)) {
						PWResultMessage("*영문, 숫자 8~20 자리 입력");
						window.pwdResult = false;
					} else {
						PWResultMessage("*사용 가능한 비밀번호 입니다.");
						window.pwdResult = true;
					}
					
					
				})

				document.getElementById("pwdcheck").addEventListener('input',(e)=>{
					
					if(pwd_check($("#pwd").val(),e.target.value)) {
						PWResultMessage("패스워드가 일치합니다.");
					} else{
						PWResultMessage("패스워드가 일치하지 않습니다.");
					}
				})
				
				

			</script>
		</div>
		
		<script>
			

						
			function idOverlap(str) {
				//NULL갑 체크 
				if(!checkNullCheck(str)) {
					idResultMessage("*아이디를 입력해 주세요")
					return false;
				} else if(checkSpecialCheck(str)){
					idResultMessage("*특수문자는 사용할 수 없습니다.");
					return false;
				} else if(koreanCheckReg(str)) {
					idResultMessage("*한글은 사용할 수 없습니다.");
					return false;
				} else if(!checkNumberReg(str)) {
					idResultMessage("*숫자만 사용할 수 없습니다.");
					return false;
				} else {
					return true;
				}
			}
			


			
			/*
						
			*/
			function idResultMessage(str) {
				removeNode();
				createNode(str);
			}
			function createNode (str) {
				let createText = document.getElementById("text-box");
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
			function PWResultMessage(str) {
				removePWNode();
				createPWNode(str);
			}
			function createPWNode (str) {
				let createText = document.getElementById("pwd-box");
				if(createText.childElementCount == 0){
					let h3 = document.createElement('h3');
					h3.setAttribute('class','check-id-ps');
					h3.innerText = str;
					createText.appendChild(h3);
				}
						
			}
			function removePWNode() {
				let removeText = document.getElementById("pwd-box");
				let h3 = removeText.children[0];
				if(removeText.childElementCount) {
					removeText.removeChild(h3);
				}
			}
			function passwordCheckReg(str) {
				var regExp = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,20}$/g;
				if(regExp.test(str)) {
					return true;
				} else {
					return false;
				}
			}
			function phoneCheckReg(str) {
				var regExp = /\d{3}\d{4}\d{4}/g;
				if(regExp.test(str)) {
					return true;
				} else {
					return false;
				}

			}
			function koreanCheckReg(str) {
				var regExp = /[ㄱ-ㅎㅏ-ㅣ가-힣]/g;
				if(regExp.test(str)){
        			return true;
    			} else {
        			return false;
    			}
			}
			
					//공백 체크 
			function checkNullCheck(str) {
				var regExp = /./g;
						
				if(regExp.test(str)) {
					return true;
				} else {
					return false;
				}
						
			}
					//특수문자 체크 
			function checkSpecialCheck(str) {
				var regExp = /[/\[\]\{\}\/\(\)\.\?\<\>!@#$%^&*]+/g;
				
				if(regExp.test(str)) {
					return true;
				} else {
					return false;
				}
			}	
					
			//숫자만 체크
			function checkNumberReg(str) {
			var regExp = /[0-9_]*[a-z]+[0-9_]*/g;
				if(regExp.test(str)) {
					return true;
				} else {
					return false;
				}
			}

			//회원가입 조건이 만족하지 않으면 회원가입 버튼이 활성화되지 않게 하기 

			
			/*
				//최소 10자리 이상 : 영어 대문자, 소문자, 숫자, 특수문자 중 2종류 조합
				//최소 8자리 이상 : 영어 대문자, 소문자, 숫자, 특수문자 중 3종류 조합
				//비밀번호 생성 규칙을 확인하고 데이터가 null인지 그리고 패스워드 더블체크 
			*/
			function name_check(name) {
				return koreanCheckReg(name);
			}

			function pwd_check(pwd,pwdcheck) {
				return pwd === pwdcheck;
			}
			
			function send(e) {
				e.method = "POST"
				e.action="/signup.me";
				e.submit();
			}
			



			
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








