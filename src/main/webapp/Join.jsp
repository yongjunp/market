<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
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
    <h2>회원가입</h2>
    <form action="${pageContext.request.contextPath }/memJoin" method="post">
        <label for="name">이름:</label>
        <input type="text" id="name" name="name" required>

        <label for="username">아이디:</label>
        <input type="text" id="username" name="id" required>

        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="pw" required>

        <label for="confirmPassword">E-mail:</label>
        <input type="text" id="confirmPassword" name="email" required>

        <label for="phone">전화번호:</label>
        <input type="tel" id="phone" name="phone" required>

        <label for="address">주소:</label>
        <input type="text" id="address" name="address" required>

        <button type="submit">가입하기</button>
        <button type="submit">이전페이지</button>
       
    </form>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>
	</div>
</body>
</html>