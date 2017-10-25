package io.renren.modules.test.service;

import io.renren.modules.test.entity.TestEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户
 * 
 * @author w.x.y
 * @email 438123371@qq.com
 * @date 2017-10-24 10:12:18
 */
public interface TestService {
	
	TestEntity queryObject(Long userId);
	
	List<TestEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TestEntity test);
	
	void update(TestEntity test);
	
	void delete(Long userId);
	
	void deleteBatch(Long[] userIds);
}
