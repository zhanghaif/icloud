package cn.com.icloud.service.system;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import cn.com.icloud.core.service.Service;
import cn.com.icloud.model.system.PermissionEntity;

public interface PermissionService extends Service<PermissionEntity> {
    /**
     * 找到所有权限可控资源
     *
     */
	List<PermissionEntity> findAllResourcePermission();
}
