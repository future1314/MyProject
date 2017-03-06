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
			<h4 style="width: 400px; height: 30px; margin: 0 auto;">查看订单的同时，还可以修改信息哦</h4>
			<strong>订单编号</strong> <input type="text" readonly="readonly"
				name="ordertablerId" value="${orderId}" />
			<table class="table table-bordered">
				<tr>
					<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">货物编码：</td>
					<td width="23%"><input type="text" name="productId"
						id="input10" class="span1-1" value="${orderDetail.productId}" /></td>
					<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">货物名字：</td>
					<td width="23%"><input type="text" name="productName"
						id="input14" class="span1-1" value="${orderDetail.productName}" /></td>
					<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">货物类型：</td>
					<td><input type="text" name="productCategory" id="input15"
						class="span1-1" /></td>
				</tr>
				<tr>
					<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">货物重量：</td>
					<td><input type="text" name="productWeight" id="input1-1"
						class="span1-1" value="${orderDetail.productWeight }" /></td>
					<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">货物体积：</td>
					<td><input type="text" name="productVolume" id="input12"
						class="span1-1" value="${orderDetail.productVolume }" /></td>
					<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">数量：</td>
					<td><input type="text" name="productNum" id="input16"
						class="span1-1" value="${orderDetail. productNum}" /></td>
				</tr>
				<tr>
					<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">收入：</td>
					<td><input type="text" name="income" id="input16"
						class="span1-1" value="${orderDetail.income }" /></td>
					<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">运费：</td>
					<td><input type="text" name="freight" id="input16"
						class="span1-1" value="${orderDetail.freight }" /></td>
					<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">备注：</td>
					<td align="right" nowrap="nowrap"><input type="text"
						name="other" id="input9" class="span10"
						value="${orderDetail.other }" /></td>
				</tr>

			</table>

			<table class="margin-bottom-20  table no-border">
				<tr>
					<td class="text-center">
						<button type="submit" class="btn btn-default" style="width: 80px;"
							onclick="updateDetail()">更新</button>
						<button type="button" class="btn btn-default" style="width: 80px"
							onclick="javascript:window.history.back(-1);">返回</button>
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
 
 function updateDetail(){
	 alert("更新成功");
 }
</script>




</body>
</html>
