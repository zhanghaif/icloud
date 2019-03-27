package cn.com.icloud.service.system.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.icloud.core.service.AbstractService;
import cn.com.icloud.mapper.system.LogMapper;
import cn.com.icloud.model.entity.system.SysLog;
import cn.com.icloud.model.vo.system.SysLogVO;
import cn.com.icloud.service.system.LogService;
import cn.com.icloud.util.BeanUtils;
import lombok.AllArgsConstructor;
/**
 * @className: LogServiceImpl
 * @description: 日志service
 * @author zhanghaifeng
 * @dateTime 2019年3月25日 09:34:21
 */

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class LogServiceImpl extends AbstractService<SysLog> implements LogService{

	@Resource
    LogMapper logMapper;

    public List<SysLog> getLogList() {
    	
//    	SysLog sysLog = new SysLog(); //logMapper.getLogs();
//    	sysLog.setId(1L);
//    	sysLog.setAction("123");
//    	sysLog.setModule("234");
//    	SysLogVO vo = new SysLogVO();
//    	BeanUtils.copyProperties(vo,sysLog);
//    	System.out.println(vo);
//    	
//    	List<SysLogVO> sysLogVOs = new ArrayList<SysLogVO>();
//    	List<SysLog> sysLogs = logMapper.getLogs();
//    	BeanUtils.copyProperties(sysLogVOs,sysLogs);
//    	System.out.println(sysLogVOs);
//    	
        return logMapper.getLogs();
    }
}
