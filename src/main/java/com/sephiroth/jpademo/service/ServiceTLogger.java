package com.sephiroth.jpademo.service;


import com.sephiroth.jpademo.entity.EntityTLogger;
import com.sephiroth.jpademo.base.jpa.BaseJpaRepository;
import com.sephiroth.jpademo.base.BaseService;
import com.sephiroth.jpademo.jpadao.JpaTLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 吴占超
 * @Description: Service 
 * @Date: Create in 
 * @Modified By:
 */
@Service
public class ServiceTLogger  extends
    BaseService<EntityTLogger> {

    @Autowired
    private JpaTLogger jpaTLogger;

    @Override
    public BaseJpaRepository getBaseJpaRepository() {
        return jpaTLogger;
    }

}
