<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
	                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="${clothes.clphoto}" alt="..." /></div>
	                    <div class="col-md-6">
	                        <div class="small mb-1">${clothes.ctype }</div>
	                        <h1 class="display-5 fw-bolder">${clothes.cname }</h1>
	                        <div class="fs-5 mb-5">
	                            <span class="text-decoration-line-through">${clothes.cprice }</span>
	                        </div>
	                        <p class="lead">  ${clothes.clinfo }   </p>
	                        <div class="d-flex">
	                            <input class="form-control text-center me-3" id="inputQuantity" type="num" value="1" style="max-width: 3rem" />
	                            <c:if test="${sessionScope.LoginMemId != null }">
	                            <a class="btn btn-outline-dark flex-shrink-0" type="button" href="${pageContext.request.contextPath }/orderForm?clcode=${param.Clcode}&clname=${clothes.cname}&cprice=${clothes.cprice }&photo=${clothes.clphoto}&csize=${clothes.csize}">
	                                <i class="bi-cart-fill me-1"></i>
	                                구매하기
	                            </a>
	                            </c:if>
	                            <c:if test="${sessionScope.LoginMemId == null }">
	                            <a class="btn btn-outline-dark flex-shrink-0" type="button" href="${pageContext.request.contextPath}/Login">
	                                <i class="bi-cart-fill me-1"></i>
	                                구매하기
	                            </a>
	                            </c:if>
	                            <a href="javascript:add()" class="btn btn-outline-dark flex-shrink-0" type="button">
	                                <i class="bi-cart-fill me-1"></i>
	                                장바구니
	                            </a>
	                        </div>
	                    </div>
	                </div>
            </div>
</section>

    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script type="text/javascript">
    console.log('${clothes}')
    function add(){
    	$.ajax({
    		url:"${pageContext.request.contextPath}/addCart",
    		type:"post",
    		data:{"mid":"${sessionScope.LoginMemId}", "clcode":"${clothes.clcode}", "price":"${clothes.cprice}", "size":"${clothes.csize}", "amount":"${clothes.camount}"},
    		success:function(rs){
    			alert(rs);
    		}
    	})
    }
    </script>
</html>
