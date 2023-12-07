<%@ page contentType="text/html; charset=utf-8"%>

<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<title>상품 등록</title>
</head>
<body>
	<jsp:include page="menu.jsp" />

	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">옷 등록</h1>
		</div>
	</div>
	<div class="container">
		<form name="newProduct"
			action="${pageContext.request.contextPath }/addproduct"
			class="form-horizontal" method="post">


			<div class="form-group row">
				<label class="col-sm-2">사진</label>
				<div class="col-sm-3">
					<input type="text" name="photo" id="photo" onchange="loadFile(this)" required>
					<img src="" id="showImg" style="height:300px; width:450px;">					
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상품명</label>
				<div class="col-sm-3">
					<input type="text" name="name" id="name" class="form-control" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">가격</label>
				<div class="col-sm-3">
					<input type="text" name="price" name="price" class="form-control" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">사이즈</label>
				<div class="col-sm-3">
					<select id="size" name="size">
						<option value="S">S</option>
						<option value="M">M</option>
						<option value="L">L</option>
						<option value="XL">XL</option>
						<option value="XXL">XXL</option>
						<option value="XXXL">XXXL</option>
						<option value="FREE">FREE</option>						
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상세 정보</label>
				<div class="col-sm-5">
					<textarea name="info" id="info" cols="50" rows="2"
						class="form-control" required></textarea>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">분류</label>
				<div class="col-sm-3">
					<select id="type" name="type">
						<option value="상의">상의</option>
						<option value="하의">하의</option>
						<option value="아우터">아우터</option>
						<option value="신발">신발</option>
						<option value="모자">모자</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">재고 수</label>
				<div class="col-sm-3">
					<input type="text" name="amount" id="amount" class="form-control" required>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10 ">
					<input type="submit" class="btn btn-primary" value="등록">
				</div>
			</div>
		</form>
	</div>
</body>
<script>
	function loadFile(input) {
	    //미리 만들어 놓은 div에 text(파일 이름) 추가
	    var name = document.getElementById('photo');
	    console.log(name.value);
	    let imgTag = document.getElementById('showImg');
	    imgTag.setAttribute('src', name.value);
	}
</script>
</html>