package com.sephiroth.jpademo.commtools.helper;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 13:26 2018/2/7
 * @Modified By:
 */
public class StringHelper {

    /**
     *  @Author: 吴占超
     *  @Description:
     *  @Date:  13:42 2018/2/7
     *  @param param
     *  @return
     */
    public static boolean IsNullOrEmpty(String param) {
        return (null == param || 0 == param.trim().length());
    }
}
