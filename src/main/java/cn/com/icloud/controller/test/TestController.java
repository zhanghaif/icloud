package cn.com.icloud.controller.test;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.icloud.core.response.Result;
import cn.com.icloud.core.response.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.schema.Model;

/**
 * @className: TestController
 * @description: 测试类
 * @author zhanghaifeng
 * @dateTime 2019年3月19日 
 */

@Api(value="事例代码",tags={"CRUD事例代码"})
@RestController
@RequestMapping("/v1/test")
@Validated
public class TestController {

	@ApiOperation(value = "查询", notes = "查询信息")
	@GetMapping
	public Result list() {
		return ResultGenerator.genOkResult();
	}
	
	@ApiOperation(value = "按Id删除", notes = "删除方法")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "id")
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable final Long id) {
		return ResultGenerator.genOkResult();
	}
	
	@ApiOperation(value = "按Id查询数据", notes = "查询方法")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "id")
	@GetMapping("/{id}")
	public Result from(@PathVariable final Long id) {
		return ResultGenerator.genOkResult();
	}
	
	@ApiOperation(value = "修改方法", notes = "修改方法")
    @ApiImplicitParam(name = "model", value = "model", required = true, dataType = "Model")
	@PutMapping
	public Result update(@PathVariable final Model model) {
		return ResultGenerator.genOkResult();
	}
}
