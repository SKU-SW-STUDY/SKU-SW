<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="sku.lesson.spring.utils.DateService"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form action="/regist" method="Post">
<table>
	<tr>
		<td>ID</td><td><input type="text" name="userId" id="userId" /></td><td><input type="button"  id="btn_id" value="idCheck" /></td>
	</tr>
	<tr>
		<td>name</td><td><input type="text" name="userName" id="userName" /></td>
	</tr>
	<tr>
		<td>pwd</td><td><input type="password" name="userPwd" id="userPwd" /></td>
	</tr>
	<tr>	
		<td>date</td><td><input type="text" name="registDate" id="registDate" value="<%=DateService.getDateTime(0)%>" readonly /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" id="btn_submit" value="regist" /></td>
	</tr>
</table>
</form>
</body>
<script>
	$(document).ready(function (){
		$("#btn_id").on('click', function(){
			$.ajax({
			    url: '/idCheck',
			    method: 'GET',
			    data: {userId : $("#userId").val()}, 
			    success: function(response) {
			        if(response == "check") alert("사용할 수 있는 ID 입니다.");
			        else alert("이미 사용중인 ID 입니다.");
			    },
			    error: function(xhr, status, error) {
			        console.error('오류:', error);
			    }
			});
		});
		
		$("#btn_submit").on('click', function(e){
			let pwd = $("#userPwd").val();
			let name = $("#userName").val();
			let id = $("#userId").val();
			let isGo = false;
			if(pwd != "" && name != "" && id != "") isGo = true;
			
			if(!isGo){
				alert("검증 조건에 맞지 않습니다.");
				e.preventDefault();
			}
		});
	});
</script>
</html>