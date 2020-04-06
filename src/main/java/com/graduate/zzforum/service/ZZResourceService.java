package com.graduate.zzforum.service;

import com.graduate.zzforum.entity.ZZResource;
import com.graduate.zzforum.service.dto.ZZResourceDto;

import java.util.List;

public interface ZZResourceService {
    List<ZZResource> treeResourceByUserId(Long id);
    List<ZZResourceDto> buildTree(List<ZZResourceDto> zzResourceDtos);
}
