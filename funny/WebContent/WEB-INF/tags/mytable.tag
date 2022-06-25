 <%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>


<c:set var="regular_bank" value="${regular_bank }" />
<c:set var="regular_account" value="${regular_account }" />
<c:set var="regular_amount" value="${regular_amount }" />
<c:set var="vregular_date" value="${regular_date }" />

<div class="twin container">
	<div class="row">
<!-- 정기후원중이 아니라면 테이블 대신 후원정보가 없습니다 노출//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
		<div class="col-md-6">
			<div class="twins-wrap">
				<h2>정기후원내역</h2>
				<div>
					<div>
						<table class="board table"
							style="text-align: center; margin-bottom: 14px;">
							<tbody>
								<tr class="boardHead">
									<td>은행</td>
									<td>계좌</td>
									<td>금액</td>
									<td>후원시작일</td>
								</tr>
							</tbody>
							<tbody class="boardTbottom">
<!-- Mypage 데이터 불러오기//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

								<tr>
									<td>${regular_bank }</td>
									<td>${regular_account }</td>
									<td>${regular_amount }</td>
									<td>${regular_date }</td>
								</tr>
								<tr>
								</tr>
							</tbody>
						</table>
							<a href="supportREGEnd.sp" type="button" class="btn btn-primary support">&nbsp;후원종료&nbsp;</a>
					</div>
				</div>
			</div>
		</div>
<!-- 일시후원중이 아니라면 테이블 대신 후원정보가 없습니다 노출//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
		<div class="col-md-6">
			<div class="twins-wrap">
				<h2>일시후원내역</h2>
				<div>
					<div>
						<table class="board table" style="text-align: center;">
							<tbody>
								<tr class="boardHead">
									<td>은행</td>
									<td>계좌</td>
									<td>금액</td>
								</tr>
							</tbody>
							<tbody class="boardTbottom">
<!-- 데이터 불러온뒤 for문으로 구현//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
								<tr>
									<td>신한은행</td>
									<td>110-123-456987</td>
									<td>50,000</td>
								</tr>
								<tr>
									<td>국민은행</td>
									<td>33-2541-5326</td>
									<td>30,000</td>
								</tr>
								<tr>
									<td>기업은행</td>
									<td>3333-11-9652369</td>
									<td>100,000</td>
								</tr>
								<tr>
									<td>우리은행</td>
									<td>110-231-521365</td>
									<td>50,000</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div> 

