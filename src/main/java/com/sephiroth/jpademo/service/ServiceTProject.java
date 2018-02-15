package com.sephiroth.jpademo.service;


import com.sephiroth.jpademo.entity.EntityTProject;
import com.sephiroth.jpademo.base.BaseJpaRepository;
import com.sephiroth.jpademo.base.BaseService;
import com.sephiroth.jpademo.jpadao.JpaTProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 吴占超
 * @Description: Service 
 * @Date: Create in 
 * @Modified By:
 */
@Service
public class ServiceTProject  extends
    BaseService<EntityTProject> {

    @Autowired
    private JpaTProject jpaTProject;

    @Override
    public BaseJpaRepository getBaseJpaRepository() {
        return jpaTProject;
    }

}
