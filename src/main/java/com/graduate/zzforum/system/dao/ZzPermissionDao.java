package com.graduate.zzforum.system.dao;

import com.graduate.zzforum.system.entity.ZzPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author me
 * @since 2020-04-08
 */
@Repository
public interface ZzPermissionDao extends BaseMapper<ZzPermission> {
    ZzPermission findZzPermission(ZzPermission zzPermission);
}
