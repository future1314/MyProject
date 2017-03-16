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
   <div class="title_right"><strong>编辑调度表</strong></div>
  <form action="<%=request.getContextPath() %>/dispath/save" id="editCar"  class="form_table" method="post">
     <span>订单编号:&nbsp;&nbsp;</span>
    <input type="text" name="ordertableDetailId"  value="${vehiscleSch.ordertableDetailId}" readonly="readonly"/>
     <br/> <br/>
    <span>车辆编号：&nbsp;</span>
    <select style="width: 300px;" name="selectId">
    <option value="0">不分配</option>
    <c:forEach items="${carList}" var="carList">
    <option value="${carList.carId}">${carList.carId}</option>
    </c:forEach>
    </select>
     <span style="color: red">*</span>
    <br/> <br/>
    <span>出发时间:&nbsp;</span>
    <input type="date" name="carSend" value="${vehiscleSch.carSend} " />
    <br/> <br/>
    <span>到达时间:&nbsp;</span>
    <input type="date" name="carArrive" value="${vehiscleSch.carArrive }"/>
     <br/> <br/> 
    <button type="submit" class="btn btn-default" onclick="update()">更新</button>
    <button type="reset" class="btn btn-default">重置</button>
   </form>  
       
     </div>     
 <script>
!function(){
laydate.skin('molv');
laydate({elem: '#Calendar'});
}();

function update(){
	alert("更新成功！");
	
	
}
 
</script>



 
</body>
</html>
