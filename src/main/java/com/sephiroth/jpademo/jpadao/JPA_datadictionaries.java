package com.sephiroth.jpademo.jpadao;

import com.sephiroth.jpademo.entity.E_datadictionaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 10:57 2018/2/4
 * @Modified By:
 */
public interface JPA_datadictionaries extends
    JpaRepository<E_datadictionaries,String>,
    JpaSpecificationExecutor<E_datadictionaries>,
    Serializable
{

}
