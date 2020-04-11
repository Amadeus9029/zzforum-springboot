package com.graduate.zzforum.system.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ZzResourceVo implements Serializable {
    private Long id;
    private String name;
    private String type;
    private String value;
    private String path;
    private String icon;
    private List<ZzResourceVo> children;
    private Date createTime;
    private Date updateTime;
}
