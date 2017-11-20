package com.zc.myboot.controller;

import com.zc.myboot.jpa.UserJPA;
import com.zc.myboot.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;


/**
 * @author: zc
 * @date: 2017/11/21
 */
@RestController
@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    UserJPA userJPA;

    @RequestMapping(value = "/login")
    public String login(UserEntity user, HttpServletRequest request){
        boolean flag = true;
        String result = "登录成功";
        UserEntity userEntity = userJPA.findOne(new Specification<UserEntity>(){
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder){
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"), user.getName()));
                return null;
            }
        });

        if ( userEntity == null ){
            result = "用户不存在，登录失败";
        }else if( !userEntity.getPwd().equals(user.getPwd())){
            result = "用户密码不正确，登录失败";
        }

        if (flag){
            request.getSession().setAttribute("session_user", userEntity);
        }
        return result;
    }
}
