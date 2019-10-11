package com.zhaojh.blogs.dao;

import com.zhaojh.blogs.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {

    /**
     * 用户账号的唯一性校验
     * @param account
     * @return
     */
    @Query(value = "select account from blog_user where account=?1",nativeQuery = true)
    String findByAccount(String account);


}
