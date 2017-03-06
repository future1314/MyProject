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

import cn.edu.scau.logistics.entity.Customer;
import cn.edu.scau.logistics.services.interfaces.CustomerService;
import cn.edu.scau.logistics.util.Page;
@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Resource
	private CustomerService customerService;
	
	/**
	 * 跳转到添加新客户信息界面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/goAddCustomer")
	public String goAddCustomer()throws Exception{
		return "customer/addCustomer";
	}
	
	/**
	 * 跳转到更新页面
	 * @param uid
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goUpdate/{uid}")
	public String goUpdate(@PathVariable("uid") int uid ,Model model)throws Exception{
		Customer customer = customerService.findById(uid);
		model.addAttribute("customer",customer);
		return "customer/updateCustomer";
	}
	
	/**
	 * 添加或修改客户信息
	 * @param customer
	 * @return
	 */
	@RequestMapping("/save")
	public String addCustomer(Customer customer)throws Exception{
		if(customer.getCustomerId() == 0)
			customerService.addCustomer(customer);		
		else
			customerService.updateCustomer(customer);
		return "redirect:/customer/findCustomer";
	}
	/**
	 * 分页查询
	 * @param info
	 * @param current
	 * @param model
	 * @return
	 */
	@RequestMapping("/findCustomer")
	public String findCustomer(String info,Integer current,Model model){
		if( current == null )
			current = 1;
		Page page = customerService.queryCustomer(info, current);
		model.addAttribute("page",page);
		return "customer/queryCustomer";
	}
	
	/**
	 * 删除客户信息
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value= "/deleteCustomer" , method = RequestMethod.POST)
	public @ResponseBody int deleteCustomer (int cid) throws Exception{
		int flag = 0;
		flag = customerService.deletCustomer(cid);
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
		String info = request.getParameter("queryCustomer");
		model.put("info", info);
		return "redirect:/customer/findCustomer";
	}
	
	
	
}
