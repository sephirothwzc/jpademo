package com.sephiroth.jpademo.service;


import com.sephiroth.jpademo.entity.EntitySysRole;
import com.sephiroth.jpademo.base.BaseJpaRepository;
import com.sephiroth.jpademo.base.BaseService;
import com.sephiroth.jpademo.jpadao.JpaSysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 吴占超
 * @Description: Service 
 * @Date: Create in 
 * @Modified By:
 */
@Service
public class ServiceSysRole  extends
    BaseService<EntitySysRole> {

    @Autowired
    private JpaSysRole jpaSysRole;

    @Override
    public BaseJpaRepository getBaseJpaRepository() {
        return jpaSysRole;
    }

}
