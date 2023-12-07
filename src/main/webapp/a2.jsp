<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <title>예약 페이지</title>
    
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            text-align: center;
        }
        h1 {
            color: #333;
        }
        h2 {
            color: #555;
        }
        p {
            color: #777;
            margin: 5px 0;
        }
        .info-box {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 100px;
            margin-bottom: 15px;
            display: inline-block; /* 요소를 인라인 블록으로 설정하여 네모 상자 안에 배치 */
        }
    </style>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>










    <h1>구매</h1>
    <div class="info-box">
        <h2></h2>
        
        <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="${param.photo }" alt="..." /></div>
        
        
        <div class="info-item">
        <form action="${pageContext.request.contextPath }/order" onsubmit="return checkPoint(this)">
            <p>상품: ${param.clname }</p><input type="hidden" value="${param.clcode }" name="goodsCode">
            <p>이름: ${sessionScope.LoginMemName }</p><input type="hidden"name = "MemId" value="${sessionScope.LoginMemId }">
            <p>주문 내역: ${odcode }</p><input type="hidden"name = "ordercode" value="${odcode }">
            <p>금액: ${param.cprice }</p><input type="hidden" id="goodsPrice"name = "goodsPrice" value="${param.cprice }">
            <p style="display: contents;">사용가능 포인트:${sessionScope.LoginMemPoint }</p>
            <input type="text" id="point" name="mpoint" value="0"><br>
            <p style="display: contents;">사이즈:${param.csize }</p><input type="hidden" name="goodsSize"value="${param.csize }"><br>
            <p style="display: contents;">수량(최대10):</p><select name="goodsAmount"><c:forEach var="i" begin="1" end="10"><option value="${i }">${i }</option></c:forEach></select><br>
            <p style="display: contents;">주소: </p><input type="text"name="address" value="${sessionScope.LoginMemAddr }"><br>
             <button type="submit"> 결제하기 </button>
        </form>
          
            
            
        </div>
    </div>
    <script type="text/javascript">
    function checkPoint(obj){
    	let inputpoint = document.querySelector("#point");
    	if(parseInt("${sessionScope.LoginMemPoint }", 10) < parseInt(inputpoint.value, 10)){
    		alert("포인트가 부족합니다.");
    		return false;
    	}
    	return true;
    }
    </script>
</body>
</html>
