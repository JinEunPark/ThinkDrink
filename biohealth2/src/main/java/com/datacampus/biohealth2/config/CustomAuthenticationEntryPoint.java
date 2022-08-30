package com.datacampus.biohealth2.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        if("XMLHttpRequest".equals(httpServletRequest.getHeader("x-requested-with"))){
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized");
        }else{
            httpServletResponse.sendRedirect("/members/login");
        }
    }
}
