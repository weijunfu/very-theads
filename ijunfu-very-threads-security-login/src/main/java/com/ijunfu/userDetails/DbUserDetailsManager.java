package com.ijunfu.userDetails;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ijunfu.entity.SysUser;
import com.ijunfu.mapper.SysUserMapper;
import jakarta.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.security.auth.login.AccountLockedException;
import java.util.Objects;
import java.util.Vector;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/15 14:21
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */

public class DbUserDetailsManager implements UserDetailsManager, UserDetailsPasswordService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    /**
     * @Title  : 判断用户是否存在
     *
     * @Param	: username 用户名
     * @Return : boolean
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/16 14:38
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    @Override
    public boolean userExists(String username) {
        return Objects.nonNull(
                getSysUser(username)
        );
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = getSysUser(username);

        if(Objects.isNull(sysUser)) {
            throw new UsernameNotFoundException("用户不存在");
        }

        if(Boolean.FALSE.equals(sysUser.getEnabled())) {
            throw new UsernameNotFoundException("用户已被禁用");
        }

        Vector<GrantedAuthority> authorities = new Vector<>();
        return new User(
                sysUser.getUsername(),
                sysUser.getPassword(),
                sysUser.getEnabled(),
                true,   // 用户账号是否过期
                true,   // 用户凭证是否过期
                true,   // 用户是否未被锁定
                authorities
        );
    }

    /**
     * @Title  : 根据用户名获取用户
     *
     * @Param	: username
     * @Return : com.ijunfu.entity.SysUser
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/16 14:37
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    private SysUser getSysUser(String username) {
        return sysUserMapper.selectOne(
                Wrappers.lambdaQuery(SysUser.class)
                        .eq(SysUser::getUsername, username)
        );
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        return null;
    }
}
