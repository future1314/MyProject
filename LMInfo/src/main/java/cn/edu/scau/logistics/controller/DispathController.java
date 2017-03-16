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

import cn.edu.scau.logistics.entity.Car;
import cn.edu.scau.logistics.entity.VehicleSch;
import cn.edu.scau.logistics.services.interfaces.CarService;
import cn.edu.scau.logistics.services.interfaces.DispathService;
import cn.edu.scau.logistics.util.Page;

@Controller
@RequestMapping("/dispath")
public class DispathController {
	@Resource
	private DispathService dispathService;
	@Resource
	private CarService carSerivce;
	/**
	 * 跳到更新
	 * @param schId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value="/goUpdate/{schId}")
	public String goUpdate(@PathVariable("schId") int schId ,Model model)throws Exception{
		List<Car> carList = carSerivce.findAll();
		VehicleSch vehiscleSch = dispathService.findById(schId);
		model.addAttribute("carList", carList);
		model.addAttribute("vehiscleSch", vehiscleSch);
		return "car/updateSch";
	}
	
	/**
	 * 调度
	 * @param vehicleSch
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/save")
	public String save(VehicleSch vehicleSch,HttpServletRequest request,Model model) {
		if(request.getParameter("selectId") != null){
			int carId = Integer.parseInt(request.getParameter("selectId"));
			vehicleSch.setCarId(carId);
			
		}
		
		dispathService.updateSch(vehicleSch);
		return "redirect:/dispath/findDispath";
	}
	
	
	/**
	 * 分页查询
	 * @param info
	 * @param current
	 * @param model
	 * @return
	 */
	@RequestMapping("/findDispath")
	public String findDispath(String info,Integer current , Model model){
		if(current == null)
			current = 1;
		Page page = dispathService.querySch(info, current);
		model.addAttribute("page", page);
		return "car/dispathCar";
	}
	
	
	/**
	 * 删除信息
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value= "/deleteDispath" , method = RequestMethod.POST)
	public @ResponseBody int deleteDispath (int id) throws Exception{
		int flag = 0;
		flag = dispathService.deleteSch(id);
		if(flag != 0)
		return 1;
		else 
		return 0;
	}
	
	
	@RequestMapping("/findByInfo")
	public String findByInfo (HttpServletRequest request,ModelMap model)throws Exception{
		String info = request.getParameter("querySch");
		model.put("info", info);
		return "redirect:/dispath/findDispath";
		
	}
	
}
