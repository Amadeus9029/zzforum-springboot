package com.graduate.zzforum.system.dao;

import com.graduate.zzforum.system.entity.ZzRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduate.zzforum.system.entity.ZzUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author me
 * @since 2020-04-08
 */
@Repository
public interface ZzRoleDao extends BaseMapper<ZzRole> {
    ZzRole findZzRole(ZzRole role);
    ZzRole findZzRoleWithMenu(ZzRole role);
}
