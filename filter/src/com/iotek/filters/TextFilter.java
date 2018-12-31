package com.iotek.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class TextFilter implements Filter {


    public TextFilter() {
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
	    HttpServletResponse resp=(HttpServletResponse)response;
		response.setCharacterEncoding("utf-8");
		String user=request.getParameter("username");
		if(user!=null&&!"".equals(user)){
			if(user.contains("你妹")){
				request.setAttribute("message", "请输入正常的信息");
				request.getRequestDispatcher("text.jsp").forward(request, response);
			}
			else{
				chain.doFilter(request, response); //放行
			}
		}else{
			resp.sendRedirect("text.jsp");
		}
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
