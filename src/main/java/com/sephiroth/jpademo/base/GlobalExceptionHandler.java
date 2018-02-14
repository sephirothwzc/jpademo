package com.sephiroth.jpademo.base;

import com.sephiroth.jpademo.base.BaseResult;
import com.sephiroth.jpademo.base.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kinginblue on 2017/4/10.
 * @ControllerAdvice + @ExceptionHandler 实现全局的 Controller 层的异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理所有不可知的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    BaseResult handleException(Exception e){
        LOGGER.error(e.getMessage(), e);

        return new BaseResult(BaseResult.ResultState.Fail,null,"操作失败:"+e.getMessage());
    }

    /**
     * 处理所有业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    BaseResult handleBusinessException(BusinessException e){
        LOGGER.error(e.getMessage(), e);

        return new BaseResult(BaseResult.ResultState.Fail,null,"业务异常:"+e.getMessage());
    }

    /**
     * 处理所有接口数据验证异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    BaseResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        LOGGER.error(e.getMessage(), e);

        BaseResult response = new BaseResult();
        response.setState(BaseResult.ResultState.Fail);
        response.setMsg(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return response;
    }

}
