package com.github.netty.servlet;

import javax.servlet.*;
import javax.servlet.ServletContext;
import java.io.IOException;

/**
 * Created by acer01 on 2018/7/14/014.
 */
public class ServletRequestDispatcher implements RequestDispatcher {

    private javax.servlet.ServletContext context;
    private FilterChain filterChain;

    ServletRequestDispatcher(ServletContext context, FilterChain filterChain) {
        this.context = context;
        this.filterChain = filterChain;
    }

    @Override
    public void forward(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        request.setAttribute(ServletHttpServletRequest.DISPATCHER_TYPE, DispatcherType.FORWARD);
        // TODO implement
    }

    @Override
    public void include(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        request.setAttribute(ServletHttpServletRequest.DISPATCHER_TYPE, DispatcherType.INCLUDE);
        // TODO implement
    }

    public void dispatch(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        request.setAttribute(ServletHttpServletRequest.DISPATCHER_TYPE, DispatcherType.ASYNC);
        filterChain.doFilter(request, response);
    }

}