package cn.edu.scau.logistics.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.scau.logistics.dao.OrderDetailDao;
import cn.edu.scau.logistics.entity.OrderDetail;
import cn.edu.scau.logistics.services.interfaces.OrderDetailService;
@Service("orderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {
	@Resource
	private OrderDetailDao orderDetailDao;
	@Override
	public OrderDetail findById(int detailId) {
		// TODO Auto-generated method stub
		return orderDetailDao.findById(detailId);
	}

	@Override
	public int addOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return orderDetailDao.addOrderDetail(orderDetail);
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

}
