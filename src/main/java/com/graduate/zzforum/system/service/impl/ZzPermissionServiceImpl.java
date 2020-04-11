package com.graduate.zzforum.system.service.impl;

import com.graduate.zzforum.system.entity.ZzPermission;
import com.graduate.zzforum.system.dao.ZzPermissionDao;
import com.graduate.zzforum.system.service.ZzPermissionService;
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
public class ZzPermissionServiceImpl extends ServiceImpl<ZzPermissionDao, ZzPermission> implements ZzPermissionService {
    private final ZzPermissionDao zzPermissionDao;

    public ZzPermissionServiceImpl(ZzPermissionDao zzPermissionDao) {
        this.zzPermissionDao = zzPermissionDao;
    }

    @Override
    public ZzPermission getZzPermission(ZzPermission zzPermission) {
        return zzPermissionDao.findZzPermission(zzPermission);
    }
}
