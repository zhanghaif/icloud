package cn.com.icloud.controller.system;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.com.icloud.core.response.Result;
import cn.com.icloud.core.response.ResultGenerator;
import cn.com.icloud.model.entity.system.SysPermission;
import cn.com.icloud.service.system.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @className: PermissionController
 * @description: 权限管理类
 * @author zhanghaifeng
 * @dateTime 2019年3月20日 
 */
@Api(value="权限管理",tags={"权限管理"})
@RestController
@RequestMapping("/v1/system/permission")
@Validated
public class PermissionController {

	@Resource
	PermissionService permissionService;
	
	@ApiOperation(value = "获取所有菜单信息", notes = "菜单信息")
	@GetMapping
	public Result list() {
		List<SysPermission> list = permissionService.findAllResourcePermission();
		
		return ResultGenerator.genOkResult(list);
	}
	
	
}
