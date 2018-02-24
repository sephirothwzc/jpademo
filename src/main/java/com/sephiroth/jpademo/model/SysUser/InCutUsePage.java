package com.sephiroth.jpademo.model.SysUser;

import com.sephiroth.jpademo.base.jpa.BasePagination;
import com.sephiroth.jpademo.retention.RetentionPagination;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 23:38 2018/2/11
 * @Modified By:
 */
@Data
public class InCutUsePage extends BasePagination {


    @NotEmpty
    @RetentionPagination(field = "username")
    public String username;

    @RetentionPagination(field = "password")
    public String pwd;
}
