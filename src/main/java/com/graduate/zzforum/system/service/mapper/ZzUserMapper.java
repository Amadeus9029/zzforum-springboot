package com.graduate.zzforum.system.service.mapper;

import com.graduate.zzforum.system.entity.ZzUser;
import com.graduate.zzforum.system.entity.vo.JwtUser;
import com.graduate.zzforum.system.service.dto.ZzUserDto;
import org.mapstruct.Mapper;


@Mapper(componentModel="spring")
public interface ZzUserMapper {
    ZzUser toEntity(ZzUserDto zzUserDto);
    ZzUserDto toDto(ZzUser zzUser);
    JwtUser toJwt(ZzUser zzUser);
}
