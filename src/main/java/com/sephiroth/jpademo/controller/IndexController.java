package com.sephiroth.jpademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 21:28 2018/2/5
 * @Modified By:
 */
@Controller
@RequestMapping(value = "/home")
public class IndexController {

    /**
     *  @Author: 吴占超
     *  @Description:
     *  @Date:  21:33 2018/2/5
     *  @return 登陆页
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     *  @Author: 吴占超
     *  @Description:
     *  @Date:  21:34 2018/2/5
     *  @return 主页
     */
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
