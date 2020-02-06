package com.graduate.zzforum.service;

import java.util.List;

import com.graduate.zzforum.entity.ZZUser;

/**
 * ZZUserService
 */

public interface ZZUserService {
    List<ZZUser> listUser();
    ZZUser getUser(ZZUser user);
    void addUser(ZZUser user);
    void removeUser(int id);
}