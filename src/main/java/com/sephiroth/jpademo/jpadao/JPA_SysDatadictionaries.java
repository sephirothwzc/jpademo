package com.sephiroth.jpademo.jpadao;

import com.sephiroth.jpademo.entity.E_SysDatadictionaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @Author: 吴占超
 * @Description: JPA DAO
 * @Date: Create in 10:57 2018/2/4
 * @Modified By:
 */
public interface JPA_SysDatadictionaries extends
    JpaRepository<E_SysDatadictionaries,String>,
    JpaSpecificationExecutor<E_SysDatadictionaries>,
    Serializable
{

}
