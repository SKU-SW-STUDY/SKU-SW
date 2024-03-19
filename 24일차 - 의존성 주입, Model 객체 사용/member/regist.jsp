<%@page import="sku.lesson.spring.utils.DateService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Regist</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#btn_id').on('click',function(){
			//alert("event success");
			let id = $('#userId').val();
			//서버접속
			$.ajax({
				url : "./ajax",
				method : "post",
				data : {"userId":id},
				success : function(data){
					//alert('server connect success '+data);
					let json = JSON.parse(data);
					
					if(json.result==false){
						alert("사용하실 수 있는 아이디 입니다.");
						$('#isQuery').val(true);
					}else {
						alert("이미 사용중인 아이디 입니다.");
					}
				},
				error : function(error){
					alert('server connect fail');
				}
			});
		});
		
		$('#btn_submit').on('click',function(e){
			//validation
			let pwd = $('#userPwd').val();
			let name = $('#userName').val();
			let id = $('#userId').val();
			let isGo = false;
			if(pwd!=""&&name!=""&&id!=""){
				isGo = true
			}
			// 서버에서 검증을 받았는지 체크
			//alert('val : '+$('#isQuery').val());
			let isQuery = $('#isQuery').val()==="true"?true:false;
			//alert('check : '+isQuery);
			if(!(isGo&&isQuery)){
				alert('검증 조건에 맞지 않습니다.');
				e.preventDefault();
			}
		});
		
	});
</script>
</head>
<body>
<form action="./regist" method="post">
<table>
	<tr>
		<td>id</td>
		<td><input type="text" name="userId" id="userId"></td>
		<td>
			<input type="button" value="checkID" id="btn_id">
			<input type="hidden" value="false" id="isQuery">
		</td>
	</tr>
	<tr>
		<td>name</td><td><input type="text" name="userName" id="userName"></td><td></td>
	</tr>
	<tr>
		<td>pwd</td><td><input type="text" name="userPwd" id="userPwd"></td><td></td>
	</tr>
	<tr>
		<td>date</td>
		<td>
			<input type="text" name="registDate" id="registDate" 
							value="${registDate}" 
							readonly="readonly">
		</td>
		<td></td>
	</tr>
	<tr>
		<td><input type="submit" value="regist" id="btn_submit"></td>
	</tr>
</table>
</form>
</body>
</html>