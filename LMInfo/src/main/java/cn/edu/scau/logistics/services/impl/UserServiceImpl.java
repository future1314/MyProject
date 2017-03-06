package cn.edu.scau.logistics.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.scau.logistics.dao.UserDao;
import cn.edu.scau.logistics.entity.UserEntity;
import cn.edu.scau.logistics.services.interfaces.UserService;
import cn.edu.scau.logistics.util.Page;
@Service("userService")	
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	
	@Override
	public UserEntity login(UserEntity user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	@Override
	public int getTotal(String info) {
		// TODO Auto-generated method stub
		return userDao.getTotal(info);
	}

	@Override
	public int updateUser(UserEntity user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public int addUser(UserEntity user) {
		// TODO Auto-generated method stub
		return	userDao.addUser(user);
	}

	@Override
	public int deleteUser(int userId) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(userId);
	}

	@Override
	public UserEntity findAccount(String account) {
		// TODO Auto-generated method stub
		return userDao.findAccount(account);
	}

	@Override
	public Page queryAllUser(String info,int current) {
		// TODO Auto-generated method stub
		Page page =new Page( current );
		int count = userDao.getTotal(info);
		System.out.println(page.getStart()+"hhhhhhhhhhhhhhhhhhh!!!!!!!"); 
		
		page.setCount(count);
		List<UserEntity > userList = userDao.queryAllUser(info,page.getStart(), page.getSize());
		
		page.setList(userList);
		return page;
	}

	@Override
	public Page queryAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity findUserById(int userId) {
		// TODO Auto-generated method stub
		return userDao.findUserById(userId);
	}

	
	


	

}
