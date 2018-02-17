package com.sephiroth.jpademo.jpadao;


import com.sephiroth.jpademo.entity.EntitySysJurisdiction;
import com.sephiroth.jpademo.base.BaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: 吴占超
 * @Description: JPA DAO
 * @Date: Create in 
 * @Modified By:
 */
public interface JpaSysJurisdiction  extends
    BaseJpaRepository<EntitySysJurisdiction,String> {

    @Query(value = "select j.* from sys_user_role ur\n" +
            "inner join sys_user u\n" +
            "on ur.user_id = u.id\n" +
            "inner join sys_role_jurisdiction rj\n" +
            "on ur.role_id = rj.role_id\n" +
            "inner join sys_jurisdiction j\n" +
            "on rj.jur_id = j.id\n" +
            "where \n" +
            "ur.enableflag = 1\n" +
            "and u.enableflag = 1\n" +
            "and rj.enableflag = 1" +
            "and u.user_name = :username ",nativeQuery=true)
    public List<EntitySysJurisdiction> findByUserName(@Param("username") String username);
}
