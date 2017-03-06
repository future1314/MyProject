package cn.edu.scau.logistics.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.scau.logistics.dao.WorkerDao;
import cn.edu.scau.logistics.entity.Worker;
import cn.edu.scau.logistics.services.interfaces.WorkerService;
import cn.edu.scau.logistics.util.Page;
@Service("workerService")
public class WorkerServiceImpl implements WorkerService {
	@Resource
	private WorkerDao workerDao;
	@Override
	public int addWorker(Worker worker) {
		// TODO Auto-generated method stub
		return workerDao.addWorker(worker);
	}

	@Override
	public int deleteWorker(int workId) {
		// TODO Auto-generated method stub
		return workerDao.deleteWorker(workId);
	}

	@Override
	public Page queryWorker(String info, int current) {
		// TODO Auto-generated method stub
		Page page = new Page( current );
		int count = workerDao.getTotal(info);
		page.setCount(count);
		List< Worker > workerList = workerDao.queryWorker(info, page.getStart(), page.getSize());
		page.setList(workerList);
		return page;
		
	}

	@Override
	public int updateWorker(Worker worker) {
		// TODO Auto-generated method stub
		return workerDao.updateWorker(worker);
	}

	@Override
	public int getTotal(String info) {
		// TODO Auto-generated method stub
		return workerDao.getTotal(info);
	}

	@Override
	public Worker findByid(int workId) {
		// TODO Auto-generated method stub
		return workerDao.findById(workId);
	}

}
