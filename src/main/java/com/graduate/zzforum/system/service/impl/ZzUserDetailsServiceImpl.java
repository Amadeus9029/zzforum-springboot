package com.graduate.zzforum.system.service.impl;

import com.graduate.zzforum.system.entity.ZzUser;
import com.graduate.zzforum.system.entity.vo.JwtUser;
import com.graduate.zzforum.system.service.ZzUserService;
import com.graduate.zzforum.system.service.mapper.ZzUserMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ZzUserDetailsServiceImpl implements UserDetailsService {
    private final ZzUserService zzUserService;
    private final ZzUserMapper zzUserMapper;

    public ZzUserDetailsServiceImpl(ZzUserService zzUserService, @Qualifier("zzUserMapperImpl") ZzUserMapper zzUserMapper) {
        this.zzUserService = zzUserService;
        this.zzUserMapper = zzUserMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ZzUser user = new ZzUser(s);
        ZzUser zzUser = zzUserService.getUser(user);
        if(zzUser==null){
            throw new UsernameNotFoundException("账号不存在");
        }
        JwtUser jwtUser = zzUserMapper.toJwt(zzUser);

        return jwtUser;
    }
}
