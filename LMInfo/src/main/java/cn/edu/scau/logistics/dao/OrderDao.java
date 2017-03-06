package cn.edu.scau.logistics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.scau.logistics.entity.Order;

public interface OrderDao {
	public int addOrder(Order order);
	
	public int deleteOrder(int orderId);
	
	public List<Order> queryOrder(@Param("info")String info,@Param("start") int start,@Param("size") int size);
	
	public int updateOrder(Order order);
	
	public Order findById(int orderId);
	
	public int getTotal(String info);
}
