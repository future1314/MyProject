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
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/assets/css/fenye.css" />
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
			<strong>查询员工信息</strong>
		</div>

		<div style="width: 100%;">
			<form action="<%=request.getContextPath() %>/worker/findByInfo"
				method="post">
				<strong>请输入查询条件：</strong> <input type="text" name="queryWorker" />&nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-primary">查询</button>
			</form>

			<table class="table table-bordered table-hover table-striped">
				<tbody>
					<tr align="center">
						<td><strong>编号</strong></td>
						<td><strong>姓名</strong></td>
						<td><strong>性别</strong></td>
						<td><strong>生日</strong></td>
						<td><strong>身份证</strong></td>
						<td><strong>地址</strong></td>
						<td><strong>联系方式</strong></td>
						<td><strong>部门</strong></td>
						<td><strong>操作</strong></td>
					</tr>
					<c:choose>
						<c:when test="${page !=null and page.count > 0}">
							<c:forEach items="${page.list }" var="workerList">

								<tr align="center">
									<td>${workerList.workId }</td>
									<td>${workerList.workName }</td>
									<td>${workerList.workSex }</td>
									<td>${workerList.dateBirth}</td>
									<td>${workerList.cardno }</td>
									<td>${workerList.address }</td>
									<td>${workerList.tel }</td>
									<td>${workerList.departmentName}</td>
									<td><a id="DataGrid1_ctl03_LinkButton1"
										href="<%=request.getContextPath() %>/worker/goUpdate/${workerList.workId}">编辑</a>
										&nbsp; <a id="DataGrid1_ctl03_LinkButton1"
										href="<%=request.getContextPath() %>/worker/findWorker?current=${page.current}"
										onclick="deleteWorker(${workerList.workId})">删除</a></td>
								</tr>

							</c:forEach>


						</c:when>
						<c:otherwise>
           	没有信息
           </c:otherwise>
					</c:choose>
				</tbody>
			</table>

		</div>

		<div class="fenye" style="width: 400px; margin: 0 auto;">
			<ul id="pagination-digg">
				<c:if test="${page.current > 1 }">
					<li class="previous-off"><a
						href="<%=request.getContextPath() %>/worker/findWorker?current=${page.current - 1}">
							上一页 </a></li>
				</c:if>
				<c:forEach begin="1" end="${page.total}" var="p" step="1">

					<c:if test="${p == page.current}">
						<li class="active">${p }</li>

					</c:if>
					<c:if test="${p != page.current }">
						<li><a
							href="<%=request.getContextPath() %>/worker/findWorker?current=${p}">${p}
						</a></li>

					</c:if>
				</c:forEach>

				<c:if test="${page.current < page.total }">
					<li class="next"><a
						href=" <%=request.getContextPath()%>/worker/findWorker?current=${page.current + 1}">下一页</a>
					</li>
				</c:if>

			</ul>
		</div>

	</div>

	<script type="text/javascript">
	function deleteWorker (workId) {
		var isDelete  = confirm("是否删除?");
		
		if(isDelete){
			
			$.ajax({
				type: "POST",
				url:"<%=request.getContextPath()%>/worker/deleteWorker",
				data:{
					wid:workId
				},
				dataType:"json",
				success:function(flag){
					if(flag == 1){
						alert("删除成功");
						return true;
					}
					else{
						alert("删除失败");
						return false;
					}
				},
				error:function(e){
					alert("连接服务器失败");
				}
				
			});
			
			
		}
	}



</script>


</body>

</html>
