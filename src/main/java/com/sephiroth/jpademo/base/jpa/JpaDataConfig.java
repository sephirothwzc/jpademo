package com.sephiroth.jpademo.base.jpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * @Author: 吴占超
 * @Description: 通过注解配置factory-class
 * @Date: Create in 16:10 2018/2/26
 * @Modified By:
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.sephiroth.jpademo.jpadao",
        repositoryFactoryBeanClass = SubRepositoryFactoryBean.class)
@EnableSpringDataWebSupport
public class JpaDataConfig {

}
