package com.sephiroth.jpademo.base.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @Author: 吴占超
 * @Description: JPA base
 * @Date: Create in 16:14 2018/2/11
 * @Modified By:
 */
// NoRepositoryBean 子接口不被作为一个Repository创建代理实现类
@NoRepositoryBean
public interface BaseJpaRepository<T,PK extends Serializable> extends
        JpaRepository<T,PK> ,
        JpaSpecificationExecutor<T>,
        QueryDslPredicateExecutor<T>,
        Serializable
{
}