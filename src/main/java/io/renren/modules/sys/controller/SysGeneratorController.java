package io.renren.modules.sys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import io.renren.modules.sys.service.SysGeneratorService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月19日 下午9:12:58
 */
@RestController
@RequestMapping("/sys/generator")
public class SysGeneratorController extends AbstractController {
	@Autowired
	private SysGeneratorService sysGeneratorService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:gen:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<Map<String, Object>> list = sysGeneratorService.queryList(query);
		int total = sysGeneratorService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 生成代码
	 */
	@RequestMapping(value = "/code",method = RequestMethod.POST)
	@RequiresPermissions("sys:gen:code")
	public R code(HttpServletRequest request) throws IOException{
		String[] tableNames = new String[]{};
		String tables = request.getParameter("tables");
		/*JSONArray objects = JSON.parseArray(tables);
		tableNames = objects.toArray(tableNames);*/
		tableNames = JSON.parseArray(tables).toArray(tableNames);
		
		sysGeneratorService.generatorCode(tableNames);
		return R.ok();
	}

}
