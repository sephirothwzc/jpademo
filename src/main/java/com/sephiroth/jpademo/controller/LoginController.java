package com.sephiroth.jpademo.controller;

import com.sephiroth.jpademo.entity.E_SysUser;
import com.sephiroth.jpademo.iiteral.IiteralSession;
import com.sephiroth.jpademo.jpadao.JPA_SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 10:05 2018/2/5
 * @Modified By:
 */
@Controller
@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    private JPA_SysUser jpa_sysUser;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(E_SysUser user, HttpServletRequest request) {
        // 根据用户名查询用户是否存在
        E_SysUser sysUser = jpa_sysUser.findOne(new Specification<E_SysUser>() {
            @Override
            public Predicate toPredicate(Root<E_SysUser> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("username"),user.getUsername()));
                return null;
            }
        });
        if(null == sysUser) {
            return "用户名不存在！";
        }
        else if(!sysUser.getPassword().equals(user.getPassword())) {
            return "密码错误！";
        }
        request.getSession().setAttribute(IiteralSession.user,sysUser);
        return "登录成功";
    }
}
