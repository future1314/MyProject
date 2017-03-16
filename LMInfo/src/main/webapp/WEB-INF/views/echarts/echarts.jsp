<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>物流管理系统</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/bootstrap.css" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/css.css" />
    <script type="text/javascript" src="<%=request.getContextPath() %>/assets/js/jquery1.9.0.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/assets/js/sdmenu.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/assets/js/laydate/laydate.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/assets/js/echarts.min.js"></script>

</head>

<body>
 <div class="right_cont">
   <div class="title_right">
   <strong>统计	</strong>
   </div>
        
    <form id="echartsData" action="" method="post" class="form_table"> 
        
    <input type="date" name="start" id="start">
    <input type="date" name="end" id="end">
    <button type="button" class="btn btn-default" onclick="getInfo()">OK</button>
    <button type="reset" class="btn btn-default">清空</button>
    </form>      
     </div>
   
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:400px"></div>
  


     <script type="text/javascript">

    var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
   var option = {
            title: {
                text: '统计表'
            },
            tooltip: {},
            legend: {
                data:['收入','运费','利润']
            },
            xAxis: {
                data: []
               
            },
            yAxis: {},
            series: [
           {
                name: '收入',
                type: 'bar',
                data: []
            }
           
           
           
           ]
        };                
        // 使用刚指定的配置项和数据显示图表。



/*        myChart.hideLoading();*/

        function getInfo(){
            $.ajax({
                type:"post",	
                url:"<%=request.getContextPath()%>/echarts/getOption",
                data: $('#echartsData').serialize(),// 序列化表单值  
                dataType : "json",
                success:function(json){
                	alert("123");
        			myChart.hideLoading(); 
                	myChart.setOption({
                		xAxis:{
                			data:json.xAxisData
                		},
                		series:json.seriesList
                		
                		/* series:[
                			{
                				
                			name:'AS',
                			type:'bar',
                			data:["1","2"]
                			}
                			 
                			
                		] */
                		
                		
                		
                		
                	});    
        				
        				
                		
                },
            error:function(e){


                alert("请求数据失败");
            } 



            });

        } 
        
        myChart.setOption(option);
    </script>



   
</body>