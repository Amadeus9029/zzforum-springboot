package com.graduate.zzforum.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ZZUserVo implements Serializable {
    private String name;
    private String password;
}
