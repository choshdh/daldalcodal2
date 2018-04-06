<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/jquery-1.12.4.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/join" method="get">
		Id:<input type="text" name="id" id="id"><br>
		NickName:<input type="text" name="nickName" id="nickname"><br>
		Password:<input type="password" name="pw" id="pw"><br>
		age:<input type="text" name="age" id="age"><br>
		e-mail:<input type="text" name="email" id="email"><br>
		<input type="submit" value="회원가입완료">
	</form>
	<a href="${pageContext.request.contextPath}/user/overlap?joinIdCheck=testId">중복체크</a>
	
	<input type="button" name="button" id="button" value="json회원가입완료">
</body>
<script type="text/javascript">
console.log("before jquery");
var id;
var nickname;
var pw;
var age;
var email;

$("#button").on("click",function(){
	id = $("#id").val();
	nickname = $("#nickname").val();
	pw = $("#pw").val();
	age = $("#age").val();
	email = $("#email").val();

	var UserJoinDto = {
		"id":id,
		"nickname":nickname,
		"pw":pw,
		"age":age,
		"email":email
	};
	
	$.ajax({
		url : "${pageContext.request.contextPath }/api/user/join",
		type : "post",
		contentType : "application/json",
		data : JSON.stringify(UserJoinDto),
		
		dataType : "json",
		success : function(UserJoinDto){
			/*성공시 처리해야될 코드 작성*/
			console.log(UserJoinDto);
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	});
});

</script>

</html>