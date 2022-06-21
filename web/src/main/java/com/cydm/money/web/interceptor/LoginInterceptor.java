package com.cydm.money.web.interceptor;

import com.cydm.money.common.constant.Constants;
import com.cydm.money.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user=(User)request.getSession().getAttribute(Constants.SESSION_USER);
        if(user==null){
            response.sendRedirect(request.getContextPath()+"/index");
            return false;
        }
        return true;
    }
}
