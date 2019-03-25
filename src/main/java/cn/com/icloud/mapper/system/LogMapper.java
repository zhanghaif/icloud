package cn.com.icloud.mapper.system;

import java.util.List;
import cn.com.icloud.core.mapper.MyMapper;
import cn.com.icloud.model.entity.system.SysLog;

public interface LogMapper extends MyMapper<SysLog> {

    /**
     * 获取日志列表
     *
     * @return
     */
    List<SysLog> getLogs();

    /**
     * 插入日志
     *
     * @param sysLog
     * @return
     */
//    int insert(SysLog sysLog);
}
