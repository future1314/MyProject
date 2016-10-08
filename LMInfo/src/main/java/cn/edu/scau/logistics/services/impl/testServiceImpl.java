package cn.edu.scau.logistics.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.scau.logistics.dao.testMapper;
import cn.edu.scau.logistics.entity.testEntity;
import cn.edu.scau.logistics.services.interfaces.testService;
@Service

public class testServiceImpl implements testService{
	@Autowired
	private testMapper testmapper;
	@Override
	public testEntity findById(int id) {
		// TODO Auto-generated method stub
		testEntity test = testmapper.findById(id);
		return test;
	}

}
