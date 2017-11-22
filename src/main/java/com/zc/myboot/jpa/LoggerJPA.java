package com.zc.myboot.jpa;

import com.zc.myboot.entity.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @description:
 * @author: Zhangc
 * @date: 2017/11/22
 */

public interface LoggerJPA extends JpaRepository<LoggerEntity,Long>,JpaSpecificationExecutor<LoggerEntity>,Serializable {
}
