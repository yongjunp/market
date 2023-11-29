<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <title>���� ������</title>
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
            display: inline-block; /* ��Ҹ� �ζ��� ������� �����Ͽ� �׸� ���� �ȿ� ��ġ */
        }
    </style>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>










    <h1>����</h1>
    <div class="info-box">
        <h2></h2>
        
        <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="https://dummyimage.com/600x700/dee2e6/6c757d.jpg" alt="..." /></div>
        
        
        <div class="info-item">
        <form action="${pageContext.request.contextPath }/order">
            <p>��ǰ: asd</p><input type="hidden" value="CL00001" name="goodsCode">
            <p>�̸�: ${sessionScope.LoginMemName }</p><input type="hidden"name = "MemId" value="${sessionScope.LoginMemId }">
            <p>�ֹ� ����: OD00001</p><input type="hidden"name = "goodsCode" value="OD00001">
            <p>�ݾ�: 1000</p><input type="hidden" id="goodsPrice"name = "goodsPrice" value="1000">
            <p style="display: contents;">������:</p><select name="goodsSize"><option value="m">m</option><option value="l">l</option><option value="xl">xl</option></select><br>
            <p style="display: contents;">����(�ִ�10):</p><select name="goodsAmount"><c:forEach var="i" begin="1" end="10"><option value="${i }">${i }</option></c:forEach></select><br>
            <p style="display: contents;">�ּ�: </p><input type="text"name="address"><br>
             <button type="submit"> �����ϱ� </button>
        </form>
          
            
            
        </div>
    </div>
</body>
</html>
