package com.sephiroth.jpademo.jpadao;


import com.sephiroth.jpademo.entity.E_TLogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
/**
 * @Author: 吴占超
 * @Description: JPA DAO
 * @Date: Create in 
 * @Modified By:
 */
public interface JPA_TLogger  extends
    JpaRepository<E_TLogger,String>,
    JpaSpecificationExecutor<E_TLogger>,
    Serializable {


}
