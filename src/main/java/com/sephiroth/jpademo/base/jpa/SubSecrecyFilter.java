package com.sephiroth.jpademo.base.jpa;

import lombok.val;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Author: 吴占超
 * @Description: jpa自定义拦截
 * @Date: Create in 13:31 2018/2/24
 * @Modified By:
 */
public abstract class SubSecrecyFilter {
    public static Object dofilter(MethodInvocation Invocation) throws Throwable {
        val args = Invocation.getArguments();
        val q = Invocation.getThis();
        val x = Invocation.getMethod();

        System.out.println(args);
        Object obj=Invocation.proceed();
        return obj;
    }
}
