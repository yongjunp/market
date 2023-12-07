<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>핏하네 장바구니</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="jumbotron" style="background-color: black; color: blue;">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-6">
                <h1 class="display-5">장바구니</h1>
                <hr style="border-top: 2px solid white;">
                <h1 class="display-5">상,하의 세트 구매시 33%할인</h1>
            </div>
            
        </div>
    </div>
</div>
	<div class="container">
		<div class="row">
			<table width="100%">
				<tr>
					<td align="left"><a href="./deleteCartjsp" class="btn btn-danger">삭제하기</a></td>
					<td align="right"><a href="${pageContext.request.contextPath }/cartOrder" class="btn btn-success" style="background-color: blue;">주문하기</a></td>
				</tr>
			</table>
		</div>
		<div style="padding=top: 50px">
			<table class="table table-hover">
				<tr>
					<th>상품이름</th>
					<th>가격</th>
					<th>남은 수량</th>
					<th>사이즈</th>
					<th>비고</th>
				</tr>
				<c:choose>
				<c:when test="${caddList == '[]' }">
				<tr>
					<td>추가한 상품이 없습니다.</td>
				</tr>
				</c:when>
				<c:otherwise>
				<c:forEach items="${caddList }" var="cadd">
				<tr>
					<td>${cadd.clcode }</td>
					<td>${cadd.price }</td>
					<td>${cadd.amount }</td>
					<td>${cadd.csize }</td>
					<td><a href="${pageContext.request.contextPath }/searchPage?search=${cadd.clcode}" class="badge badge-primary">검색</a>
					<a href="${pagecontext.request.contextpath }/deletecadd?adcode=${cadd.adcode}" class="badge badge-danger">삭제</a></td>
				</tr>
				</c:forEach>
				</c:otherwise>
				</c:choose>
				</table>
				<a href="./NewFile1.jsp" class="btn-secondary"> &laquo;쇼핑계속하기</a>
		</div>
		<hr>
	</div>
	<script type="text/javascript">
	console.log("${caddList}");
	</script>
</body>
</html>