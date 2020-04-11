package com.graduate.zzforum.system.service;

import com.graduate.zzforum.system.entity.ZzUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author me
 * @since 2020-04-08
 */
public interface ZzUserService extends IService<ZzUser> {
    List<ZzUser> listUser();
    ZzUser getUser(ZzUser user);
    void addUser(ZzUser user);
    void removeUser(int id);
}
