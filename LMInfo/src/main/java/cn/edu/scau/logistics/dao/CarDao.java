package cn.edu.scau.logistics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.scau.logistics.entity.Car;

public interface CarDao {
	public int addCar(Car car);
	
	public int deleteCar(int carId);
	
	public int updateCar(Car car);
	
	public int getTotal(String info);
	
	public List<Car> queryCar(@Param("info")String info,@Param("start")int start,@Param("size")int size);
	
	public Car findById(int carId);
	
	public List<Car> findAll();
}
