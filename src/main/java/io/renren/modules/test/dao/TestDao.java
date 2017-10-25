package io.renren.modules.test.dao;

import io.renren.modules.test.entity.TestEntity;
import io.renren.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 * 
 * @author w.x.y
 * @email 438123371@qq.com
 * @date 2017-10-24 10:12:18
 */
@Mapper
public interface TestDao extends BaseDao<TestEntity> {
	
}
