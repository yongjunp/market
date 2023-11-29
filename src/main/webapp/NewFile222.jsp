<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Item - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css222.css" rel="stylesheet" />
    </head>
    <body>
    
    
    
    
    
    
        
    
    
    
      <jsp:include page="menu.jsp" />
    
    
    
    
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="https://dummyimage.com/600x700/dee2e6/6c757d.jpg" alt="..." /></div>
                    <div class="col-md-6">
                        <div class="small mb-1">상의</div>
                        <h1 class="display-5 fw-bolder">무슨무슨옷</h1>
                        <div class="fs-5 mb-5">
                            <span class="text-decoration-line-through">할인전 가격</span>
                            <span>할인 후 가격</span>
                        </div>
                        <p class="lead">  설명 창   </p>
                        <div class="d-flex">
                            <input class="form-control text-center me-3" id="inputQuantity" type="num" value="1" style="max-width: 3rem" />
                            
                            
                            
                            
                            <a class="btn btn-outline-dark flex-shrink-0" type="button" href="${pageContext.request.contextPath }/orderForm">
                                <i class="bi-cart-fill me-1"></i>
                                구매하기
                            </a>
                            
                            
                            
                            
                            
                            
                            
                            <button class="btn btn-outline-dark flex-shrink-0" type="button">
                                <i class="bi-cart-fill me-1"></i>
                                장바구니
                            </button>
                        </div>
                    </div>
                </div>
            </div>
</section>

    </body>
</html>
