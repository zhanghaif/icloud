package cn.com.icloud.controller.test;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.icloud.core.response.Result;
import cn.com.icloud.core.response.ResultGenerator;

/**
 * @className: TestController
 * @description: 测试类
 * @author zhanghaifeng
 * @dateTime 2019年3月19日 
 */

@RestController
@RequestMapping("/v2")
@Validated
public class TestController {

	@GetMapping("/")
	public Result init() {
		return ResultGenerator.genOkResult();
	}
}
