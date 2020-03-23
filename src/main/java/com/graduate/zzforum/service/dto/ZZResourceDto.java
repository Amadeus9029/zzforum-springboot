package com.graduate.zzforum.service.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ZZResourceDto implements Serializable {
    private Long id;
    private Long parent_id;
    private Long user_id;
    private String name;
    private String type;
    private String value;
    private String path;
    private String icon;
    private List<ZZResourceDto> children;
    private Date create_time;
    private Date update_time;
}
