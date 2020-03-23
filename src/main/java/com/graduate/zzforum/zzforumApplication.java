package com.graduate.zzforum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.graduate.zzforum.dao")
public class zzforumApplication {
	public static void main(String[] args) {
		SpringApplication.run(zzforumApplication.class, args);
	}
}
