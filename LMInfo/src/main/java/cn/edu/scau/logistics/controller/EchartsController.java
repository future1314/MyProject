package cn.edu.scau.logistics.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.scau.logistics.services.interfaces.EchartsService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/echarts")
public class EchartsController {
	@Resource
	private EchartsService echartsService;
	@RequestMapping("/goEcharts")
	public String goEcharts(HttpServletRequest request){
		return "echarts/echarts";
	}
	
	@RequestMapping(value="/getOption" ,method=RequestMethod.POST)
	public @ResponseBody JSONObject getOption(HttpServletRequest request) throws Exception{
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		JSONObject jsonObject = echartsService.getJsonObject(start, end);
		System.out.println(jsonObject.toString());
		return jsonObject;
	}
	
}
