package com.onethread.cms.config;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;

public class EmailPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        return request.getParameter("email");
    }
}
