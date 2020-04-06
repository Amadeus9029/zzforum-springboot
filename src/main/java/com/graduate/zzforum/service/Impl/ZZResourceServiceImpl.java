package com.graduate.zzforum.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduate.zzforum.dao.ZZResourceDao;
import com.graduate.zzforum.entity.ZZResource;
import com.graduate.zzforum.service.ZZResourceService;
import com.graduate.zzforum.service.dto.ZZResourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<ZZResourceDto> buildTree(List<ZZResourceDto> zzResourceDtos) {
        List<ZZResourceDto> tree = new ArrayList<>();
        for(ZZResourceDto resource : zzResourceDtos){
            if(resource.getParentId()==0){
                tree.add(resource);
            }
            List<ZZResourceDto> children = new ArrayList<>();
            for(ZZResourceDto child : zzResourceDtos){
                if(child.getParentId()==resource.getId()){
                    children.add(child);
                }
            }
            resource.setChildren(children);
        }
        return tree;
    }
}
