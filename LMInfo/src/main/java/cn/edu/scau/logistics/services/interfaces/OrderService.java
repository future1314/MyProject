package cn.edu.scau.logistics.services.interfaces;

import cn.edu.scau.logistics.entity.Order;
import cn.edu.scau.logistics.util.Page;

public interface OrderService {
	public int addOrder(Order order);
	
	public int deleteOrder(int orderId);
	
	public Page queryOrder(String info,int current);
	
	public int updateOrder(Order order);
	
	public Order findByid(int orderId);
	
	public int getTotal (String info);
}
