package com.sephiroth.jpademo.jpadao;


import com.sephiroth.jpademo.entity.E_SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;


public interface JPA_SysUser  extends
    JpaRepository<E_SysUser,String>,
    JpaSpecificationExecutor<E_SysUser>,
    Serializable {


}
