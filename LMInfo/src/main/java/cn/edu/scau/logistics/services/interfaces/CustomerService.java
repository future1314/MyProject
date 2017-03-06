package cn.edu.scau.logistics.services.interfaces;

import java.util.List;

import cn.edu.scau.logistics.entity.Customer;
import cn.edu.scau.logistics.util.Page;

public interface CustomerService {
	
	public  Page queryCustomer(String info,int current);
	
	public int addCustomer(Customer customer);
	
	public int updateCustomer(Customer customer);
	
	public int getTotal(String info);
	
	public  Customer findById(int customerId);
	
	public int deletCustomer(int customerId);
	
	public List <Customer> findAll();
}
