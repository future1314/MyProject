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
			<strong>新增客户信息</strong>
		</div>
		<form class="form_table"
			action="<%=request.getContextPath() %>/customer/save" method="post">
			<span>温馨提示：</span> 客户编号系统自动生成<br /> <br /> <span>姓名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="customerName" required /> <span
				style="color: red">*</span> <br /> <br /> <span>联系方式:</span> <input
				type="text" name="customerTel" required /> <span style="color: red">*</span>
			<br /> <br /> <span>地址:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="customerAddress" required /> <span
				style="color: red">*</span> <br /> <br /> <span>email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="customerEmail" required /> <span
				style="color: red">*</span> <br /> <br />
			<button type="submit" class="btn btn-default"
				onclick="submitCoustomer()">新建</button>
			<button type="reset" class="btn btn-default">重置</button>
		</form>
	</div>
	<script>
!function(){
laydate.skin('molv');
laydate({elem: '#Calendar'});
}();
 
 
 
 
function submitCoustomer(){
	<%-- $.ajax({
		type:"post",
		url:"<%=request.getContextPath() %>/coustomer/checkAccount",
		data:{
			account: $("#account").val()
		},
		dataType: "json",
		success :function(flag){
			if(flag == 1){
				$("#addCoustomer").submit();
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
		
		
	}); --%>
	alert("新建成功，跳转到查询界面");
	
}
</script>




</body>
</html>
