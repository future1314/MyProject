package cn.edu.scau.logistics.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.scau.logistics.dao.CarDao;
import cn.edu.scau.logistics.entity.Car;
import cn.edu.scau.logistics.services.interfaces.CarService;
import cn.edu.scau.logistics.util.Page;
@Service("car")
public class CarServiceImpl implements CarService {
	@Resource
	private CarDao carDao;
	@Override
	public Page queryCar(String info, int current) {
		// TODO Auto-generated method stub
		Page page = new Page( current );
		int count = carDao.getTotal(info);
		page.setCount(count);
		List<Car> carList = carDao.queryCar(info, page.getStart(), page.getSize());
		page.setList(carList);
		return page;
	}

	@Override
	public int addCar(Car car) {
		// TODO Auto-generated method stub
		return carDao.addCar(car);
	}

	@Override
	public int update(Car car) {
		// TODO Auto-generated method stub
		return carDao.updateCar(car);
	}

	@Override
	public int getTotal(String info) {
		// TODO Auto-generated method stub
		return carDao.getTotal(info);
	}

	@Override
	public int deleteCar(int carId) {
		// TODO Auto-generated method stub
		return carDao.deleteCar(carId);
	}

	@Override
	public Car findById(int carId) {
		// TODO Auto-generated method stub
		return carDao.findById(carId);
	}

	@Override
	public List<Car> findAll() {
		// TODO Auto-generated method stub
		return carDao.findAll();
	}

}
