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
   <div class="title_right"><strong>新增入库信息</strong></div>
  <form action="<%=request.getContextPath() %>/output/save" class="form_table">
    <span>温馨提示：</span>
    编号系统自动生成<br/> <br/>
    <span>订单编号:&nbsp;&nbsp;</span>
   	<input type="text" name="ordertableDetailId" value="${output.ordertableDetailId }" readonly="readonly"/>
     <span style="color: red">*</span>
    <br/> <br/>
    <span>产品类别:&nbsp;&nbsp;</span>
    <input type="text" name="outputCategory" value="${output.outputCategory}"/>
       <span style="color: red">*</span>
    <br/> <br/>
    <span>产品名称:&nbsp;&nbsp;</span>
    <input type="text" name="outputName" value="${output.outputName }"/>
       <span style="color: red">*</span>
    <br/> <br/>
    <span>产品数量:&nbsp;&nbsp;&nbsp;</span>
    <input type="text" name="outputNum" value="${output.outputNum }"/>
      <span style="color: red">*</span>
    <br/> <br/>
    <span>实际出库量:</span>
    <input type="text" name="outputTrueNum" value="${output.outputTrueNum }"/>
    <span style="color: red">*</span>
    <br/><br/>
    <span>出库时间</span>
    <input type="date" name="outputTime" value="${output.outputTime }"/>
    <br/><br/>
    <span>出库是否已经完成:&nbsp;&nbsp;&nbsp;&nbsp;</span>
    <span>是</span>
    <input style="width: 50px; height: 15px;" type="radio" name="isOutput" value="Y" />
    <span>否</span>
    <input style="width: 50px; height: 15px;" type="radio" name="isOutput" value="N" />
    <br/> <br/>
    <span>备注：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
    <input type="text" name="outputOther" value="${output.outputOther }"/>
    <br/><br/>
    <button type="submit" class="btn btn-default" onclick="add()">新建</button>
    <button type="reset" class="btn btn-default">重置</button>
   </form>  
       
     </div>     
 <script>
!function(){
laydate.skin('molv');
laydate({elem: '#Calendar'});
}();
 
 function add(){
	 alert("创建成功！");
	 
 }
 
 
</script>



 
</body>
</html>
