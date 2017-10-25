package io.renren.modules.test.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.test.entity.TestEntity;
import io.renren.modules.test.service.TestService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;




/**
 * 用户
 * 
 * @author w.x.y
 * @email 438123371@qq.com
 * @date 2017-10-24 10:12:18
 */
@RestController
@RequestMapping("/test/test")
public class TestController {
	@Autowired
	private TestService testService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("test:test:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TestEntity> testList = testService.queryList(query);
		int total = testService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(testList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("test:test:info")
	public R info(@PathVariable("userId") Long userId){
		TestEntity test = testService.queryObject(userId);
		
		return R.ok().put("test", test);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("test:test:save")
	public R save(@RequestBody TestEntity test){
		testService.save(test);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("test:test:update")
	public R update(@RequestBody TestEntity test){
		testService.update(test);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("test:test:delete")
	public R delete(@RequestBody Long[] userIds){
		testService.deleteBatch(userIds);
		
		return R.ok();
	}
	
}
