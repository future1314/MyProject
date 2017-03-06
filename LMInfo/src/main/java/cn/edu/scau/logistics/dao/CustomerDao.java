package cn.edu.scau.logistics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.scau.logistics.entity.Customer;

/**
 * 客户信息
 */
public interface CustomerDao {

	public List<Customer> queryCustomer(@Param("info")String info,@Param("start") int start, @Param("size")int size);
	
	public int getTotal(String info);
	
	public int updateCustomer(Customer customer);
	
	public int deleteCustomer(int customerId);
	
	public int addCustomer(Customer customer);
	
	public Customer findById(int customerId);
	
	public List<Customer> findAll();
}
