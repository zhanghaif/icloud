package cn.com.icloud.mapper.system;

import com.alibaba.fastjson.JSONObject;

import cn.com.icloud.core.mapper.MyMapper;
import cn.com.icloud.model.system.PermissionEntity;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper extends MyMapper<PermissionEntity> {
    /**
     * 找到所有权限可控资源
     *
     * @return Json对象列表
     */
    List<JSONObject> findAllResourcePermission();

    /**
     * 获取所有权限代码
     *
     * @return 代码列表
     */
    @Select("SELECT p.permission_key FROM `icloud_sys_permission` p")
    List<String> findAllCode();
}