package cn.com.icloud.service.test.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.icloud.core.service.AbstractService;
import cn.com.icloud.mapper.test.TestMapper;
import cn.com.icloud.model.entity.test.SysTest;
import cn.com.icloud.service.test.TestService;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class TestServiceImpl extends AbstractService<SysTest> implements TestService{
	
	@Resource
	TestMapper testMapper;
	
	@Override
	public List<SysTest> getId(Long id) {
		// TODO Auto-generated method stub
		return testMapper.getId(id);
	}

	@Override
	public void update(SysTest sysTest) {
		testMapper.update(sysTest);
	}
}
