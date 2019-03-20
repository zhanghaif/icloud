package cn.com.icloud.service.system.impl;


import cn.com.icloud.core.service.AbstractService;
import cn.com.icloud.mapper.system.PermissionMapper;
import cn.com.icloud.mapper.system.UserMapper;
import cn.com.icloud.model.system.UserEntity;
import cn.com.icloud.service.system.UserService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends AbstractService<UserEntity> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private PermissionMapper permissionMapper;
    
    @Resource
    private PasswordEncoder passwordEncoder;
    
    @Override
    public UserEntity findDetailBy(final String column, final Object param) {
        final Map<String, Object> map = new HashMap<>(1);
        map.put(column, param);
        return this.userMapper.findDetailBy(map);
    }



	@Override
    public boolean verifyPassword(final String rawPassword, final String encodedPassword) {
        return this.passwordEncoder.matches(rawPassword, encodedPassword);
    }



	@Override
    public UserEntity findDetailByAccount(final String account) throws UsernameNotFoundException {
        final UserEntity user = this.findDetailBy("account", account);
        if (user == null) {
            throw new UsernameNotFoundException("not found this username");
        }
        return user;
    }



    @Override
    public List<UserEntity> findAllUserWithRole() {
        return this.userMapper.findAllUserWithRole();
    }

}
