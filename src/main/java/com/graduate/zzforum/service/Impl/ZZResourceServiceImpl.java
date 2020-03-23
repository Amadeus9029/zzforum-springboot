package com.graduate.zzforum.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduate.zzforum.dao.ZZResourceDao;
import com.graduate.zzforum.entity.ZZResource;
import com.graduate.zzforum.service.ZZResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZZResourceServiceImpl implements ZZResourceService {
    @Autowired
    ZZResourceDao zzResourceDao;
    @Override
    public List<ZZResource> treeResourceByUserId(Long id) {
        QueryWrapper<ZZResource> query = new QueryWrapper<>();
        query.eq("user_id",id);
        return zzResourceDao.selectList(query);
    }
}
