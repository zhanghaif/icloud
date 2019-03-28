package cn.com.icloud.controller.system;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.com.icloud.service.system.LogService;
import cn.com.icloud.core.common.SysLog;
import cn.com.icloud.core.response.Result;
import cn.com.icloud.core.response.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @className: LogController
 * @description: 日志管理类
 * @author zhanghaifeng
 * @dateTime 2019年3月25日 09:25:21
 */
@Api(value="日志",tags={"日志接口"})
@RestController
@RequestMapping("/v1/system/log")
public class LogController {

    @Resource
    LogService LogService;

    @PreAuthorize("hasAuthority('system:log:list')")
    @ApiOperation(value = "获取所有日志信息", notes = "日志信息")
    @SysLog(module = "日志", action = "列表")
    @GetMapping
    public Result list() {
        return ResultGenerator.genOkResult(LogService.getLogList());
    }
}
