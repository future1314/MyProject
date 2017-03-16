package cn.edu.scau.logistics.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.scau.logistics.entity.Output;
import cn.edu.scau.logistics.services.interfaces.OutputService;
import cn.edu.scau.logistics.util.Page;

@Controller
@RequestMapping("/output")
public class OutputCotroller {
	@Resource
	private OutputService outputService;
	
	@RequestMapping(value="/goUpdate/{id}")
	public String goUpdate(@PathVariable("id") int id ,Model model)throws Exception{
		Output output= outputService.findById(id);
		model.addAttribute("output", output);
		return "goods/updateOutput";
	}
	
	@RequestMapping("/save")
	public String addOutput(Output output,HttpServletRequest request,Model model)throws Exception{
		
		outputService.updateOutput(output);
		return "redirect:/output/findOutput";
	}
	
	@RequestMapping("/findOutput")
	public String findOutput(String info,Integer current,Model model)throws Exception{
		if(current == null)
			current = 1;
		Page page = outputService.queryOutput(info, current);
		model.addAttribute("page", page);
		return "goods/queryOutput";
	}
	

	@RequestMapping(value= "/deleteOutput" , method = RequestMethod.POST)
	public @ResponseBody int deleteOutput (int id) throws Exception{
		int flag = 0;
		flag =outputService.deleteOutput(id);
		if(flag != 0)
		return 1;
		else 
		return 0;
	}
	
	@RequestMapping("/findByInfo")
	public String findByInfo (HttpServletRequest request,ModelMap model)throws Exception{
		String info = request.getParameter("queryOutput");
		model.put("info", info);
		return "redirect:/output/findOutput";
	}
	
	
}
