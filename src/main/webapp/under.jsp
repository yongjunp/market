<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Shop Homepage - Start Bootstrap Template</title>
<style>
	.mainImg{
		max-width: none;
		width:2000px;
		height: 700px;
		position: relative;
    	top: -16px
	}
</style>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="NewFile.css" rel="stylesheet" />
</head>
<body>


	<jsp:include page="menu.jsp" />



	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<!--           <a class="navbar-brand" href="#!">핏하네</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#!">All Products</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                                <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                        </button>
                    </form>-->
		</div>
		</div>
	</nav>
	<!-- Header-->
	<header class="">
		<div class="">
			<div class="">
				<img src='https://ifh.cc/g/dcXdOL.jpg' class="mainImg">	
			</div>
		</div>
	</header>

	<div id="contents">


		<ul class="nav nav-tabs">


			<li class="nav-item"><a class="nav-link "
				href="${pageContext.request.contextPath }/upper"
				style="color: #000;">상의</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath }/under"
				style="color: #000;">하의</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath }/outer"
				style="color: #000;">아우터</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath }/shoes"
				style="color: #000;">신발</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath }/cap" style="color: #000;">모자</a>
			</li>
		</ul>

		<!-- Section-->
		<section class="py-5">
			<div class="container px-4 px-lg-5 mt-5">
				<div
					class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
					<c:forEach items="${clothes }" var="cl">
						<div class="col mb-5">
							<div class="card h-100">
								<!-- Product image-->
								<img class="card-img-top" src="${cl.clphoto }" alt="..."
									style="height: 300px;">
								<!-- Product details-->
								<div class="card-body p-4">
									<div class="text-center">
										<!-- Product name-->
										<h5 class="fw-bolder">${cl.cname }</h5>
										${cl.cprice }

										<!-- Product price-->
									</div>
								</div>
								<!-- Product actions-->
								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center">
										<a class="btn btn-outline-dark mt-auto"
											href="${pageContext.request.contextPath }/detailPage?Clcode=${cl.clcode }">상세
											페이지</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>


			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
					<li class="page-item disabled"></li>
				</ul>
			</nav>







		</section>
		<!-- Footer-->
		<footer class="py-5 bg-dark">
			<div class="container">
				<p class="m-0 text-center text-white">fit &copy; 핏하네</p>
			</div>
		</footer>
		<!-- Bootstrap core JS-->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
		<!-- Core theme JS-->
		<script src="js/scripts.js"></script>
</body>
</html>
