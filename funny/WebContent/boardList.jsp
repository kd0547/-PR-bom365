<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE HTML>
<html>
<head>
<title>자유게시판</title>
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

<!-- contect boardList.css -->
<link rel="stylesheet" href="css/boardList.css">

</head>
<body>

	<div id="page">

		<!-- Page Header-->
		<mytag:pageHeader/>

		<div class="breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col">
						<p class="bread">
							<span><a href="main.do">Home</a></span> / <span>자유게시판</span>
						</p>
					</div>
				</div>
			</div>
		</div>
		
		<h1 id="menuTitle">자유게시판</h1>
		
		<!-- BoardList -->
		<div class="boardListFirstDiv">
			<div style="display: inline-block;">
				<table class="board table">
					<tbody>
						<tr>
							<td class="removeBorderTop"></td>
							<td colspan="2" class="removeBorderTop"
								style="padding-inline: 120px;">
								
								<!-- 로그인했을시에만 글 작성 가능 -->
								<c:choose>
									<c:when test="${supporter_id==null}">
										<a href="login.jsp" class="btn btn-primary inputSubmit apply">로그인
											후 작성가능</a>
									</c:when>
									<c:otherwise>
										<a href="boardRequest.jsp"
											class="btn btn-primary inputSubmit apply">글 작성하기</a>
									</c:otherwise>
								</c:choose>
								
								<!-- 검색 -->
								<form method="post" action="boardSearch.do" style="float: right;">
									<input type="text" name="keyword" class="searchKeyword">
									<input type="submit" value="검색"
										class="btn btn-primary inputSubmit searchButton">
								</form>

							</td>
							<td class="removeBorderTop"></td>
						</tr>
						
						<tr>
							<td class="removeBorderTop"></td>
							<td colspan="2" class="removeBorderTop" style="float: right;"><h6>
									정렬 :&nbsp; 
									<a href="boardCategory.do?category=recent">최신순</a>&nbsp;|&nbsp;
									<a href="boardCategory.do?category=comment">댓글순</a>&nbsp;
									<!-- 로그인이안돼있다면 숨김 -->
									<c:if test="${supporter_id!=null}">
										|&nbsp;<a href="boardCategory.do?category=mine">내글보기</a>&nbsp;
									</c:if>
								</h6></td>
							<td class="removeBorderTop"></td>
						</tr>
						
						<tr class="boardHead">
							<td style="width: 7em;">번호</td>
							<td style="width: 28em;">제목</td>
							<td style="width: 7em;">작성자</td>
							<td style="width: 7em;">날짜</td>
						</tr>
					</tbody>
					<c:choose>
						<c:when test="${boardList.size()==0}">
							<tbody class="boardTbottom">
								<tr>
									<td colspan="4"><h3>등록된 글이 없습니다!</h3></td>
								</tr>
							</tbody>
						</c:when>
						<c:otherwise>
							<tbody class="boardTbottom">
								<c:forEach var="v" items="${boardList}">
									<tr>
										<c:choose>
											<c:when test="${v.supporter_id=='admin'}">
												<td>공지</td>
												<td colspan="3" class="boardTitle"><a
													href="boardDetail.do?board_number=${v.board_number}"
													style="color: #b74a55;">[필독]&nbsp;&nbsp;&nbsp;${v.board_title}</a></td>
											</c:when>
											<c:otherwise>
												<td>${v.board_number}</td>
												<td class="boardTitle"><a
													href="boardDetail.do?board_number=${v.board_number}"
													style="color: #978d67;">${v.board_title}&nbsp; <b
														style="color: #978d678c;">[${v.board_commentCnt}]</b>
												</a></td>
												<td>${v.supporter_id}</td>
												<td>${v.board_date}</td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:forEach>
							</tbody>
						</c:otherwise>
					</c:choose>
				</table>
			</div>
		</div>
<!-- 페이지네이션 구현한다면 유지//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- 		<div style="margin-bottom: 3em;">
			<div class="col-md-12 text-center">
				<div class="block-27">
					<ul>
						<li><a href="#"><i class="ion-ios-arrow-back"></i></a></li>
						<li class="active"><span>1</span></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#"><i class="ion-ios-arrow-forward"></i></a></li>
					</ul>
				</div>
			</div>
		</div> -->

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