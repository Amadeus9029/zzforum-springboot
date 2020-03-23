package com.graduate.zzforum.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ZZUserDto implements Serializable {
    private Long id;
    private String name;
    private String password;
}
