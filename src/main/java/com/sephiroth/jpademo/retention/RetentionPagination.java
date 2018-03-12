package com.sephiroth.jpademo.retention;

import java.lang.annotation.*;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 13:10 2018/2/14
 * @Modified By:
 */
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Target({ElementType.FIELD}) // 定义注解的作用目标**作用范围字段、枚举的常量/方法
@Documented // 说明该注解将被包含在javadoc中
public @interface RetentionPagination {

    /**
     * 查询属性名 默认 ""
     * @return
     */
    String field() default "";

    /**
     * 排序字段 默认 0
     * @return
     */
    int order() default 0;

    /**
     * 关联条件 默认 0
     * @return
     */
    ScpeEnum scpeEnum() default ScpeEnum.like;

    public enum ScpeEnum {
        eq,in,notIn,between,like,notLike,gt,lt,gteq,lteq
    }

}


