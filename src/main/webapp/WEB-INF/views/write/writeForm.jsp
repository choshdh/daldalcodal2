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
	<form action="${pageContext.request.contextPath}/write" method="get">
		
		<!-- 구분 -->
		<select name="division" id="division">
		    <option value="couple" selected="selected">연인</option>
		    <option value="man">남남</option>
		    <option value="woman">여여</option>
		    <option value="concoction">혼성</option>
		    <option value="family">가족</option>
		</select><br>
		
		<!-- 날짜 -->
		<input type="text" name="month" id="month">월<br>
		<input type="text" name="day" id="day">일<br>
		
		<!-- 시간 -->
		am:<input type="text" name="startTime" id="startTime" >시<br>
		pm:<input type="text" name="endTime" id="endTime" >시<br>
		
		<!-- 인원수 -->
		<select name="peopleNo" id="peopleNo">
		    <option value="2" selected="selected">2</option>
		    <option value="3">3</option>
		    <option value="4">4</option>
		    <option value="5">5</option>
		    <option value="6">6</option>
		    <option value="7">7</option>
		    <option value="8">8</option>
		    <option value="9">9</option>
		</select><br>
		
		<!-- 총 비용 계산기 계산된값만 받는걸로 -->
		<input type="text" name="cost" id="cost">총 비용<br>
		
		<!-- 봉사/헌혈 체크박스 -->
		<input type="checkbox" name="volunteer" value="volunteer">봉사/헌혈<br>
		
		<!-- 지역 -->
		<input type="text" name="city" id="city">시<br>
		<input type="text" name="borough" id="borough">구<br>
		<input type="text" name="dong" id="dong">동<br>
		
		<!-- 반경 -->
		<input type="text" name="radius" id="radius">반경<br>
		
		<input type="submit" value="작성완료">
	</form>
	<input type="button" name="button1" value="json작성완료" id="button">
</body>

<script type="text/javascript">
console.log("before jquery");
var division;
var month;
var day;
var startTime;
var endTime;
var peopleNo;
var cost;
var volunteer;
var city;
var borough;
var dong;
var radius;

$("#button").on("click",function(){
	division = $("#division").val();
	month = $("#month").val();
	day = $("#day").val();
	startTime = $("#startTime").val();
	endTime = $("#endTime").val();
	peopleNo = $("#peopleNo").val();
	cost = $("#cost").val();
	volunteer = $("#volunteer").val();
	city = $("#city").val();
	borough = $("#borough").val();
	dong = $("#dong").val();
	radius = $("#radius").val();
	

	var WriteDto = {
		"division":division,
		"month":month,
		"day":day,
		"startTime":startTime,
		"endTime":endTime,
		"peopleNo":peopleNo,
		"cost":cost,
		"volunteer":volunteer,
		"city":city,
		"borough":borough,
		"dong":dong,
		"radius":radius
	};
	
	$.ajax({
		url : "${pageContext.request.contextPath }/api/write",
		type : "post",
		contentType : "application/json",
		data : JSON.stringify(WriteDto),
		
		dataType : "json",
		success : function(writedto){
			/*성공시 처리해야될 코드 작성*/
			console.log(writedto);
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	});
});

</script>
</html>