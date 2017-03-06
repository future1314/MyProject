package cn.edu.scau.logistics.dao;

import java.util.List;

import cn.edu.scau.logistics.entity.Department;

public interface DepartmentDao {
	public List<Department> findAllDep();
	
	public int addDep(Department dep);
	
	public Department findDepByName(String departmentName);
}
