<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="js/validate-Fun.js"></script>
<div class="signup-form-container">
	<form id="supporter_update" method="post" action="update.me"

		class="woocommerce-form woocommerce-form-register register ">
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
			<label class="reg_signup">이름&nbsp;</label>
		
			<input id="supporter_name" type="text"
				class="woocommerce-Input woocommerce-Input--text input-text"
				name="supporter_name" value="${userInfo.supporter_name }" >
		</p>
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
			<label class="reg_signup">아이디&nbsp;</label>
			
			<input id="supporter_id" name="supporter_id" type="text"
				class="woocommerce-Input woocommerce-Input--text input-text"
				value="${userInfo.supporter_id }" readonly>
			
		</p>

		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
			<label class="reg_signup">비밀번호&nbsp;</label>
			<input id="supporter_password" type="password"
				class="woocommerce-Input woocommerce-Input--text input-text"
				 name="supporter_password" placeholder="비밀번호는 안전하게" >
		</p>
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide"
			style="padding-left: 6px;">
			<label class="reg_signup">비밀번호확인&nbsp;</label>
			<input id="supporter_password_check" type="password"
				class="woocommerce-Input woocommerce-Input--text input-text"
				 >
		</p>
		<div id="pwd-box"></div>
		<!-- 핸드폰 번호  -->
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
			<label class="reg_signup">핸드폰번호&nbsp;</label>
			<input id="phone_number" type="text"
				class="woocommerce-Input woocommerce-Input--text input-text"
				name="phone_number" value="${userInfo.phone_number }" >
		</p>
		<!-- 우편주소  -->
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
			<label class="reg_signup">우편주소&nbsp;</label>
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
			<input id="detailed_address" type="text"
				class="woocommerce-Input woocommerce-Input--text input-text"
				name="detailed_address" value="${userInfo.detailed_address }" >
		</p>
		<p class="woocommerce-form-row form-row mb-0 register">
			<button id="send" type="submit" class="btn btn-primary btn-register" 
				formmethod="post">수정하기</button>
		</p>
		
	</form>
	<script>
		$('#send').click((e)=> {
			e.preventDefault();
			 
			var formValues = $('#supporter_update').serializeArray();
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
 			/*
 				주소 유효성 검사
 			*/
 			/*
 			if(!addressCheck(formValues[5].value)) {
 				alert("상세 주소를 확인해 주세요");
 				return false;
 			}
 			*/
 			
 			$('#supporter_update').submit();
 			
		})
		$("#supporter_password").on('input',(e)=>{
					let validatePW = e.target.value;
					let pwdCheck = $("#supporter_password_check").val();
					if(!passwordCheckReg(validatePW)) {
						PWResultMessage("*영문, 숫자 8~20 자리 입력");
						return false;
					}
					if(!pwd_check(validatePW,pwdCheck)) {
						PWResultMessage("*비밀번호가 일치하지 않습니다");
						return false;
					}

					if(passwordCheckReg(validatePW)) {
						PWResultMessage("*사용 가능한 비밀번호 입니다");
						return false;
					}
					
				
					if(!passwordCheckReg(validatePW)) {
						PWResultMessage("*영문, 숫자 8~20 자리 입력");
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
		$(window).ready(()=>{
	
			var result_pwd = document.getElementById("pwd-box");
	
			if(!result_pwd.childElementCount) {
				result_pwd.style.height = "21px";
			}
		})
	</script>
</div>