<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="signup-form-container">
<!-- action 채워넣기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<form method="post" action=""
		class="woocommerce-form woocommerce-form-register register ">
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
			<label class="reg_signup">이름&nbsp;</label>
<!-- 데이터불러온뒤 value수정//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<input type="text"
				class="woocommerce-Input woocommerce-Input--text input-text"
				name="supporter_name" value="김개똥" required>
		</p>
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
			<label class="reg_signup">아이디&nbsp;</label>
<!-- 데이터불러온뒤 placeholder수정//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<input type="text"
				class="woocommerce-Input woocommerce-Input--text input-text"
				placeholder="dogpoo" disabled="disabled">
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
				name="phone_number" value="01012459562" required>
		</p>
		<p
			class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide more">
			<label class="reg_signup">우편주소&nbsp;</label>
<!-- 데이터불러온뒤 value수정//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<input type="text"
				class="woocommerce-Input woocommerce-Input--text input-text unique post"
				id="sample4_postcode" name="post_code" value="12345" disabled="disabled" required>
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
				name="detailed_address" value="어딘가로" required>
		</p>
		<p class="woocommerce-form-row form-row mb-0 register">
			<button type="submit" class="btn btn-primary btn-register"
				formmethod="post">수정하기</button>
		</p>
	</form>
</div>
