package com.graduate.zzforum;


import com.graduate.zzforum.dao.ZZUserDao;
import com.graduate.zzforum.utils.JwtUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class zzforumApplicationTests {
	@Autowired
	public ZZUserDao zzUserDao;
	@Test
	public void contextLoads() {
		Long num = Long.parseLong("2");
		System.out.println(zzUserDao.toString());
	}

}
