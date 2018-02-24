package com.sephiroth.jpademo.service;


import com.sephiroth.jpademo.entity.EntitySysSettings;
import com.sephiroth.jpademo.base.jpa.BaseJpaRepository;
import com.sephiroth.jpademo.base.BaseService;
import com.sephiroth.jpademo.jpadao.JpaSysSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 吴占超
 * @Description: Service 
 * @Date: Create in 
 * @Modified By:
 */
@Service
public class ServiceSysSettings  extends
    BaseService<EntitySysSettings> {

    @Autowired
    private JpaSysSettings jpaSysSettings;

    @Override
    public BaseJpaRepository getBaseJpaRepository() {
        return jpaSysSettings;
    }

}
