package com.sephiroth.jpademo.jpadao;


import com.sephiroth.jpademo.entity.EntitySysRole;
import com.sephiroth.jpademo.entity.EntitySysUserRole;
import com.sephiroth.jpademo.base.BaseJpaRepository;

import java.util.List;

/**
 * @Author: 吴占超
 * @Description: JPA DAO
 * @Date: Create in 
 * @Modified By:
 */
public interface JpaSysUserRole  extends
    BaseJpaRepository<EntitySysUserRole,String> {

}
