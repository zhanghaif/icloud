package cn.com.icloud.mapper.test;

import java.util.List;
import cn.com.icloud.core.mapper.MyMapper;
import cn.com.icloud.model.entity.test.SysTest;

public interface TestMapper extends MyMapper<SysTest> {

	 List<SysTest> getId(Long id);
	 
	 void update(SysTest sysTest);
}
