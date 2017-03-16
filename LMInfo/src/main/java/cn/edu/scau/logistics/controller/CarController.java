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
import cn.edu.scau.logistics.entity.Driver;
import cn.edu.scau.logistics.entity.Worker;
import cn.edu.scau.logistics.services.interfaces.CarService;
import cn.edu.scau.logistics.services.interfaces.WorkerService;
import cn.edu.scau.logistics.util.Page;

@Controller
@RequestMapping("/car")
public class CarController {
	@Resource
	private CarService carService;
	@Resource
	private WorkerService workerService;
	/**
	 * 跳转到添加信息界面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/goAddCar")
	public String goAddCar(Model model)throws Exception{
		List<Driver> driver = workerService.findAllDriver();
		model.addAttribute("driver", driver);
		return "car/addCar";
	}
	
	/**
	 * 跳转到更新页面
	 * @param 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goUpdate/{carId}")
	public String goUpdate(@PathVariable("carId") int carId ,Model model)throws Exception{
		Car car = carService.findById(carId);
		List<Driver> driver = workerService.findAllDriver();
		model.addAttribute("driver", driver);
		model.addAttribute("car",car);
		return "car/updateCar";
	}
	
	/**
	 * 添加或修改信息
	 * @param worker
	 * @return
	 */
	@RequestMapping("/save")
	public String saveCar(Car car,HttpServletRequest request,Model model)throws Exception{
		if(request.getParameter("carDriver")!=null){
			int workId = Integer.parseInt(request.getParameter("carDriver"));
			Worker worker = workerService.findByid(workId);
			car.setWorkId(workId);
			car.setCarDriver(worker.getWorkName());
			
		}
	
		if(car.getCarId() == 0){
			carService.addCar(car);
		}
		else{
			carService.update(car);
		}
		return "redirect:/car/findCar";
	}
	/**
	 * 分页查询
	 * @param info
	 * @param current
	 * @param model
	 * @return
	 */
	@RequestMapping("/findCar")
	public String findCar(String info,Integer current,Model model){
		if( current == null )
			current = 1;
		Page page = carService.queryCar(info, current);
		model.addAttribute("page",page);
		return "car/queryCar";
	}
	
	/**
	 * 删除信息
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value= "/deleteCar" , method = RequestMethod.POST)
	public @ResponseBody int deleteCar (int carId) throws Exception{
		int flag = 0;
		flag =carService.deleteCar(carId);
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
		String info = request.getParameter("queryCar");
		model.put("info", info);
		return "redirect:/car/findCar";
	}
	
	
}
