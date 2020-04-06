package com.graduate.zzforum.service.Impl;

import com.graduate.zzforum.entity.ZZUser;
import com.graduate.zzforum.entity.vo.JwtUser;
import com.graduate.zzforum.service.ZZUserService;
import com.graduate.zzforum.service.mapper.ZZUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ZZUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    ZZUserService zzUserService;
    @Autowired
    ZZUserMapper zzUserMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ZZUser user = new ZZUser(s);
        ZZUser zzUser = zzUserService.getUser(user);
        if(zzUser==null){
            throw new UsernameNotFoundException("账号不存在");
        }
        JwtUser jwtUser = zzUserMapper.toJwt(zzUser);
        return jwtUser;
    }
}
