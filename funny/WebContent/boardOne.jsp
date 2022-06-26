<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE HTML>
<html>
<head>
<title>상세글</title>
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
<link rel="stylesheet" href="css/boardOne.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	function del() {
		ans = confirm("정말 삭제하시겠습니까?");
		if (ans == true) {
			document.withdrawal.submit();
		} else {
			event.preventDefault();
		}
	}
</script>
</head>
<body>

	<div id="page">

		<!-- Page Header-->
		<mytag:pageHeader />
		<div class="breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col">
						<p class="bread">
							<span><a href="boardList.do">자유게시판</a></span> / <span>상세글</span>
						</p>
					</div>
				</div>
			</div>
		</div>

		<div style="text-align: center; margin-top: 2em; margin-bottom: 7em;">
			<div class="col-sm-4 text-left total writeForm"
				style="display: inline-block;">
				<div class="form-group">

					<div class="form-group boardOne">
						<h5 class="h5-detail title" style="width: 100%;">제목</h5>
						<c:if test="${boardOne.board.supporter_id!='admin'}">
							<h5 class="h5-detail title info">${boardOne.board.supporter_id}
								| ${boardOne.board.board_date}</h5>
						</c:if>
					</div>

					<div class="title-box">
						<h5 style="padding: 14px;">${boardOne.board.board_title}</h5>
					</div>
					<div class="form-group">
						<h5>내용</h5>
						<textarea name="board_content" id="autoHeight"
							class="form-control gap one" disabled>${boardOne.board.board_content}</textarea>
					</div>
					<script type="text/javascript">
						function adjustHeight() {
							var textEle = $('#autoHeight');
							var textEleHeight = textEle.prop('scrollHeight');
							console.log(textEleHeight);
							textEle.css("height", textEleHeight);
						};
						adjustHeight();
					</script>
					<!-- 본인 글에만 노출 -->
					<c:if test="${boardOne.board.supporter_id==supporter_id}">
						<div style="float: right;">
							<a
								href="boardUpdatePage.do?board_number=${boardOne.board.board_number}"
								class="btn btn-primary boardUD">수정하기</a> <a
								href="boardDelete.do?board_number=${boardOne.board.board_number}"
								class="btn btn-primary boardUD" onclick="del()">삭제하기</a>
						</div>
					</c:if>

				</div>
			</div>

			<c:if test="${boardOne.board.supporter_id!='admin'}">
				<!-- 댓글 -->
				<hr>
				<div class="col-sm-4 text-left total writeForm"
					style="display: inline-block;">
					<h3 class="head">${boardOne.board.board_commentCnt}&nbsp;Reviews</h3>

					<c:forEach var="v" items="${boardOne.comments}">
						<div class="review">
							<div class="desc">
								<p class="p-comment" style="font-size: 18px;">${v.comment_content}</p>
								<span class="text-right" style="color: #5959596b;">${v.supporter_id}&nbsp;|&nbsp;${v.comment_date}
									<!-- 본인 댓글에만 노출 --> <c:if
										test="${v.supporter_id==supporter_id}">
										<a
											href="commentDelete.do?comment_number=${v.comment_number}&board_number=${boardOne.board.board_number}"
											class="commentDel">&nbsp;&nbsp;&nbsp;삭제</a>
									</c:if>
								</span>
							</div>
						</div>
					</c:forEach>

					<form action="commentInsert.do" method="post"
						style="display: flex;">
						<input type="hidden" name="board_number"
							value="${boardOne.board.board_number}">

						<!-- 로그인 시에만 댓글 작성 가능 -->
						<c:choose>
							<c:when test="${supporter_id==null}">
								<textarea name="comment_content" cols="10" rows="3"
									class="form-control gap comment comment"
									placeholder="댓글을 작성하려면 로그인 해주세요" disabled></textarea>
								<input type="submit" value="댓글등록"
									class="btn btn-primary inputSubmit comment" disabled>
							</c:when>
							<c:otherwise>
								<textarea name="comment_content" cols="10" rows="3"
									class="form-control gap comment comment"
									placeholder="댓글을 남겨보세요."></textarea>
								<input type="submit" value="댓글등록"
									class="btn btn-primary inputSubmit comment">
							</c:otherwise>
						</c:choose>

					</form>
				</div>
			</c:if>
		</div>
	</div>

	<!-- Page Footer-->
	<mytag:pageFooter />


	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="ion-ios-arrow-up"></i></a>
	</div>

	<script src="js/loginCheck.js"></script>
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

