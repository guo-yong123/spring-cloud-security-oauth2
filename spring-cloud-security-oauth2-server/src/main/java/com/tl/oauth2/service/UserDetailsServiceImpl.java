package com.tl.oauth2.service;

import com.tl.oauth2.domain.CapUser;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CapUserService capUserService;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        CapUser capUser = capUserService.getUserByUserId(username);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (capUser != null) {
//            查询用户所有角色
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
            grantedAuthorities.add(grantedAuthority);
        }
        // 由框架完成认证工作
        return new User(capUser.getUserId(), capUser.getUserPassword(), grantedAuthorities);
    }
}