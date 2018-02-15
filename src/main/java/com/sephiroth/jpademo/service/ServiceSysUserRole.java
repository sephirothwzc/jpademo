package com.sephiroth.jpademo.service;


import com.sephiroth.jpademo.entity.EntitySysUserRole;
import com.sephiroth.jpademo.base.BaseJpaRepository;
import com.sephiroth.jpademo.base.BaseService;
import com.sephiroth.jpademo.jpadao.JpaSysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 吴占超
 * @Description: Service 
 * @Date: Create in 
 * @Modified By:
 */
@Service
public class ServiceSysUserRole  extends
    BaseService<EntitySysUserRole> {

    @Autowired
    private JpaSysUserRole jpaSysUserRole;

    @Override
    public BaseJpaRepository getBaseJpaRepository() {
        return jpaSysUserRole;
    }

}
