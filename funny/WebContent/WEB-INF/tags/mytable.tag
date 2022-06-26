<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s"%>

<script type="text/javascript">
	function del() {
		var ans = confirm("정말 후원을 중지하시겠습니까?");
		if (ans == true) {

			var trans = document.getElementById("trans");
			trans.method = "POST";
			location = "supportREGEnd.sp";
		} else {
			event.preventDefault();
		}
	}
</script>

<div class="twin container">
	<div class="row temreg container">
		<div class="col-md-6 reg">
			<div class="twins-wrap reg" style="width: 41em;">
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
									<td>시작일</td>
									<td>종료일</td>
								</tr>
							</tbody>
							<tbody class="boardTbottom">
								<c:choose>
									<c:when test="${MypageREGList.size() == 0 }">
										<tr class="boardHead">
											<td colspan="5">
												<h4>후원 내역이 없습니다!</h4>
											</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach var="spList" items="${MypageREGList}">
											<tr>
												<td>${spList.regular_bank }</td>
												<td>${spList.regular_account }</td>
												<td>${spList.regular_amount }</td>
												<td>${spList.regular_date }</td>
												<td>${spList.regular_end }</td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
						<c:if test="${regular_end=='진행중'}">
							<a href="#" id="trans" class="btn btn-primary del support"
								onclick="del()">&nbsp;후원종료&nbsp;</a>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6 tem">
			<div class="twins-wrap tem" style="width: 26em; margin-left: 116px;">
				<h2>일시후원내역</h2>
				<div>
					<div>
						<table class="board table" style="text-align: center;">
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
											<td colspan="2"><h6>후원 내역이 없습니다!</h6></td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach var="spList" items="${MypageTEMList}">
											<tr>
												<td>${spList.temporary_amount }</td>
												<td>${spList.temporary_date }</td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>