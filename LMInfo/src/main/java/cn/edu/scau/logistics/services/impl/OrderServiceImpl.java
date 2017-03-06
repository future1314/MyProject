package cn.edu.scau.logistics.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.scau.logistics.dao.OrderDao;
import cn.edu.scau.logistics.dao.OrderDetailDao;
import cn.edu.scau.logistics.entity.Order;
import cn.edu.scau.logistics.services.interfaces.OrderService;
import cn.edu.scau.logistics.util.Page;
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderDao orderDao;
	@Resource
	private OrderDetailDao orderDelDao;
	
	@Override
	public int addOrder(Order order) {
		// TODO Auto-generated method stub
		return orderDao.addOrder(order);
	}

	@Override
	
	public int deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		Order order = orderDao.findById(orderId);
		orderDelDao.deletrOrderDetail(order.getOrdertablerId());
		return orderDao.deleteOrder(orderId);
	}

	@Override
	public Page queryOrder(String info, int current) {
		Page page = new Page( current );
		int count = orderDao.getTotal(info);
		page.setCount(count);
		List< Order > orderList = orderDao.queryOrder(info, page.getStart(), page.getSize());
		page.setList(orderList);
		return page;
		// TODO Auto-generated method stub

	}

	@Override
	public int updateOrder(Order order) {
		
		// TODO Auto-generated method stub
		return orderDao.updateOrder(order);
	}

	@Override
	public Order findByid(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.findById(orderId);
	}

	@Override
	public int getTotal(String info) {
		// TODO Auto-generated method stub
		return orderDao.getTotal(info);
	}

}
