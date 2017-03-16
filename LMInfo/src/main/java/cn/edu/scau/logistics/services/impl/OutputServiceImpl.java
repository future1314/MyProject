package cn.edu.scau.logistics.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.scau.logistics.dao.OrderDao;
import cn.edu.scau.logistics.dao.OutputDao;
import cn.edu.scau.logistics.entity.Order;
import cn.edu.scau.logistics.entity.Output;
import cn.edu.scau.logistics.services.interfaces.OutputService;
import cn.edu.scau.logistics.util.Page;
@Service("output")
public class OutputServiceImpl implements OutputService {
	@Resource
	private OutputDao outputDao;
	@Resource
	private OrderDao orderDao;
	@Override
	public int addOutput(Output output) {
		// TODO Auto-generated method stub
		return outputDao.addOutput(output);
	}

	@Override
	public int updateOutput(Output output) {
		// TODO Auto-generated method stub
		if(output.getOutputTime() != null && output.getIsOutput() == "Y"){
			Order order = orderDao.findById(output.getOrdertableDetailId());
			order.setIsSend("Y");
			orderDao.updateOrder(order);
		}
		return outputDao.updateOutput(output);
	}

	@Override
	public int deleteOutput(int id) {
		// TODO Auto-generated method stub
		return outputDao.deleteOutput(id);
	}

	@Override
	public Output findById(int id) {
		// TODO Auto-generated method stub
		return outputDao.findById(id);
	}

	@Override
	public int getTotal(String info) {
		// TODO Auto-generated method stub
		return outputDao.getTotal(info);
	}

	@Override
	public Page queryOutput(String info, int current) {
		// TODO Auto-generated method stub
		Page page = new Page(current);
		int count = outputDao.getTotal(info);
		List<Output> list =outputDao.queryOutput(info, page.getStart(), page.getSize());
		page.setCount(count);
		page.setList(list);
		return page;
	}

}
