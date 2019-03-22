package cn.com.icloud.service.system;

import java.util.List;
import cn.com.icloud.core.service.Service;
import cn.com.icloud.model.entity.system.PermissionEntity;

public interface PermissionService extends Service<PermissionEntity> {
    /**
     * 找到所有权限可控资源
     *
     */
	List<PermissionEntity> findAllResourcePermission();
}
