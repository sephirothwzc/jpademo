package com.sephiroth.jpademo.model.SysUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 15:17 2018/2/15
 * @Modified By:
 */
@Data
@AllArgsConstructor
public class Inlogin {
    @NotEmpty
    public String username;

    @NotEmpty
    public String password;
}
