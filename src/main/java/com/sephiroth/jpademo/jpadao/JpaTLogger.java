package com.sephiroth.jpademo.jpadao;


import com.sephiroth.jpademo.entity.EntityTLogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
/**
 * @Author: 吴占超
 * @Description: JPA DAO
 * @Date: Create in 
 * @Modified By:
 */
public interface JpaTLogger extends
    JpaRepository<EntityTLogger,String>,
    JpaSpecificationExecutor<EntityTLogger>,
    Serializable {


}
