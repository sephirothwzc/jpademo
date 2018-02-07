package com.sephiroth.jpademo.commtools.Mail;

/**
 * @Author: 吴占超
 * @Description: 邮件类型枚举
 * @Date: Create in 09:51 2018/2/7
 * @Modified By:
 */
public enum MailContentTypeEnum {
    HTML("text/html;charset=UTF-8"), //html格式
    TEXT("text")
    ;
    private String value;

    MailContentTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
