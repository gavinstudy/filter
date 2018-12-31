package com.iotek.listeners;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class CountUserFilter implements Filter {
    private FilterConfig config;
    /**
     * Default constructor. 
     */
    public CountUserFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //1.获取application中map
		ServletContext app=config.getServletContext();
		Map<String,Integer> map=(Map<String,Integer>)app.getAttribute("map");
		//2获取客户端的IP地址.
		String ip=request.getRemoteAddr();   //获取客户端的IP地址;
		//3进行判断
		if(map.containsKey(ip)){   //这个ip在map中存在,说明不是第一次访问
			int count=map.get(ip);     
			map.put(ip, count+1);
		}else{
			map.put(ip, 1);
		}
		app.setAttribute("map", map);  //把更新后的map,放回application对象中.
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config=fConfig;
	}

}
