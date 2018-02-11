package com.sephiroth.jpademo.jpadao;


import com.sephiroth.jpademo.entity.EntitySysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;


public interface JpaSysUser extends
    JpaRepository<EntitySysUser,String>,
    JpaSpecificationExecutor<EntitySysUser>,
    Serializable {


}
