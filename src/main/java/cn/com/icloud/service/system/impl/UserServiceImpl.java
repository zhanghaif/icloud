package cn.com.icloud.service.system.impl;

import cn.com.icloud.core.service.AbstractService;
import cn.com.icloud.mapper.system.PermissionMapper;
import cn.com.icloud.mapper.system.UserMapper;
import cn.com.icloud.mapper.system.UserRoleMapper;
import cn.com.icloud.model.entity.system.SysUser;
import cn.com.icloud.model.entity.system.SysUserRole;
import cn.com.icloud.service.system.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: UserServiceImpl
 * @description: 用户service
 * @author zhanghaifeng
 * @dateTime 2019年3月21日 
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends AbstractService<SysUser> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper; 
    
    @Resource
    private PermissionMapper permissionMapper;
    
    @Resource
    private PasswordEncoder passwordEncoder;
    
    @Override
    public SysUser findDetailBy(final String column, final Object param) {
        final Map<String, Object> map = new HashMap<>(1);
        map.put(column, param);
        return this.userMapper.findDetailBy(map);
    }



	@Override
    public boolean verifyPassword(final String rawPassword, final String encodedPassword) {
        return this.passwordEncoder.matches(rawPassword, encodedPassword);
    }



	@Override
    public SysUser findDetailByAccount(final String account) throws UsernameNotFoundException {
        final SysUser user = this.findDetailBy("account", account);
        if (user == null) {
            throw new UsernameNotFoundException("not found this username");
        }
        return user;
    }



    @Override
    public List<SysUser> findAllUserWithRole() {
        return this.userMapper.findAllUserWithRole();
    }
    
    /**
     * 重写save方法，密码加密后再存
     */
    @Override
    public void save(final SysUser user) {
    	SysUser u = this.findBy("account", user.getUsername());
        if (u != null) {
        	throw new UsernameNotFoundException("account already existed");
        } else {
                //log.info("before password : {}", user.getPassword().trim());
                user.setPassword(this.passwordEncoder.encode(user.getPassword().trim()));
                //log.info("after password : {}", user.getPassword());
                this.userMapper.insertSelective(user);
                //log.info("User<{}> id : {}", user.getUsername(), user.getId());
                // 如果没有指定角色Id，以默认普通用户roleId保存
                Long roleId = user.getRoleId();
                if (roleId == null) {
                    roleId = 2L;
                }
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(user.getId());
                sysUserRole.setRoleId(roleId);
                this.userRoleMapper.insert(sysUserRole);
            
        }
    }
    
    /**
     * 重写update方法
     */
    @Override
    public void update(final SysUser user) {
        // 如果修改了密码
        if (user.getPassword() != null && user.getPassword().length() >= 6) {
            // 密码修改后需要加密
            user.setPassword(this.passwordEncoder.encode(user.getPassword().trim()));
        }
        this.userMapper.updateByPrimaryKeySelective(user);
    }

}
