package com.graduate.zzforum.service.Impl;

import java.util.List;

import com.graduate.zzforum.dao.ZZUserDao;
import com.graduate.zzforum.entity.ZZUser;
import com.graduate.zzforum.service.ZZUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ZZUserServiceImpl
 */
@Service
public class ZZUserServiceImpl implements ZZUserService {
    @Autowired
    ZZUserDao zzUserDao;
    @Override
    public List<ZZUser> listUser() {
        return zzUserDao.getZZUserList();
    }

    @Override
    public ZZUser getUser(ZZUser user) {
        return zzUserDao.findZZUser(user);
    }

    @Override
    public void addUser(ZZUser user) {
        zzUserDao.addZZUser(user);
    }

    @Override
    public void removeUser(int id) {
        zzUserDao.removeZZUserById(id);
    }
}