package com.sephiroth.jpademo.service;


import com.sephiroth.jpademo.entity.EntitySysDatadictionaries;
import com.sephiroth.jpademo.base.jpa.BaseJpaRepository;
import com.sephiroth.jpademo.base.BaseService;
import com.sephiroth.jpademo.jpadao.JpaSysDatadictionaries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @Author: 吴占超
 * @Description: 数据字典Service 启用缓存
 * @Date: Create in 
 * @Modified By:
 */
@Service
@CacheConfig(cacheNames = "dataDic")
public class ServiceSysDatadictionaries  extends
    BaseService<EntitySysDatadictionaries> {

    @Autowired
    private JpaSysDatadictionaries jpaSysDatadictionaries;

    @Override
    public BaseJpaRepository getBaseJpaRepository() {
        return jpaSysDatadictionaries;
    }

    /**
     *  @Author: 吴占超
     *  @Description: 获取所有可用数据字典缓存
     *  @Date:  09:44 2018/2/23
     *
     */
    public List<EntitySysDatadictionaries> findAll() {
        return jpaSysDatadictionaries.findAll(new Specification<EntitySysDatadictionaries>() {
            @Override
            public Predicate toPredicate(Root<EntitySysDatadictionaries> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaQuery.where(criteriaBuilder.equal(root.get(EntitySysDatadictionaries._enableflag),"1"))
                        .getRestriction();
            }
        });
    }

}
