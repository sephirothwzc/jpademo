package com.sephiroth.jpademo;

import com.sephiroth.jpademo.interceptor.SessionInterceptor;
import org.omg.PortableInterceptor.InterceptorOperations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 23:06 2018/2/5
 * @Modified By:
 */
@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
    }
}
