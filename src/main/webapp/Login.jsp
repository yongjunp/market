<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인페이지</title>
    <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        .login-container {
            width: 300px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .login-container h2 {
            text-align: center;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
        }

        .form-group input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        
           /* 밑줄 없애기 */
        .form-group a:hover {
            text-decoration: none;
        }    
        
    </style>
</head>
<body>










    <div class="login-container">
        <h2>Login</h2>
        <form action="${pageContext.request.contextPath}/memLogin" method="get">
            <div class="form-group">
                <label for="username">아 이 디:</label>
                <input type="text" id="username" name="username">
            </div>

            <div class="form-group">
                <label for="password">비밀번호:</label>
                <input type="password" id="password" name="password">
            </div>

            <div class="form-group">
                <button type="submit">Login</button>
            </div>
              <div class="form-group">
                <a href="${pageContext.request.contextPath}/Join" onclick="showSignupForm()">회원가입</a>
                <a href="#" onclick="showIdRecoveryForm()">아이디 찾기</a>
                <a href="#" onclick="showPasswordRecoveryForm()">비밀번호 찾기</a>
            </div>
                <a href="#" class="back-button" onclick="goBack()">이전 페이지로</a>
    </form>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>
    </div>

</body>
</html>