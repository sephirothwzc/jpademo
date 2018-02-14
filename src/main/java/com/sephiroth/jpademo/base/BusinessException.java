package com.sephiroth.jpademo.base;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 23:03 2018/2/14
 * @Modified By:
 */
public class BusinessException extends RuntimeException {

    public BusinessException(){
        super();
    }

    public BusinessException(String message){
        super(message);
    }
}
