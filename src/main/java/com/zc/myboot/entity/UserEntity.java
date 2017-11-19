package com.zc.myboot.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: zc
 * @date: 2017/11/17
 */
@Entity
@Table(name = "t_user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue
//    @Column(name = "id")
    private Long id;

//    @Column(name = "name")
    private String name;

//    @Column(name ="age")
    private Integer age;

//    @Column(name = "address")
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
