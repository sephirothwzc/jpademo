package com.sephiroth.jpademo.interceptor;

import com.sephiroth.jpademo.iiteral.IiteralSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 吴占超
 * @Description: session 拦截
 * @Date: Create in 21:36 2018/2/5
 * @Modified By:
 */
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object o) throws Exception {
        // 登录不做拦截
        System.out.println(request.getRequestURI());
        if("/login/login".equals(request.getRequestURI())|| "/login/".equals(request.getRequestURI())) {
            return true;
        }
        Object obj = request.getSession().getAttribute(IiteralSession.user);
        if(null == obj) {
            response.sendRedirect("/login/");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest var1, HttpServletResponse var2, Object var3, ModelAndView var4) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest var1, HttpServletResponse var2, Object var3, Exception var4) throws Exception {

    }
}
