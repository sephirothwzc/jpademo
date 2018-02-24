package com.sephiroth.jpademo.service;


import com.sephiroth.jpademo.entity.EntitySysRole;
import com.sephiroth.jpademo.base.jpa.BaseJpaRepository;
import com.sephiroth.jpademo.base.BaseService;
import com.sephiroth.jpademo.jpadao.JpaSysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     *  @Author: 吴占超
     *  @Description: 根据用户名获取
     *  @Date:  18:44 2018/2/17
     *  @param username
     *  @return
     *
     */
    public List<EntitySysRole> findByUser(String username) {
        return jpaSysRole.findByUserName(username);
    }

}
