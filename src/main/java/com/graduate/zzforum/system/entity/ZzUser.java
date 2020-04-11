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
@ApiModel(value="ZzUser对象", description="")
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class ZzUser implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long avatarId;
//    private Long deptId;
//    private Long jobId;

    private String username;
//    private String nickName;
    private String password;
//    private String email;
    private String sex;
//    private Date lastPasswordResetTime;

    @TableField(exist = false)
    private ZzRole role;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @TableLogic
    private Integer enabled;

    public ZzUser(String username){
        this.username=username;
    }
}
