package com.sephiroth.jpademo.service;


import com.sephiroth.jpademo.entity.EntityTResult;
import com.sephiroth.jpademo.base.BaseJpaRepository;
import com.sephiroth.jpademo.base.BaseService;
import com.sephiroth.jpademo.jpadao.JpaTResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 吴占超
 * @Description: Service 
 * @Date: Create in 
 * @Modified By:
 */
@Service
public class ServiceTResult  extends
    BaseService<EntityTResult> {

    @Autowired
    private JpaTResult jpaTResult;

    @Override
    public BaseJpaRepository getBaseJpaRepository() {
        return jpaTResult;
    }

}
