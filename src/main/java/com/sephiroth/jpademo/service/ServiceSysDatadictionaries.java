package com.sephiroth.jpademo.service;


import com.sephiroth.jpademo.entity.EntitySysDatadictionaries;
import com.sephiroth.jpademo.base.BaseJpaRepository;
import com.sephiroth.jpademo.base.BaseService;
import com.sephiroth.jpademo.jpadao.JpaSysDatadictionaries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 吴占超
 * @Description: Service 
 * @Date: Create in 
 * @Modified By:
 */
@Service
public class ServiceSysDatadictionaries  extends
    BaseService<EntitySysDatadictionaries> {

    @Autowired
    private JpaSysDatadictionaries jpaSysDatadictionaries;

    @Override
    public BaseJpaRepository getBaseJpaRepository() {
        return jpaSysDatadictionaries;
    }

}
