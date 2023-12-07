<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div style="margin-top: 30px;"></div>
	<div style="padding: 0 100px 0 100px;">
		<h2>이기면 1000P 획득!</h2>
		<div
			style="border: 2px solid black; padding: 0 100px 0 100px; text-align: center;">
			<p>남은횟수: ${mcount }</p>
			<img id="lspImg"
				src="https://media.istockphoto.com/id/1366199097/ko/%EB%B2%A1%ED%84%B0/%EA%B0%84%EB%8B%A8%ED%95%9C-%EB%B0%94%EC%9C%84-%EC%A2%85%EC%9D%B4-%EA%B0%80%EC%9C%84-%EB%A7%88%ED%81%AC-%EC%9D%BC%EB%9F%AC%EC%8A%A4%ED%8A%B8%EB%A0%88%EC%9D%B4%EC%85%98.jpg?s=612x612&w=0&k=20&c=uWDTsQ6tDKqSG5ECE1r9EG7vMM3-c3s6RBFr-fOBivM="
				style="height: 400px;">

			<form id="form" onsubmit="return asd(this)">
				가위 : <input type="radio" value="가위" name="rsp"> 바위 : <input
					type="radio" value="바위" name="rsp"> 보 : <input type="radio"
					value="보" name="rsp">
				<button type="submit">확인</button>
			</form>
		</div>

	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script type="text/javascript">
	const form = document.querySelector('#form');

	form.addEventListener("submit", (event) => {
	  // 동작(이벤트)을 실행하지 못하게 막는 메서드입니다.
	  event.preventDefault();
	})
	function asd(obj){
		console.log(obj.rsp.value)
		if(parseInt("${mcount}", 10)>0){
			$.ajax({
				url:"/sendRSP",
				type:"get",
				data:{"rsp":obj.rsp.value},
				success:function (rs){
					let imgTag = document.querySelector("#lspImg")
					console.log(rs.split("+"[1]))
					
					imgTag.setAttribute("src",rs.split("+")[1])
					setTimeout(function() {
					alert(rs.split("+")[0]);
					location.href="${pageContext.request.contextPath}/rsp";
					}, 1000);
				}
			})
		}else{
			alert("사용횟수가 없습니다.");
		}
		return false;
	}
	</script>
</body>
</html>