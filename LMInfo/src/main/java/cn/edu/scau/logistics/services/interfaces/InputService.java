package cn.edu.scau.logistics.services.interfaces;

import cn.edu.scau.logistics.entity.Input;
import cn.edu.scau.logistics.util.Page;

public interface InputService {
	public Input findById(int id);
	public int updateInput(Input input);
	public Page queryInput(String info,int current);
	public int deleteInput(int id);
	public int getTotal(String info);
	public int addInput(Input input);
}
