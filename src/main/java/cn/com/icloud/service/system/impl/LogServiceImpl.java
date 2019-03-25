package cn.com.icloud.service.system.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.com.icloud.core.service.AbstractService;
import cn.com.icloud.mapper.system.LogMapper;
import cn.com.icloud.model.entity.system.SysLog;
import cn.com.icloud.service.system.LogService;
/**
 * @className: LogServiceImpl
 * @description: 日志service
 * @author zhanghaifeng
 * @dateTime 2019年3月25日 09:34:21
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class LogServiceImpl extends AbstractService<SysLog> implements LogService{

	@Resource
    LogMapper logMapper;

    public List<SysLog> getLogList() {
        return logMapper.getLogs();
    }
}
