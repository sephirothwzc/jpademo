package com.sephiroth.jpademo.base.jpa;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.support.RepositoryProxyPostProcessor;

/**
 * @Author: 吴占超
 * @Description: 自定义jpa拦截
 * @Date: Create in 10:19 2018/2/23
 * @Modified By:
 */
public class SecurecyPostProcessor implements RepositoryProxyPostProcessor {

    @Override
    public void postProcess(ProxyFactory proxyFactory, RepositoryInformation repositoryInformation) {
        proxyFactory.addAdvice();
    }
}
