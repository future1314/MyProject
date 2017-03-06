package cn.edu.scau.logistics.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.scau.logistics.entity.Department;
import cn.edu.scau.logistics.services.interfaces.DepartmentService;

/**
 * 部门
 * @author lan
 *
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Resource
	private DepartmentService depService;
	/**
	 * 验证是否已经存在部门
	 * @param depName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/checkDep",method = RequestMethod.POST)
	public @ResponseBody int checkeDep(String depName)throws Exception{
		Department dep = new Department(); 
		dep = depService.findDepByName(depName);
		if(dep == null){
			Department department = new Department();
			department.setDepartmentName(depName);
			depService.addDep(department);
			return 1;
		}
		else
		return 0;
	}
	/**
	 * 添加新的部门
	 * @param dep
	 * @return
	 */
	@RequestMapping("/addDep")
	public String addDep(Department dep){
		depService.addDep(dep);
		return null;
	}
	
}
