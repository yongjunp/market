<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="UTF-8">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css">
<style type="text/css">
.formWrap {
	margin-bottom: 0px;
	width: 400px;
	border: 3px solid black;
	padding: 10px;
	border-radius: 10px;
	background-color: white;
	margin-left: auto;
	margin-right: auto;
}

.formInput {
	margin-bottom: 0px;
	border: 1px solid #dfdfdf;
	border-radius: 7px;
	padding: 7px;
	align-items: center;
	flex-wrap: wrap;
}

.formInput>input[type='text'], .formInput>input[type='date'] {
	box-sizing: border-box;
	width: 100%;
	border: none;
	outline: none;
	padding: 5px;
	font-size: 20px;
}

.formInput>input[type='button'] {
	width: 100%;
	border-radius: 10px;
	padding: 3px;
	background-color: bisque;
	cursor: pointer;
	margin-bottom: 3px;
}

.formSubmit {
	border: none;
	border-radius: 7px;
	margin-top: 5px;
}

.formSubmit>input {
	background-color: bisque;
	width: 100%;
	padding: 10px;
	border-radius: 15px;
	font-weight: bold;
	font-size: 20px;
	cursor: pointer;
}

input[type='date'] {
	font-family: auto;
}

.formInputOn {
	border: 2px solid green;
}

.checkMsg {
	color: blue;
	margin-top: 2px;
	margin-left: 10px;
	margin-bottom: 2px;
	font-size: 15px;
}

.formInputOn {
	border: 2px solid green;
}

.formInputErr {
	border: 2px solid red !important;
}
#search{
	display: inline-block;
}
.searchBtn{
	height: 50px;
    position: relative;
    top: -3px;
}
</style>
</head>



<nav class="navbar navbar-expand-lg bg-body-tertiary"
	style="background-color: #000;">

	<a class="navbar-brand" href="${pageContext.request.contextPath}/"
		style="color: white;">핏하네</a>
	<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
		data-bs-target="#navbarTogglerDemo02"
		aria-controls="navbarTogglerDemo02" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarTogglerDemo02">


		<div class="container">
			<form name="newProduct"
			action="${pageContext.request.contextPath }/searchPage"
			class="form-horizontal" method="post">
				<input name="search" id="search" class="container-fluid form-control-lg me-2" type="text"
					placeholder="검색" aria-label="검색" style="width: 1000px;">
				<button class="btn btn-outline-success searchBtn " id="search" type="submit">검색</button>
			</form>
		</div>
	</div>


	<div class="text-center">
		<a class="btn btn-outline-light mt-auto" href="./my.jsp">마이페이지</a>
	</div>
	<div class="text-center">
		<a class="btn btn-outline-light mt-auto" href="${pageContext.request.contextPath }/cart">장바구니</a>
	</div>
	<c:if test="${sessionScope.LoginMstate == 2 }">
	<div class="text-center">
		<a class="btn btn-outline-light mt-auto" href="/Addproduct.jsp">옷등록</a>
	</div>
	</c:if>

	<c:choose>
		<c:when test="${ sessionScope.LoginMemId == null }">
			<div class="text-center">
				<a class="btn btn-outline-light mt-auto"
					href="${pageContext.request.contextPath}/Login">로그인</a>
			</div>
			<div class="text-center">
				<a class="btn btn-outline-light mt-auto"
					href="${pageContext.request.contextPath}/Join">회원가입</a>
			</div>
		</c:when>
		<c:otherwise>
			<div class="text-center">
				<a class="btn btn-outline-light mt-auto"
					href="${pageContext.request.contextPath}/Logout">로그아웃</a>
			</div>
			<div class="text-center">
				<a class="btn btn-outline-light mt-auto"
					href="${pageContext.request.contextPath}/my">내정보</a>
			</div>
			<div class="text-center">
				<a class="btn btn-outline-light mt-auto"
					href="${pageContext.request.contextPath}/rsp">가위바위보</a>
			</div>
		</c:otherwise>
	</c:choose>
</nav>
</html>
