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
import cn.edu.scau.logistics.entity.VehicleSch;
import cn.edu.scau.logistics.services.interfaces.DispathService;
import cn.edu.scau.logistics.services.interfaces.OrderDetailService;

@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController {
	@Resource
	private OrderDetailService orderDetailService;
	@Resource
	private DispathService dispathServcie;
	
	
	@RequestMapping("/save")
	public String saveDetail(OrderDetail orderDetail,HttpServletRequest request ,ModelMap model)throws Exception{
		int ordertablerId = Integer.parseInt(request.getParameter("ordertablerId"));
		orderDetail.setOrdertablerId(ordertablerId);
		orderDetail.setOrdertableDetailId(ordertablerId);
		orderDetailService.addOrderDetail(orderDetail);
		VehicleSch sch = new VehicleSch();
		sch.setOrdertableDetailId(orderDetail.getOrdertableDetailId());
		dispathServcie.addSch(sch);
		return "redirect:/order/findOrder";
	}
	
	@RequestMapping("/update")
	public String updateDetali(OrderDetail orderDetail,HttpServletRequest request)throws Exception{
		orderDetailService.updateOrderDetail(orderDetail);
		return "redirect:/order/finOrder";
	}
	
	
	@RequestMapping(value="/goUpdate/{oid}")
	public String goUpdate(@PathVariable("oid") int oid ,Model model)throws Exception{
		OrderDetail orderDetail = orderDetailService.findById(oid);
		model.addAttribute("orderId", oid);
		model.addAttribute("orderDetail",orderDetail);
		return "order/updateDetail";
	}
}
