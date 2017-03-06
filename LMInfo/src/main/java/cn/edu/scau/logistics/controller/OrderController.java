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
import cn.edu.scau.logistics.entity.Customer;
import cn.edu.scau.logistics.entity.Order;
import cn.edu.scau.logistics.services.interfaces.CustomerService;
import cn.edu.scau.logistics.services.interfaces.OrderService;
import cn.edu.scau.logistics.util.Page;



/**
 * 
 * @author lan
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	@Resource
	private OrderService orderService;
	@Resource
	private CustomerService customerService;
	/**
	 * 跳转到添加添加新订单信息界面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/goAddOrder")
	public String goAddOrder(Model model)throws Exception{
		List<Customer> cusList = customerService.findAll();
		model.addAttribute("cusList", cusList);
		return "order/addOrder";
	}
	
	/**
	 * 跳转到更新页面
	 * @param oid
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goUpdate/{oid}")
	public String goUpdate(@PathVariable("oid") int oid ,Model model)throws Exception{
		Order order = orderService.findByid(oid);
		model.addAttribute("order",order);
		return "order/updateOrder";
	}
	
	/**
	 * 添加或修改信息
	 * @param worker
	 * @return
	 */
	@RequestMapping("/save")
	public String saveOrder(Order order,HttpServletRequest request,Model model)throws Exception{
		if(request.getParameter("customerId") != null){
			int customerId = Integer.parseInt(request.getParameter("customerId"));
			order.setCustomerId(customerId);
		}
		if(order.getOrdertablerId() == 0){
			System.out.println(order.getOrdertablerId() + "222222222");
			orderService.addOrder(order);
			model.addAttribute("orderId", order.getOrdertablerId());
		return "order/addDetail";
		}
		else{
			System.out.println(order.getOrdertablerId() + "1111111111111");
			orderService.updateOrder(order);
			return "redirect:/order/findOrder";
		}
	}
	/**
	 * 分页查询
	 * @param info
	 * @param current
	 * @param model
	 * @return
	 */
	@RequestMapping("/findOrder")
	public String findOrder(String info,Integer current,Model model){
		if( current == null )
			current = 1;
		Page page = orderService.queryOrder(info, current);
		model.addAttribute("page",page);
		return "order/queryOrder";
	}
	
	/**
	 * 删除信息
	 * @param wid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value= "/deleteOrder" , method = RequestMethod.POST)
	public @ResponseBody int deleteOrder (int oid) throws Exception{
		int flag = 0;
		flag = orderService.deleteOrder(oid);
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
		String info = request.getParameter("queryOrder");
		model.put("info", info);
		return "redirect:/order/findOrder";
	}
	
}
