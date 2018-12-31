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
        //1.��ȡapplication��map
		ServletContext app=config.getServletContext();
		Map<String,Integer> map=(Map<String,Integer>)app.getAttribute("map");
		//2��ȡ�ͻ��˵�IP��ַ.
		String ip=request.getRemoteAddr();   //��ȡ�ͻ��˵�IP��ַ;
		//3�����ж�
		if(map.containsKey(ip)){   //���ip��map�д���,˵�����ǵ�һ�η���
			int count=map.get(ip);     
			map.put(ip, count+1);
		}else{
			map.put(ip, 1);
		}
		app.setAttribute("map", map);  //�Ѹ��º��map,�Ż�application������.
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
