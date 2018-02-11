package com.sephiroth.jpademo.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sephiroth.jpademo.commtools.helper.WebAppContextHelper;
import com.sephiroth.jpademo.entity.EntitySysUser;
import com.sephiroth.jpademo.entity.EntityTLogger;
import com.sephiroth.jpademo.iiteral.IiteralLogger;
import com.sephiroth.jpademo.iiteral.IiteralSession;
import com.sephiroth.jpademo.jpadao.JpaTLogger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 11:37 2018/2/8
 * @Modified By:
 */
public class LoggerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        // 日志对象
        EntityTLogger logger = new EntityTLogger();
        // 请求的sessionid 获取
        logger.setSessionId(request.getRequestedSessionId());
        // 请求路径
        logger.setAliUri(request.getRequestURI());
        // 参数信息
        logger.setAliParamdata(JSON.toJSONString(request.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        // 客户端ip
        logger.setClientip(WebAppContextHelper.getCliectIp(request));
        // 请求方法
        logger.setAliMethod(request.getMethod());
        // 请求类型(json|普通请求)
        logger.setAliType(WebAppContextHelper.getRequestType(request));
        // 请求开始时间
        request.setAttribute(IiteralLogger.LOGGER_SEND_TIME,System.currentTimeMillis());
        // 设置对象
        request.setAttribute(IiteralLogger.LOGGER_ENTITY,logger);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
        // 获取对象
        EntityTLogger logger = (EntityTLogger)request.getAttribute(IiteralLogger.LOGGER_ENTITY);
        // 请求错误码
        logger.setHttpStatusCode(String.valueOf(response.getStatus()));
        // 请求开始时间
        long stime = Long.valueOf(request.getAttribute(IiteralLogger.LOGGER_SEND_TIME).toString());
        // 获取时间差
        long etime = System.currentTimeMillis();
        logger.setAliReturnTime(new Timestamp(etime));
        logger.setAliTimeConsuming(etime-stime);
        logger.setAliDatetime(new Timestamp(stime));
        // endregion
        logger.setAliReturnData(JSON.toJSONString(request.getAttribute(IiteralLogger.LOGGER_RETURN),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        // 设置登陆对象
        Object obj = request.getSession().getAttribute(IiteralSession.user);
        if(null != obj) {
            logger.setTokenUser(((EntitySysUser)obj).getId());
        }
        // 写入数据库
        JpaTLogger jpaTLogger = new WebAppContextHelper().getJPADAO(JpaTLogger.class,request);
        jpaTLogger.save(logger);
    }
}
