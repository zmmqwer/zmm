package com.zmm.ssm01.fighter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ProjectName: ssm01
 * @Package: com.zmm.ssm01.fighter
 * @Description: java类作用描述
 * @Author: 周铭明
 * @CreateDate: 2020/11/12 0012 14:31
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
//登录拦截器、
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        Object object = httpSession.getAttribute("uname");//获取session中userName
        if(object != null){ //判断userName是否为非空，如果为非空，则表示已登录，可继续操作
            return true;
        }else{ //如果为空，则表示未登录，返回登录界面
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
