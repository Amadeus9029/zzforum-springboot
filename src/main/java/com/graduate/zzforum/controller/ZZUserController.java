package com.graduate.zzforum.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.graduate.zzforum.entity.ZZResource;
import com.graduate.zzforum.entity.ZZUser;
import com.graduate.zzforum.service.ZZResourceService;
import com.graduate.zzforum.service.ZZUserService;
import com.graduate.zzforum.service.dto.ZZUserDto;
import com.graduate.zzforum.service.mapper.ZZUserMapper;
import com.graduate.zzforum.utils.jwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


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

    @RequestMapping("/list")
    public List<ZZUser> ZZUserList() {
        return zzUserService.listUser();
    }
    @RequestMapping("/treeResource")
    public ResponseEntity<List<ZZResource>> ZZResourceTree(@RequestBody ZZUser zzUser) {
        return ResponseEntity.ok(zzResourceService.treeResourceByUserId(zzUser.getId()));
    }
    @RequestMapping("/addUser")
    public String addZZUser() {
        return "addSuccessful";
    }
    @RequestMapping("/login")
    public ResponseEntity login(@RequestBody ZZUser user) {
        System.out.println(user);
        ZZUser getUser = zzUserService.getUser(user);
        System.out.println(getUser);
        if(getUser != null && getUser.getPassword().equals(user.getPassword())){
            Map<String,Object> map = new HashMap<>();
            map.put("name",getUser.getName());
            map.put("password",getUser.getPassword());
            String token = jwtUtil.createJwt(getUser.getName(), getUser.getPassword(), map);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.ok("登录失败");
    }
    @RequestMapping("/register")
    public ResponseEntity register(@RequestBody ZZUser user) {
        ZZUser getUser = zzUserService.getUser(user);
        if(getUser == null){
            zzUserService.addUser(user);
            Map<String,Object> map = new HashMap<>();
            map.put("name",getUser.getName());
            map.put("password",getUser.getPassword());
            String token = jwtUtil.createJwt(getUser.getName(), getUser.getPassword(), map);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.ok("注册失败");
    }
}