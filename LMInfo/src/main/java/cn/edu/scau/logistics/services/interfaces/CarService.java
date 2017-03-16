package cn.edu.scau.logistics.services.interfaces;

import java.util.List;

import cn.edu.scau.logistics.entity.Car;
import cn.edu.scau.logistics.util.Page;

public interface CarService {
	
	public Page queryCar(String info,int current);
	
	public int addCar(Car car);
	
	public int update(Car car);
	
	public int getTotal(String info);
	
	public int deleteCar(int carId);
	
	public Car findById(int carId);
	
	public List<Car> findAll();
}
