<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ȸ������</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        form {
            width: 300px;
            margin: 20px auto;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 12px;
            box-sizing: border-box;
        }

        button {
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>



  <div class="login-container">
    <h2>ȸ������</h2>
    <form action="${pageContext.request.contextPath }/memJoin" method="post">
        <label for="name">�̸�:</label>
        <input type="text" id="name" name="name" required>

        <label for="username">���̵�:</label>
        <input type="text" id="username" name="id" required>

        <label for="password">��й�ȣ:</label>
        <input type="password" id="password" name="pw" required>

        <label for="confirmPassword">E-mail:</label>
        <input type="text" id="confirmPassword" name="email" required>

        <label for="phone">��ȭ��ȣ:</label>
        <input type="tel" id="phone" name="phone" required>

        <label for="address">�ּ�:</label>
        <input type="text" id="address" name="address" required>

        <button type="submit">�����ϱ�</button>
        <button type="submit">����������</button>
       
    </form>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>
	</div>
</body>
</html>