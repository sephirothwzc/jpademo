package com.sephiroth.jpademo.controller;

import com.sephiroth.jpademo.commtools.Mail.MailEntity;
import com.sephiroth.jpademo.commtools.Mail.MailSend;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 15:40 2018/2/7
 * @Modified By:
 */
@Controller
@RequestMapping(value = "/Mail")
public class MailController {

    @RequestMapping(value = "/send")
    @ResponseBody
    public String sendMail(MailEntity mail) {
        MailSend mailSend = new MailSend(mail);
        try{
            mailSend.send();
        }catch (Exception e){
            return e.getMessage();
        }
        return "mailsend";
    }
}
