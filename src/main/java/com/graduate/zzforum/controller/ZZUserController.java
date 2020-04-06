package com.graduate.zzforum.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.graduate.zzforum.entity.ZZResource;
import com.graduate.zzforum.entity.ZZUser;
import com.graduate.zzforum.entity.vo.JwtUser;
import com.graduate.zzforum.entity.vo.ZZResourceVo;
import com.graduate.zzforum.service.ZZResourceService;
import com.graduate.zzforum.service.ZZUserService;
import com.graduate.zzforum.service.dto.ZZResourceDto;
import com.graduate.zzforum.service.mapper.ZZResourceMapper;
import com.graduate.zzforum.service.mapper.ZZUserMapper;
import com.graduate.zzforum.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * ZZUserController
 */
@RestController
public class ZZUserController {
    @Autowired
    ZZUserService zzUserService;
    @Autowired
    ZZResourceService zzResourceService;
    @Autowired
    ZZUserMapper zzUserMapper;
    @Autowired
    ZZResourceMapper zzResourceMapper;
    @Autowired
    AuthenticationManagerBuilder authenticationManagerBuilder;
    @Autowired
    @Qualifier(BeanIds.AUTHENTICATION_MANAGER)
    AuthenticationManager authenticationManager;
    JwtUtil jwtUtil;
    @Value("${rsa.private_key}")
    private String privateKey;
    @RequestMapping("/list")
    public List<ZZUser> ZZUserList() {
        return zzUserService.listUser();
    }
    @RequestMapping("/treeResource")
    public ResponseEntity<List<ZZResourceVo>> ZZResourceTree(@RequestBody ZZUser zzUser) {
        List<ZZResource> resource = zzResourceService.treeResourceByUserId(zzUser.getId());
        List<ZZResourceDto> resourceDto = zzResourceMapper.toDto(resource);
        List<ZZResourceDto> resourceTree = zzResourceService.buildTree(resourceDto);
        List<ZZResourceVo> resourceVo = zzResourceMapper.toVo(resourceTree);
        return ResponseEntity.ok(resourceVo);
    }
    @RequestMapping("/addUser")
    public String addZZUser() {
        return "addSuccessful";
    }
    @RequestMapping("/login")
    public ResponseEntity login(@RequestBody ZZUser user) {
        Map<String,Object> map = new HashMap<>();
        RSA rsa = new RSA(privateKey,null);
        String password = new String(rsa.decrypt(user.getPassword(), KeyType.PrivateKey));
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(user.getUsername(),password);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        map.put("username",user.getUsername());
        String token = jwtUtil.createToken(user.getUsername(),map);
        JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
        Map<String,Object> res = new HashMap<>();
        res.put("token",token);
        res.put("user",jwtUser);
        res.put("message","Successful");
        return ResponseEntity.ok(res);
    }
    @RequestMapping("/register")
    public ResponseEntity register(@RequestBody ZZUser user) {
        ZZUser getUser = zzUserService.getUser(user);
        if(getUser == null){
            zzUserService.addUser(user);
            Map<String,Object> map = new HashMap<>();
            map.put("name",getUser.getUsername());
            map.put("password",getUser.getPassword());
            String token = jwtUtil.createToken(getUser.getUsername(), map);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.ok("注册失败");
    }
}