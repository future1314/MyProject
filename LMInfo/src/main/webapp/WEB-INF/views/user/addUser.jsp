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
			<strong>新增用户</strong>
		</div>
		<form action="<%=request.getContextPath() %>/user/save" id="addUser"
			class="form_table" method="post">
			<span>温馨提示：</span> 客户编号系统自动生成<br /> <br /> <span>账号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="account" id="account" required /> <span
				style="color: red">*</span> <br /> <br /> <span>密码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="userPassword" required /> <span
				style="color: red">*</span> <br /> <br /> <span>联系电话:&nbsp;</span> <input
				type="text" name="userTel" required /> <span style="color: red">*</span>
			<br /> <br /> <span>姓名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="userName" required /> <span
				style="color: red">*</span> <br /> <br /> <span>email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="userEmail" /> <br /> <br /> <span>角色：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<select name="selectRole">
				<option value="超级管理员">超级管理员</option>
				<option value="系统使用者">系统使用者</option>
			</select> <span style="color: red">*</span> <br /> <br />
			<button type="button" class="btn btn-default" onclick="submitUser()">新建</button>
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
			if(flag == 1){
				$("#addUser").submit();
				alert("创建成功！");
				return true;
			}else{
				alert("账号已经存在");
				return false;
			}
		},
		error:function(e){
			alert("error");
		}
		
		
	});
	
	
}
 
</script>




</body>
</html>
