package cn.edu.scau.logistics.services.interfaces;

import cn.edu.scau.logistics.entity.OrderDetail;

public interface OrderDetailService {
	public OrderDetail findById(int detailId);
	
	public int addOrderDetail(OrderDetail orderDetail);
	
	public int deletrOrderDetail(int id);
	
	public int updateOrderDetail(OrderDetail orderDetail);

}
