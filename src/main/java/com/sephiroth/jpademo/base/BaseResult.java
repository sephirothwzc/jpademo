package com.sephiroth.jpademo.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 吴占超
 * @Description: 返回值对象
 * @Date: Create in 19:53 2018/2/11
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult {

    /**
     *  @Author: 吴占超
     *  @Description: 默认成功 构造函数
     *  @Date:  10:38 2018/3/8
     *  @param d
     */
    public BaseResult(Object d) {
        this.setData(d);
    }

    // 状态
    public ResultState state = ResultState.Success;
    // 数据对象
    public Object data;
    // 消息
    public String msg;

    /**
     * @Author: 吴占超
     * @Description:
     * @Date: Create in 20:03 2018/2/11
     * @Modified By:
     */
    public enum ResultState {
        Fail,Success
    }

}


