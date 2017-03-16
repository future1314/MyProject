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

import cn.edu.scau.logistics.entity.Input;
import cn.edu.scau.logistics.services.interfaces.InputService;
import cn.edu.scau.logistics.util.Page;

@Controller
@RequestMapping("/input")
public class InputController {
	@Resource
	private InputService inputService;
	
	/**
	 * 跳转到更新页面
	 * @param 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goUpdate/{id}")
	public String goUpdate(@PathVariable("id") int id ,Model model)throws Exception{
		Input input = inputService.findById(id);
		model.addAttribute("input", input);
		return "goods/updateInput";
	}
	
	@RequestMapping("/save")
	public String save(Input input,HttpServletRequest request,Model model) throws Exception{
		inputService.updateInput(input);
		return "redirect:/input/findInput";
	}
	
	@RequestMapping("/findInput")
	public String findInput(String info,Integer current,Model model)throws Exception{
		if(current == null)
			current = 1;
		Page page = inputService.queryInput(info, current);
		model.addAttribute("page", page);
		return "goods/queryInput";
		
	}
	
	
	@RequestMapping(value= "/deleteInput" , method = RequestMethod.POST)
	public @ResponseBody int deleteInput (int id) throws Exception{
		int flag = 0;
		flag =inputService.deleteInput(id);
		if(flag != 0)
		return 1;
		else 
		return 0;
	}
	
	@RequestMapping("/findByInfo")
	public String findByInfo (HttpServletRequest request,ModelMap model)throws Exception{
		String info = request.getParameter("queryInput");
		model.put("info", info);
		return "redirect:/input/findInput";
	}
	
}
