package com.graduate.zzforum.system.service;

import com.graduate.zzforum.system.entity.ZzPermission;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author me
 * @since 2020-04-08
 */
public interface ZzPermissionService extends IService<ZzPermission> {
    ZzPermission getZzPermission(ZzPermission zzPermission);
}
