package com.sephiroth.jpademo.jpadao;

import com.sephiroth.jpademo.entity.EntitySysDatadictionaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: 吴占超
 * @Description: JPA DAO
 * @Date: Create in 10:57 2018/2/4
 * @Modified By:
 */
public interface JpaSysDatadictionaries extends
    JpaRepository<EntitySysDatadictionaries,String>,
    JpaSpecificationExecutor<EntitySysDatadictionaries>,
    Serializable {

    // 自定义查询 nativeQuery = true (sql) false (hql)
    // Query 只支持查询 配合 Modifying 执行增删改
    @Query(value = "select * from sys_datadictionaries where enableflag = ?1",nativeQuery = true)
    List<EntitySysDatadictionaries> useGetEnableflag(String enableflag);


    /*
     * 异常TranscationRequiredException，
     * 意思就是你当前的操作给你抛出了需要事务异常，
     * SpringDataJPA自定义SQL时需要在对应的接口或者调用接口的地方添加事务注解
     * @Transactional，
     * 来开启事务自动化管理。
     */
    @Modifying
    @Transactional
    @Query(value = "delete from sys_datadictionaries where code = ?1 and name = ?2",nativeQuery = true)
    void deleteQuery(String code,String name);
}
