package cn.edu.scau.logistics.services.interfaces;

import java.util.List;

import cn.edu.scau.logistics.entity.Department;

public interface DepartmentService {
	public List<Department> findAllDep();
	
	public int addDep(Department department);
	
	public Department findDepByName(String depName);
}
