package com.zc.myboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @description:
 * @author: Zhangc
 * @date: 2017/11/22
 */

@Entity
@Table(name = "logger_info")
public class LoggerEntity implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    //请求ip
    private String clientIp;
    //请求的路径
    private String uri;
    //请求的类型,普通或ajax
    private String type;
    //请求方法
    private String method;
    //请求参数json，
    private String paramData;
    //请求接口唯一标识
    private String sessionId;
    //请求时间
    private Timestamp time;
    //接口返回时间
    private String returnTime;
    //接口返回数据
    private String returnData;
    //请求状态
    private String httpStatusCode;
    //请求耗时秒单位
    private int timeConsuming;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public int getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(int timeConsuming) {
        this.timeConsuming = timeConsuming;
    }

    @Override
    public String toString() {
        return "LoggerEntity{" +
                "id=" + id +
                ", clientIp='" + clientIp + '\'' +
                ", uri='" + uri + '\'' +
                ", type='" + type + '\'' +
                ", method='" + method + '\'' +
                ", paramData='" + paramData + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", time=" + time +
                ", returnTime='" + returnTime + '\'' +
                ", returnData='" + returnData + '\'' +
                ", httpStatusCode='" + httpStatusCode + '\'' +
                ", timeConsuming=" + timeConsuming +
                '}';
    }
}
