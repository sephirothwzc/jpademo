package com.sephiroth.jpademo.commtools.Mail;

import com.sephiroth.jpademo.commtools.helper.PropertiesHelper;
import com.sephiroth.jpademo.commtools.helper.StringHelper;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.List;
import java.util.Properties;

/**
 * @Author: 吴占超
 * @Description: 邮件发送
 * @Date: Create in 22:35 2018/2/6
 * @Modified By:
 */
public class MailSend {
    // 邮件实体
    private MailEntity mailEntity = new MailEntity();

    // region 构造函数
    public MailSend(MailEntity mail) {
        this.mailEntity = mail;
    }
    // endregion

    /**
     *  @Author: 吴占超
     *  @Description: 设置标题
     *  @Date:  22:45 2018/2/6
     *  @param title 标题
     *  @return
     */
    public MailSend title(String title) {
        mailEntity.setTitle(title);
        return this;
    }

    /**
     *  @Author: 吴占超
     *  @Description: 设置内容
     *  @Date:  22:47 2018/2/6
     *  @param content
     *  @return
     *
     */
    public MailSend content(String content) {
        mailEntity.setContent(content);
        return this;
    }

    /**
     *  @Author: 吴占超
     *  @Description:
     *  @Date:  23:51 2018/2/6
     *  @param targets 收件人列表
     *  @return
     *
     */
    public MailSend targets(List<String> targets) {
        mailEntity.setList(targets);
        return this;
    }

    /**
     *  @Author: 吴占超
     *  @Description: 设置格式
     *  @Date:  09:52 2018/2/7
     *  @param typeEnum
     *  @return
     *
     */
    public MailSend contentType(MailContentTypeEnum typeEnum) {
        mailEntity.setContentType(typeEnum.getValue());
        return this;
    }

    /**
     *  @Author: 吴占超
     *  @Description: 执行发送 抛出异常
     *  @Date:  23:53 2018/2/6
     *  @return
     *
     */
    public void send() throws Exception {
        // 默认使用html发送
        if (null == mailEntity.getContentType()) {
            mailEntity.setContentType(MailContentTypeEnum.HTML.getValue());
        }
        if (StringHelper.IsNullOrEmpty(mailEntity.getTitle())) {
            throw new Exception("标题没有设置！");
        }
        if (StringHelper.IsNullOrEmpty(mailEntity.getContent())) {
            throw new Exception("标题没有设置！");
        }

        // region 构建邮件参数
        // 读取/resource/mail_zh_CN.properties
        final PropertiesHelper propertiesHelper = new PropertiesHelper("mail");
        // 创建Properties类用于记录邮箱的一些属性
        final Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        // SMTP服务器
        props.put("mail.smtp.host", propertiesHelper.getValue("mail.smtp.service"));
        // 端口号 qq邮箱 465/587
        props.put("mail.smtp.port", propertiesHelper.getValue("mail.smtp.port"));
        // 发送邮箱
        props.put("mail.user", propertiesHelper.getValue("mail.from.address"));
        // 设置发送邮箱的16位STMP口令
        props.put("mail.password", propertiesHelper.getValue("mail.from.stmp.pwd"));
        // endregion

        // 构建授权信息，用于进行 SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new javax.mail.PasswordAuthentication(userName, password);
            }
        };

        // 使用环境属性和授权信息，创建邮会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件信息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        String nickName = MimeUtility.encodeText(propertiesHelper.getValue("mail.from.nickname"));
        InternetAddress form = new InternetAddress(nickName + "<" + props.getProperty("mail.user") + ">");
        message.setFrom(form);

        // 设置邮件标题
        message.setSubject(mailEntity.getTitle());
        if (MailContentTypeEnum.HTML.getValue().equals(mailEntity.getContentType())) {
            message.setContent(mailEntity.getContent(), MailContentTypeEnum.HTML.getValue());
        } else if (MailContentTypeEnum.TEXT.getValue().equals(mailEntity.getContentType())) {
            message.setText(mailEntity.getContent());
        }

        // 发送邮箱地址
        mailEntity.getList().forEach(p->{
            try{
                // 设置收件人的邮箱
                InternetAddress to = new InternetAddress(p);
                message.setRecipient(Message.RecipientType.TO,to);
                // 发送
                Transport.send(message);
            } catch(Exception e){
                return;
            }
        });
    }

}
