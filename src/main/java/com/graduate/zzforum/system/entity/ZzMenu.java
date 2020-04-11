package com.graduate.zzforum.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

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
@ApiModel(value="ZzMenu对象", description="")
@NoArgsConstructor
@AllArgsConstructor
@TableName("menu")
public class ZzMenu implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private Long sort = 999L;

    private String path;

    private String component;

    /** 类型，目录、菜单、按钮 */
    private Integer type;

    /** 权限 */
    private String permission;

    private String componentName;

    private String icon;

    private Boolean cache;

    private Boolean hidden;

    /** 上级菜单ID */
    private Long pid;

    /** 是否为外链 true/false */
    private Boolean iFrame;
    @TableField(exist = false)
    private Set<ZzRole> roles;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public @interface Update {}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ZzMenu menu = (ZzMenu) o;
        return Objects.equals(id, menu.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public ZzMenu(String name) {
        this.name = name;
    }
}

