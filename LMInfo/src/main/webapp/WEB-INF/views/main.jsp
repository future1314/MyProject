<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="header">
		<div class="header-right">
			<i class="icon-off icon-white"></i> <a id="modal-973558"
				href="#modal-container-973558" role="button" data-toggle="modal">注销</a>
			<div id="modal-container-973558" class="modal hide fade"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
				data-backdrop="static"
				style="width: 300px; margin-left: -150px; top: 30%">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">注销系统</h3>
				</div>
				<div class="modal-body">
					<p>您确定要注销退出系统吗？</p>
				</div>
				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
					<a class="btn btn-primary" style="line-height: 20px;"
						href="<%=request.getContextPath() %>/user/logout">确定退出</a>
				</div>
			</div>
		</div>
	</div>
	<!-- 顶部 -->

	<div id="middle">
		<div class="left">
			<script type="text/javascript">
  var myMenu;
  window.onload = function() {
	myMenu = new SDMenu("my_menu");
	myMenu.init();
};
</script>

			<div id="my_menu" class="sdmenu">
				<div class="collapsed">
					<span>人事管理</span> <a
						href="<%=request.getContextPath() %>/customer/goAddCustomer"
						target="right_function">新增客户信息</a> <a
						href="<%=request.getContextPath() %>/customer/findCustomer?current=1"
						target="right_function">查询所有客户信息</a> <a
						href="<%=request.getContextPath() %>/worker/goAddWorker"
						target="right_function">新增员工信息</a> <a
						href="<%=request.getContextPath()%>/worker/findWorker?current=1"
						target="right_function">查询所有员工信息</a>
					<!-- 		<a href="index.html">快速下单</a>
 -->
				</div>

				<div class="collapsed">
					<span>数据统计</span> <a href="#">收款详单</a> <a href="#">每日汇总</a>
				</div>
				<div class="collapsed">
					<span>订单管理</span> <a
						href="<%=request.getContextPath()%>/order/goAddOrder"
						target="right_function">客户订单信息管理</a> <a
						href="<%=request.getContextPath()%>/order/findOrder?current=1"
						target="right_function">订单信息查询</a>

				</div>
				<div class="collapsed">
					<span>用户管理</span> <a
						href="<%=request.getContextPath() %>/user/goAddUser"
						target="right_function">新增用户</a> <a
						href="<%=request.getContextPath() %>/user/findUser?current=1"
						target="right_function">查询所有用户信息</a>
				</div>


				<div class="collapsed">
					<span>车辆管理</span> <a href="#">新增车辆信息</a> <a href="#">车辆基本信息管理</a> <a
						href="#">车辆调度管理</a>
				</div>

				<div class="collapsed">
					<span>货物管理</span> <a href="#">货物入库</a> <a href="#">货物出库</a>
				</div>
			</div>

		</div>
		<div class="Switch"></div>
		<script type="text/javascript">
	$(document).ready(function(e) {
    $(".Switch").click(function(){
	$(".left").toggle();
	 
		});
});
</script>

		<div class="right" id="mainFrame">
			<iframe name="right_function" style="width: 100%; min-height: 800px;"
				scrolling="no" frameborder="0" border="0"></iframe>
		</div>
	</div>

	<!-- 底部 -->
	<div id="footer">版权所有：毕业设计@兰阳佳 &copy;
		2017&nbsp;&nbsp;&nbsp;&nbsp;</div>



	<script>
function(){
laydate.skin('molv');
laydate({elem: '#Calendar'});
}();
 
</script>




</body>
</html>
