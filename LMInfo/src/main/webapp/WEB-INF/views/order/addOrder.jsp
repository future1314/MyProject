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
			<strong>创建新订单</strong>
		</div>
		<form action="<%=request.getContextPath() %>/order/save" method="post">
			<table class="table table-bordered">
				<tr>
					<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">订单日期：</td>
					<td width="23%"><input name="ordersTime" type="date"
						class="form-control" required/></td>
					<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">客户姓名：</td>
					<td width="23%"><select name="customerId" id="selectName"
						class=" span2">
							<c:forEach items="${cusList}" var="cusList">
								<option value="${cusList.customerId}">
									${cusList.customerName}</option>

							</c:forEach>

					</select></td>
					<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">收货人：</td>
					<td><input type="text" name="consignee" id="" class="span1-1" required/></td>
				</tr>
				<tr>
					<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">收货人联系电话：</td>
					<td><input type="text" name="receivingTel" id=""
						class="span1-1" required/></td>
					<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">收货人地址：</td>
					<td><input type="text" name="receivingAddress" id=""
						class="span1-4" required/></td>
					<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">预发时间：</td>
					<td><input name="sendTime" type="date" class="form-control"
						id="send" required/></td>
				</tr>
				<tr>
					<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">预到时间：</td>
					<td><input name="arriveTime" type="date" class="form-control"
						id="arrive" required/></td>
					<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">是否已经发货：</td>
					<td><input type="radio" value="Y" name="isSend" /> Y <input
						type="radio" value="N" name="isSend" /> N</td>

					<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">操作员：</td>
					<td><input type="text" name="operatorName" id="input3"
						class="span1-1" required/></td>
				</tr>
			</table>

			<table class="margin-bottom-20  table no-border">
				<tr>
					<td class="text-center">
						<button type="submit" class="btn btn-default" style="width: 80px;">新建</button>
						<button type="reset" class="btn btn-default" style="width: 80px;">重置</button>
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
