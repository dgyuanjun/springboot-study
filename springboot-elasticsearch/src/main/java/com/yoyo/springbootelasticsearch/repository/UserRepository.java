package com.yoyo.springbootelasticsearch.repository;


import com.yoyo.springbootelasticsearch.bean.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Administrator
 * @create 2019/7/30-23:33
 * @DESCRIPTION
 */
public interface UserRepository extends ElasticsearchRepository<User, Integer> {
}
