package com.sephiroth.jpademo.service;


import com.sephiroth.jpademo.entity.EntitySysJurisdiction;
import com.sephiroth.jpademo.base.BaseJpaRepository;
import com.sephiroth.jpademo.base.BaseService;
import com.sephiroth.jpademo.jpadao.JpaSysJurisdiction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
