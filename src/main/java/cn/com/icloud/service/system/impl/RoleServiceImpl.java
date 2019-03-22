package cn.com.icloud.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.icloud.core.service.AbstractService;
import cn.com.icloud.mapper.system.RoleMapper;
import cn.com.icloud.model.entity.system.RoleEntity;
import cn.com.icloud.service.system.RoleService;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends AbstractService<RoleEntity> implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<RoleEntity> findAllRoleWithPermission() {
        return this.roleMapper.findAllRoleWithPermission();
    }

}
