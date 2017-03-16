package cn.edu.scau.logistics.services.interfaces;

import java.util.List;


import cn.edu.scau.logistics.entity.Driver;
import cn.edu.scau.logistics.entity.Worker;
import cn.edu.scau.logistics.util.Page;

public interface WorkerService {
	public int addWorker(Worker worker);
	
	public int deleteWorker(int workId);
	
	public Page queryWorker(String info,int current);
	
	public int updateWorker(Worker worker);
	
	public int getTotal(String info);
	
	public Worker findByid(int workId);
	
	public List<Driver> findAllDriver();
	
	
}
