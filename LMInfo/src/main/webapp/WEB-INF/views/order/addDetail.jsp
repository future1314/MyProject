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
			<strong>订单详情</strong>
		</div>
		<form action="<%=request.getContextPath() %>/orderDetail/save"
			method="post">
			<strong>订单编号：</strong> <input type="text" readonly="readonly"
				name="ordertablerId" value="${orderId}" />
			<table class="table table-bordered">
				<tr>
					<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">货物编码：</td>
					<td width="23%"><input type="text" name="productId"
						id="input10" class="span1-1" required/></td>
					<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">货物名字：</td>
					<td width="23%"><input type="text" name="productName"
						id="input14" class="span1-1" required/></td>
					<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">货物类型：</td>
					<td><input type="text" name="productCategory" id="input15"
						class="span1-1" required/></td>
				</tr>
				<tr>
					<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">货物重量：</td>
					<td><input type="text" name="productWeight" id="input1-1"
						class="span1-1" required/></td>
					<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">货物体积：</td>
					<td><input type="text" name="productVolume" id="input12"
						class="span1-1" required/></td>
					<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">数量：</td>
					<td><input type="text" name="productNum" id="input16"
						class="span1-1" required/></td>
				</tr>
				<tr>
					<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">收入：</td>
					<td><input type="text" name="income" id="input16"
						class="span1-1" required/></td>
					<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">运费：</td>
					<td><input type="text" name="freight" id="input16"
						class="span1-1" required/></td>
					<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">备注：</td>
					<td align="right" nowrap="nowrap"><input type="text"
						name="other" id="input9" class="span10" /></td>
				</tr>

			</table>

			<table class="margin-bottom-20  table no-border">
				<tr>
					<td class="text-center">
						<button type="submit" class="btn btn-default" style="width: 80px;">新建</button>
						<button type="reset" class="btn btn-default" style="width: 80px;">重置</button>
					</td>
				</tr>
			</table>
		</form>



	</div>
	<script>
!function(){
laydate.skin('molv');
laydate({elem: '#Calendar'});
}();
 
</script>




</body>
</html>
