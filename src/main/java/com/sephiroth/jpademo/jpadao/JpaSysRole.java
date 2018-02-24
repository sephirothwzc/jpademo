package com.sephiroth.jpademo.jpadao;


import com.sephiroth.jpademo.entity.EntitySysRole;
import com.sephiroth.jpademo.base.jpa.BaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: 吴占超
 * @Description: JPA DAO
 * @Date: Create in 
 * @Modified By:
 */
public interface JpaSysRole  extends
    BaseJpaRepository<EntitySysRole,String> {

    @Query(value = "select r.* from sys_role r \n" +
            "inner join sys_user_role ur\n" +
            "on r.id = ur.role_id\n" +
            "inner join sys_user u\n" +
            "on ur.user_id = u.id\n" +
            "where \n" +
            "ur.enableflag = 1\n" +
            "and u.enableflag = 1\n" +
            "and r.enableflag = 1\n" +
            "and u.user_name = :username ",nativeQuery=true)
    public List<EntitySysRole> findByUserName(@Param("username") String username);
}
