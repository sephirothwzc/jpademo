package com.sephiroth.jpademo.base;

import lombok.Data;

/**
 * @Author: 吴占超
 * @Description: 返回值对象
 * @Date: Create in 19:53 2018/2/11
 * @Modified By:
 */
@Data
public class BaseResult {
    // 状态
    public ResultState state = ResultState.Success;
    // 数据对象
    public Object data;
    // 消息
    public String msg;
}

