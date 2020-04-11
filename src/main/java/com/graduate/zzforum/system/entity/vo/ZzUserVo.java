package com.graduate.zzforum.system.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ZzUserVo implements Serializable {
    private String name;
    private String password;
}
