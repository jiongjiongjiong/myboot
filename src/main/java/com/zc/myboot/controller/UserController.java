package com.zc.myboot.controller;

import com.zc.myboot.jpa.UserJPA;
import com.zc.myboot.entity.UserEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: zc
 * @date: 2017/11/17
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value ="/list", method = RequestMethod.GET)
    @ApiOperation(value="获取用户列表", notes="")
    public List<UserEntity> list(){
        return userJPA.findAll();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    public UserEntity save(UserEntity entity){
        return userJPA.save(entity);
    }

    @PatchMapping(value ="/delete")
    public List<UserEntity> delete(Long id){
        userJPA.delete(id);
        return userJPA.findAll();
    }

    @PostMapping(value = "/age")
    public List<UserEntity> age(){
        return userJPA.nativeQuery(20);
    }


    @PostMapping(value = "/deleteWhere")
    public String deleteWhere(){
        userJPA.deleteQuery("admin3","444");
        return "删除成功";
    }

    @PostMapping(value = "/cutpage")
    public List<UserEntity> cutPage(int page){
        UserEntity user = new UserEntity();
        user.setSize(2);
        user.setPage(page);
        user.setSord("desc");

        Sort.Direction sort_di = Sort.Direction.ASC.toString().equalsIgnoreCase(user.getSord()) ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = new Sort(sort_di, user.getSidx());

        PageRequest pageRequest = new PageRequest(user.getPage() - 1, user.getSize(),sort);
        return userJPA.findAll(pageRequest).getContent();
    }
}
