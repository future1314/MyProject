package cn.edu.scau.logistics.controller;
/**
 * 订单详情
 * @author lan
 *
 */

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.edu.scau.logistics.entity.OrderDetail;
import cn.edu.scau.logistics.services.interfaces.OrderDetailService;

@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController {
	@Resource
	private OrderDetailService orderDetailService;
	
	@RequestMapping("/save")
	public String saveDetail(OrderDetail orderDetail,HttpServletRequest request ,ModelMap model)throws Exception{
		int ordertablerId = Integer.parseInt(request.getParameter("ordertablerId"));
		orderDetail.setOrdertablerId(ordertablerId);
		if(orderDetail.getOrdertablerId() == 0){
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");

			orderDetailService.addOrderDetail(orderDetail);
		}
		else{
			System.out.println("??????????????????");

			orderDetailService.updateOrderDetail(orderDetail);
		}
		return "redirect:/order/findOrder";
	}
	
	
	@RequestMapping(value="/goUpdate/{oid}")
	public String goUpdate(@PathVariable("oid") int oid ,Model model)throws Exception{
		OrderDetail orderDetail = orderDetailService.findById(oid);
		model.addAttribute("orderId", oid);
		model.addAttribute("orderDetail",orderDetail);
		return "order/updateDetail";
	}
}
