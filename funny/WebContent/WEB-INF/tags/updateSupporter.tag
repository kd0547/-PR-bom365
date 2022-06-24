<%@tag import="model.supporter.SupporterDTO"%>
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

	SupporterDTO  SupporterDTO;
	SupporterDTO = (SupporterDTO)request.getAttribute("userInfo");	
%>
<c:set var="userInfo" value="<%= SupporterDTO%>"> </c:set>
<div class="signup-form-container">
<!-- action 채워넣기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<form method="post" action="supporterUpdate.me"
		class="woocommerce-form woocommerce-form-register register ">
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
			<label class="reg_signup">이름&nbsp;</label>
<!-- 데이터불러온뒤 value수정//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
		
			<input type="text"
				class="woocommerce-Input woocommerce-Input--text input-text"
				name="supporter_name" value="${userInfo.supporter_name }" required>
		</p>
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
			<label class="reg_signup">아이디&nbsp;</label>
<!-- 데이터불러온뒤 placeholder수정//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			
			<input type="text"
				class="woocommerce-Input woocommerce-Input--text input-text"
				placeholder="${userInfo.supporter_id }" disabled="disabled">
			
		</p>

		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
			<label class="reg_signup">비밀번호&nbsp;</label>
<!-- id="pw1"사용하여 ajax구현//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<input type="password"
				class="woocommerce-Input woocommerce-Input--text input-text"
				id="pw1" name="supporter_password" placeholder="비밀번호는 안전하게" required>
		</p>
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide"
			style="padding-left: 6px;">
			<label class="reg_signup">비밀번호확인&nbsp;</label>
<!-- id="pw1"사용하여 ajax구현//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<input type="password"
				class="woocommerce-Input woocommerce-Input--text input-text"
				id="pw2" required>
		</p>
		<h3 class="check-id-ps">*비밀번호가 일치하지 않습니다.</h3>

		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
			<label class="reg_signup">핸드폰번호&nbsp;</label>
<!-- 데이터불러온뒤 value수정//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<input type="text"
				class="woocommerce-Input woocommerce-Input--text input-text"
				name="phone_number" value="${userInfo.phone_number }" required>
		</p>
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
			<label class="reg_signup">우편주소&nbsp;</label>
<!-- 데이터불러온뒤 value수정//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<input type="text"
				class="woocommerce-Input woocommerce-Input--text input-text unique post"
				id="sample4_postcode" name="post_code" value="${userInfo.post_code }" disabled="disabled" required>
				<input type="button" class="searchingPostcode"
					onclick="sample4_execDaumPostcode()"
					value="우편번호 찾기">
				<mytag:postcode />
		</p>
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more bottom">
			<label class="reg_signup">상세주소&nbsp;</label>
<!-- 데이터불러온뒤 value수정//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<input type="text"
				class="woocommerce-Input woocommerce-Input--text input-text"
				name="detailed_address" value="${userInfo.detailed_address }" required>
		</p>
		<p class="woocommerce-form-row form-row mb-0 register">
			<button type="submit" class="btn btn-primary btn-register"
				formmethod="post">수정하기</button>
		</p>
	</form>
</div>
