package com.sephiroth.jpademo.service;

import com.sephiroth.jpademo.base.jpa.BaseJpaRepository;
import com.sephiroth.jpademo.base.BaseService;
import com.sephiroth.jpademo.entity.EntitySysUser;
import com.sephiroth.jpademo.jpadao.JpaSysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @Author: 吴占超
 * @Description: 用户服务
 * @Date: Create in 17:14 2018/2/11
 * @Modified By:
 */
@Service
public class ServiceSysUser extends BaseService<EntitySysUser>{

    @Autowired
    private JpaSysUser jpaSysUser;

    @Override
    public BaseJpaRepository getBaseJpaRepository() {
        return jpaSysUser;
    }

    /**
     *  @Author: 吴占超
     *  @Description: 根据用户名获取用户
     *  @Date:  14:55 2018/2/15
     *  @param username
     *  @return
     */
    public EntitySysUser findByUserName(String username) {
        return jpaSysUser.findOne((Root<EntitySysUser> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder)->
            criteriaQuery.where(criteriaBuilder.equal(root.get(EntitySysUser._userName),username))
                    .getRestriction());
//        return jpaSysUser.findOne(new Specification<EntitySysUser>() {
//            @Override
//            public Predicate toPredicate(Root<EntitySysUser> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                return criteriaQuery.where(criteriaBuilder.equal(root.get(EntitySysUser._userName),username))
//                        .getRestriction();
//            }
//        });
    }
}
