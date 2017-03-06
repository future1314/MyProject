package cn.edu.scau.logistics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.scau.logistics.entity.Worker;

public interface WorkerDao {
	public int addWorker(Worker worker);
	
	public int deleteWorker(int workId);
	
	public List<Worker> queryWorker(@Param("info")String info,@Param("start") int start, @Param("size")int size);
	
	public int updateWorker(Worker worker);
	
	public int getTotal(String info);
	
	public Worker findById(int workId);
	
	
}
