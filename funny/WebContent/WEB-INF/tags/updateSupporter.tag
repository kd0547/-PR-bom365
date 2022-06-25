<%@tag import="model.supporter.SupporterVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%

	if(request.getSession().getAttribute("supporter_id") == null) {
		//에러 메시지 출력 or 404 에러 추가 
		//나중에 mypage 에 데이터를 저장할 수 있으면 if문은 옮겨야 함 
		//중복 코드 사용은 별로임
		// 세션 제어를 위한 테스트 코드
		// 이 값을 나중에 변경 
		//response.sendRedirect("/main.do");
		response.getWriter().println("<script>alert('허용하지 않는 경로 입니다.');history.go(-1);</script>");
	} 

	SupporterVO  supporterVO;
	supporterVO = (SupporterVO)request.getAttribute("userInfo");	
%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<c:set var="userInfo" value="<%= supporterVO%>"> </c:set>
<div class="signup-form-container">
<!-- action 채워넣기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<form action="userUpdate.me" method="POST"
		class="woocommerce-form woocommerce-form-register register ">
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
			<label class="reg_signup">이름&nbsp;</label>
<!-- 데이터불러온뒤 value수정//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
		
			<input id="supporter_name" type="text"
				class="woocommerce-Input woocommerce-Input--text input-text"
				name="supporter_name" value="${userInfo.supporter_name }" >
		</p>
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
			<label class="reg_signup">아이디&nbsp;</label>
<!-- 데이터불러온뒤 placeholder수정//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			
			<input id="supporter_id" type="text"
				class="woocommerce-Input woocommerce-Input--text input-text"
				placeholder="${userInfo.supporter_id }" disabled="disabled">
			
		</p>

		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
			<label class="reg_signup">비밀번호&nbsp;</label>
<!-- id="pw1"사용하여 ajax구현//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<input id="supporter_pwd" type="password"
				class="woocommerce-Input woocommerce-Input--text input-text"
				 name="supporter_password" placeholder="비밀번호는 안전하게" >
		</p>
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide"
			style="padding-left: 6px;">
			<label class="reg_signup">비밀번호확인&nbsp;</label>
<!-- id="pw1"사용하여 ajax구현//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<input id="supporter_pwd_check" type="password"
				class="woocommerce-Input woocommerce-Input--text input-text"
				 >
		</p>
		<h3 class="check-id-ps">*비밀번호가 일치하지 않습니다.</h3>
		<!-- 핸드폰 번호  -->
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
			<label class="reg_signup">핸드폰번호&nbsp;</label>
<!-- 데이터불러온뒤 value수정//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<input id="phone_number" type="text"
				class="woocommerce-Input woocommerce-Input--text input-text"
				name="phone_number" value="${userInfo.phone_number }" >
		</p>
		<!-- 우편주소  -->
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
			<label class="reg_signup">우편주소&nbsp;</label>
<!-- 데이터불러온뒤 value수정//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<input type="text"
				class="woocommerce-Input woocommerce-Input--text input-text unique post"
				id="sample4_postcode" name="post_code" value="${userInfo.post_code }" readonly >
				<input type="button" class="searchingPostcode"
					onclick="sample4_execDaumPostcode()"
					value="우편번호 찾기">
				<mytag:postcode />
		</p>
		<!-- 상세주소  -->
		
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more bottom">
			<label class="reg_signup">상세주소&nbsp;</label>
<!-- 데이터불러온뒤 value수정//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<input id="detailed_address" type="text"
				class="woocommerce-Input woocommerce-Input--text input-text"
				name="detailed_address" value="${userInfo.detailed_address }" >
		</p>
		<p class="woocommerce-form-row form-row mb-0 register">
			<button id="send" type="submit" class="btn btn-primary btn-register" onClick="send()"
				formmethod="post">수정하기</button>
		</p>
		
	</form>
	<script>
	//console.log($("#detailed_address").val());
	//console.log($("#sample4_postcode").val());
	//console.log($("#phone_number").val());
	//console.log($("#supporter_name").val());
	//console.log($("#supporter_pwd").val());
	//console.log($("#supporter_pwd_check").val());
		
		//var detailed_address = $("#detailed_address").val()
		//console.log(!checkNullCheck(detailed_address));
		/*
		$("#send").click(function() {
			//공백 체크 우선 
			if(checkNullCheck($("#detailed_address").val()) && checkNullCheck($("#sample4_postcode").val()) && checkNullCheck($("#phone_number").val()) && checkNullCheck($("#supporter_name").val()) && checkNullCheck($("#supporter_pwd").val()) && checkNullCheck($("#supporter_pwd_check").val())) {
				// 이름 확인
				if(!name_check($("#supporter_name").val())) {
					event.preventDefault();
					if(  checkNumOnlyReg($("#supporter_name").val())) {
						alert("이름에 숫자는 사용할 수 없습니다.");
					} else if(checkEngOnlyReg($("#supporter_name").val())) {
						alert("이름에 영어는 사용할 수 없습니다.");
					} 
					
				} else {
					
				}
				
				
			} else if(!checkNullCheck($("#detailed_address").val())) {
				event.preventDefault();
				alert("상세 주소 입력");
			} else if(!checkNullCheck($("#sample4_postcode").val())) {
				event.preventDefault();
				alert("우편 주소 입력");
			} else if(!checkNullCheck($("#phone_number").val())) {
				event.preventDefault();
				alert("핸드폰 번호 입력");
			} else if(!checkNullCheck($("#supporter_name").val())) {
				event.preventDefault();
				alert("이름 입력");
			} else if(!checkNullCheck($("#supporter_pwd").val())) {
				event.preventDefault();
				alert("비밀번호 입력");
			} else if(!checkNullCheck($("#supporter_pwd_check").val())) {
				event.preventDefault();
				alert("비밀번호 확인 입력");
			}
		})
		
		*/
		
		
		function send() {
			this.method = ""
			this.action = "userUpdate.me";
			this.submit();
		}
		
		
		
		function successPWNode (str) {
			let createText = document.getElementById("pwd-box");
			if(createText.childElementCount == 0){
				let h3 = document.createElement('h3');
				h3.setAttribute('class','check-id-ps');
				h3.style.color = "blue";
				h3.innerText = str;
				createText.appendChild(h3);
			}
					
		}
		function sucremovePWNode() {
			let removeText = document.getElementById("pwd-box");
			let h3 = removeText.children[0];
			if(removeText.childElementCount) {
				removeText.removeChild(h3);
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
			var regExp = /^[가-힣]{2,4}$/;
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
		function checkEngOnlyReg(str) {
			var regExp = /[A-Za-z]+/g;
			if(regExp.test(str)) {
				return true;
			} else {
				return false;
			}
		}
		function checkNumOnlyReg(str) {
			var regExp = /\d/g;
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
		
		
	</script>
</div>

