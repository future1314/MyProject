package cn.edu.scau.logistics.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.scau.logistics.entity.Department;
import cn.edu.scau.logistics.entity.Worker;
import cn.edu.scau.logistics.services.interfaces.DepartmentService;
import cn.edu.scau.logistics.services.interfaces.WorkerService;
import cn.edu.scau.logistics.util.Page;

@Controller
@RequestMapping("/worker")
public class WokerController {
	@Resource
	private WorkerService workerService;
	@Resource
	private DepartmentService depService;
	/**
	 * 跳转到添加新员工信息界面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/goAddWorker")
	public String goAddWorker(Model model)throws Exception{
		List<Department> depList = depService.findAllDep();
		model.addAttribute("depList", depList);
		return "worker/addWorker";
	}
	
	/**
	 * 跳转到更新页面
	 * @param uid
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goUpdate/{wid}")
	public String goUpdate(@PathVariable("wid") int wid ,Model model)throws Exception{
		Worker worker = workerService.findByid(wid);
		List<Department> depList = depService.findAllDep();
		model.addAttribute("depList", depList);
		model.addAttribute("worker",worker);
		return "worker/updateWorker";
	}
	
	/**
	 * 添加或修改员工信息
	 * @param worker
	 * @return
	 */
	@RequestMapping("/save")
	public String saveWorker(Worker worker,HttpServletRequest request,String departmentId)throws Exception{
		int id;
		if(request.getParameter("departmentId") != null)
		id = Integer.parseInt(request.getParameter("departmentId"));
		else
			id = 0;
		worker.setDepartmentId(id);
		if(worker.getWorkId() == 0)
			workerService.addWorker(worker);
		else
			workerService.updateWorker(worker);
		return "redirect:/worker/findWorker";
	}
	/**
	 * 分页查询
	 * @param info
	 * @param current
	 * @param model
	 * @return
	 */
	@RequestMapping("/findWorker")
	public String findWorker(String info,Integer current,Model model){
		if( current == null )
			current = 1;
		Page page = workerService.queryWorker(info, current);
		model.addAttribute("page",page);
		return "worker/queryWorker";
	}
	
	/**
	 * 删除员工信息
	 * @param wid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value= "/deleteWorker" , method = RequestMethod.POST)
	public @ResponseBody int deleteWorker (int wid) throws Exception{
		int flag = 0;
		flag = workerService.deleteWorker(wid);
		if(flag != 0)
		return 1;
		else 
		return 0;
	}
	
	/**
	 * 获取查询信息
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findByInfo")
	public String findByInfo (HttpServletRequest request,ModelMap model)throws Exception{
		String info = request.getParameter("queryWorker");
		model.put("info", info);
		return "redirect:/worker/findWorker";
	}
	
	
}
