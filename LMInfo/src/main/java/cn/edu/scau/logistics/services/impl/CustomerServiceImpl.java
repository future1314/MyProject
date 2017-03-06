package cn.edu.scau.logistics.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.scau.logistics.dao.CustomerDao;
import cn.edu.scau.logistics.entity.Customer;
import cn.edu.scau.logistics.services.interfaces.CustomerService;
import cn.edu.scau.logistics.util.Page;
@Service("customerService")	
public class CustomerServiceImpl implements CustomerService {
	@Resource
	private CustomerDao customerDao;
	
	@Override
	public Page queryCustomer(String info, int current) {
		// TODO Auto-generated method stub
		Page page = new Page( current );
		int count = customerDao.getTotal(info);
		page.setCount(count);
		List<Customer> customerList = customerDao.queryCustomer(info, page.getStart(), page.getSize());
		page.setList(customerList);
		return page;
	}

	@Override
	public int addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.addCustomer(customer);
	}

	@Override
	public int updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.updateCustomer(customer);
	}

	@Override
	public int getTotal(String info) {
		// TODO Auto-generated method stub
		return customerDao.getTotal(info);
	}

	@Override
	public Customer findById(int customerId) {
		// TODO Auto-generated method stub
		return customerDao.findById(customerId);
	}

	@Override
	public int deletCustomer(int customerId) {
		// TODO Auto-generated method stub
		return customerDao.deleteCustomer(customerId);
	}
	
	public List<Customer> findAll(){
		return customerDao.findAll();
	}
}
