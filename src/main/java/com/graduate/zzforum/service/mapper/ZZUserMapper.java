package com.graduate.zzforum.service.mapper;

import com.graduate.zzforum.entity.ZZUser;
import com.graduate.zzforum.service.dto.ZZUserDto;
import org.mapstruct.Mapper;


@Mapper(componentModel="spring")
public interface ZZUserMapper{
    ZZUser toEntity(ZZUserDto zzUserDto);
    ZZUserDto toDto(ZZUser zzUser);
}
