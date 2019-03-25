package cn.com.icloud.service.system;

import java.util.List;
import cn.com.icloud.core.service.Service;
import cn.com.icloud.model.entity.system.SysPermission;

public interface PermissionService extends Service<SysPermission> {
    /**
     * 找到所有权限可控资源
     *
     */
	List<SysPermission> findAllResourcePermission();
}
