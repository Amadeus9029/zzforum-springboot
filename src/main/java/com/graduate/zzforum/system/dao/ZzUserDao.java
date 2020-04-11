package com.graduate.zzforum.system.dao;

import com.graduate.zzforum.system.entity.ZzUser;
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
public interface ZzUserDao extends BaseMapper<ZzUser> {
    ZzUser findZzUser(ZzUser user);
}
