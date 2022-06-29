<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	function end(com, loc) {
		var ans = confirm(com);
		if (ans == true) {
			location = loc;
		} else {
			event.preventDefault();
		}
	}
</script>

<div class="colorlib-featured">
	<div class="container table">
		<div class="row">
			<div class="col-md-4 reg">
				<div class="twins-wrap tem">
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
									</tr>
								</tbody>
								<tbody class="boardTbottom">
									<c:choose>
										<c:when test="${MypageREGList.size() == 0 }">
											<tr class="boardHead">
												<td colspan="3">
													<h4 style="color: #7c7454;">후원 내역이 없습니다!</h4>
												</td>
											</tr>
								</tbody>
							</table>
							<a href="supportREGRequest.jsp"
								class="btn btn-primary del support">후원하러 가기</a>
							</c:when>
							<c:otherwise>
								<c:forEach var="spList" items="${MypageREGList}">
									<tr>
										<td>${spList.regular_bank }</td>
										<td>${spList.regular_account }</td>
										<td>${spList.regular_amount }</td>
									</tr>
									<tr>
										<c:choose>
											<c:when test="${spList.regular_end=='중'}">
												<td colspan="3" class="startSup">출금 : 매달
													${spList.regular_paymentDate }일&nbsp;&nbsp;|&nbsp;&nbsp;시작
													: ${spList.regular_date }</td>
											</c:when>
											<c:otherwise>
												<td colspan="3" class="startSup">출금 : 매달
													${spList.regular_paymentDate }일&nbsp;&nbsp;|&nbsp;&nbsp;시작
													: ${spList.regular_date }&nbsp;&nbsp;|&nbsp;&nbsp;종료 :
													${spList.regular_end }</td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:forEach>
								</tbody>
								</table>
							</c:otherwise>
							</c:choose>
							<c:if test="${regular_end=='진행중'}">
								<a href="#" id="regEnd" class="btn btn-primary del support"
									onclick="end('정말 후원을 중지하시겠습니까?', 'supportREGEnd.sp')">&nbsp;후원종료&nbsp;</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-4 tem">
				<div class="twins-wrap tem">
					<h2>일시후원내역</h2>
					<div>
						<div>
							<table class="board table"
								style="text-align: center; margin-bottom: 14px;">
								<tbody>
									<tr class="boardHead">
										<td>금액</td>
										<td>날짜</td>
									</tr>
								</tbody>

								<tbody class="boardTbottom">
									<c:choose>
										<c:when test="${MypageTEMList.size() == 0}">
											<tr class="boardHead">
												<td colspan="2">
													<h4 style="color: #7c7454;">후원 내역이 없습니다!</h4>
												</td>
											</tr>
								</tbody>
							</table>
							<a href="supportTEMRequest.jsp"
								class="btn btn-primary del support">후원하러 가기</a>
							</c:when>
							<c:otherwise>
								<c:forEach var="spList" items="${MypageTEMList}">
									<tr>
										<td>${spList.temporary_amount }</td>
										<td>${spList.temporary_date }</td>
									</tr>
								</c:forEach>
								</tbody>
								</table>
							</c:otherwise>
							</c:choose>

						</div>
					</div>
				</div>
			</div>

			<div class="col-md-4 tem">
				<div class="twins-wrap tem">
					<h2>봉사내역</h2>
					<div>
						<div>
							<table class="board table"
								style="text-align: center; margin-bottom: 14px;">
								<tbody>
									<tr class="boardHead">
										<td>날짜</td>
										<td>파트</td>
										<td></td>
									</tr>
								</tbody>
								<tbody class="boardTbottom">
									<c:choose>
										<c:when test="${mypageVolList.size() == 0}">
											<tr class="boardHead">
												<td colspan="3">
													<h4 style="color: #7c7454;">신청 내역이 없습니다!</h4>
												</td>
											</tr>
								</tbody>
							</table>
							<a href="volunteerList.vt" class="btn btn-primary del support">봉사신청
								이동</a>
							</c:when>
							<c:otherwise>
								<c:forEach var="vtList" items="${mypageVolList}">
									<c:set var="volEnd" value="volEnd${vtList.volunteer_number}" />
									<tr>
										<td>${vtList.volunteer_date}</td>
										<td>${vtList.volunteer_time}</td>
										<td><c:choose>
												<c:when test="${today lt vtList.volunteer_date}">
													<a href="#" id="volEnd${vtList.volunteer_number}"
														class="volEnd"
														onmouseenter="document.getElementById('${volEnd}').innerHTML = '취소';"
														onmouseleave="document.getElementById('${volEnd}').innerHTML = '예정';"
														onclick="end('봉사신청을 취소하시겠습니까?', 'volunteerDelete.vt?volunteer_number=${vtList.volunteer_number}')">예정</a>
												</c:when>
												<c:otherwise>🌼
												</c:otherwise>
											</c:choose></td>
									</tr>
								</c:forEach>
								</tbody>
								</table>
							</c:otherwise>
							</c:choose>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>