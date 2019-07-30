package com.yoyo.springbootelasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.yoyo.springbootelasticsearch")
public class SpringbootElasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootElasticsearchApplication.class, args);
	}

}
