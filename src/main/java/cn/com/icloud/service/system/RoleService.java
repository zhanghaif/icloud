package cn.com.icloud.service.system;

import java.util.List;
import cn.com.icloud.core.service.Service;
import cn.com.icloud.model.entity.system.SysRole;

public interface RoleService extends Service<SysRole> {
    /**
     * 获取所有角色以及对应的权限
     *
     * @return 角色可控资源列表
     */
    List<SysRole> findAllRoleWithPermission();
}
