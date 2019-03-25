package cn.com.icloud.mapper.system;

import java.util.List;
import cn.com.icloud.core.mapper.MyMapper;
import cn.com.icloud.model.entity.system.SysRole;

public interface RoleMapper extends MyMapper<SysRole> {
    /**
     * 获取所有角色以及对应的权限
     *
     * @return 角色可控资源列表
     */
    List<SysRole> findAllRoleWithPermission();
}