package com.graduate.zzforum.service;

import com.graduate.zzforum.entity.ZZResource;

import java.util.List;

public interface ZZResourceService {
    List<ZZResource> treeResourceByUserId(Long id);
}
