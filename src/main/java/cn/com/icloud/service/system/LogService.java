package cn.com.icloud.service.system;

import java.util.List;
import cn.com.icloud.core.service.Service;
import cn.com.icloud.model.entity.system.SysLog;

public interface LogService extends Service<SysLog>{

	/**
	 * 
	 * @Title: getLogList   
	 * @Description: 查询日志信息
	 * @param: @param page
	 * @return: List<SysLog>      
	 * @throws
	 */
	public List<SysLog> getLogList();
	
}
