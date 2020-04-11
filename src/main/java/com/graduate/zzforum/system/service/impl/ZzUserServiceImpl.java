package com.graduate.zzforum.system.service.impl;

import com.graduate.zzforum.system.entity.ZzUser;
import com.graduate.zzforum.system.dao.ZzUserDao;
import com.graduate.zzforum.system.service.ZzUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author me
 * @since 2020-04-08
 */
@Service
public class ZzUserServiceImpl extends ServiceImpl<ZzUserDao, ZzUser> implements ZzUserService {
    private final ZzUserDao zzUserDao;

    public ZzUserServiceImpl(ZzUserDao zzUserDao) {
        this.zzUserDao = zzUserDao;
    }

    @Override
    public List<ZzUser> listUser() {
        return zzUserDao.selectList(null);
    }

    @Override
    public ZzUser getUser(ZzUser user) {
        return zzUserDao.findZzUser(user);
    }

    @Override
    public void addUser(ZzUser user) {
        zzUserDao.insert(user);
    }

    @Override
    public void removeUser(int id) {
        zzUserDao.deleteById(id);
    }
}
