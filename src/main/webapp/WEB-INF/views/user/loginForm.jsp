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
	<form action="${pageContext.request.contextPath}/user/login" method="get">
		Id:<input type="text" name="id" id="id" value="testId"><br>
		Password:<input type="password" name="pw" id="pw" value="1234"><br>
		<input type="submit" value="로그인">
	</form>
	<a href="${pageContext.request.contextPath}/user/joinform">회원가입</a>
	<input type="button" name="button1" value="json로그인" id="button">
</body>

<script type="text/javascript">
console.log("before jquery");
var id;
var pw;

$("#button").on("click",function(){
	id = $("#id").val();
	pw = $("#pw").val();

	var UserLoginDto = {
		"id":id,
		"pw":pw
			
	};
	
	$.ajax({
		url : "${pageContext.request.contextPath }/api/user/login",
		type : "post",
		contentType : "application/json",
		data : JSON.stringify(UserLoginDto),
		
		dataType : "json",
		success : function(UserLoginDto){
			/*성공시 처리해야될 코드 작성*/
			console.log(UserLoginDto);
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	});
	
});

</script>
</html>