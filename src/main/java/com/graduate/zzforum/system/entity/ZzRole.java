package com.graduate.zzforum.system.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author me
 * @since 2020-04-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ZzRole对象", description="")
@NoArgsConstructor
@AllArgsConstructor
@TableName("role")
public class ZzRole implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;
    private String remark;
    private Integer level;
    private String permission;
    private String dataScope;
    @TableField(exist = false)
    private List<ZzUser> users;
    @TableField(exist = false)
    private List<ZzMenu> menus;
    @TableField(exist = false)
    private List<ZzPermission> permissions;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public ZzRole(String name) {
        this.name = name;
    }

}
