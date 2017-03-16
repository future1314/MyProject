package cn.edu.scau.logistics.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.scau.logistics.dao.InputDao;
import cn.edu.scau.logistics.dao.OrderDetailDao;
import cn.edu.scau.logistics.dao.OutputDao;
import cn.edu.scau.logistics.entity.Input;
import cn.edu.scau.logistics.entity.Money;
import cn.edu.scau.logistics.entity.OrderDetail;
import cn.edu.scau.logistics.entity.Output;
import cn.edu.scau.logistics.services.interfaces.OrderDetailService;
@Service("orderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {
	@Resource
	private OrderDetailDao orderDetailDao;
	@Resource
	private InputDao inputDao;
	@Resource
	private OutputDao outputDao;
	@Override
	public OrderDetail findById(int detailId) {
		// TODO Auto-generated method stub
		return orderDetailDao.findById(detailId);
	}

	@Override
	public int addOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		int result = 0;
		result = orderDetailDao.addOrderDetail(orderDetail);
		Input input = new Input();
		input.setOrdertableDetailId(orderDetail.getOrdertableDetailId());
		input.setInputId(orderDetail.getOrdertableDetailId());
		inputDao.addInput(input);
		
		Output output = new Output();
		output.setOutputId(orderDetail.getOrdertableDetailId());
		output.setOrdertableDetailId(orderDetail.getOrdertableDetailId());
		outputDao.addOutput(output);
		
		return  result;
	}

	@Override
	public int deletrOrderDetail(int id) {
		// TODO Auto-generated method stub
		return orderDetailDao.deletrOrderDetail(id);
	}

	@Override
	public int updateOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return orderDetailDao.updateOrderDetail(orderDetail);
	}

	@Override
	public List<Money> findByData(String start, String end) {
		// TODO Auto-generated method stub
		return orderDetailDao.findByData(start, end);
	}

}
