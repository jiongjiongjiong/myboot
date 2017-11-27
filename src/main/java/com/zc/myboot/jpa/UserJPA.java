package com.zc.myboot.jpa;

import com.zc.myboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * @author: zc
 * @date: 2017/11/18
 */
@Transactional
public interface UserJPA extends JpaRepository<UserEntity,Long>,JpaSpecificationExecutor<UserEntity>{

    @Query(value = "select * from t_user where age > ?1", nativeQuery = true)
    public List<UserEntity> nativeQuery(int age);

    @Modifying
    @Query(value = "delete from t_user where name=?1 and pwd=?2", nativeQuery = true)
    public void deleteQuery(String name,String pwd);
}
