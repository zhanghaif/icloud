package cn.com.icloud.mapper.system;

import java.util.List;
import java.util.Map;
import cn.com.icloud.core.mapper.MyMapper;
import cn.com.icloud.model.system.UserEntity;

/**
 */
public interface UserMapper extends MyMapper<UserEntity> {
 
	/**
     * 获取所有用户以及对应角色
     *
     * @return 用户列表
     */
    List<UserEntity> findAllUserWithRole();
    /**
     * 按条件查询用户信息
     *
     * @param param 参数map
     * @return 用户
     */
    UserEntity findDetailBy(Map<String, Object> param);

   
}