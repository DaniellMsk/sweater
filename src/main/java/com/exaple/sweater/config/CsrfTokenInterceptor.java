package com.exaple.sweater.config;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CsrfTokenInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        if (modelAndView != null) {
            modelAndView.addObject("_csrf", csrfToken);
        }
    }
}