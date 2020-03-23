package com.graduate.zzforum.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduate.zzforum.entity.ZZUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ZZUserDao
 */
@Repository
public interface ZZUserDao extends BaseMapper<ZZUser> {
//    List<ZZUser> getZZUserList();
    ZZUser findZZUser(ZZUser user);
//    void addZZUser(ZZUser user);
//    void removeZZUserById(int id);
}