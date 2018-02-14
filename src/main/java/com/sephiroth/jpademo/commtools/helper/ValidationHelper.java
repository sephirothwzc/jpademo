package com.sephiroth.jpademo.commtools.helper;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.hibernate.validator.HibernateValidator;

/**
 *  @Author: 吴占超
 *  @Description: entity校验
 *  @Date:  20:42 2018/2/14
 *
 */
public class ValidationHelper {

    /**
     * 使用hibernate的注解来进行验证
     *
     */
    private static Validator validator = Validation
            .byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();

    /**
     * 功能描述: <br>
     * 〈注解验证参数〉
     *
     * @param obj
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static <T> String validate(T obj) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        // 抛出检验异常
        if (constraintViolations.size() > 0) {
            return  String.format("参数校验失败:%s", constraintViolations.iterator().next().getMessage());
            // throw new AppException("0001", String.format("参数校验失败:%s", constraintViolations.iterator().next().getMessage()));
        }
        return null;
    }
}