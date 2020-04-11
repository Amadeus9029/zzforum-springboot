package com.graduate.zzforum.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduate.zzforum.system.entity.ZzResource;
import com.graduate.zzforum.system.dao.ZzResourceDao;
import com.graduate.zzforum.system.service.ZzResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduate.zzforum.system.service.dto.ZzResourceDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author me
 * @since 2020-04-08
 */
@Service
public class ZzResourceServiceImpl extends ServiceImpl<ZzResourceDao, ZzResource> implements ZzResourceService {
    private final ZzResourceDao zzResourceDao;

    public ZzResourceServiceImpl(ZzResourceDao zzResourceDao) {
        this.zzResourceDao = zzResourceDao;
    }

    @Override
    public List<ZzResource> treeResourceByUserId(Long id) {
        QueryWrapper<ZzResource> query = new QueryWrapper<>();
        query.eq("user_id",id);
        return zzResourceDao.selectList(query);
    }

    @Override
    public List<ZzResourceDto> buildTree(List<ZzResourceDto> zzResourceDtos) {
        List<ZzResourceDto> tree = new ArrayList<>();
        for(ZzResourceDto resource : zzResourceDtos){
            if(resource.getParentId()==0){
                tree.add(resource);
            }
            List<ZzResourceDto> children = new ArrayList<>();
            for(ZzResourceDto child : zzResourceDtos){
                if(child.getParentId()==resource.getId()){
                    children.add(child);
                }
            }
            resource.setChildren(children);
        }
        return tree;
    }
}
