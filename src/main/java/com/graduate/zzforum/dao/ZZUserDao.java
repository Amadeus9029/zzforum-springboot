package com.graduate.zzforum.dao;

import java.util.List;

import com.graduate.zzforum.entity.ZZUser;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * ZZUserDao
 */
@Mapper
@Repository
public interface ZZUserDao {
    List<ZZUser> getZZUserList();
    ZZUser findZZUser(ZZUser user);
    void addZZUser(ZZUser user);
    void removeZZUserById(int id);
}