package cn.edu.scau.logistics.dao;

import cn.edu.scau.logistics.entity.OrderDetail;

public interface OrderDetailDao {
	public OrderDetail findById(int detailId);
	
	public int addOrderDetail(OrderDetail orderDetail);
	
	public int deletrOrderDetail(int id);
	
	public int updateOrderDetail(OrderDetail orderDetail);

}
