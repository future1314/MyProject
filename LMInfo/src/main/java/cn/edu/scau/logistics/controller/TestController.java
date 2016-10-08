package cn.edu.scau.logistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.scau.logistics.entity.testEntity;
import cn.edu.scau.logistics.services.interfaces.testService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private testService testservice;
	@RequestMapping("/testFunction")
	public String testFunction(testEntity test,Model model){
		testEntity hh = testservice.findById(test.getId());
		System.out.println(hh.getId() + " " + hh.getName());
		model.addAttribute("test", hh);
		return "test/testPage";
	}

}
