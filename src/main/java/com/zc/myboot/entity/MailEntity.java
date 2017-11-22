package com.zc.myboot.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 发送邮件实体
 * @author: Zhangc
 * @date: 2017/11/22
 */

public class MailEntity implements Serializable {

    //发送邮件服务器
    private String smtpService;
    //端口号
    private String smtpPort;
    //发送者地址
    private String fromMailAddress;
    //发送密码
    private String fromMailSmtpPwd;
    //邮件标题
    private String title;
    //邮件内容
    private String content;
    //邮件类型
    private String contentType;
    //收件人地址
    private List<String> toMailAddress = new ArrayList<>();

    public String getSmtpService() {
        return smtpService;
    }

    public void setSmtpService(String smtpService) {
        this.smtpService = smtpService;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getFromMailAddress() {
        return fromMailAddress;
    }

    public void setFromMailAddress(String fromMailAddress) {
        this.fromMailAddress = fromMailAddress;
    }

    public String getFromMailSmtpPwd() {
        return fromMailSmtpPwd;
    }

    public void setFromMailSmtpPwd(String fromMailSmtpPwd) {
        this.fromMailSmtpPwd = fromMailSmtpPwd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public List<String> getToMailAddress() {
        return toMailAddress;
    }

    public void setToMailAddress(List<String> toMailAddress) {
        this.toMailAddress = toMailAddress;
    }
}
