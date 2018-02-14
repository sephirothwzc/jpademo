package com.sephiroth.jpademo.model.SysUser;

import com.sephiroth.jpademo.base.BasePagination;
import com.sephiroth.jpademo.entity.EntitySysUser;
import com.sephiroth.jpademo.entity.QEntitySysUser;
import com.sephiroth.jpademo.retention.RetentionPagination;
import lombok.Data;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 23:38 2018/2/11
 * @Modified By:
 */
@Data
public class InCutUsePage extends BasePagination {


    @RetentionPagination(field = "username")
    public String username;

    @RetentionPagination(field = "password")
    public String pwd;
}
