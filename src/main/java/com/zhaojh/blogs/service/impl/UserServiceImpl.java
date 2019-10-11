package com.zhaojh.blogs.service.impl;

import com.zhaojh.blogs.dao.IUserDao;
import com.zhaojh.blogs.pojo.User;
import com.zhaojh.blogs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户的业务层
 */

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    /**
     * 用户的账号的唯一性校验
     * @param account 账号
     * @return success/fail
     */

    @Override
    public String uniqueAccount(String account){
        String accountIsUse = userDao.findByAccount(account);
        if(accountIsUse!=null&&!"".equals(accountIsUse)){
            return "fail";
        }
        return "success";
    }

    /**
     * 用户注册
     * @param user 用户
     * @return string
     */

    @Transactional
    @Override
    public String register(User user){
        User save = userDao.save(user);
        if(user.getId()!=null&&!"".equals(user.getId())){
            return "success";
        }
        return "fail";
    }

    /**
     * 查询用户是否存在，可以是account、手机号
     * @param account 用户账号
     * @param phone_number 用户手机号
     * @return user
     */
    @Override
    public User findByAccount(String account,String phone_number){
        Specification<User> spec= new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                //拼装多条件查询
                List<Predicate> predicateList = new ArrayList<>();

                if(account!=null&&"".equals(account)){
                    Path<Object> account1 = root.get("account");
                    predicateList.add(cb.equal(account1.as(String.class),account));
                }
                if(phone_number!=null&&"".equals(phone_number)){
                    Path<Object> phoneNumber = root.get("phoneNumber");
                    predicateList.add(cb.equal(phoneNumber.as(String.class),phone_number));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        List<User> all = userDao.findAll(spec);
        if(all.size()>0){
            return all.get(1);
        }
        return null;
    }

    /**
     * 用户登录
     * @param account 账号
     * @param password 密码
     * @return user
     */
    @Override
    public User loginUserInfo(String account, String password){
        return null;
    }



}
