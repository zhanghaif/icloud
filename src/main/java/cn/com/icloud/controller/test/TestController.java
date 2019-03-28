package cn.com.icloud.controller.test;

import javax.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.icloud.core.common.SysLog;
import cn.com.icloud.core.response.Result;
import cn.com.icloud.core.response.ResultGenerator;
import cn.com.icloud.model.entity.test.SysTest;
import cn.com.icloud.service.test.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @className: TestController
 * @description: 测试类
 * 				@Api swagger注解
 * 				@RestController 相当于@Controller+@ResponseBody两个注解的结合
 * 				@RequestMapping 映射请求
 *   			@Validated校验数据，如果数据异常则会统一抛出异常
 * @author zhanghaifeng
 * @dateTime 2019年3月19日 
 */

@Api(value="事例代码",tags={"CRUD事例代码"})
@RestController
@RequestMapping("/v1/test")
@Validated
public class TestController {

	@Resource
	TestService testService;
	/**
	 * 
	 * @Title: list   
	 * @Description: @PreAuthorize:进入方法之前验证授权
	 * 				 @SysLog 日志管理，所有业务函数要使用此标签
	 * 				 @ApiOperation swagger注解
	 * 				 @GetMapping get请求
	 * @param: @return      
	 * @return: 返回统一格式的数据 { "code": 200,"data": "","msg": "OK"}
	 * @throws
	 */
	@PreAuthorize("hasAuthority('system:test:list')")
	@ApiOperation(value = "查询", notes = "查询信息")
	@SysLog(module = "test", action = "列表")
	@GetMapping
	public Result list() {
		return ResultGenerator.genOkResult(testService.findAll());
	}
	
	@PreAuthorize("hasAuthority('system:test:add')")
	@ApiOperation(value = "新建方法", notes = "新建方法")
    @ApiImplicitParam(name = "SysTest", value = "SysTest", required = true, dataType = "SysTest")
	@PostMapping
	public Result add(@RequestBody final SysTest test) {
		this.testService.save(test);
		return ResultGenerator.genOkResult();
	}
	
	@PreAuthorize("hasAuthority('system:test:delete')")
	@ApiOperation(value = "按Id删除", notes = "删除方法")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "id")
	@SysLog(module = "test", action = "删除")
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable final Long id) {
		this.testService.deleteBy("id", id);
//		this.testService.deleteById(id);
		return ResultGenerator.genOkResult();
	}
	
	@PreAuthorize("hasAuthority('system:test:from')")
	@ApiOperation(value = "按Id查询数据", notes = "查询方法")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "id")
	@GetMapping("/{id}")
	public Result from(@PathVariable final Long id) {
		testService.findById(id);
		return ResultGenerator.genOkResult(this.testService.findBy("id", id));
	}
	
	@PreAuthorize("hasAuthority('system:test:update')")
	@ApiOperation(value = "修改方法", notes = "修改方法")
    @ApiImplicitParam(name = "test", value = "test", required = true, dataType = "SysTest")
	@PutMapping
	public Result update(@RequestBody final SysTest test) {
		this.testService.update(test);
		return ResultGenerator.genOkResult();
	}
}
