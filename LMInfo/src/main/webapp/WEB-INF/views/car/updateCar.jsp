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
   <div class="title_right"><strong>更新车辆</strong></div>
  <form action="<%=request.getContextPath() %>/car/save "class="form_table">
    <span>车牌号码:&nbsp;&nbsp;</span>
    <input type="text" name="carNum" value = "${car.carNum}" />
      <span style="color: red">*</span>
    <br/> <br/>
    <span>负重:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
    <input type="text" name="deadweight" value="${car.deadweight}"/>
       <span style="color: red">*</span>
    <br/> <br/>
    <span>车辆长度:&nbsp;</span>
    <input type="text" name="carLong" value="${car.carLong }"/>
       <span style="color: red" >*</span>
    <br/> <br/>
    <span>车辆宽度:&nbsp;&nbsp;</span>
    <input type="text" name="carHeight" value="${car.carHeight }"/>
       <span style="color: red">*</span>
    <br/> <br/>
    <span>车辆状态:&nbsp;</span>
    <input type="text" name="carState" value = "${car.carState}"/ readonly="readonly">
       <span style="color: red">*</span>
    <br/> <br/>
    <span>司机：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
    <select name="carDriver">
    <c:forEach items="${driver}" var="driver">
    <option value="${driver.workId}"> ${driver.workName} </option>
    </c:forEach>
    </select>
      <span style="color: red">*</span>
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
	 
	 
	 alert("更新成功!");
 }
</script>



 
</body>
</html>
