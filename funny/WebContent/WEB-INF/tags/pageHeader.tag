<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<%@ attribute name="pageSector"%>

<nav class="colorlib-nav" role="navigation">
	<div class="top-menu">
		<div class="container">
			<div class="row">
				<div class="col-sm-7 col-md-9">
					<div id="colorlib-logo">
						<a href="main.jsp"><img src="images/logo.png" alt="brandLogo"
							width="160px" height="120px" /></a>
					</div>
				</div>
				<div class="col-sm-5 col-md-3">
					<a href="login.jsp" class="btn btn-primary">&nbsp;로그인&nbsp;</a> <a
						href="#" class="btn btn-primary">회원가입</a>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 text-right menu-1">
					<ul>
						<li><a href="animalsList.jsp">입양하기</a></li>
						<li class="has-dropdown"><a href="men.html">후원하기</a>
							<ul class="dropdown">
								<li><a href="product-detail.html">정기 후원</a></li>
								<li><a href="cart.html">일시 후원</a></li>
							</ul></li>
						<li><a href="about.html">봉사자모집</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="sale">
	
	</div>
</nav>