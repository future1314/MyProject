package cn.edu.scau.logistics.services.interfaces;

import cn.edu.scau.logistics.entity.VehicleSch;
import cn.edu.scau.logistics.util.Page;

public interface DispathService {
	public int addSch(VehicleSch vehicleSch);
	public VehicleSch findById(int id);
	public int updateSch(VehicleSch vehicleSch);
	public int deleteSch(int id);
	public int getTotal(String info);
	public Page querySch(String info,int current);
	
}
