<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <title>����������</title>
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
            margin-bottom: 20px;
        }
        .info-box {
            display: inline-block;
            text-align: left;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="submit"] {
            padding: 8px;
            width: 200px;
            border-radius: 3px;
            border: 1px solid #ccc;
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>����������</h1>
    <%-- ���⿡�� ����� ������ �������ּ��� --%>
    <div class="info-box">
        <label for="userName">�̸�:</label>
        <p id="userName">${sessionScope.LoginMemId}</p>
        <label for="userEmail">�̸���:</label>
        <p id="userEmail">${sessionScope.LoginMemEmail }</p>
        <label for="orderDetails">�ֹ� ����:</label>
        <p id="orderDetails"></p>
        <input type="submit" value="�ֹ� ������">
    </div>
</body>
</html>
