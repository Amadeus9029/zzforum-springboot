package com.graduate.zzforum.system.service;

import com.graduate.zzforum.system.entity.ZzResource;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduate.zzforum.system.service.dto.ZzResourceDto;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author me
 * @since 2020-04-08
 */
public interface ZzResourceService extends IService<ZzResource> {
    List<ZzResource> treeResourceByUserId(Long id);
    List<ZzResourceDto> buildTree(List<ZzResourceDto> zzResourceDtos);
}
