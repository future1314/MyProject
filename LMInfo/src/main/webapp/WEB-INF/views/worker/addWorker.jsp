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
			<strong>新增员工信息</strong>
		</div>
		<form action="<%=request.getContextPath()%>/worker/save" method="post"
			class="form_table">
			<span>温馨提示：</span> 员工编号系统自动生成<br /> <br /> <span>姓名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="workName" required /> <span
				style="color: red">*</span> <br /> <br /> <span>性别:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="workSex" /> <br /> <br /> <span>生日:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" class="laydate-icon span1-1" id="Calendar"
				name="dateBirth" /> <br /> <br /> <span>联系方式:</span> <input
				type="text" name="tel" required /> <span style="color: red">*</span>
			<br /> <br /> <span>地址:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="address" required /> <span
				style="color: red">*</span> <br /> <br /> <span>身份证:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<input type="text" name="cardno" required /> <span
				style="color: red">*</span> <br /> <br /> <span>部门:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<select name="departmentId" id="selectid">
				<c:forEach items="${depList}" var="depList">

					<option value="${depList.departmentId}">
						${depList.departmentName}</option>

				</c:forEach>
			</select>
			<button class="btn btn-default " data-toggle="modal"
				data-target="#myModal">新建部门</button>
			<br /> <br />
			<button type="submit" class="btn btn-default">新建</button>
			<button type="reset" class="btn btn-default">重置</button>
		</form>

	</div>

	<!-- 模态框 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">请输入部门名称</h4>
				</div>


				<%--  <form action="<%=request.getContextPath()%>/department/addDep"  id="department" method="post"> --%>
				<div class="modal-body">
					<input type="text" name="departmentName" id="depName" /> <span
						id="showInfo"></span>
				</div>
				<div class="modal-footer">
					<button type="reset" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary " data-dismiss="modal"
						onclick="submitDep()">确定</button>
				</div>
				<!--     </form> -->

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<script>
 !function(){
 laydate.skin('molv');
 laydate({elem: '#Calendar'});
 }();


/*
 $(function () { $('#myModal').modal({
     backdrop: 'static',
     keyboard: false
   }
   )


}
);*/

function submitDep(){
	
	var depName = $("#depName").val();
	$.ajax({
		type:"post",
		url:"<%=request.getContextPath() %>/department/checkDep",
		data:{
			depName: $("#depName").val()
		},
		dataType: "json",
		success :function(flag){
			if(flag == 1){
				var last = $("#selectId option:last").val() + 1;
				$('<option></option>').text(depName).val(last).appendTo('#selectid');
				alert("创建成功");
				 $("#depName").attr("value","");
				return true;
			}else{
				alert("创建失败，部门已经存在");
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
