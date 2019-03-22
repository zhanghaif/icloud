package cn.com.icloud.service.system;


import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.com.icloud.core.service.Service;
import cn.com.icloud.model.entity.system.UserEntity;

public interface UserService extends Service<UserEntity> {
   
    /**
     * 按条件查询用户信息
     *
     * @param column 列名
     * @param param  参数map
     * @return 用户
     */
    UserEntity findDetailBy(String column, Object param);

    /**
     * 按用户名查询用户信息
     *
     * @param account 用户名
     * @return 用户
     * @throws UsernameNotFoundException 用户名找不到
     */
    UserEntity findDetailByAccount(String account) throws UsernameNotFoundException;

    /**
     * 验证用户密码
     *
     * @param rawPassword     原密码
     * @param encodedPassword 加密后的密码
     * @return boolean
     */
    boolean verifyPassword(String rawPassword, String encodedPassword);
    
    /**
     * 获取所有用户以及对应角色
     *
     * @return 用户列表
     */
    List<UserEntity> findAllUserWithRole();
}
