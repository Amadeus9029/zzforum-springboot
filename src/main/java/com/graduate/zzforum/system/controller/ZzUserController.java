package com.graduate.zzforum.system.controller;


import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.graduate.zzforum.system.dao.ZzMenuDao;
import com.graduate.zzforum.system.entity.*;
import com.graduate.zzforum.system.entity.vo.JwtUser;
import com.graduate.zzforum.system.entity.vo.ZzResourceVo;
import com.graduate.zzforum.system.service.ZzPermissionService;
import com.graduate.zzforum.system.service.ZzResourceService;
import com.graduate.zzforum.system.service.ZzRoleService;
import com.graduate.zzforum.system.service.ZzUserService;
import com.graduate.zzforum.system.service.dto.ZzResourceDto;
import com.graduate.zzforum.system.service.mapper.ZzResourceMapper;
import com.graduate.zzforum.system.service.mapper.ZzUserMapper;
import com.graduate.zzforum.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author me
 * @since 2020-04-08
 */
@RestController
public class ZzUserController {
    @Value("${rsa.private_key}")
    private String privateKey;
    private final ZzUserService zzUserService;
    private final ZzRoleService zzRoleService;
    private final ZzPermissionService zzPermissionService;
    private final ZzResourceService zzResourceService;
    private final ZzUserMapper zzUserMapper;
    private final ZzResourceMapper zzResourceMapper;
    final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final AuthenticationManager authenticationManager;
    private final ZzMenuDao zzMenuDao;

    public ZzUserController(ZzUserService zzUserService,
                            ZzRoleService zzRoleService,
                            ZzResourceService zzResourceService,
                            ZzPermissionService zzPermissionService,
                            @Qualifier("zzUserMapperImpl") ZzUserMapper zzUserMapper,
                            @Qualifier("zzResourceMapperImpl") ZzResourceMapper zzResourceMapper,
                            AuthenticationManagerBuilder authenticationManagerBuilder,
                            ZzMenuDao zzMenuDao,
                            @Qualifier(BeanIds.AUTHENTICATION_MANAGER) AuthenticationManager authenticationManager) {
        this.zzUserService = zzUserService;
        this.zzRoleService = zzRoleService;
        this.zzPermissionService = zzPermissionService;
        this.zzResourceService = zzResourceService;
        this.zzUserMapper = zzUserMapper;
        this.zzMenuDao = zzMenuDao;
        this.zzResourceMapper = zzResourceMapper;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.authenticationManager = authenticationManager;
    }

    @RequestMapping("/list")
    public ZzUser ZzUserList() {
        ZzUser zzUser = new ZzUser("admin");
        return zzUserService.getUser(zzUser);
    }
    @RequestMapping("/menuList")
    public List<ZzMenu> ZzMenuList() {
        ZzMenu zzMenu = new ZzMenu("系统管理");
        return zzMenuDao.selectList(null);
    }
    @RequestMapping("/roleList")
    public ZzRole ZzRoleList() {
        ZzRole zzRole = new ZzRole("普通用户");
        return zzRoleService.getRoleWithMenu(zzRole);
    }
    @RequestMapping("/permissionList")
    public ZzPermission ZzPermissionList() {
        ZzPermission zzPermission = new ZzPermission("/content");
        return zzPermissionService.getZzPermission(zzPermission);
    }
    @RequestMapping("/treeResource")
    public ResponseEntity<List<ZzResourceVo>> ZZResourceTree(@RequestBody ZzUser zzUser) {
        List<ZzResource> resource = zzResourceService.treeResourceByUserId(zzUser.getId());
        List<ZzResourceDto> resourceDto = zzResourceMapper.toDto(resource);
        List<ZzResourceDto> resourceTree = zzResourceService.buildTree(resourceDto);
        List<ZzResourceVo> resourceVo = zzResourceMapper.toVo(resourceTree);
        return ResponseEntity.ok(resourceVo);
    }
    @RequestMapping("/addUser")
    public String addZZUser() {
        return "addSuccessful";
    }
    @RequestMapping("/login")
    public ResponseEntity login(@RequestBody ZzUser user) {
        Map<String,Object> map = new HashMap<>();
        RSA rsa = new RSA(privateKey,null);
        String password = new String(rsa.decrypt(user.getPassword(), KeyType.PrivateKey));
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(user.getUsername(),password);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        map.put("username",user.getUsername());
        String token = JwtUtil.createToken(user.getUsername(),map);
        JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
        Map<String,Object> res = new HashMap<>();
        res.put("token",token);
        res.put("user",jwtUser);
        res.put("message","Successful");
        return ResponseEntity.ok(res);
    }
    @RequestMapping("/register")
    public ResponseEntity register(@RequestBody ZzUser user) {
        ZzUser getUser = zzUserService.getUser(user);
        if(getUser == null){
            zzUserService.addUser(user);
            Map<String,Object> map = new HashMap<>();
            map.put("name",getUser.getUsername());
            map.put("password",getUser.getPassword());
            String token = JwtUtil.createToken(getUser.getUsername(), map);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.ok("注册失败");
    }
}

