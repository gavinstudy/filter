package com.iotek.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstFilter implements Filter {
    public FirstFilter() {
		// TODO Auto-generated constructor stub
    	System.out.println("filter constructor...");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		  System.out.println("filter destroy...");
	}
	/*����������*/
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("first ����֮ǰ....");
		chain.doFilter(request, response);//ִ�й����� ,����ǰ,��ķָ���
		System.out.println("first ����֮��....");

	}
   
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String user=config.getInitParameter("user");
         System.out.println("filter init..."+user);
	}

}
