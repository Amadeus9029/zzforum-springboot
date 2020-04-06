package com.graduate.zzforum.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
    private Long parentId;
    private Long userId;
    private String name;
    private String type;
    private String value;
    private String path;
    private String icon;
    private Date createTime;
    private Date updateTime;
}
