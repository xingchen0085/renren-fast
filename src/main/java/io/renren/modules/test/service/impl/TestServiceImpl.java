package io.renren.modules.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.test.dao.TestDao;
import io.renren.modules.test.entity.TestEntity;
import io.renren.modules.test.service.TestService;



@Service("testService")
public class TestServiceImpl implements TestService {
	@Autowired
	private TestDao testDao;
	
	@Override
	public TestEntity queryObject(Long userId){
		return testDao.queryObject(userId);
	}
	
	@Override
	public List<TestEntity> queryList(Map<String, Object> map){
		return testDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return testDao.queryTotal(map);
	}
	
	@Override
	public void save(TestEntity test){
		testDao.save(test);
	}
	
	@Override
	public void update(TestEntity test){
		testDao.update(test);
	}
	
	@Override
	public void delete(Long userId){
		testDao.delete(userId);
	}
	
	@Override
	public void deleteBatch(Long[] userIds){
		testDao.deleteBatch(userIds);
	}
	
}
