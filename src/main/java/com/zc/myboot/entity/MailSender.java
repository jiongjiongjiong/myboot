package com.zc.myboot.entity;

import com.zc.myboot.utils.MailContentTypeEnum;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: Zhangc
 * @date: 2017/11/22
 */

public class MailSender implements Serializable {
    private MailEntity mail = new MailEntity();

    /**
     * 设置邮件标题
     * @param title
     * @return
     */
    public MailSender title(String title){
        mail.setTitle(title);
        return this;
    }

    /**
     * 设置邮件内容
     * @param content
     * @return
     */
    public MailSender content(String content){
        mail.setContent(content);
        return this;
    }

    /**
     * 设置邮件格式
     * @param contentType
     * @return
     */
    public MailSender contentType(String contentType){
        mail.setContentType(contentType);
        return this;
    }

    /**
     * 设置收件人地址
     * @param targets
     * @return
     */
    public MailSender targets(List<String> targets){
        mail.setToMailAddress(targets);
        return this;
    }

    public void send() throws Exception{
        //默认使用html发送
        if ( mail.getContentType() == null ){
            mail.setContentType(MailContentTypeEnum.HTML.getValue());
        }

        if (mail.getTitle() == null || mail.getTitle().trim().length() == 0){
            throw new Exception("邮件标题未设置");
        }

        if ( mail.getContent() == null || mail.getContent().trim().length() == 0){
            throw new Exception("邮件内容未设置");
        }

        if ( mail.getToMailAddress().isEmpty() ){
            throw new Exception("收件人未设置");
        }


    }
}
