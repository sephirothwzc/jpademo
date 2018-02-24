package com.sephiroth.jpademo.service;


import com.sephiroth.jpademo.entity.EntitySysJurisdiction;
import com.sephiroth.jpademo.base.jpa.BaseJpaRepository;
import com.sephiroth.jpademo.base.BaseService;
import com.sephiroth.jpademo.jpadao.JpaSysJurisdiction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 吴占超
 * @Description: Service 
 * @Date: Create in 
 * @Modified By:
 */
@Service
public class ServiceSysJurisdiction  extends
    BaseService<EntitySysJurisdiction> {

    @Autowired
    private JpaSysJurisdiction jpaSysJurisdiction;

    @Override
    public BaseJpaRepository getBaseJpaRepository() {
        return jpaSysJurisdiction;
    }

    /**
     *  @Author: 吴占超
     *  @Description: 根据用户名获取权限列表
     *  @Date:  19:50 2018/2/17
     *  @param username
     *  @return
     *
     */
    public List<EntitySysJurisdiction> findByUserName(String username) {
        return jpaSysJurisdiction.findByUserName(username);
    }
}
