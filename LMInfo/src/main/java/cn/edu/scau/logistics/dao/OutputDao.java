package cn.edu.scau.logistics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.scau.logistics.entity.Output;

public interface OutputDao {
	public int addOutput(Output output);
	public int updateOutput(Output output);
	public int deleteOutput(int id);
	public List<Output> queryOutput(@Param("info")String info,@Param("start")int start,@Param("size")int size);
	public Output findById(int id);
	public int getTotal(String info);
}
