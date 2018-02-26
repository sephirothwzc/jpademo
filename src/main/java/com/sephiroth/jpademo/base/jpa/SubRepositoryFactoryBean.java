package com.sephiroth.jpademo.base.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * @Author: 吴占超
 * @Description: 创建一个自定义的FactoryBean去替代默认的工厂类
 * @Date: Create in 16:02 2018/2/26
 * @Modified By:
 */
public class SubRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable>
        extends JpaRepositoryFactoryBean<R, T, I> {

    public SubRepositoryFactoryBean(Class<? extends R> repositoryInterface) {
        super(repositoryInterface);
    }

    @SuppressWarnings("rawtypes")
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        JpaRepositoryFactory jpaFac = new JpaRepositoryFactory(entityManager);
        jpaFac.addRepositoryProxyPostProcessor(new SecurecyPostProcessor());
        return jpaFac;
    }
}
