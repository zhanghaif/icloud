package cn.com.icloud.controller.system;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * @className: PermissionController
 * @description: 权限管理类
 * @author zhanghaifeng
 * @dateTime 2019年3月20日 
 */
@Api(value="权限管理",tags={"权限管理"})
@RestController
@RequestMapping("/v1/permission")
@Validated
public class PermissionController {

}
