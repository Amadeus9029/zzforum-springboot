package com.graduate.zzforum.system.service.mapper;


import com.graduate.zzforum.system.entity.ZzResource;
import com.graduate.zzforum.system.entity.vo.ZzResourceVo;
import com.graduate.zzforum.system.service.dto.ZzResourceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface ZzResourceMapper {
    ZzResource toEntity(ZzResourceDto zzResourceDto);
    ZzResourceDto toDto(ZzResource zzResource);
    ZzResourceVo toVo(ZzResourceDto zzResourceDto);
    List<ZzResource> toEntity(List<ZzResourceDto> zzResourceDtos);
    List<ZzResourceDto> toDto(List<ZzResource> zzResource);
    List<ZzResourceVo> toVo(List<ZzResourceDto> zzResourceDtos);
}
