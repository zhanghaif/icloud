package cn.com.icloud.controller.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.icloud.core.response.Result;
import cn.com.icloud.core.response.ResultGenerator;
import cn.com.icloud.model.system.UserEntity;
import cn.com.icloud.service.system.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @className: UserController
 * @description: 用户管理类
 * @author zhanghaifeng
 * @dateTime 2019年3月20日 
 */
@Api(value="用户管理",tags={"用户管理"})
@RestController
@RequestMapping("/v1/user")
@Validated
public class UserController {

	@Resource
	UserService userService;
	
//	@PreAuthorize("hasAuthority('user:list')")
	@ApiOperation(value = "获取所有用户信息", notes = "用户信息")
    @ApiImplicitParam(name = "user", value = "信息", required = true)
    @GetMapping
    public Result list() {
        final List<UserEntity> list = this.userService.findAllUserWithRole();
        return ResultGenerator.genOkResult(list);
    }
}
