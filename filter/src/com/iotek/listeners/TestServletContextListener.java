package com.iotek.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TestServletContextListener implements ServletContextListener,ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("add name="+arg0.getName()+" value=="+arg0.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("remove name="+arg0.getName()+" value=="+arg0.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("update name="+arg0.getName()+" value=="+arg0.getValue());
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("servletContext destroy");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		arg0.getServletContext(); //上下文对象
		System.out.println("servletContext init");
	}

}
