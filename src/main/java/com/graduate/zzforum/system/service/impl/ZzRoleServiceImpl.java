package com.graduate.zzforum.system.service.impl;

import com.graduate.zzforum.system.entity.ZzRole;
import com.graduate.zzforum.system.dao.ZzRoleDao;
import com.graduate.zzforum.system.service.ZzRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author me
 * @since 2020-04-08
 */
@Service
public class ZzRoleServiceImpl extends ServiceImpl<ZzRoleDao, ZzRole> implements ZzRoleService {
    private final ZzRoleDao zzRoleDao;

    public ZzRoleServiceImpl(ZzRoleDao zzRoleDao) {
        this.zzRoleDao = zzRoleDao;
    }

    @Override
    public ZzRole getRole(ZzRole zzRole) {
        return zzRoleDao.findZzRole(zzRole);
    }

    @Override
    public ZzRole getRoleWithMenu(ZzRole zzRole) {
        return zzRoleDao.findZzRoleWithMenu(zzRole);
    }
}
