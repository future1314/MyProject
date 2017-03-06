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
			<strong>查询用户信息</strong>
		</div>

		<div style="width: 100%;">
			<form action="<%=request.getContextPath() %>/user/findByInfo"
				method="post">
				<strong>请输入查询条件：</strong> <input type="text" name="queryUser" />&nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-primary">查询</button>
			</form>

			<table class="table table-bordered table-hover table-striped">
				<tbody>
					<tr align="center">
						<td><strong>编号</strong></td>
						<td><strong>账号</strong></td>
						<td><strong>密码</strong></td>
						<td><strong>联系电话</strong></td>
						<td><strong>用户姓名</strong></td>
						<td><strong>邮箱</strong></td>
						<td><strong>角色</strong></td>
						<td><strong>操作</strong></td>
					</tr>
					<c:choose>
						<c:when test="${page !=null and page.count > 0}">
							<c:forEach items="${page.list }" var="userList">

								<tr align="center">
									<td>${userList.userId }</td>
									<td>${userList.account }</td>
									<td>${userList.userPassword }</td>
									<td>${userList.userTel }</td>
									<td>${userList.userName }</td>
									<td>${userList.userEmail }</td>
									<td>${userList.role}</td>
									<td><a id="DataGrid1_ctl03_LinkButton1"
										href="<%=request.getContextPath() %>/user/goUpdate/${userList.userId}">编辑</a>
										&nbsp; <a id="DataGrid1_ctl03_LinkButton1"
										href="<%=request.getContextPath() %>/user/findUser?current=${page.current}"
										onclick="delectUser(${userList.userId})">删除</a></td>
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
						href="<%=request.getContextPath() %>/user/findUser?current=${page.current - 1}">
							上一页 </a></li>
				</c:if>
				<c:forEach begin="1" end="${page.total}" var="p" step="1">

					<c:if test="${p == page.current}">
						<li class="active">${p }</li>
						<%-- <option selected="selected" value="${p }">第${p }页</option> --%>
					</c:if>
					<c:if test="${p != page.current }">
						<li><a
							href="<%=request.getContextPath() %>/user/findUser?current=${p}">${p}
						</a></li>
						<%-- <option value="${p }">第${p }页</option> --%>
					</c:if>
				</c:forEach>
				<!--    <li class="active">1</li>
       <li><a href="?page=2">2</a></li>
       <li><a href="?page=3">3</a></li>
       <li><a href="?page=4">4</a></li>
       <li><a href="?page=5">5</a></li>
       <li><a href="?page=6">6</a></li>
       <li><a href="?page=7">7</a></li> -->
				<c:if test="${page.current < page.total }">
					<li class="next"><a
						href=" <%=request.getContextPath()%>/user/findUser?current=${page.current + 1}">下一页</a>
					</li>
				</c:if>

			</ul>
		</div>

	</div>

	<script type="text/javascript">
	function delectUser (userId) {
		var isDelete  = confirm("是否删除?");
		
		if(isDelete){
			
			$.ajax({
				type: "POST",
				url:"<%=request.getContextPath()%>/user/deleteUser",
				data:{
					uid:userId
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
