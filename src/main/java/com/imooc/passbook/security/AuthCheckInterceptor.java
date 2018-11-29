package com.imooc.passbook.security;


import com.imooc.passbook.constant.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <h1>权限拦截器</h1>
 */
//注册到Spring 容器中HandlerInterceptor
@Component
public class AuthCheckInterceptor implements HandlerInterceptor  {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //这个是拦截模式
        String token = request.getHeader(Constants.TEMPLATE_TOPIC);
        if(StringUtils.isEmpty(token)){
            throw new Exception("Header 中缺少 "+ Constants.TEMPLATE_TOPIC + "!");
        }
        if(!token.equals(Constants.TOKEN)){
            throw new Exception("Header 中"+ Constants.TEMPLATE_TOPIC + "错误！");
        }
        AccessContext.setToken(token);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        AccessContext.clearAccessKey();
    }
}
