<%@ page contentType="text/html; charset=utf-8"%>

<html>
<head>
<link rel = "stylesheet"
	href ="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
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
		<form name="newProduct" action="./processAddProduct.jsp" class="form-horizontal" method="post">
			
			
			<div class="form-group row">
				<label class="col-sm-2">계절</label>
				<div class="col-sm-5">
					<input type="radio" name="condition" value="New " > 봄 / 가을 
					<input type="radio" name="condition" value="Old" > 여름
					<input type="radio" name="condition" value="Refurbished" > 겨울
				</div>
			</div>
			

	
			<div class="form-group row">
				<label class="col-sm-2">사진</label>
				<div class="col-sm-3">
				<form action="uploadCheck.jsp" method="post" enctype="multipart/form-data">
		<input type="file" name="file"><br>
		<input type="submit" value="업로드">
		
		
		
	</form>
	
	
	
	
	
				
				
				</div>
			</div>
			
			
			
			<div class="form-group row">
				<label class="col-sm-2">상품 코드</label>
				<div class="col-sm-3">
					<input type="text" name="productId" class="form-control" >
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상품명</label>
				<div class="col-sm-3">
					<input type="text" name="name" class="form-control" >
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">가격</label>
				<div class="col-sm-3">
					<input type="text" name="unitPrice" class="form-control" >
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상세 정보</label>
				<div class="col-sm-5">
					<textarea name="description" cols="50" rows="2"
						class="form-control"></textarea>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">제조사</label>
				<div class="col-sm-3">
					<input type="text" name="manufacturer" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">분류</label>
				<div class="col-sm-3">
					<input type="text" name="category" class="form-control" >
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">재고 수</label>
				<div class="col-sm-3">
					<input type="text" name="unitsInStock" class="form-control" >
				</div>
			</div>
			
			
			
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10 ">
					<input type="submit" class="btn btn-primary" value="등록" >
				</div>
			</div>
		</form>
	</div>
</body>
</html>