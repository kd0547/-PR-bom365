<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="colorlib-nav" role="navigation">
	<div class="top-menu">
		<div class="container">
			<div class="row">
				<div class="col-sm-7 col-md-9">
					<div id="colorlib-logo">
						<a href="main.do"><img src="images/logo.png" alt="brandLogo"
							width="160px" height="120px" /></a>
					</div>
				</div>
				<div class="col-sm-5 col-md-3">
					<!-- 로그인 상태에따라 구성 다르게 -->
					<c:choose>
						<c:when test="${supporter_id==null}">
							<a href="login.jsp" class="btn btn-primary">&nbsp;로그인&nbsp;</a>
							<a href="signup.jsp" class="btn btn-primary">회원가입</a>
						</c:when>
						<c:otherwise>
							<a href="logout.me" class="btn btn-primary">&nbsp;로그아웃&nbsp;</a>
							<c:if test="${supporter_id!='admin'}">
								<a href="mypage.me" class="btn btn-primary">마이페이지</a>
							</c:if>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 text-right menu-1">
					<ul>
						<li><c:choose>
								<c:when test="${supporter_id=='admin'}">
									<a href="adminApplicationList.ap">입양신청목록</a>
								</c:when>
								<c:otherwise>
									<a href="animalList.am">입양하기</a>
								</c:otherwise>
							</c:choose></li>
						<li class="has-dropdown"><c:choose>
								<c:when test="${supporter_id=='admin'}">
									<a style="color: #978d67;cursor: default;">후원신청목록</a>
									<ul class="dropdown">
										<li><a href="adminSupportREGList.sp">정기후원 신청목록</a></li>
										<li><a href="adminSupportTEMList.sp">일시후원 신청목록</a></li>
									</ul>
								</c:when>
								<c:otherwise>
									<a href="support.jsp">후원하기</a>
									<ul class="dropdown">
										<li><c:choose>
												<c:when test="${regular_end == '진행중'}">
													<a class="mainREG">정기후원 (진행 중)</a>
												</c:when>
												<c:otherwise>
													<a href="#"
														onclick="${supporter_id == null? 'loginCheck()':'goREG()'}">정기후원
														신청하기</a>
												</c:otherwise>
											</c:choose></li>
										<li><a href="#"
											onclick="${supporter_id == null? 'loginCheck()':'goTEM()'}">일시후원
												신청하기</a></li>
									</ul>
								</c:otherwise>
							</c:choose></li>
						<li><a href="volunteerList.vt"> <c:choose>
									<c:when test="${supporter_id=='admin'}">봉사신청목록</c:when>
									<c:otherwise>봉사신청</c:otherwise>
								</c:choose>
						</a></li>
						<li><a href="boardList.do">자유게시판</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="sale"></div>
</nav>