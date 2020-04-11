package com.graduate.zzforum.system.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ZzUserDto implements Serializable {
    private Long id;
    private String name;
    private String password;
}
