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
			<strong>修改员工信息</strong>
		</div>
		<form action="<%=request.getContextPath() %>/worker/save"
			id="addWorker" class="form_table" method="post">
			<span>编号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <input
				type="text" name="workId" value="${worker.workId}"
				readonly="readonly" /> <br /> <br /> <span>姓名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="workName" value="${worker.workName}"
				required /> <span style="color: red">*</span> <br /> <br /> <span>性别:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="workSex" value="${worker.workSex }" /> <br />
			<br /> <span>生日:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <input
				type="text" class="laydate-icon span1-1" id="Calendar"
				name="dateBirth" value="${worker.dateBirth }" /> <br /> <br /> <span>联系方式:</span>
			<input type="text" name="tel" required value="${worker.tel}" /> <span
				style="color: red">*</span> <br /> <br /> <span>地址:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="address" required value="${worker.address }" />
			<span style="color: red">*</span> <br /> <br /> <span>身份证:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="cardno" required value="${worker.cardno}" />
			<span style="color: red">*</span> <br /> <br /> <span>部门:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<select name="departmentId" id="selectid">
				<c:forEach items="${depList}" var="depList">

					<option value="${depList.departmentId}"
						<c:if test="${depList.departmentName == worker.departmentName}">selected</c:if>>
						${depList.departmentName}</option>

				</c:forEach>
			</select>
			<button class="btn btn-default " data-toggle="modal"
				data-target="#myModal">新建部门</button>
			<br /> <br />
			<button type="submit" class="btn btn-default"
				onclick="submitWorker()">更新</button>
		</form>

	</div>
	<script>
!function(){
laydate.skin('molv');
laydate({elem: '#Calendar'});
}();

function submitWorker(){
	<%-- $.ajax({
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
	 --%>
	alert("更新员工信息成功");
}
 
</script>




</body>
</html>
