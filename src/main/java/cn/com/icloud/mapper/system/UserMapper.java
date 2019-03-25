package cn.com.icloud.mapper.system;

import java.util.List;
import java.util.Map;
import cn.com.icloud.core.mapper.MyMapper;
import cn.com.icloud.model.entity.system.SysUser;

/**
 */
public interface UserMapper extends MyMapper<SysUser> {
 
	/**
     * 获取所有用户以及对应角色
     *
     * @return 用户列表
     */
    List<SysUser> findAllUserWithRole();
    /**
     * 按条件查询用户信息
     *
     * @param param 参数map
     * @return 用户
     */
    SysUser findDetailBy(Map<String, Object> param);

    /**
     * 根据 Id 获取原始数据
     *
     * @param id
     * @return
     */
    SysUser getById(Long id);
}