package com.sephiroth.jpademo.service;


import com.sephiroth.jpademo.entity.EntityTProjectset;
import com.sephiroth.jpademo.base.BaseJpaRepository;
import com.sephiroth.jpademo.base.BaseService;
import com.sephiroth.jpademo.jpadao.JpaTProjectset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 吴占超
 * @Description: Service 
 * @Date: Create in 
 * @Modified By:
 */
@Service
public class ServiceTProjectset  extends
    BaseService<EntityTProjectset> {

    @Autowired
    private JpaTProjectset jpaTProjectset;

    @Override
    public BaseJpaRepository getBaseJpaRepository() {
        return jpaTProjectset;
    }

}
