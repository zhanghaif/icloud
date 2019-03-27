package cn.com.icloud.service.test;

import java.util.List;

import cn.com.icloud.core.service.Service;
import cn.com.icloud.model.entity.test.SysTest;

public interface TestService extends Service<SysTest>{

	List<SysTest> getId(Long id);
	
	void update(SysTest sysTest);
}
