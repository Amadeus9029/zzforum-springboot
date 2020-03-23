package com.graduate.zzforum.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ZZResourceVo implements Serializable {
    private Long id;
    private String name;
    private String type;
    private String value;
    private String path;
    private String icon;
    private List<ZZResourceVo> children;
    private Date create_time;
    private Date update_time;
}
