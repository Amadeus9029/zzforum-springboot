package com.graduate.zzforum.service.mapper;

import com.graduate.zzforum.entity.ZZResource;
import com.graduate.zzforum.service.dto.ZZResourceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface ZZResourceMapper {
    ZZResource toEntity(ZZResourceDto zzResourceDto);
    ZZResourceDto toDto(ZZResource zzResource);
}
