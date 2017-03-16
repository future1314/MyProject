package cn.edu.scau.logistics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.scau.logistics.entity.VehicleSch;

public interface DispathDao {
	public int addSch(VehicleSch vehicleSch);
	public VehicleSch findById(int id);
	public int updateSch(VehicleSch vehicleSch);
	public int deleteSch(int id);
	public int getTotal(String info);
	public List<VehicleSch> querySch(@Param("info")String info,@Param("start")int start,@Param("size")int size);
	
}
