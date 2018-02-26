package com.sephiroth.jpademo.base.jpa;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.support.RepositoryProxyPostProcessor;

/**
 * @Author: 吴占超
 * @Description: 声明拦截委托
 * @Date: Create in 13:32 2018/2/24
 * @Modified By:
 */
public class SecurecyPostProcessor implements RepositoryProxyPostProcessor {

    @Override
    public void postProcess(ProxyFactory factory, RepositoryInformation repositoryInformation) {
        factory.addAdvice(SecurecyAdvice.instance);
    }

    static enum SecurecyAdvice implements MethodInterceptor {
        instance;
        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            return SubSecrecyFilter.dofilter(invocation);
        }
    }
}
