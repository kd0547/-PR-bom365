<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE HTML>
<html>
<head>
<title>입양하기</title>
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

<!-- contect animate.css -->
<link rel="stylesheet" href="css/animalList.css">

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
							<span><a href="main.do">HOME</a></span> / <span>입양하기</span>
						</p>
					</div>
				</div>
			</div>
		</div>

		<h1 id="menuTitle">입양하기</h1>

		<!-- select-animals -->
		<div class="select-animals-container">
			<form action="animalSearch.am" method="post">
				<div class="row mb-1 mx-2">
					<div class="col-lg-10">
						<div class="row">
							<div class="col-sm-12 col-lg mb-3 mb-lg-0">
								<label class="d-block"> <span
									class="h4 d-block text-dark font-weight-semi-bold mb-0">동물구분</span>
									<small class="d-block text-secondary">개/고양이</small>
								</label>
								<div class="js-form-message">
									<div class="js-focus-state form-group">
										<select name="animal_species"
											class="form-control custom-select">
											<option value="">All</option>
											<option value="dog">개</option>
											<option value="cat">고양이</option>
										</select>
									</div>
								</div>
							</div>
							<div class="col-sm-12 col-lg mb-3 mb-lg-0">
								<label class="d-block"> <span
									class="h4 d-block text-dark font-weight-semi-bold mb-0">성별</span>
									<small class="d-block text-secondary">암컷/수컷</small>
								</label>
								<div class="js-form-message">
									<div class="js-focus-state form-group">
										<select name="animal_gender"
											class="form-control custom-select">
											<option value="">All</option>
											<option value="female">암컷</option>
											<option value="male">수컷</option>
										</select>
									</div>
								</div>
							</div>
							<div class="col-sm-12 col-lg mb-3 mb-lg-0">
								<label class="d-block"> <span
									class="h4 d-block text-dark font-weight-semi-bold mb-0">크기</span>
									<small class="d-block text-secondary">대/중/소 </small>
								</label>
								<div class="js-form-message">
									<div class="js-focus-state form-group">
										<select name="animal_weight"
											class="form-control custom-select">
											<option value="0099">All</option>
											<option value="0008">소(8kg 미만)</option>
											<option value="0818">중(8~18kg 미만)</option>
											<option value="1899">대(18kg이상)</option>
										</select>
									</div>
								</div>
							</div>
							<div class="col-sm-12 col-lg mb-3 mb-lg-0">
								<label class="d-block"> <span
									class="h4 d-block text-dark font-weight-semi-bold mb-0">연령</span>
									<small class="d-block text-secondary">puppy/junior/adult/senior</small>
								</label>
								<div class="js-form-message">
									<div class="js-focus-state form-group">
										<select name="animal_age" class="form-control custom-select">
											<option value="0000099999">All</option>
											<option value="00000000.6">Puppy(~ 6개월)</option>
											<option value="000.700002">Junior(7개월 ~ 2살)</option>
											<option value="0000300008">Adult(3살 ~ 8살)</option>
											<option value="0000999999">Senior(9살 ~)</option>
										</select>
									</div>
								</div>
							</div>

							<div class="col-12 g-pt-15">
								<div class="input-group">
									<input type="text" class="form-control" name="animal_name"
										placeholder="이름 (이름을 모를경우 비워두셔도 됩니다.)" value="">
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-2 g-pt-30 g-pt-60--lg search">
						<div class="g-pb-15 g-pb-sm-0 search-refresh">
							<a href="animalList.am"
								class="btn btn-sm btn-block g-brd-0 text-secondary g-font-size-14 g-px-0 mb-1 reset">
								<i class="icon-refresh"></i> <span
								class="g-text-underline search-refresh">검색 설정 초기화</span>
							</a>
						</div>
						<div class="g-pt-15--lg">
							<button type="submit"
								class="btn btn-sm btn-block btn-primary btn-search-animals">검색</button>
						</div>
					</div>
				</div>
			</form>
		</div>

		<c:choose>
			<c:when test="${animalList.size() == 0}">
				<h1 style="text-align: center; margin-block: 3em;">검색 결과가 없습니다!</h1>
			</c:when>
			<c:otherwise>
				<!-- animals list -->
				<div class="row animals-photos">
					<c:forEach var="v" items="${animalList}">
						<div
							class="col-md-3 col-lg-3 mb-4 text-center animals-photos-text">
							<div class="product-entry border">
								<a href="animalOne.am?animal_number=${v.animal_number}"
									class="prod-img"> <img src="${v.animal_image}"
									class="img-fluid animals"
									alt="${v.animal_number}(${v.animal_name})"> <c:if
										test="${v.isAdoption == 'true'}">
										<img src="images/adoptionDone.png" class="img-fluid animals"
											alt="Free html5 bootstrap 4 template">
									</c:if>
								</a>

								<div class="desc">
									<h2>
										<a href="animalOne.am?animal_number=${v.animal_number}">${v.animal_name}</a>
									</h2>
									<span class="animal_spacies">${v.animal_species}(${v.animal_type})</span><br>
									<span class="animal_gender">${v.animal_gender}</span><br>
									<span class="animal_age">${v.animal_age} <span
										class="animal_weight">/ ${v.animal_weight}kg</span></span>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>

				<!-- 페이징 처리 -->
				<div style="margin: 3rem 0 7em 0;">
					<div class="col-md-12 text-center">
						<div class="block-27">
							<ul>
								<c:if test="${nowPage > 1 }">
									<li><c:choose>
											<c:when test="${seach != null}">
												<a
													href="animalSearch.am?animal_name=${animal_name}&animal_species=${animal_species}&animal_gender=${animal_gender}&animal_weight=${animal_weight}&animal_age=${animal_age}&page=${nowPage-1}"><i
													class="ion-ios-arrow-back"></i></a>
											</c:when>
											<c:otherwise>
												<a href="animalList.am?page=${nowPage-1}"><i
													class="ion-ios-arrow-back"></i></a>
											</c:otherwise>
										</c:choose></li>
								</c:if>
								<c:forEach var="i" begin="${startPage }" end="${endPage }">
									<c:choose>
										<c:when test="${i == nowPage }">
											<li class="active"><span>${i }</span></li>
										</c:when>
										<c:otherwise>
											<li><c:choose>
													<c:when test="${seach != null}">
														<a
															href="animalSearch.am?animal_name=${animal_name}&animal_species=${animal_species}&animal_gender=${animal_gender}&animal_weight=${animal_weight}&animal_age=${animal_age}&page=${i}">${i }</a>
													</c:when>
													<c:otherwise>
														<a href="animalList.am?page=${i}">${i }</a>
													</c:otherwise>
												</c:choose></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:if test="${nowPage < totalPage }">
									<li><c:choose>
											<c:when test="${seach != null}">
												<a
													href="animalSearch.am?animal_name=${animal_name}&animal_species=${animal_species}&animal_gender=${animal_gender}&animal_weight=${animal_weight}&animal_age=${animal_age}&page=${nowPage+1}"><i
													class="ion-ios-arrow-forward"></i></a>
											</c:when>
											<c:otherwise>
												<a href="animalList.am?page=${nowPage+1}"><i
													class="ion-ios-arrow-forward"></i></a>
											</c:otherwise>
										</c:choose></li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>



		<!-- Page Footer-->
		<mytag:pageFooter />

	</div>

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