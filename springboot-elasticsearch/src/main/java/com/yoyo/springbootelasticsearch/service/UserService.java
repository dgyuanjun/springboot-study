package com.yoyo.springbootelasticsearch.service;

import com.yoyo.springbootelasticsearch.bean.User;
import com.yoyo.springbootelasticsearch.repository.UserRepository;
import org.apache.lucene.search.FuzzyQuery;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.search.MatchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @create 2019/7/30-23:33
 * @DESCRIPTION
 */
@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    /**
     * 创建文档
     *
     * @param user
     */
    public void save(User user) {
        userRepository.save(user);
        System.out.println("新增成功");
    }

    /**
     * 查找
     */
    public void delete(Integer id) {
        userRepository.deleteById(id);
        System.out.println("删除成功");
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        Iterable<User> iterable = userRepository.findAll();
        iterable.forEach(u -> {
            System.out.println(u);
            users.add(u);
        });
        return users;
    }

    public List<User> findByName(String userName) {
        List<User> users = new ArrayList<>();
        FuzzyQueryBuilder fuzzyQuery = QueryBuilders.fuzzyQuery("userName", userName);
        Iterable<User> iterable = userRepository.search(fuzzyQuery);
        iterable.forEach(users::add);
        return users;
    }
}
