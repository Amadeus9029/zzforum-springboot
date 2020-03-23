package com.graduate.zzforum.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("zz_resource")
public class ZZResource implements Serializable {
    @TableId
    private Long id;
    private Long parent_id;
    private Long user_id;
    private String name;
    private String type;
    private String value;
    private String path;
    private String icon;
    @Nullable
    private Date create_time;
    @Nullable
    private Date update_time;
}
