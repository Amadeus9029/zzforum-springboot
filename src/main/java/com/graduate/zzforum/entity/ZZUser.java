package com.graduate.zzforum.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * ZZUser
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("zz_user")
public class ZZUser implements Serializable{
    @TableId
    private Long id;
    private String name;
    private String password;
    private Date createTime;
}