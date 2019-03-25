package cn.com.icloud.service.system.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.icloud.model.entity.system.SysUser;
import cn.com.icloud.service.system.UserService;

/**
 * @className: UserDetailsServiceImpl
 * @description: 登录service
 * @author zhanghaifeng
 * @dateTime 2019年3月21日 
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String account) {
        final SysUser user = this.userService.findDetailByAccount(account);
        // 权限
        final List<SimpleGrantedAuthority> authorities =
                user.getPermissionCodeList().stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
        // 角色
        authorities.add(new SimpleGrantedAuthority(user.getRoleName()));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }
}
