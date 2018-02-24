package com.sephiroth.jpademo.service;


import com.sephiroth.jpademo.entity.EntitySysRoleJurisdiction;
import com.sephiroth.jpademo.base.jpa.BaseJpaRepository;
import com.sephiroth.jpademo.base.BaseService;
import com.sephiroth.jpademo.jpadao.JpaSysRoleJurisdiction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 吴占超
 * @Description: Service 
 * @Date: Create in 
 * @Modified By:
 */
@Service
public class ServiceSysRoleJurisdiction  extends
    BaseService<EntitySysRoleJurisdiction> {

    @Autowired
    private JpaSysRoleJurisdiction jpaSysRoleJurisdiction;

    @Override
    public BaseJpaRepository getBaseJpaRepository() {
        return jpaSysRoleJurisdiction;
    }

}
