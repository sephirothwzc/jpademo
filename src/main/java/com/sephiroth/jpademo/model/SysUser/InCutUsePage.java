package com.sephiroth.jpademo.model.SysUser;

import com.sephiroth.jpademo.base.BasePagination;
import lombok.Data;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 23:38 2018/2/11
 * @Modified By:
 */
@Data
public class InCutUsePage extends BasePagination {
    public String username;
}
