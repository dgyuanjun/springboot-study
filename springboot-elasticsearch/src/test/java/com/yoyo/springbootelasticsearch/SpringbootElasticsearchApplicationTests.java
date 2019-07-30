package com.yoyo.springbootelasticsearch;

import com.yoyo.springbootelasticsearch.bean.User;
import com.yoyo.springbootelasticsearch.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.yoyo.springbootelasticsearch")
public class SpringbootElasticsearchApplicationTests {

	@Resource
	private UserService userService;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testSave(){
		User user = new User();
		user.setId(1);
		user.setUserName("yoyo");
		user.setPassword("123456");
		userService.save(user);
	}

	@Test
	public void testFindAll(){
		userService.findAll().forEach(System.out::println);
	}

	@Test
	public void testFindByName(){
		userService.findByName("yoyo").forEach(System.out::println);
	}

}
