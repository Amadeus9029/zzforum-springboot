package com.graduate.zzforum.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ZZUser
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZZUser {
    private Long id;
    private String name;
    private String password;
    private Date create_time;
}