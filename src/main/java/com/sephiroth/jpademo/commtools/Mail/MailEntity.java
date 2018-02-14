package com.sephiroth.jpademo.commtools.Mail;

import lombok.Data;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 吴占超
 * @Description: java邮件对象
 * @Date: Create in 22:29 2018/2/6
 * @Modified By:
 */
@Data
public class MailEntity implements Serializable {
    // smtp 服务器
    private String smtpService;
    // smtp 端口
    private String smtpPort;
    // 发送邮件地址
    private String fromMailAddress;
    // 发送邮件账户密码
    private String fromMailsmtpPWD;
    // 邮件标题
    private String title;
    // 邮件内容
    private String content;
    // 内容格式
    private String contentType;
    // 收件地址
    private List<String> list = new ArrayList<>();

}
