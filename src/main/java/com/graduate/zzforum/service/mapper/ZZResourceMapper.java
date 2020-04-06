package com.graduate.zzforum.service.mapper;

import com.graduate.zzforum.entity.ZZResource;
import com.graduate.zzforum.entity.vo.ZZResourceVo;
import com.graduate.zzforum.service.dto.ZZResourceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface ZZResourceMapper {
    ZZResource toEntity(ZZResourceDto zzResourceDto);
    ZZResourceDto toDto(ZZResource zzResource);
    ZZResourceVo toVo(ZZResourceDto zzResourceDto);
    List<ZZResource> toEntity(List<ZZResourceDto> zzResourceDtos);
    List<ZZResourceDto> toDto(List<ZZResource> zzResource);
    List<ZZResourceVo> toVo(List<ZZResourceDto> zzResourceDtos);
}
