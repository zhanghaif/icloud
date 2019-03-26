package cn.com.icloud.controller;

import java.security.Principal;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.icloud.core.common.SysLog;
import cn.com.icloud.core.interceptor.LogInterceptor;
import cn.com.icloud.core.jwt.JwtUtil;
import cn.com.icloud.core.response.Result;
import cn.com.icloud.core.response.ResultGenerator;
import cn.com.icloud.model.entity.system.SysUser;
import cn.com.icloud.service.system.LogService;
import cn.com.icloud.service.system.UserService;
import cn.com.icloud.service.system.impl.UserDetailsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @className: AdminController
 * @description: 登录类
 * @author zhanghaifeng
 * @dateTime 2019年3月19日 
 */
@Api(value="后台登录管理",tags={"后台登录登出"})
@RestController
@RequestMapping("/v1")
@Validated
public class AdminController {
	
	@Resource
	UserService userService;
	
	@Resource
    private UserDetailsServiceImpl userDetailsService;
	
    @Resource
    private JwtUtil jwtUtil;
    
    @Resource
    private LogService logService;
    
    @Resource
    private LogInterceptor logInterceptor;
    /**
     * 
     * @Title: info   
     * @Description: 查询登录账户的权限角色信息
     * @param: @param user
     * @param: @return      
     * @return: 返回权限信息      
     * @throws
     */
    @ApiOperation(value = "获取token查询权限信息", notes = "权限信息")
    @ApiImplicitParam(name = "user", value = "信息", required = true)
    @GetMapping("/info")
    public Result info(final Principal user) {
        final SysUser userDB = this.userService.findDetailByAccount(user.getName());
        return ResultGenerator.genOkResult(userDB);
    }
	
	@ApiOperation(value = "根据用户名密码进行登录", notes = "获取token信息")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "SysUser")
	@SysLog(module = "登录", action = "登录")
	@PostMapping("/login")
	public Result login(@RequestBody final SysUser user) {
		// 用户名登录
		SysUser dbUser = null;
        if (user.getAccount() != null) {
            dbUser = this.userService.findBy("account", user.getAccount());
            if (dbUser == null) {
                return ResultGenerator.genFailedResult("username error");
            }
        }
        // 验证密码
        if (!this.userService.verifyPassword(user.getPassword(), dbUser.getPassword())) {
            return ResultGenerator.genFailedResult("password error");
        }
		return this.getToken(user);
	}
	
	@ApiOperation(value = "用户登出", notes = "注销登录信息")
    @ApiImplicitParam(name = "user", value = "信息", required = true)
	@SysLog(module = "退出", action = "退出")
	@GetMapping("/logout")
    public Result logout(final Principal user) {
        return ResultGenerator.genOkResult();
    }
	
	/**
	 * 获得 token
	*/
	private Result getToken(final SysUser user) {
        final String account = user.getAccount();
        final UserDetails userDetails = this.userDetailsService.loadUserByUsername(account);
        final String token = this.jwtUtil.sign(account, userDetails.getAuthorities());
        return ResultGenerator.genOkResult(token);
    }
	

}
