package com.zhaojh.blogs;

import com.zhaojh.blogs.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BlogsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogsApplication.class, args);
    }

    //添加雪花算法
    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }

    //实现加密
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
