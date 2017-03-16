package cn.edu.scau.logistics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.scau.logistics.entity.Money;
import cn.edu.scau.logistics.entity.OrderDetail;

public interface OrderDetailDao {
	public OrderDetail findById(int detailId);
	
	public int addOrderDetail(OrderDetail orderDetail);
	
	public int deletrOrderDetail(int id);
	
	public int updateOrderDetail(OrderDetail orderDetail);
	
	public List<OrderDetail> findAll();
	
	public List<Money> findByData(@Param("start")String start,@Param("end")String end);
}
