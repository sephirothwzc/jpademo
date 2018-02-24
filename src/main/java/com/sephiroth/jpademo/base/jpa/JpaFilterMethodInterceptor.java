package com.sephiroth.jpademo.base.jpa;

import lombok.val;
import org.apache.shiro.aop.MethodInterceptor;
import org.apache.shiro.aop.MethodInvocation;
import org.springframework.data.repository.core.RepositoryInformation;


/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 10:41 2018/2/23
 * @Modified By:
 */
public class JpaFilterMethodInterceptor implements MethodInterceptor{

    public JpaFilterMethodInterceptor(RepositoryInformation repositoryInformation){
        val iterable = repositoryInformation.getQueryMethods().iterator();

    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // 执行方法获得结果
        Object obj = methodInvocation.proceed();
        return obj;
    }
}
