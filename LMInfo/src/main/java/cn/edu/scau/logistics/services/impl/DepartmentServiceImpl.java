package cn.edu.scau.logistics.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.scau.logistics.dao.DepartmentDao;
import cn.edu.scau.logistics.entity.Department;
import cn.edu.scau.logistics.services.interfaces.DepartmentService;
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	@Resource
	private DepartmentDao departmentDao;
	
	@Override
	public List<Department> findAllDep() {
		// TODO Auto-generated method stub
		return departmentDao.findAllDep();
	}

	@Override
	public int addDep(Department department) {
		// TODO Auto-generated method stub
		return departmentDao.addDep(department);
	}

	@Override
	public Department findDepByName(String depName) {
		// TODO Auto-generated method stub
		return departmentDao.findDepByName(depName);
	}

}
