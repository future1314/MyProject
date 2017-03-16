package cn.edu.scau.logistics.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.scau.logistics.dao.CarDao;
import cn.edu.scau.logistics.dao.DispathDao;
import cn.edu.scau.logistics.entity.Car;
import cn.edu.scau.logistics.entity.VehicleSch;
import cn.edu.scau.logistics.services.interfaces.DispathService;
import cn.edu.scau.logistics.util.Page;
@Service("dispath")
public class DispathServiceImpl implements DispathService {
	@Resource
	private DispathDao dispathDao;
	@Resource
	private CarDao carDao;
	@Override
	public int addSch(VehicleSch vehicleSch) {
		// TODO Auto-generated method stub
		return dispathDao.addSch(vehicleSch);
	}

	@Override
	public VehicleSch findById(int id) {
		// TODO Auto-generated method stub
		return dispathDao.findById(id);
	}

	@Override
	public int updateSch(VehicleSch vehicleSch) {
		// TODO Auto-generated method stub
		if(vehicleSch.getCarId() == 0){
			
			return dispathDao.updateSch(vehicleSch);
		}
		else{
			Car car = carDao.findById(vehicleSch.getCarId());
			car.setCarState("Y");
			carDao.updateCar(car);
			
			return dispathDao.updateSch(vehicleSch);
		}
	
	}

	@Override
	public int deleteSch(int id) {
		// TODO Auto-generated method stub
		return dispathDao.deleteSch(id);
	}

	@Override
	public int getTotal(String info) {
		// TODO Auto-generated method stub
		return dispathDao.getTotal(info);
	}

	@Override
	public Page querySch(String info, int current) {
		// TODO Auto-generated method stub
		Page page = new Page( current );
		int count = dispathDao.getTotal(info);
		page.setCount(count);
		List< VehicleSch > list = dispathDao.querySch(info, page.getStart(), page.getSize());
		page.setList(list);
		return page;
	}

	

}
