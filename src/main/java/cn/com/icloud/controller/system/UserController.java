package cn.com.icloud.controller.system;

import java.util.List;
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
import cn.com.icloud.controller.AdminController;
import cn.com.icloud.core.common.SysLog;
import cn.com.icloud.core.response.Result;
import cn.com.icloud.core.response.ResultGenerator;
import cn.com.icloud.model.entity.system.SysUser;
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
@RequestMapping("/v1/system/user")
@Validated
public class UserController {

	@Resource
	UserService userService;
	
	@Resource
	AdminController adminController;
	
	@PreAuthorize("hasAuthority('system:user:list')")
	@ApiOperation(value = "获取所有用户信息", notes = "用户信息")
    @ApiImplicitParam(name = "user", value = "信息", required = true)
	@SysLog(module = "用户", action = "列表")
    @GetMapping
    public Result list() {
        final List<SysUser> list = this.userService.findAllUserWithRole();
        return ResultGenerator.genOkResult(list);
    }
	
	@PreAuthorize("hasAuthority('system:user:add')")
	@ApiOperation(value = "新建用户", notes = "用户信息")
    @ApiImplicitParam(name = "user", value = "信息", required = true)
	@SysLog(module = "用户", action = "新建")
	@PostMapping
	public Result add(@RequestBody final SysUser sysUser) {
		userService.save(sysUser);
		return ResultGenerator.genOkResult(sysUser);
	}
	
	@PreAuthorize("hasAuthority('system:user:delete')")
	@ApiOperation(value = "删除用户", notes = "用户信息")
    @ApiImplicitParam(name = "id", value = "id", required = true)
	@SysLog(module = "用户", action = "删除")
	@DeleteMapping("/{id}")
    public Result delete(@PathVariable final Long id) {
        this.userService.deleteById(id);
        return ResultGenerator.genOkResult(id);
    }
	
	@PreAuthorize("hasAuthority('system:user:from')")
	@ApiOperation(value = "按Id查询用户", notes = "用户信息")
    @ApiImplicitParam(name = "id", value = "id", required = true)
	@SysLog(module = "用户", action = "查询")
	@GetMapping("/{id}")
    public Result from(@PathVariable final Long id) {
        final SysUser user = this.userService.findById(id);
        return ResultGenerator.genOkResult(user);
    }
	
	@PreAuthorize("hasAuthority('system:user:update')")
	@ApiOperation(value = "修改用户", notes = "用户信息")
    @ApiImplicitParam(name = "user", value = "user", required = true)
	@SysLog(module = "用户", action = "修改")
	@PutMapping
    public Result update(@RequestBody final SysUser user) {
        this.userService.update(user);
        return ResultGenerator.genOkResult(user);
    }

}
