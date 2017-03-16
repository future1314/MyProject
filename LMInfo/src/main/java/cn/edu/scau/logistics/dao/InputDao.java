package cn.edu.scau.logistics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.scau.logistics.entity.Input;

public interface InputDao {
	public int addInput(Input input);
	public Input findById(int id);
	public int updateInput(Input input);
	public int deleteInput(int id);
	public int getTotal(String info);
	public List<Input> queryInput(@Param("info")String info,@Param("start")int start,@Param("size")int size); 
	
}
