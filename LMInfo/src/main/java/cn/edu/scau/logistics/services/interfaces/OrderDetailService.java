package cn.edu.scau.logistics.services.interfaces;

import java.util.List;

import cn.edu.scau.logistics.entity.Money;
import cn.edu.scau.logistics.entity.OrderDetail;

public interface OrderDetailService {
	public OrderDetail findById(int detailId);
	
	public int addOrderDetail(OrderDetail orderDetail);
	
	public int deletrOrderDetail(int id);
	
	public int updateOrderDetail(OrderDetail orderDetail);
	
	public List<Money> findByData(String start,String end);

}
