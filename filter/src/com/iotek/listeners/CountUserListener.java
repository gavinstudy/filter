package com.iotek.listeners;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * �ڷ���������ʱ,����map����,���浽ServletContext(applicationȫ�ֶ�����)
 * 
 * */
public class CountUserListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CountUserListener() {
        // TODO Auto-generated constructor stub
    }

	
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	//Map,ip,���ʴ���;
    	Map<String,Integer> map=new LinkedHashMap<String,Integer>();
    	ServletContext application=arg0.getServletContext();
    	application.setAttribute("map", map);
    	
    }


    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
