package cn.edu.scau.logistics.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.scau.logistics.dao.InputDao;
import cn.edu.scau.logistics.entity.Input;
import cn.edu.scau.logistics.services.interfaces.InputService;
import cn.edu.scau.logistics.util.Page;


@Service("input")
public class InputServiceImpl implements InputService {
	@Resource
	private InputDao inputDao;
	@Override
	public Input findById(int id) {
		// TODO Auto-generated method stub
		return inputDao.findById(id);
	}

	@Override
	public int updateInput(Input input) {
		// TODO Auto-generated method stub
		return inputDao.updateInput(input);
	}

	@Override
	public Page queryInput(String info, int current) {
		// TODO Auto-generated method stub
		Page page = new Page( current );
		int count = inputDao.getTotal(info);
		List<Input> list = inputDao.queryInput(info, page.getStart(), page.getSize());
		page.setCount(count);
		page.setList(list);
		return page;
	}

	@Override
	public int deleteInput(int id) {
		// TODO Auto-generated method stub
		return inputDao.deleteInput(id);
	}

	@Override
	public int getTotal(String info) {
		// TODO Auto-generated method stub
		return inputDao.getTotal(info);
	}

	@Override
	public int addInput(Input input) {
		// TODO Auto-generated method stub
		return inputDao.addInput(input);
	}

}
