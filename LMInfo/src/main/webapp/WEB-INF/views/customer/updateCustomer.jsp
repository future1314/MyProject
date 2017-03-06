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
			<strong>修改客户信息</strong>
		</div>
		<form action="<%=request.getContextPath() %>/customer/save"
			id="addCustomer" class="form_table" method="post">
			<span>编号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <input
				type="text" name="customerId" value="${customer.customerId}"
				readonly="readonly" /> <br /> <br /> <span>姓名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="customerName" id="customerName"
				value="${customer.customerName}" /> <br /> <br /> <span>联系方式:&nbsp;</span>
			<input type="text" name="customerTel"
				value="${customer.customerTel} " /> <br /> <br /> <span>地址:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="customerAddress"
				value="${customer.customerAddress }" /> <br /> <br /> <span>email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="customerEmail"
				value="${customer.customerEmail}" /> <br /> <br />
			<button type="submit" class="btn btn-default" onclick="submitUser()">更新</button>
			<button type="reset" class="btn btn-default">重置</button>
		</form>

	</div>
	<script>
!function(){
laydate.skin('molv');
laydate({elem: '#Calendar'});
}();

function submitUser(){
<%-- 	$.ajax({
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
		
		
	}); --%>
	alert("更新成功！");
	
}
 
</script>




</body>
</html>
