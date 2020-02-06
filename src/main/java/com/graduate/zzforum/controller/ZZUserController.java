package com.graduate.zzforum.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.graduate.zzforum.entity.ZZUser;
import com.graduate.zzforum.service.ZZUserService;
import com.graduate.zzforum.utils.jwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * ZZUserController
 */
@RestController
public class ZZUserController {
    @Autowired
    ZZUserService zzUserService;

    @RequestMapping("/list")
    public List<ZZUser> ZZUserList() {
        System.out.println("12346");
        System.out.println(zzUserService.listUser());
        return zzUserService.listUser();
    }

    @RequestMapping("/addUser")
    public String addZZUser() {
     
        return "addSuccessful";
    }
    @RequestMapping("/login")
    public String login(@RequestBody ZZUser user) {
        ZZUser getUser = zzUserService.getUser(user);
        if(getUser != null && getUser.getPassword().equals(user.getPassword())){
            Map<String,Object> map = new HashMap<>();
            map.put("name",getUser.getName());
            map.put("password",getUser.getPassword());
            String token = jwtUtil.createJwt(getUser.getName(), getUser.getPassword(), map);
            return token;
        }
        return "fail";
    }
}