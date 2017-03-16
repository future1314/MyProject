package cn.edu.scau.logistics.services.interfaces;

import cn.edu.scau.logistics.entity.Output;
import cn.edu.scau.logistics.util.Page;

public interface OutputService {
	public int addOutput(Output output);
	public int updateOutput(Output output);
	public int deleteOutput(int id);
	public Output findById(int id);
	public int getTotal(String info);
	public Page queryOutput(String info,int current);
}
