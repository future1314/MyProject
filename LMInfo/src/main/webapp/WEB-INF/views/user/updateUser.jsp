<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物流管理系统</title>
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/assets/css/bootstrap.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/assets/css/css.css" />
<script type="text/javascript"
	src="<%=request.getContextPath() %>/assets/js/jquery1.9.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/assets/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/assets/js/sdmenu.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/assets/js/laydate/laydate.js"></script>

</head>

<body>

	<div class="right_cont">
		<div class="title_right">
			<strong>修改用户信息</strong>
		</div>
		<form action="<%=request.getContextPath() %>/user/save" id="addUser"
			class="form_table" method="post">
			<span>编号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <input
				type="text" name="userId" value="${user.userId}" readonly="readonly" />
			<br /> <br /> <span>账号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="account" id="account"
				value="${user.account}" readonly="readonly" /> <br /> <br /> <span>密码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="userPassword" value="${user.userPassword} " />
			<br /> <br /> <span>联系电话:&nbsp;</span> <input type="text"
				name="userTel" value="${user.userTel}" /> <br /> <br /> <span>姓名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="userName" value="${user.userName }" /> <br />
			<br /> <span>email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <input
				type="text" name="userEmail" value="${user.userEmail}" /> <br /> <br />
			<span>角色：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <span>
				${user.role} </span> <select name="selectRole">

				<option value="superUser"
					<c:if test="${user.role=='超级管理员'}">selected</c:if>>超级管理员</option>

				<option value="systemUser"
					<c:if test="${user.role=='系统使用者'}">selected</c:if>>
					系统使用者</option>

			</select> <br /> <br />
			<button type="button" class="btn btn-default" onclick="submitUser()">更新</button>
			<button type="reset" class="btn btn-default">重置</button>
		</form>

	</div>
	<script>
!function(){
laydate.skin('molv');
laydate({elem: '#Calendar'});
}();

function submitUser(){
	$.ajax({
		type:"post",
		url:"<%=request.getContextPath() %>/user/checkAccount",
		data:{
			account: $("#account").val()
		},
		dataType: "json",
		success :function(flag){
				
				$("#addUser").submit();
				alert("更新成功！");
				return true;
		},
		error:function(e){
			alert("error");
		}
		
		
	});
	
	
}
 
</script>




</body>
</html>
