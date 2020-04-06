package com.graduate.zzforum.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    private String username;
    private String password;
    private Date createTime;

    public ZZUser(String username){
        this.username=username;
    }
}