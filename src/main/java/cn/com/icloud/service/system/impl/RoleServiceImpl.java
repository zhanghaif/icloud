package cn.com.icloud.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.icloud.core.service.AbstractService;
import cn.com.icloud.mapper.system.RoleMapper;
import cn.com.icloud.model.entity.system.SysRole;
import cn.com.icloud.service.system.RoleService;

/**
 * @className: RoleServiceImpl
 * @description: 角色service
 * @author zhanghaifeng
 * @dateTime 2019年3月21日 
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends AbstractService<SysRole> implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<SysRole> findAllRoleWithPermission() {
        return this.roleMapper.findAllRoleWithPermission();
    }

}
