package com.sephiroth.jpademo;

import com.sephiroth.jpademo.interceptor.LoggerInterceptor;
import com.sephiroth.jpademo.interceptor.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: 吴占超
 * @Description: 注册拦截器
 * @Date: Create in 23:06 2018/2/5
 * @Modified By:
 */
@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
    }
}
