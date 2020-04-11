package com.graduate.zzforum.system.service.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ZzResourceDto implements Serializable {
    private Long id;
    private Long parentId;
    private Long userId;
    private String name;
    private String type;
    private String value;
    private String path;
    private String icon;
    private List<ZzResourceDto> children;
    private Date createTime;
    private Date updateTime;
}
